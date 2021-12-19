package main.java.model;

public class Reaction {
	String uuid;
	boolean isPositive;
	Alternative alternative;
	TeamMember reactor;
	
	public Reaction() {	}
	public Reaction(String uuid) {}
	public Reaction(String uuid, boolean isPositive, Alternative alternative, TeamMember reactor) {
		this.uuid = uuid;
		this.alternative = alternative;
		this.isPositive = isPositive;
		this.reactor = reactor;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public boolean getIsPositive() {
		return isPositive;
	}
	public void setIsPositive(boolean isPositive) {
		this.isPositive = isPositive;
	}
	public Alternative getAlternative() {
		return alternative;
	}
	public void setAlternative(Alternative alternative) {
		this.alternative = alternative;
	}
	public TeamMember getReactor() {
		return reactor;
	}
	public void setReactor(TeamMember reactor) {
		this.reactor = reactor;
	}
}
