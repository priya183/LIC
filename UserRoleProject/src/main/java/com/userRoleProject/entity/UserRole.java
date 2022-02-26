package com.userRoleProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userRoleId;
	@JoinColumn
	@ManyToOne
	private User userId;
	@JoinColumn
	@ManyToOne
	private Role roleId;
	public Integer getUser_role_id() {
		return userRoleId;
	}
	public void setUser_role_id(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public Role getRoleId() {
		return roleId;
	}
	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserRole [user_role_id=" + userRoleId + ", userId=" + userId + ", roleId=" + roleId + "]";
	}
	
	

}

