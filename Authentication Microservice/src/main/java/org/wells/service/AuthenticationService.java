package org.wells.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.wells.models.AddUserRequest;
import org.wells.models.LoginRequest;
import org.wells.models.User;
import org.wells.models.enums.UserTypes;
import org.wells.util.UserRepository;

import java.util.ArrayList;


@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        
        if(user==null) {
        	throw new UsernameNotFoundException("Error: User not found with username: " + username);
        }
        
    	
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
    }
    
    public boolean checkAdmin(LoginRequest user) throws DataIntegrityViolationException {
        User user1 = userRepository.findByUsername(user.getUsername());
        if(user1.getUserType()==UserTypes.ADMIN)
        	return true;
        return false;
    }
    
    public boolean checkExistingUserName(AddUserRequest user) throws DataIntegrityViolationException {
        User user1 = userRepository.findByUsername(user.getUsername());
        if(user1==null)
        	return true;
        return false;
   	}
    
    public boolean checkExistingEmail(AddUserRequest user) throws DataIntegrityViolationException {
        User user1 = userRepository.findByEmail(user.getEmail());   
        if(user1==null)
        	return true;
        return false;
   	}
    
    public boolean checkExistingMobile(AddUserRequest user) throws DataIntegrityViolationException {
        User user1 = userRepository.findByMobile(user.getMobile());
        if(user1==null)
        	return true;
        return false;
   	}
    
    
	public User save(AddUserRequest userRequest) {
		User newUser = new User();
		newUser.setUsername(userRequest.getUsername());
		newUser.setPassword(userRequest.getPassword());
		newUser.setFirstName(userRequest.getFirstName());
		newUser.setLastName(userRequest.getLastName());
		newUser.setMobile(userRequest.getMobile());
		newUser.setConfirmed(true);
		newUser.setEmail(userRequest.getEmail());
		newUser.setUserType(UserTypes.CONSUMER);
		
		return userRepository.save(newUser);
	}
    
    
}
