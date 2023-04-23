package ch.fhnw.crm.exchangeWebservice.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.fhnw.crm.exchangeWebservice.data.domain.User;

// declaring a database relation user (the user of the application)

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	User findByUsernameAndPassword(String username, String password);
	User findByEmailAndIdAndNameNot(String email, Long userId, String usernames);
	User findByUsername(String username);
	static User findByUsernameAndIdNot(String username, Long userId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findByUsernameAndIdNot'");
	}
	User findByItemId(Long itemId);
	User findByTransaction_Id(Long transactionId);
	static User findByUserId(Long userId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findByUserId'");
	}

	// Delete user by username

	void deleteByUsername(String username);

	// Count number of users

	long count();

	
	

	
}