package main.java.model;

public class Feedback {
	String uuid;
	String explanation;
	Alternative alternative;
	TeamMember writer;
	String dateCreated;
	
	public Feedback() {	}
	public Feedback(String uuid) {}
	public Feedback(String uuid, String explanation, Alternative alternative, TeamMember writer, String dateCreated) {
		this.uuid = uuid;
		this.alternative = alternative;
		this.explanation = explanation;
		this.dateCreated = dateCreated;
		this.writer = writer;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public Alternative getAlternative() {
		return alternative;
	}
	public void setAlternative(Alternative alternative) {
		this.alternative = alternative;
	}
	public TeamMember getWriter() {
		return writer;
	}
	public void setWriter(TeamMember writer) {
		this.writer = writer;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
}
