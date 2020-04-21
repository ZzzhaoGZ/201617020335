package com.am.util;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CatNode {
	private String id;
	private String text;
	private String state;
	private List<?> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<?> getChildren() {
		return children;
	}

	public void setChildren(List<?> children) {
		this.children = children;
	}

}
