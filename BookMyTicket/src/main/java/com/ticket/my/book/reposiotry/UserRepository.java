package com.ticket.my.book.reposiotry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ticket.my.book.user.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query(nativeQuery = true, value = "select * from user where user_name = ?1")
	User findByUserName(String username);

	@Query(nativeQuery = true, value="select * from user where email_id=?1")
	User findUserByEmail(String emailId);
	
	
}
