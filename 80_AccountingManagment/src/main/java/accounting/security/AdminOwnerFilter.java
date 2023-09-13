package accounting.security;

import accounting.entities.UserAccount;
import accounting.repo.UserAccountRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.io.IOException;

@Component
@Order(30)
public class AdminOwnerFilter implements Filter {

    @Autowired
    UserAccountRepository repository;

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (checkPoints(req.getMethod(), req.getServletPath())) {

            String login = req.getUserPrincipal().getName();
            UserAccount user = repository.findById(login).get();
            String[] path = req.getServletPath().split("/");
            String temp = path[path.length - 1].isEmpty() ? path[path.length - 2] : path[path.length - 1];

            if (!(user.getRoles().contains("ADMIN") || temp.equals(login))) {
                res.sendError(403);
                return;
            }
        }
        chain.doFilter(req, res);
    }

    private boolean checkPoints(final String method, final String servletPath) {
        return (method.equals("GET") && servletPath.matches("/account/\\w+/\\w+") || servletPath.matches("/account/user/\\w+"));
//        return servletPath.matches("/account/user/\\w+") || servletPath.matches("/account/roles/\\w+") || servletPath.matches("/account/password/\\w+") || servletPath.matches("/account/activation_date/\\w+");
    }
}

//@DeleteMapping("/user/{login}")
//@PutMapping("/user/{login}")
//@GetMapping("/roles/{login}")
//@GetMapping("/password/{login}")
//@GetMapping("/activation_date/{login}")