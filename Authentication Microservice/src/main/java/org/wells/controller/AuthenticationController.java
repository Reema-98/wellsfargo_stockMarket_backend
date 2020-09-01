package org.wells.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wells.models.AddUserRequest;
import org.wells.models.LoginRequest;
import org.wells.models.LoginResponse;
import org.wells.service.AuthenticationService;
import org.wells.util.JwtRequestFilter;
import org.wells.util.JwtUtil;

@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private AuthenticationService userDetailsService;

	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationTokenAdmin(@RequestBody LoginRequest loginRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
			);
			
			
		}
		catch (BadCredentialsException e) {
			return new ResponseEntity<>("Error: Incorrect username or password" , HttpStatus.FORBIDDEN);
		}

		if(!userDetailsService.checkAdmin(loginRequest))
			return new ResponseEntity<>("Error: User not Admin" , HttpStatus.FORBIDDEN);
		
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(loginRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new LoginResponse(jwt));
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest loginRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			return new ResponseEntity<>("Error: Incorrect username or password" , HttpStatus.FORBIDDEN);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(loginRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new LoginResponse(jwt));
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody AddUserRequest user) throws DataIntegrityViolationException {
		
		boolean value = userDetailsService.checkExistingUserName(user);
		if(value==false)
			return new ResponseEntity<>("Error: User already exists with username: "+ user.getUsername() , HttpStatus.FORBIDDEN);
		value= userDetailsService.checkExistingEmail(user);
		if(value==false)
			return new ResponseEntity<>("Error: User already exists with email: "+ user.getEmail() , HttpStatus.FORBIDDEN);
		value =userDetailsService.checkExistingMobile(user);
		if(value==false)
			return new ResponseEntity<>("Error: User already exists with mobile number: "+ user.getMobile() , HttpStatus.FORBIDDEN);
		
		return ResponseEntity.ok(userDetailsService.save(user));
}

}