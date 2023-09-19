package calculator.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@Component
public class ExpiredPasswordFilter extends GenericFilterBean
{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(checkEndpoint(req.getMethod(), req.getServletPath()) && auth != null &&
				auth.getPrincipal() instanceof UserProfile)
		{
			UserProfile user = (UserProfile) auth.getPrincipal();
			if(!user.isPasswordIsNotExpired())
			{
				res.sendError(403, "Password expired");
				return;
			}
		}
		
		chain.doFilter(req, res);
	}

	private boolean checkEndpoint(String method, String servletPath)
	{
		return !(method.equals("PUT") && servletPath.matches("/account/password"));
	}

}
