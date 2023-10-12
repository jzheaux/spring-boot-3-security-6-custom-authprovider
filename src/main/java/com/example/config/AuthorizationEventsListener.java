package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authorization.event.AuthorizationDeniedEvent;
import org.springframework.security.authorization.event.AuthorizationGrantedEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationEventsListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationEventsListener.class);

    @EventListener
    public void onAuthorizationDeniedEvent(AuthorizationDeniedEvent authorizationDeniedEvent) {
        // ... implement logic
        LOGGER.info("AuthorizationDeniedEvent {}", authorizationDeniedEvent);
    }

    @EventListener
    public void onFailure(AuthorizationGrantedEvent authorizationGrantedEvent) {
        // ... implement logic
        LOGGER.info("AuthorizationGrantedEvent  {}", authorizationGrantedEvent);
    }
}