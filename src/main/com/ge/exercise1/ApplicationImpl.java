package com.ge.exercise1;

import java.util.Arrays;
import java.util.List;

public class ApplicationImpl extends Application {
	
	private UserImpl[] users;
	private GroupImpl[] groups;
	
	public ApplicationImpl() {
		super("","");
	}
	
	public ApplicationImpl(String id, String name) {
		super(id, name);
	}
	
	public ApplicationImpl(String id, String name, UserImpl[] users, GroupImpl[] groups) {
		super(id, name);
		this.users = users;
		this.groups = groups;
	}
	
	public void setUsers(UserImpl[] users) {
		this.users = users;
	}

	public void setGroups(GroupImpl[] groups) {
		this.groups = groups;
	}
	
	@Override
	public List<User> getUsers() {
		return Arrays.asList(this.users);
	}

	@Override
	public User getUser(String userId) {
		List<User> users = this.getUsers();
		for (User user : users) {
		   if (userId.equals(user.getId())) {
			   return user;
		   }
		}
		return null;
	}

	@Override
	public List<Group> getGroups() {
		return Arrays.asList(this.groups);
	}

	@Override
	public Group getGroup(String groupId) {
		List<Group> groups = this.getGroups();
		for (Group group : groups) {
		   if (groupId.equals(group.getId())) {
			   return group;
		   }
		}
		return null;
	}

}
