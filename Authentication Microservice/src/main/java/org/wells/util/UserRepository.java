package org.wells.util;

import org.springframework.data.repository.CrudRepository;
import org.wells.models.User;
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
    
    User save(User entity);

	User findByEmail(String email);

	User findByMobile(String mobile);
}