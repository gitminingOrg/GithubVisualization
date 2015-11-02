package org.gitmining.bean;

public class User {
	private int id;
	private String login;
	private String type;
	private boolean site_admin;
	private String name;
	private String company;
	private String blog;
	private String location;
	private String email;
	private boolean hireable;
	private String bio;
	private int public_repos;
	private int public_gists;
	private int followers;
	private int following;
	private String create_at;
	private String update_at;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isSite_admin() {
		return site_admin;
	}
	public void setSite_admin(boolean site_admin) {
		this.site_admin = site_admin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBlog() {
		return blog;
	}
	public void setBlog(String blog) {
		this.blog = blog;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isHireable() {
		return hireable;
	}
	public void setHireable(boolean hireable) {
		this.hireable = hireable;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public int getPublic_repos() {
		return public_repos;
	}
	public void setPublic_repos(int public_repos) {
		this.public_repos = public_repos;
	}
	public int getPublic_gists() {
		return public_gists;
	}
	public void setPublic_gists(int public_gists) {
		this.public_gists = public_gists;
	}
	public int getFollowers() {
		return followers;
	}
	public void setFollowers(int followers) {
		this.followers = followers;
	}
	public int getFollowing() {
		return following;
	}
	public void setFollowing(int following) {
		this.following = following;
	}
	public String getCreate_at() {
		return create_at;
	}
	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}
	public String getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(String update_at) {
		this.update_at = update_at;
	}
	public User(int id, String login, String type, boolean site_admin,
			String name, String company, String blog, String location,
			String email, boolean hireable, String bio, int public_repos,
			int public_gists, int followers, int following, String create_at,
			String update_at) {
		super();
		this.id = id;
		this.login = login;
		this.type = type;
		this.site_admin = site_admin;
		this.name = name;
		this.company = company;
		this.blog = blog;
		this.location = location;
		this.email = email;
		this.hireable = hireable;
		this.bio = bio;
		this.public_repos = public_repos;
		this.public_gists = public_gists;
		this.followers = followers;
		this.following = following;
		this.create_at = create_at;
		this.update_at = update_at;
	}
	
}
