package com.sales.savvy.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponse;
import org.springframework.web.server.ResponseStatusException;

import com.sales.savvy.SecurityConfig;
import com.sales.savvy.dto.FetchContactDTO;
import com.sales.savvy.dto.JwtResponse;
import com.sales.savvy.dto.LoginData;
import com.sales.savvy.dto.UserDTO;
import com.sales.savvy.entity.User;
import com.sales.savvy.enums.Gender;
import com.sales.savvy.enums.Role;
import com.sales.savvy.enums.userStatus;
import com.sales.savvy.repository.UserRepository;
import com.sales.savvy.security.JwtUtils;

@Service
@Primary
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository repo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
	private JwtUtils jwtUtils;
    @Autowired
	private AuthenticationManager authenticationManager;
    @Override
    public String addUser(UserDTO userDto) {
        // Normalize & check duplicates
        String username = userDto.getUsername().toLowerCase();
        String email = userDto.getEmail().toLowerCase();
        
        if (repo.findByUsername(username).isPresent() || repo.findByEmail(email).isPresent()) {
            return "fail";
        }
        
        // ✅ Convert enums BEFORE builder
        Role role = Role.valueOf(userDto.getRole().toUpperCase());
        Gender gender = Gender.valueOf(userDto.getGender().toUpperCase());
        
        // ✅ Build ONCE with ALL fields
        User user = User.builder()
            .username(username)
            .email(email)
            .password(passwordEncoder.encode(userDto.getPassword()))  // ✅ Hash ONLY
            .phone(userDto.getPhone())
            .gender(gender)
            .location(userDto.getLocation())
            .dob(userDto.getDob())
            .role(role)
            .joinedDate(LocalDate.now())
            .status(userStatus.ACTIVE)
            .authorities(Set.of(role))  // ✅ role now exists
            .enabled(true)
            .accountNonExpired(true)
            .accountNonLocked(true)
            .credentialsNonExpired(true)
            .build();
        
        repo.save(user);
        return "success";
    }


    @Override
    public UserDTO getUser(String username) {
        // Just wrap repo call
    	Optional<User> userOP = repo.findByUsername(username.toLowerCase());
    	User user = userOP.get();
		UserDTO dto = new UserDTO();
		dto.setDob(user.getDob());
		dto.setEmail(user.getEmail());
		dto.setGender(user.getGender().toString());
		dto.setPassword(user.getPassword());
		dto.setRole(user.getRole().toString());
		dto.setUsername(user.getUsername());
		dto.setJoinedDate(user.getJoinedDate());
		dto.setLocation(user.getLocation());
		dto.setPhone(user.getPhone());
		dto.setStatus(user.getStatus().toString());
		dto.setId(user.getId());
        return dto;
    }

    @Override
    public ResponseEntity<?> validateUser(LoginData data) {
        try {
            // 1. Authenticate (validates username + password)
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    data.getUsername().toLowerCase(),  // ✅ Normalize
                    data.getPassword()
                )
            );
            
            SecurityContextHolder.getContext().setAuthentication(authentication);
            
            // 2. Get user details from authentication (SAFER)
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User user = repo.findByUsername(userDetails.getUsername()).get();  // Now guaranteed to exist
            
            // 3. Generate JWT
            String jwtToken = jwtUtils.generateTokenFromUsername(userDetails);
            
            // 4. Response
            JwtResponse response = JwtResponse.builder()
                .username(user.getUsername())
                .role(user.getRole() == Role.ADMIN ? "admin" : "customer")
                .jwtToken(jwtToken)
                .build();
                
            return ResponseEntity.ok(response);
            
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("message", "Invalid credentials"));
        }
    }



	@Override
	public void deleteUser(UUID id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public void deleteAllUser() {
		// TODO Auto-generated method stub
		repo.deleteAll();
	}

	@Override
	public List<UserDTO> searchUser(String name) {
		// TODO Auto-generated method stub
		List<User> users = repo.searchUser(name);
		List<UserDTO> dtos = new ArrayList<>();
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			UserDTO dto = new UserDTO();
			dto.setDob(user.getDob());
			dto.setEmail(user.getEmail());
			dto.setGender(user.getGender().toString());
			dto.setPassword(user.getPassword());
			dto.setRole(user.getRole().toString());
			dto.setUsername(user.getUsername());
			dto.setId(user.getId());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<UserDTO> getAllUser() {
		// TODO Auto-generated method stub
		List<User> users = repo.findAll();
		List<UserDTO> dtos = new ArrayList<>();
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			UserDTO dto = new UserDTO();
			dto.setDob(user.getDob());
			dto.setEmail(user.getEmail());
			dto.setGender(user.getGender().toString());
			dto.setPassword(user.getPassword());
			dto.setRole(user.getRole().toString());
			dto.setUsername(user.getUsername());
			dto.setJoinedDate(user.getJoinedDate());
			dto.setLocation(user.getLocation());
			dto.setPhone(user.getPhone());
			dto.setStatus(user.getStatus().toString());
			dto.setId(user.getId());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public String updateUser(UserDTO userDto) {
		// TODO Auto-generated method stub
		Optional<User> existing = repo.findByUsername(userDto.getUsername());
        if (existing.isPresent()) {
            return "fail";   // already taken
        }
        String username = userDto.getUsername().toLowerCase();
        String email = userDto.getEmail().toLowerCase();
        Role role = Role.valueOf(userDto.getRole().toUpperCase());
        Gender gender = Gender.valueOf(userDto.getGender().toUpperCase());
        User user = User.builder()
        		.id(userDto.getId())
                .username(username)
                .email(email)
                .password(passwordEncoder.encode(userDto.getPassword()))  // ✅ Hash ONLY
                .phone(userDto.getPhone())
                .gender(gender)
                .location(userDto.getLocation())
                .dob(userDto.getDob())
                .role(role)
                .joinedDate(LocalDate.now())
                .status(userStatus.ACTIVE)
                .authorities(Set.of(role))  // ✅ role now exists
                .enabled(true)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .build();
        // New username — save
        repo.save(user);
        return "success";
	}

	@Override
	public List<String> getAllUserEmails() {
		// TODO Auto-generated method stub
		List<User> users = repo.findAll();
		List<String> emails = new ArrayList<>();
		for (int i = 0; i < users.size(); i++) {
			emails.add(users.get(i).getEmail());
		}
		return emails;
	}
	
	@Override
	public List<String> getAllUserPhone() {
		// TODO Auto-generated method stub
		List<User> users = repo.findAll();
		List<String> phones = new ArrayList<>();
		for (int i = 0; i < users.size(); i++) {
			phones.add(users.get(i).getEmail());
		}
		return phones;
	}

	@Override
	public List<UserDTO> getAllAdmin() {
		// TODO Auto-generated method stub
		List<User> users = repo.findByRole(Role.ADMIN);
		List<UserDTO> dtos = new ArrayList<>();
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			UserDTO dto = new UserDTO();
			dto.setDob(user.getDob());
			dto.setEmail(user.getEmail());
			dto.setGender(user.getGender().toString());
			dto.setPassword(user.getPassword());
			dto.setRole(user.getRole().toString());
			dto.setUsername(user.getUsername());
			dto.setJoinedDate(user.getJoinedDate());
			dto.setLocation(user.getLocation());
			dto.setPhone(user.getPhone());
			dto.setStatus(user.getStatus().toString());
			dto.setId(user.getId());
			dtos.add(dto);
		}
		return dtos;
	}
	
	@Override
	public List<UserDTO> getAllCustomer() {
		// TODO Auto-generated method stub
		List<User> users = repo.findByRole(Role.CUSTOMER);
		List<UserDTO> dtos = new ArrayList<>();
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			UserDTO dto = new UserDTO();
			dto.setDob(user.getDob());
			dto.setEmail(user.getEmail());
			dto.setGender(user.getGender().toString());
			dto.setPassword(user.getPassword());
			dto.setRole(user.getRole().toString());
			dto.setUsername(user.getUsername());
			dto.setJoinedDate(user.getJoinedDate());
			dto.setLocation(user.getLocation());
			dto.setPhone(user.getPhone());
			dto.setStatus(user.getStatus().toString());
			dto.setId(user.getId());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public String userStatus(UUID id){
		// TODO Auto-generated method stub
		Optional<User> userOpt = repo.findById(id);
		User user = userOpt.get();
		if(user.getStatus().equals(userStatus.ACTIVE)) {
			user.setStatus(userStatus.DISABLED);
		} else {
			user.setStatus(userStatus.ACTIVE);
		}
		repo.save(user);
		return "changed";
	}

	@Override
	public FetchContactDTO getEmailAndPhoneByUser(String username) {
		// TODO Auto-generated method stub
		Optional<User> userOpt = repo.findByUsername(username);
		FetchContactDTO contact = new FetchContactDTO(userOpt.get().getPhone(),userOpt.get().getEmail());
		return contact;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = repo.findByUsername(username)
 	            .orElseThrow(() ->
 	                    new UsernameNotFoundException("User not found: " + username));
 	    return User.builder()
 	    		.id(user.getId())
 	            .username(user.getUsername())
 	            .email(user.getEmail())
 	            .password(user.getPassword())
 	            .authorities(user.getAuthorities().stream().map(role -> Role.valueOf(role.getAuthority())).collect(Collectors.toSet()))   // ✅ PASS Set<Role> DIRECTLY
 	            .enabled(user.isEnabled())
 	            .accountNonExpired(user.isAccountNonExpired())
 	            .accountNonLocked(user.isAccountNonLocked())
 	            .credentialsNonExpired(user.isCredentialsNonExpired())
 	            .build();
	}

}
