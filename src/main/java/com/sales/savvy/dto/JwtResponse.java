package com.sales.savvy.dto;

public class JwtResponse {
    private String jwtToken;
    private String username;
    private String role;
    
    // Private constructor for Builder only
    private JwtResponse() {}
    
    public String getJwtToken() { 
        return jwtToken; 
    }
    
    public String getUsername() { 
        return username; 
    }
    
    
    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
    public String toString() {
        return "JwtResponse [jwtToken=" + jwtToken + ", username=" + username + "]";
    }
    
    // ✅ FIX 1: Make Builder STATIC (public static class)
    public static class Builder {
        private String jwtToken;
        private String username;
        private String role;
        // ✅ FIX 2: Complete the static builder() method
        
        public Builder role(String role) {
        	this.role = role;
        	return this;
        }
        public Builder jwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
            return this;
        }
        
        public Builder username(String username) {
            this.username = username;
            return this;
        }
        
        public JwtResponse build() {
            JwtResponse response = new JwtResponse();
            response.jwtToken = this.jwtToken;
            response.username = this.username;
            response.role = this.role;
            return response;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
