package com.sys.entity.sys;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * sysResources 实体类 Mon Oct 09 16:32:00 CST 2017 孙文祥
 */
@Component
@Entity
@Table(name = "sys_resources")
public class SysResources {

	/** 分享id */
	@Id
	@Column(name = "id", length = 32)
	private String id;

	/** 资源名称 */
	@Column(name = "name", length = 32)
	private String name;

	/** 资源地址 */
	@Column(name = "url", length = 64)
	private String url;

	/***/
	@Column(name = "parent_id", length = 32)
	private String parentId;

	/** 权限编码 */
	@Column(name = "perm_code", length = 64)
	private String permCode;

	/***/
	@Column(name = "iconCls", length = 64)
	private String iconCls;

	/** 资源级别 */
	@Column(name = "level", length = 4)
	private byte level;

	/** 排序 */
	@Column(name = "sort", length = 8)
	private int sort;

	/** 1菜单 2 权限 */
	@Column(name = "type", length = 20)
	private String type;

	/** 1可用 0禁用 */
	@Column(name = "status", length = 2)
	private String status;

	/***/
	@Column(name = "remark", length = 255)
	private String remark;

	/** 时间 */
	@Column(name = "create_time", length = 19)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	public SysResources() {
		super();
	}

	public SysResources(String id, String name, String url, String parentId, String permCode, String iconCls,
			byte level, int sort, String type, String status, String remark, Date createTime) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.parentId = parentId;
		this.permCode = permCode;
		this.iconCls = iconCls;
		this.level = level;
		this.sort = sort;
		this.type = type;
		this.status = status;
		this.remark = remark;
		this.createTime = createTime;
	}

	public void setId(String id) {

		this.id = id;
	}

	public String getId() {

		return id;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getName() {

		return name;
	}

	public void setUrl(String url) {

		this.url = url;
	}

	public String getUrl() {

		return url;
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

	public void setIconCls(String iconCls) {

		this.iconCls = iconCls;
	}

	public String getIconCls() {

		return iconCls;
	}

	public void setLevel(byte level) {

		this.level = level;
	}

	public byte getLevel() {

		return level;
	}

	public void setSort(int sort) {

		this.sort = sort;
	}

	public int getSort() {

		return sort;
	}

	public void setType(String type) {

		this.type = type;
	}

	public String getType() {

		return type;
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

	public void setCreateTime(Date createTime) {

		this.createTime = createTime;
	}

	public Date getCreateTime() {

		return createTime;
	}

	@Override
	public String toString() {
		return "SysResources [id=" + id + ", name=" + name + ", url=" + url + ", parentId=" + parentId + ", permCode="
				+ permCode + ", iconCls=" + iconCls + ", level=" + level + ", sort=" + sort + ", type=" + type
				+ ", status=" + status + ", remark=" + remark + ", createTime=" + createTime + "]";
	}
}
