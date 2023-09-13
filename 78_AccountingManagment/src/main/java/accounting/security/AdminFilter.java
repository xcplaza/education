package accounting.security;

import accounting.entities.UserAccount;
import accounting.repo.UserAccountRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(20)
public class AdminFilter implements Filter {

    @Autowired
    UserAccountRepository repository;

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (checkPoints(req.getMethod(), req.getServletPath())) {
            UserAccount user = repository.findById(req.getUserPrincipal().getName()).get();
            if (!user.getRoles().contains("ADMIN")) {
                res.sendError(403);
                return;
            }
        }
        chain.doFilter(req, res);
    }

    private boolean checkPoints(final String method, final String servletPath) {
        return servletPath.matches("/account/revoke/\\w+") || servletPath.matches("/account/activate/\\w+") || servletPath.matches("/account/user/\\w+/role/\\w+");
    }
}
