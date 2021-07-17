package ca.smckinlay.dealership.service.util.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Configuration
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private static final Logger log = LoggerFactory.getLogger(LoginSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if(roles.contains("ROLE_SERVICE")) {
            response.sendRedirect("/service");

        } else if (roles.contains("ROLE_WORKSHOP")) {
            response.sendRedirect("/workshop");
        } else if (roles.contains("ROLE_MANAGER")) {
            response.sendRedirect("/service");
        }

    }
}
