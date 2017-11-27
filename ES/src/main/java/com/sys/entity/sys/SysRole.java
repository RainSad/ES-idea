package com.sys.entity.sys;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * sysRole 实体类 Mon Oct 09 16:32:00 CST 2017 孙文祥
 */
@Component
@Entity
@Table(name = "sys_role")
public class SysRole {

	/** 分享id */
	@Id
	@Column(name = "id", length = 32)
	private String id;

	/** 角色名称 */
	@Column(name = "role_name", length = 64)
	private String roleName;

	/** 角色code */
	@Column(name = "role_code", length = 64)
	private String roleCode;

	/** 时间 */
	@Column(name = "create_time", length = 19)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/** 1可用 0禁用 */
	@Column(name = "status", length = 2)
	private String status;

	/***/
	@Column(name = "remark", length = 255)
	private String remark;

	public SysRole() {
		super();
	}

	public SysRole(String id, String roleName, String roleCode, Date createTime, String status, String remark) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.roleCode = roleCode;
		this.createTime = createTime;
		this.status = status;
		this.remark = remark;
	}

	public void setId(String id) {

		this.id = id;
	}

	public String getId() {

		return id;
	}

	public void setRoleName(String roleName) {

		this.roleName = roleName;
	}

	public String getRoleName() {

		return roleName;
	}

	public void setRoleCode(String roleCode) {

		this.roleCode = roleCode;
	}

	public String getRoleCode() {

		return roleCode;
	}

	public void setCreateTime(Date createTime) {

		this.createTime = createTime;
	}

	public Date getCreateTime() {

		return createTime;
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
		return "SysRole [id=" + id + ", roleName=" + roleName + ", roleCode=" + roleCode + ", createTime=" + createTime
				+ ", status=" + status + ", remark=" + remark + "]";
	}
}
