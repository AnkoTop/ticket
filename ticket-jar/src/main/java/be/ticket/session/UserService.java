package be.ticket.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import be.ticket.dao.UserDAO;
import be.ticket.entity.User;
import be.ticket.error.InvalidUserException;

@Stateless
@LocalBean
@Named
public class UserService {
	@Inject
	UserDAO userDAO;
	
	public void createUser(User user) throws InvalidUserException {
		if (validUserName(user.getUserName())) {
			userDAO.create(user);
		} else {
			throw new InvalidUserException(String.format("Duplicate user name %s!", user.getUserName()));
		}
	}

	public List<User> findAllUsers() {
		return userDAO.findAll();
	}

	public User findUser(Long id) {
		return userDAO.find(id);
	}

	public User updateUser(User user) {
		return userDAO.update(user);
	}

	public void deleteUser(User user) {
		userDAO.delete(user);
	}
	
	public boolean validUserName(String userName) {
		List<User> result = userDAO.findUsersByUserName(userName);
		return !(result != null && result.size() > 0);
	}

}
