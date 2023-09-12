package accounting.security;

import accounting.dto.exceptions.UserNotFoundExeption;
import accounting.entities.UserAccount;
import accounting.repo.UserAccountRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.security.Principal;
import java.util.Base64;
import java.util.Set;

@Component
public class AuthenticationFilter implements Filter {
    @Autowired
    UserAccountRepository repository;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (checkEndPoint(req.getMethod(), req.getServletPath())) {
            String auth = req.getHeader("Authorization");
            if (auth == null) {
                res.sendError(401, "Header authorization is not exists");
                return;
            } else {
                try {
                    String[] base = auth.split(" ");
                    String decode = new String(Base64.getDecoder().decode(base[1]));
                    String[] credentials = decode.split(":");

                    UserAccount user = repository.findById(credentials[0]).orElse(null);
                    if (user == null) {
                        res.sendError(401, "User not found");
                        return;
                    }

                    if (!BCrypt.checkpw(credentials[1], user.getHash())) {
                        res.sendError(401, "User or password not valid");
                        return;
                    }

                    req = new WrapperRequest(req, credentials[0]);
                } catch (Exception e) {
                    res.sendError(401, "User or password not valid");
                    return;
                }
            }
        }
        chain.doFilter(req, res);
    }

    private boolean checkEndPoint(String method, String servletPath) {
        return !(method.equals("POST") && servletPath.matches("/account/register/?"));
    }

    //    Pricipal - get name (вместо null)
    private class WrapperRequest extends HttpServletRequestWrapper {

        String login;

        public WrapperRequest(HttpServletRequest request, String login) {
            super(request);
            this.login = login;
        }

        @Override
        public Principal getUserPrincipal() {
            return () -> login;
        }
    }
}
