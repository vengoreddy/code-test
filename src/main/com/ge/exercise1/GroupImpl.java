package com.ge.exercise1;

public class GroupImpl extends Group {

	private UserImpl[] users;

	public GroupImpl() {
		super("", "");
	}

	public GroupImpl(String id, String name) {
		super(id, name);
	}

	public UserImpl[] getUsers() {
		return users;
	}

	public void setUsers(UserImpl[] users) {
		this.users = users;
	}

}
