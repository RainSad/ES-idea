package com.sys.entity.user;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity
@Table(name = "user")
public class User {

	/**
	 * @Fields serialVersionUID : TODO(用户登录实体)
	 */
	@Id
	@Column(length = 32)
	private String id;
	@Column(name = "user_name", length = 20)
	private String userName;
	@Column(name = "pass_word", length = 20)
	private String passWord;
	@Column(name = "nick_wame", length = 20)
	private String nickName;

	public User() {
		super();
	}
	

	public User(String id, String userName, String passWord, String nickName) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.nickName = nickName;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", nickName=" + nickName + "]";
	}

}
