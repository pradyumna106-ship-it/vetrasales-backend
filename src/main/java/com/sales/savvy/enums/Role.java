package com.sales.savvy.enums;

import org.springframework.security.core.GrantedAuthority;

import jakarta.annotation.Nullable;

public enum Role implements GrantedAuthority {
	ADMIN("ADMIN"),
	CUSTOMER("CUSTOMER");
	
	private String value;
    
    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
	@Override
	public @Nullable String getAuthority() {
		// TODO Auto-generated method stub
		return name();
	}
}
