package com.example.demo.datatransfert;

import java.util.List;

public class UserData {

    private String firstname;
    private String lastname;
    private Long roleId;
    private List<Long> booksId;
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Long getRoleId() {
        return roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
	public List<Long> getBooksId() {
		return booksId;
	}
	public void setBooksId(List<Long> booksId) {
		this.booksId = booksId;
	}
}