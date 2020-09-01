package org.wells.tests;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.wells.models.User;
import org.wells.models.enums.UserTypes;
import org.wells.service.AuthenticationService;
import org.wells.util.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthenticationTests {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@MockBean
	private UserRepository userRepo;

		@Test
		public void saveUserTest() {
			
			User user = new User();
			user.setUsername("Shankar");
			user.setPassword("Shankar");
			user.setFirstName("Shankar");
			user.setLastName("Ray");
			user.setMobile("9641657888");
			user.setConfirmed(true);
			user.setEmail("a@gmail.com");
			user.setUserType(UserTypes.CONSUMER);
			when(userRepo.save(user)).thenReturn(user);
			assertEquals(user, authenticationService.save(user));
		}
}