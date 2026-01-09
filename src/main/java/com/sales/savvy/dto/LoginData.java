package com.sales.savvy.dto;
import java.lang.module.ModuleDescriptor.Builder;

public class LoginData {
	private String username;
	private String password;
	public LoginData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginData(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public static Builder builder() {
        return new Builder();
    }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginData [username=" + username + ", password=" + password + "]";
	}
	public static class Builder {
        private String username;
        private String password;
        
        public Builder username(String username) {
            this.username = username;
            return this;
        }
        
        public Builder password(String password) {
            this.password = password;
            return this;
        }
        
        public LoginData build() {
        	LoginData request = new LoginData();
            request.username = this.username;
            request.password = this.password;
            return request;
        }
    }
}
