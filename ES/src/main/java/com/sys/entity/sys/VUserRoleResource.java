package com.sys.entity.sys;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * vUserRoleResource 实体类 Mon Oct 09 16:32:00 CST 2017 孙文祥
 */
@Component
@Entity
@Table(name = "v_user_role_resource")
public class VUserRoleResource {

	/** 分享用户id */
	@Id
	@Column(name = "user_id", length = 32)
	private String userId;

	/***/
	@Column(name = "role_id", length = 32)
	private String roleId;

	/** 分享id */
	@Column(name = "id", length = 32)
	private String id;

	/** 资源级别 */
	@Column(name = "level", length = 4)
	private byte level;

	/** 资源名称 */
	@Column(name = "name", length = 32)
	private String name;

	/***/
	@Column(name = "parent_id", length = 32)
	private String parentId;

	/** 权限编码 */
	@Column(name = "perm_code", length = 64)
	private String permCode;

	/***/
	@Column(name = "remark", length = 255)
	private String remark;

	/** 排序 */
	@Column(name = "sort", length = 8)
	private int sort;

	/** 1可用 0禁用 */
	@Column(name = "status", length = 2)
	private String status;

	/** 1菜单 2 权限 */
	@Column(name = "type", length = 20)
	private String type;

	/** 资源地址 */
	@Column(name = "url", length = 64)
	private String url;

	/** 时间 */
	@Column(name = "create_time", length = 19)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/***/
	@Column(name = "iconCls", length = 64)
	private String iconCls;

	public VUserRoleResource() {
		super();
	}

	public VUserRoleResource(String userId, String roleId, String id, byte level, String name, String parentId,
			String permCode, String remark, int sort, String status, String type, String url, Date createTime,
			String iconCls) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.id = id;
		this.level = level;
		this.name = name;
		this.parentId = parentId;
		this.permCode = permCode;
		this.remark = remark;
		this.sort = sort;
		this.status = status;
		this.type = type;
		this.url = url;
		this.createTime = createTime;
		this.iconCls = iconCls;
	}

	public void setUserId(String userId) {

		this.userId = userId;
	}

	public String getUserId() {

		return userId;
	}

	public void setRoleId(String roleId) {

		this.roleId = roleId;
	}

	public String getRoleId() {

		return roleId;
	}

	public void setId(String id) {

		this.id = id;
	}

	public String getId() {

		return id;
	}

	public void setLevel(byte level) {

		this.level = level;
	}

	public byte getLevel() {

		return level;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getName() {

		return name;
	}

	public void setParentId(String parentId) {

		this.parentId = parentId;
	}

	public String getParentId() {

		return parentId;
	}

	public void setPermCode(String permCode) {

		this.permCode = permCode;
	}

	public String getPermCode() {

		return permCode;
	}

	public void setRemark(String remark) {

		this.remark = remark;
	}

	public String getRemark() {

		return remark;
	}

	public void setSort(int sort) {

		this.sort = sort;
	}

	public int getSort() {

		return sort;
	}

	public void setStatus(String status) {

		this.status = status;
	}

	public String getStatus() {

		return status;
	}

	public void setType(String type) {

		this.type = type;
	}

	public String getType() {

		return type;
	}

	public void setUrl(String url) {

		this.url = url;
	}

	public String getUrl() {

		return url;
	}

	public void setCreateTime(Date createTime) {

		this.createTime = createTime;
	}

	public Date getCreateTime() {

		return createTime;
	}

	public void setIconCls(String iconCls) {

		this.iconCls = iconCls;
	}

	public String getIconCls() {

		return iconCls;
	}

	@Override
	public String toString() {
		return "VUserRoleResource [userId=" + userId + ", roleId=" + roleId + ", id=" + id + ", level=" + level
				+ ", name=" + name + ", parentId=" + parentId + ", permCode=" + permCode + ", remark=" + remark
				+ ", sort=" + sort + ", status=" + status + ", type=" + type + ", url=" + url + ", createTime="
				+ createTime + ", iconCls=" + iconCls + "]";
	}
}
