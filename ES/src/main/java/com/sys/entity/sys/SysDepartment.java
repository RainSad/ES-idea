package com.sys.entity.sys;

import java.util.Date;

import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * sysDepartment 实体类
 * Fri Dec 29 14:11:45 CST 2017 孙文祥
 */
@Builder
@Entity
@Table(name = "sys_department")
public class SysDepartment {

    /***/
    @Id
    @Column(name = "id", length = 32)
    private String id;

	/**部门名称*/
    @Column(name = "name", length = 20)
    private String name;

    /**
     * 部门层级
     */
    @Column(name = "level", length = 200)
    private String level;

    /**
     * 部门在当前层级下的顺序，由小到大
     */
    @Column(name = "seq", length = 11)
    private Integer seq;

    /**
     * 部门地址
     */
    @Column(name = "dept_address", length = 255)
    private String deptAddress;

	/**部门电话*/
    @Column(name = "dept_phone", length = 32)
    private String deptPhone;

	/**父id*/
    @Column(name = "parent_id", length = 32)
	private String parentId;

	/***/
	@Column(name = "remark", length = 255)
    private String remark;

	/**创建时间*/
    @Column(name = "create_time", length = 19)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 操作者
     */
    @Column(name = "operator", length = 20)
    private String operator;

    /**
     * 最后一次操作时间
     */
    @Column(name = "operate_time", length = 19)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date operateTime;

    /**
     * 操作者ip
     */
    @Column(name = "operate_ip", length = 20)
    private String operateIp;

    /***/
    @Column(name = "dept_name", length = 128)
    private String deptName;

    /***/
    @Column(name = "type", length = 2)
    private String type;

    public SysDepartment() {
        super();
    }

    public SysDepartment(String id, String name, String level, Integer seq, String deptAddress, String deptPhone, String parentId, String remark, Date createTime, String operator, Date operateTime, String operateIp, String deptName, String type) {
        super();
        this.id = id;
        this.name = name;
		this.level = level;
		this.seq = seq;
		this.deptAddress = deptAddress;
		this.deptPhone = deptPhone;
		this.parentId = parentId;
        this.remark = remark;
        this.createTime = createTime;
        this.operator = operator;
        this.operateTime = operateTime;
        this.operateIp = operateIp;
        this.deptName = deptName;
        this.type = type;
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

    public void setLevel(String level) {

        this.level = level;
    }

    public String getLevel() {

        return level;
    }

    public void setSeq(Integer seq) {

        this.seq = seq;
    }

    public Integer getSeq() {

        return seq;
    }

    public void setDeptAddress(String deptAddress){

		this.deptAddress=deptAddress;
    }

    public String getDeptAddress() {

        return deptAddress;
    }

    public void setDeptPhone(String deptPhone){

		this.deptPhone = deptPhone;
    }

    public String getDeptPhone() {

        return deptPhone;
    }

    public void setParentId(String parentId){

		this.parentId = parentId;
    }

    public String getParentId() {

        return parentId;
    }

    public void setRemark(String remark){

        this.remark = remark;
    }

    public String getRemark() {

        return remark;
    }

    public void setCreateTime(Date createTime){

        this.createTime = createTime;
    }

    public Date getCreateTime() {

        return createTime;
    }

    public void setOperator(String operator) {

        this.operator = operator;
    }

    public String getOperator() {

        return operator;
    }

    public void setOperateTime(Date operateTime) {

        this.operateTime = operateTime;
    }

    public Date getOperateTime() {

        return operateTime;
    }

    public void setOperateIp(String operateIp) {

        this.operateIp = operateIp;
    }

    public String getOperateIp() {

        return operateIp;
    }

    public void setDeptName(String deptName) {

        this.deptName = deptName;
    }

    public String getDeptName() {

        return deptName;
    }

    public void setType(String type){

        this.type=type;
    }

	public String getType() {

        return type;
    }

    @Override
    public String toString() {
        return "SysDepartment [id=" + id + ", name=" + name + ", level=" + level + ", seq=" + seq + ", deptAddress=" + deptAddress + ", deptPhone=" + deptPhone + ", parentId=" + parentId + ", remark=" + remark + ", createTime=" + createTime + ", operator=" + operator + ", operateTime=" + operateTime + ", operateIp=" + operateIp + ", deptName=" + deptName + ", type=" + type + "]";
    }
}

