package org.wells.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.wells.models.AddUserRequest;
import org.wells.models.User;
import org.wells.service.AuthenticationService;

@DataJpaTest
@RunWith(SpringRunner.class)
public class AuthenticationTests {
	
	@Autowired
	private AddUserRequest UserTest;
	
	@MockBean
	private AuthenticationService authenticationService;
	
	@Test
	@Rollback(false)
	public void testCreateUser() {
		
			UserTest.setUsername("rishabh");
			UserTest.setFirstName("Rishabh");;
			UserTest.setLastName("Sethi");
			UserTest.setPassword("password");
			UserTest.setEmail("email");
			UserTest.setMobile("789456123");
			
			User temp = authenticationService.save(UserTest);
			assertThat(temp.getUsername()).isEqualTo("rishabh");
			
		}
}