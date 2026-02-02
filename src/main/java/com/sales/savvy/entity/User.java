package com.sales.savvy.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.savvy.enums.Gender;
import com.sales.savvy.enums.Role;
import com.sales.savvy.enums.userStatus;

import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "user")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) // ✅ Tells JPA to auto-generate IDs
    private UUID id;
    private String username;
    @Column(unique = true)
    private String email;
    private String phone;
    private String password;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String location;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private Role role;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinedDate;
    @Enumerated(EnumType.STRING)
    private userStatus status;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> authorities;

    private boolean accountNonExpired;
    private boolean enabled;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;

 // User.java
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Product> products;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Review> reviews;

    // Getters & Setters
	public User() {
        // JPA only
    }
	private User(Builder builder) {
	    this.id = builder.id;
	    this.username = builder.username;  // Remove duplicate line
	    this.email = builder.email;
	    this.phone = builder.phone;
	    this.password = builder.password;
	    this.gender = builder.gender;
	    this.location = builder.location;
	    this.dob = builder.dob;
	    this.role = builder.role;  // Or remove if using only authorities
	    this.joinedDate = builder.joinedDate;
	    this.status = builder.status;
	    this.authorities = builder.authorities;
	    this.accountNonExpired = builder.accountNonExpired;
	    this.enabled = builder.enabled;
	    this.accountNonLocked = builder.accountNonLocked;
	    this.credentialsNonExpired = builder.credentialsNonExpired;
	}

    public String getUsername() { return username; }
    public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public LocalDate getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(LocalDate joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getLocation() {
		return this.location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public userStatus getStatus() {
		return status;
	}

	public void setStatus(userStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", phone=" + phone + ", password="
				+ password + ", gender=" + gender + ", location=" + location + ", dob=" + dob + ", role=" + role
				+ ", joinedDate=" + joinedDate + ", status=" + status + "]";
	}
	public Set<Role> getAuthorities() {
    	if (authorities == null) {
            return Set.of();
        }
        return authorities;
    }

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public void setAuthorities(Set<Role> authorities) {
		this.authorities = authorities;
	}

	 public static class Builder {
		    private UUID id;
		    private String username;
		    private String email;
		    private String phone = "";
		    private Gender gender;
		    private String location = "";
		    private LocalDate dob;
		    private Role role;  // Or remove if using authorities only
		    private LocalDate joinedDate = LocalDate.now();
		    private userStatus status = userStatus.ACTIVE;  // Assume enum default
		    private String password;
		    private Set<Role> authorities = Set.of();
		    private boolean accountNonExpired = true;
		    private boolean enabled = true;
		    private boolean accountNonLocked = true;
		    private boolean credentialsNonExpired = true;
			public Builder(UUID id, String username, String email, String password, Set<Role> authorities,
					boolean accountNonExpired, boolean enabled, boolean accountNonLocked,
					boolean credentialsNonExpired) {
				super();
				this.id = id;
				this.username = username;
				this.email = email;
				this.password = password;
				this.authorities = authorities;
				this.accountNonExpired = accountNonExpired;
				this.enabled = enabled;
				this.accountNonLocked = accountNonLocked;
				this.credentialsNonExpired = credentialsNonExpired;
			}
			public Builder() {
				super();
				// TODO Auto-generated constructor stub
			}
			public Builder id(UUID id) { this.id = id; return this; }
		    public Builder username(String username) { this.username = username; return this; }
		    public Builder email(String email) { this.email = email; return this; }
		    public Builder phone(String phone) { this.phone = phone; return this; }
		    public Builder gender(Gender gender) { this.gender = gender; return this; }
		    public Builder location(String location) { this.location = location; return this; }
		    public Builder dob(LocalDate dob) { this.dob = dob; return this; }
		    public Builder role(Role role) { this.role = role; return this; }
		    public Builder joinedDate(LocalDate joinedDate) { this.joinedDate = joinedDate; return this; }
		    public Builder status(userStatus status) { this.status = status; return this; }
		    public Builder password(String password) { this.password = password; return this; }
		    public Builder authorities(Set<Role> authorities) { this.authorities = authorities; return this; }
		    public Builder accountNonExpired(boolean val) { this.accountNonExpired = val; return this; }
		    public Builder enabled(boolean val) { this.enabled = val; return this; }
		    public Builder accountNonLocked(boolean val) { this.accountNonLocked = val; return this; }
		    public Builder credentialsNonExpired(boolean val) { this.credentialsNonExpired = val; return this; }
			public Builder(UUID id, String username, String email, String phone, Gender gender, String password,
					Set<Role> authorities, boolean accountNonExpired, boolean enabled, boolean accountNonLocked,
					boolean credentialsNonExpired) {
				super();
				this.id = id;
				this.username = username;
				this.email = email;
				this.phone = phone;
				this.gender = gender;
				this.password = password;
				this.authorities = authorities;
				this.accountNonExpired = accountNonExpired;
				this.enabled = enabled;
				this.accountNonLocked = accountNonLocked;
				this.credentialsNonExpired = credentialsNonExpired;
			}
			public UUID getId() {
				return id;
			}
			public void setId(UUID id) {
				this.id = id;
			}
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}
			public Set<Role> getAuthorities() {
				return authorities;
			}
			public void setAuthorities(Set<Role> authorities) {
				this.authorities = authorities;
			}
			public boolean isAccountNonExpired() {
				return accountNonExpired;
			}
			public void setAccountNonExpired(boolean accountNonExpired) {
				this.accountNonExpired = accountNonExpired;
			}
			public boolean isEnabled() {
				return enabled;
			}
			public void setEnabled(boolean enabled) {
				this.enabled = enabled;
			}
			public boolean isAccountNonLocked() {
				return accountNonLocked;
			}
			public void setAccountNonLocked(boolean accountNonLocked) {
				this.accountNonLocked = accountNonLocked;
			}
			public boolean isCredentialsNonExpired() {
				return credentialsNonExpired;
			}
			public void setCredentialsNonExpired(boolean credentialsNonExpired) {
				this.credentialsNonExpired = credentialsNonExpired;
			}
			public static Builder builder() { return new Builder(); }
	        public User build() {
	            if (email == null || password == null || username == null) {
	                throw new IllegalStateException("Email and password must not be null");
	            }
	            return new User(this);
	        }
			@Override
			public String toString() {
				return "Builder [id=" + id + " username=" + username + ", email=" + email
						+ ", password=" + password + ", authorities=" + authorities + ", accountNonExpired="
						+ accountNonExpired + ", enabled=" + enabled + ", accountNonLocked=" + accountNonLocked
						+ ", credentialsNonExpired=" + credentialsNonExpired + "]";
			}
	        
	 }

	 public static Builder builder() {
		// TODO Auto-generated method stub
		return new Builder();
	 }
	 
}
