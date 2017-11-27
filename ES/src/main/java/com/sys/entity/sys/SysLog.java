package com.sys.entity.sys;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * sysLog 实体类 Mon Oct 09 16:32:00 CST 2017 孙文祥
 */
@Component
@Entity
@Table(name = "sys_log")
public class SysLog {

	/** 分享id */
	@Id
	@Column(name = "id", length = 32)
	private String id;

	/** ip地址 */
	@Column(name = "ip", length = 32)
	private String ip;

	/** 操作系统 */
	@Column(name = "os", length = 64)
	private String os;

	/** 浏览器 */
	@Column(name = "browser", length = 64)
	private String browser;

	/** 用户名 */
	@Column(name = "opt_user", length = 32)
	private String optUser;

	/***/
	@Column(name = "realname", length = 32)
	private String realname;

	/** 是否成功 1是 0否 */
	@Column(name = "is_success", length = 2)
	private String isSuccess;

	/** 请求参数 */
	@Column(name = "req_param", length = 255)
	private String reqParam;

	/** 请求地址 */
	@Column(name = "req_url", length = 64)
	private String reqUrl;

	/***/
	@Column(name = "login_addr", length = 20)
	private String loginAddr;

	/** 时间 */
	@Column(name = "create_time", length = 19)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/***/
	@Column(name = "end_time", length = 19)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;

	/***/
	@Column(name = "remark", length = 255)
	private String remark;

	public SysLog() {
		super();
	}

	public SysLog(String id, String ip, String os, String browser, String optUser, String realname, String isSuccess,
			String reqParam, String reqUrl, String loginAddr, Date createTime, Date endTime, String remark) {
		super();
		this.id = id;
		this.ip = ip;
		this.os = os;
		this.browser = browser;
		this.optUser = optUser;
		this.realname = realname;
		this.isSuccess = isSuccess;
		this.reqParam = reqParam;
		this.reqUrl = reqUrl;
		this.loginAddr = loginAddr;
		this.createTime = createTime;
		this.endTime = endTime;
		this.remark = remark;
	}

	public void setId(String id) {

		this.id = id;
	}

	public String getId() {

		return id;
	}

	public void setIp(String ip) {

		this.ip = ip;
	}

	public String getIp() {

		return ip;
	}

	public void setOs(String os) {

		this.os = os;
	}

	public String getOs() {

		return os;
	}

	public void setBrowser(String browser) {

		this.browser = browser;
	}

	public String getBrowser() {

		return browser;
	}

	public void setOptUser(String optUser) {

		this.optUser = optUser;
	}

	public String getOptUser() {

		return optUser;
	}

	public void setRealname(String realname) {

		this.realname = realname;
	}

	public String getRealname() {

		return realname;
	}

	public void setIsSuccess(String isSuccess) {

		this.isSuccess = isSuccess;
	}

	public String getIsSuccess() {

		return isSuccess;
	}

	public void setReqParam(String reqParam) {

		this.reqParam = reqParam;
	}

	public String getReqParam() {

		return reqParam;
	}

	public void setReqUrl(String reqUrl) {

		this.reqUrl = reqUrl;
	}

	public String getReqUrl() {

		return reqUrl;
	}

	public void setLoginAddr(String loginAddr) {

		this.loginAddr = loginAddr;
	}

	public String getLoginAddr() {

		return loginAddr;
	}

	public void setCreateTime(Date createTime) {

		this.createTime = createTime;
	}

	public Date getCreateTime() {

		return createTime;
	}

	public void setEndTime(Date endTime) {

		this.endTime = endTime;
	}

	public Date getEndTime() {

		return endTime;
	}

	public void setRemark(String remark) {

		this.remark = remark;
	}

	public String getRemark() {

		return remark;
	}

	@Override
	public String toString() {
		return "SysLog [id=" + id + ", ip=" + ip + ", os=" + os + ", browser=" + browser + ", optUser=" + optUser
				+ ", realname=" + realname + ", isSuccess=" + isSuccess + ", reqParam=" + reqParam + ", reqUrl="
				+ reqUrl + ", loginAddr=" + loginAddr + ", createTime=" + createTime + ", endTime=" + endTime
				+ ", remark=" + remark + "]";
	}
}
