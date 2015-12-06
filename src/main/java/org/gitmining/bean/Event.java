package org.gitmining.bean;

public class Event {
	private int id;
	private String title;
	private String startdate;
	private String enddate;
	private String description;
	private int low_threshold;
	private int high_threshold;
	private int importance;
	private int ypix;
	private String slug;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getLow_threshold() {
		return low_threshold;
	}
	public void setLow_threshold(int low_threshold) {
		this.low_threshold = low_threshold;
	}
	public int getHigh_threshold() {
		return high_threshold;
	}
	public void setHigh_threshold(int high_threshold) {
		this.high_threshold = high_threshold;
	}
	public int getImportance() {
		return importance;
	}
	public void setImportance(int importance) {
		this.importance = importance;
	}
	public int getYpix() {
		return ypix;
	}
	public void setYpix(int ypix) {
		this.ypix = ypix;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	
}
