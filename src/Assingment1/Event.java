package Assingment1;

public class Event extends Post{

	private String Venue;
	private String Date;
	private int Capacity;
	private int AttendeeCount;

	public Event(String eventname, String description, String venue, String date, int capacity) {
		super(eventname, description);
		Venue = venue;
		Date = date;
		Capacity = capacity;
		AttendeeCount = 0;
	}
	
	@Override
	public String getPostDetails() {
		String temp;
		temp = super.getPostDetails();
		temp += "Venue : "+ Venue + "/n" + "Date : "+ Date + "/n" + "Capacity : "+ Capacity + "/n" +
				"Attendees : "+ AttendeeCount + "/n";
		return temp;
	}

	// still need to complete its checks
	@Override
	public boolean handleReply(Reply reply) {
		// to set status based on capacity
		if(AttendeeCount == Capacity) {
			super.setStatus(false);
		}
		if(reply.getValue()==1 && super.isStatus())
		{
			Replies.add(reply);
			return true;
		}
		return false;
	}

	@Override
	public String getReplyDetails() {
		String AttendeeList = null;
		if(Replies.size() > 0)
		{
			AttendeeList = "Attendee List : ";
			for(int i=0;i<Replies.size();i++){
				if(Replies.get(i).getValue() == 1)
					AttendeeList += Replies.get(i).getResponderID();
			}

		}
		return AttendeeList;
	}

	// Getter and setters methods below
	public String getVenue() {
		return Venue;
	}

	public int getAttendeeCount() {
		return AttendeeCount;
	}

	public void setAttendeeCount(int attendeeCount) {
		AttendeeCount = attendeeCount;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public int getCapacity() {
		return Capacity;
	}

	public void setCapacity(int capacity) {
		Capacity = capacity;
	}

	public void setVenue(String venue) {
		Venue = venue;
	}
	

}
