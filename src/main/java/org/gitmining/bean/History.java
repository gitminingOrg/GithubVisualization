package org.gitmining.bean;

import java.util.List;

public class History {
	private String id;
	private String title;
	private String focus_date;
	private int initial_zoom;
	private String color;
	private String size_importance;
	private List<Event> events;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFocus_date() {
		return focus_date;
	}
	public void setFocus_date(String focus_date) {
		this.focus_date = focus_date;
	}
	public int getInitial_zoom() {
		return initial_zoom;
	}
	public void setInitial_zoom(int initial_zoom) {
		this.initial_zoom = initial_zoom;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize_importance() {
		return size_importance;
	}
	public void setSize_importance(String size_importance) {
		this.size_importance = size_importance;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
}
//"id": "idahoTimeline",
//"title": "A History of Idaho",
//"focus_date": "1981-07-01 12:00",
//"initial_zoom": "45",
//"color": "#82530d",
//"size_importance": "true",