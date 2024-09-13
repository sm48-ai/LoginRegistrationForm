package in.sp.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entities.User;
import in.sp.main.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean registerUser(User user) {
		try {
			userRepository.save(user);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public User loginUser(String email, String password) {
		
		User dbuser=userRepository.findByEmail(email);
		if(dbuser!=null && dbuser.getPassword().equals(password)) {
			return dbuser;
		}
		return null;
		
		
	}

}
