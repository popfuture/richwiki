package richwiki;

import java.util.Date;

public class Page {
	private String title;
	private String html;
	private String lastAuthor;
	private Date lastEditTime;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getHtml() {
		return html;
	}
	
	public void setHtml(String html) {
		this.html = html;
	}
	
	public String getLastAuthor() {
		return lastAuthor;
	}
	
	public void setLastAuthor(String lastAuthor) {
		this.lastAuthor = lastAuthor;
	}
	
	public Date getLastEditTime() {
		return lastEditTime;
	}
	
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
}
