package main.java.model;

public class Choice {
	String uuid;
	String title;
	String description;
	String dateCreated;
	Alternative finalAlternative;
	String dateFinalized;
	int memberCount;
	
	public Choice () {}
	public Choice (String uuid) {
		this.uuid = uuid;
	}
	public Choice (String uuid, String title, String description, String dateCreated, int memberCount) {
		this.uuid = uuid;
		this.title = title;
		this.dateCreated = dateCreated;
		this.description = description;
		this.memberCount = memberCount;
	}
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String date) {
		this.dateCreated = date;
	}
	public Alternative getFinalAlternative() {
		return finalAlternative;
	}
	public void setFinalAlternative(Alternative finalAlternative) {
		this.finalAlternative = finalAlternative;
	}
	public String getDateFinalized() {
		return dateFinalized;
	}
	public void setDateFinalized(String dateFinalize) {
		this.dateFinalized = dateFinalize;
	}
	public int getMemberCount() {
		return memberCount;
	}
	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}
}
