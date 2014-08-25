package com.shabi.forms;

public class SearchJobResponseDTO {
	private String id;
	private String jobTitle;
	private String employer;
	private String client;
	private boolean applied;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getEmployer() {
		return employer;
	}
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public boolean isApplied() {
		return applied;
	}
	public void setApplied(boolean applied) {
		this.applied = applied;
	}
}
