package com.example.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomAuthenticationProvider extends DaoAuthenticationProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    private final UserDetailsService userDetailsService;

    public CustomAuthenticationProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // process additional request parameters here
        String verificationCode = null;
        if (Objects.nonNull(authentication.getDetails())) {
            verificationCode = ((CustomWebAuthenticationDetails) authentication.getDetails())
                    .getVerificationCode();
        }
        LOGGER.info("Verification Code {} ", verificationCode);
        return super.authenticate(authentication);
    }

    @Override
    protected void doAfterPropertiesSet() {
        this.setUserDetailsService(userDetailsService);
    }
}
