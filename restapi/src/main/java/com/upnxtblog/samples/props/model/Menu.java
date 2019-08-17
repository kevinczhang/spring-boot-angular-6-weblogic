package com.upnxtblog.samples.props.model;

public class Menu {
	private String name;
	private String path;
	private String title;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Menu{" + "name='" + name + '\'' + ", path='" + path + '\'' + ", title='" + title + '\'' + '}';
	}
}
