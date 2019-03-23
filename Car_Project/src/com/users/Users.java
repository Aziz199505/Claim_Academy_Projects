package com.users;

import java.util.ArrayList;
import java.util.List;

import com.user.User;

public class Users {
	private List<User> users = new ArrayList<>();
	
	public Users() {
		super();
	}

	public void addUser(User user) {
		users.add(user);
	}
	
	public void deleteUser(User user) {
		users.remove(user);
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public String usersFormat() {
		String temp = "";
		for(User user: users) {
			temp += user + "\n";
		}
		
		return temp;
	}

	@Override
	public String toString() {
		return usersFormat();
	}
	
	
}
