package main.java.model;

public class TeamMember {
	String uuid;
	Choice choice;
	String username;
	String password;
	
	public TeamMember() {}
	public TeamMember(String uuid) {
		this.uuid = uuid;
	}
	public TeamMember(String uuid, Choice choice, String username) {
		this.uuid = uuid;
		this.choice = choice;
		this.username = username;
	}
	public TeamMember(String uuid, Choice choice, String username, String password) {
		this.uuid = uuid;
		this.choice = choice;
		this.username = username;
		this.password = password;
	}
}
