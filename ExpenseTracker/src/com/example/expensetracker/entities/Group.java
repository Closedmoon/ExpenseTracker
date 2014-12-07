package com.example.expensetracker.entities;

public class Group {
	
	private int _id;
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String get_name() {
		return name;
	}
	public void set_name(String name) {
		this.name = name;
	}
	public int get_type() {
		return type;
	}
	public void set_type(int type) {
		this.type = type;
	}
	private String name;
	private int type;
	
	
	

}
