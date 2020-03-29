package Assingment1;

public class Reply {
	
	private String PostID;
	private double value;
	private String ResponderID;

	
	// Mutators and Accesors
	public String getPostID() {
		return PostID;
	}

	public void setPostID(String postID) {
		PostID = postID;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getResponderID() {
		return ResponderID;
	}

	public void setResponderID(String responderID) {
		ResponderID = responderID;
	}

	// constructor
	public Reply(String postID, double value, String responderID) {
		PostID = postID;
		this.value = value;
		ResponderID = responderID;
	}

}
