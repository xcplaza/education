package accounting.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class AuthorizationConfiguration {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception { //SecurityFilterChain - используем для spring security
        /* DEPRICATE
        http.httpBasic(); // дотягиваемся до базовых настроек http
        http.csrf().disable(); // отключение проверки межсайтовой подмены запросов
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // отключили кеширование логин/пароль
        */
        http.addFilterBefore(new ExpiredPasswordFilter(), BasicAuthenticationFilter.class);

        http.authorizeHttpRequests(autorize -> autorize
//                preAuthorize
                .requestMatchers("/account/register", "/account/register/").permitAll()
                .requestMatchers("/account/user/*/role/*", "/account/revoke/*", "/account/activate/*").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/account/user/{login}").access(new WebExpressionAuthorizationManager("#login == authentication.name"))
//                .requestMatchers(HttpMethod.PUT, "/account/user/{login}").access(new WebExpressionAuthorizationManager("@customWebSecurity.checkOwner(#login)"))
                .requestMatchers(HttpMethod.GET, "/account/*/{login}").access(new WebExpressionAuthorizationManager("#login == authentication.name or hasRole('ADMIN')"))
                .requestMatchers(HttpMethod.DELETE, "/account/user/{login}").access(new WebExpressionAuthorizationManager("#login == authentication.name or hasRole('ADMIN')"))
                .requestMatchers("/account/login", "/account/password").authenticated()
                .anyRequest().denyAll());

        return http.build();
    }
}

//      /account/**     /account/register   /account/user/role
//      /account/*/role
