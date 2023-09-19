package calculator.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class AuthorizationConfiguration
{
	@Bean
	SecurityFilterChain configure(HttpSecurity http) throws Exception
	{
		http.httpBasic();
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(new ExpiredPasswordFilter(), BasicAuthenticationFilter.class);
		
		http.authorizeHttpRequests(autorize -> autorize
//				preAutorize
				.requestMatchers("/account/register", "/account/register/","/operations").permitAll()
			.requestMatchers("/account/user/*/role/*", "/account/revoke/*", "/account/activate/*")
//						.hasAnyRole("ADMIN", "MASTER", "MODERATOR")
						.hasRole("ADMIN")
			.requestMatchers(HttpMethod.PUT, "/account/user/{login}")
					.access(new WebExpressionAuthorizationManager("#login == authentication.name"))
//			.access(new WebExpressionAuthorizationManager("@customWebSecurity.checkOwner(#login)"))
			.requestMatchers(HttpMethod.GET, "/account/*/{login}")
				.access(new WebExpressionAuthorizationManager
					("#login == authentication.name or hasRole('ADMIN')"))
			.requestMatchers(HttpMethod.DELETE, "/account/user/{login}")
				.access(new WebExpressionAuthorizationManager
					("#login == authentication.name or hasRole('ADMIN')"))
			.requestMatchers("/account/login", "/account/password").authenticated()
			.anyRequest().denyAll());
		
		return http.build();
	}
}
