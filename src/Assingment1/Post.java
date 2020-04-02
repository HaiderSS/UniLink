package Assingment1;

import java.util.ArrayList; // import the ArrayList class

public abstract class Post {
	
	protected String Id;
	private String title;
	private String Description;
	protected String CreaterID;
	private boolean status;
	protected ArrayList<Reply> Replies;

	
	protected Post(String id ,String Title, String description, String createrid){
		Id = id;
		title = Title;
		Description = description;
		Replies = new ArrayList<Reply>(); // Create an ArrayList object
		CreaterID = createrid;
		status = true;
	}
	
	public String getPostDetails() {
		String temp;
		temp = "ID : "+ Id + "\n" + "Title : " + title + "\n" + "Description : " + Description +
				"\n" + "Creator ID : " + CreaterID + "\n" + "Status : " + status + "\n";
		return temp;
	}
	
	// setters and getters
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	// abstract methods
	public abstract boolean handleReply(Reply reply);

	public abstract String getReplyDetails();

	public abstract String getPostId();

	public abstract String getCreaterID();

}
