package com.example.expensetracker.entities;

import java.util.ArrayList;

public class GroupContacts {
	
	public int get_groupid() {
		return _groupid;
	}
	public void set_groupid(int _groupid) {
		this._groupid = _groupid;
	}
	public ArrayList<Contact> get_contactlist() {
		return _contactlist;
	}
	public void set_contactlist(ArrayList<Contact> _contactlist) {
		this._contactlist = _contactlist;
	}
	public String get_groupname() {
		return _groupname;
	}
	public void set_groupname(String _groupname) {
		this._groupname = _groupname;
	}
	
	
	private int _groupid;
	private ArrayList<Contact> _contactlist;
	private String _groupname;
	
	
	

}
