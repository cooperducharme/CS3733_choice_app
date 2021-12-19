package main.java.model;

public class Alternative {
	String uuid;
	String description;
	Choice choice;
	public Alternative() {}
	public Alternative(String uuid) {
		this.uuid = uuid;
	}
	public Alternative(String uuid, String description, Choice choice) {
		this.uuid = uuid;
		this.description = description;
		this.choice = choice;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Choice getChoice() {
		return choice;
	}
	public void setChoice(Choice choice) {
		this.choice = choice;
	}
}
