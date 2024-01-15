package com.galarto.training.TaskManagementSystem.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public enum Role implements GrantedAuthority {
    USER("USER");

    private final String vale;

    @Override
    public String getAuthority() {
        return vale;
    }
}