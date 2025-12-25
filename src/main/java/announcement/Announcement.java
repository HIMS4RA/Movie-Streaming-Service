package announcement;

public class Announcement {
	
	private int id;
	private String date;
	private String category;
	private String title;
	private String content;
	
	public Announcement(int id, String date, String category, String title, String content) {
		
		this.id = id;
		this.date = date;
		this.category = category;
		this.title = title;
		this.content= content;
		
	}

	public int getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public String getCategory() {
		return category;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	
	
}
