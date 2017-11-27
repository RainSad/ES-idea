package com.sys.entity.sys;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * sysUser 实体类 Mon Oct 09 16:32:00 CST 2017 孙文祥
 */
@Component
@Entity
@Table(name = "sys_user")
public class SysUser {

	/** 分享id */
	@Id
	@Column(name = "id", length = 32)
	private String id;

	/** 用户名 */
	@Column(name = "username", length = 64)
	private String username;

	/***/
	@Column(name = "realname", length = 64)
	private String realname;

	/** 昵称 */
	@Column(name = "nickname", length = 64)
	private String nickname;

	/** 密码 */
	@Column(name = "password", length = 255)
	private String password;

	/** 联系电话 */
	@Column(name = "phone", length = 16)
	private String phone;

	/** 邮箱 */
	@Column(name = "email", length = 64)
	private String email;

	/** 生日 */
	@Column(name = "birthday", length = 19)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date birthday;

	/** 性别 0不详 1男 2女 */
	@Column(name = "geneder", length = 2)
	private String geneder;

	/** 注册时间 */
	@Column(name = "reg_time", length = 19)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date regTime;

	/** 部门id */
	@Column(name = "dept_id", length = 32)
	private String deptId;

	/** 1可用 0禁用 */
	@Column(name = "status", length = 2)
	private String status;

	/***/
	@Column(name = "remark", length = 255)
	private String remark;

	public SysUser() {
		super();
	}

	public SysUser(String id, String username, String realname, String nickname, String password, String phone,
			String email, Date birthday, String geneder, Date regTime, String deptId, String status, String remark) {
		super();
		this.id = id;
		this.username = username;
		this.realname = realname;
		this.nickname = nickname;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.birthday = birthday;
		this.geneder = geneder;
		this.regTime = regTime;
		this.deptId = deptId;
		this.status = status;
		this.remark = remark;
	}

	public void setId(String id) {

		this.id = id;
	}

	public String getId() {

		return id;
	}

	public void setUsername(String username) {

		this.username = username;
	}

	public String getUsername() {

		return username;
	}

	public void setRealname(String realname) {

		this.realname = realname;
	}

	public String getRealname() {

		return realname;
	}

	public void setNickname(String nickname) {

		this.nickname = nickname;
	}

	public String getNickname() {

		return nickname;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public String getPassword() {

		return password;
	}

	public void setPhone(String phone) {

		this.phone = phone;
	}

	public String getPhone() {

		return phone;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getEmail() {

		return email;
	}

	public void setBirthday(Date birthday) {

		this.birthday = birthday;
	}

	public Date getBirthday() {

		return birthday;
	}

	public void setGeneder(String geneder) {

		this.geneder = geneder;
	}

	public String getGeneder() {

		return geneder;
	}

	public void setRegTime(Date regTime) {

		this.regTime = regTime;
	}

	public Date getRegTime() {

		return regTime;
	}

	public void setDeptId(String deptId) {

		this.deptId = deptId;
	}

	public String getDeptId() {

		return deptId;
	}

	public void setStatus(String status) {

		this.status = status;
	}

	public String getStatus() {

		return status;
	}

	public void setRemark(String remark) {

		this.remark = remark;
	}

	public String getRemark() {

		return remark;
	}

	@Override
	public String toString() {
		return "SysUser [id=" + id + ", username=" + username + ", realname=" + realname + ", nickname=" + nickname
				+ ", password=" + password + ", phone=" + phone + ", email=" + email + ", birthday=" + birthday
				+ ", geneder=" + geneder + ", regTime=" + regTime + ", deptId=" + deptId + ", status=" + status
				+ ", remark=" + remark + "]";
	}
}
