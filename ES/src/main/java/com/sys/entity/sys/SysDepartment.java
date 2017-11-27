package com.sys.entity.sys;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * sysDepartment 实体类 Mon Oct 09 16:32:00 CST 2017 孙文祥
 */
@Component
@Entity
@Table(name = "sys_department")
public class SysDepartment {

	/** 分享id */
	@Id
	@Column(name = "id", length = 32)
	private String id;

	/** 部门名称 */
	@Column(name = "dept_name", length = 128)
	private String deptName;

	/** 部门地址 */
	@Column(name = "dept_address", length = 255)
	private String deptAddress;

	/** 部门电话 */
	@Column(name = "dept_phone", length = 32)
	private String deptPhone;

	/** 1菜单 2 权限 */
	@Column(name = "type", length = 2)
	private String type;

	/***/
	@Column(name = "parent_id", length = 32)
	private String parentId;

	/***/
	@Column(name = "remark", length = 255)
	private String remark;

	/** 时间 */
	@Column(name = "create_time", length = 19)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	public SysDepartment() {
		super();
	}

	public SysDepartment(String id, String deptName, String deptAddress, String deptPhone, String type, String parentId,
			String remark, Date createTime) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.deptAddress = deptAddress;
		this.deptPhone = deptPhone;
		this.type = type;
		this.parentId = parentId;
		this.remark = remark;
		this.createTime = createTime;
	}

	public void setId(String id) {

		this.id = id;
	}

	public String getId() {

		return id;
	}

	public void setDeptName(String deptName) {

		this.deptName = deptName;
	}

	public String getDeptName() {

		return deptName;
	}

	public void setDeptAddress(String deptAddress) {

		this.deptAddress = deptAddress;
	}

	public String getDeptAddress() {

		return deptAddress;
	}

	public void setDeptPhone(String deptPhone) {

		this.deptPhone = deptPhone;
	}

	public String getDeptPhone() {

		return deptPhone;
	}

	public void setType(String type) {

		this.type = type;
	}

	public String getType() {

		return type;
	}

	public void setParentId(String parentId) {

		this.parentId = parentId;
	}

	public String getParentId() {

		return parentId;
	}

	public void setRemark(String remark) {

		this.remark = remark;
	}

	public String getRemark() {

		return remark;
	}

	public void setCreateTime(Date createTime) {

		this.createTime = createTime;
	}

	public Date getCreateTime() {

		return createTime;
	}

	@Override
	public String toString() {
		return "SysDepartment [id=" + id + ", deptName=" + deptName + ", deptAddress=" + deptAddress + ", deptPhone="
				+ deptPhone + ", type=" + type + ", parentId=" + parentId + ", remark=" + remark + ", createTime="
				+ createTime + "]";
	}
}
