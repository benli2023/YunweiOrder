/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2013
 */

package com.yunwei.order.model;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.github.springrest.base.JsonDateSerializer;

import java.util.*;

import com.github.springrest.base.*;
import com.github.springrest.util.*;
import org.codehaus.jackson.annotate.*;
import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.yunwei.order.model.*;
import com.yunwei.order.dao.*;
import com.yunwei.order.service.*;
import com.yunwei.order.vo.query.*;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class Staff extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "员工";
	public static final String ALIAS_STAFF_ID = "员工ID";
	public static final String ALIAS_DEPT_ID = "所在部门";
	public static final String ALIAS_STAFF_NAME = "员工名称";
	public static final String ALIAS_LOGIN_NAME = "登录名称";
	public static final String ALIAS_LOGIN_PASSWORD = "密码";
	public static final String ALIAS_POSITION = "职务";
	public static final String ALIAS_GENDER = "性别";
	public static final String ALIAS_BIRTH_DATE = "出生日期";
	public static final String ALIAS_HIRE_DATE = "合同签订日期";
	public static final String ALIAS_MATURE_DATE = "合同到期日期";
	public static final String ALIAS_IDENTITY_CARD = "身份证号码";
	public static final String ALIAS_ADDRESS = "住址";
	public static final String ALIAS_PHONE = "电话";
	public static final String ALIAS_EMAIL = "电子邮件";
	public static final String ALIAS_CTIME = "创建时间";
	public static final String ALIAS_ADMIN_ID = "创建人";
	
	//date formats
	public static final String FORMAT_BIRTH_DATE = DATE_FORMAT;
	public static final String FORMAT_HIRE_DATE = DATE_FORMAT;
	public static final String FORMAT_MATURE_DATE = DATE_FORMAT;
	public static final String FORMAT_CTIME = DATE_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
    /**
     * 员工ID       db_column: staff_id 
     */ 	
	
	
	
	private java.lang.Long staffId;
	
	
	private java.lang.Integer deptId;
	private String deptIdTxt;
	
	
    /**
     * 员工名称       db_column: staff_name 
     */ 	
	@Length(max=128)
	@JsonProperty("staff_name")
	
	private java.lang.String staffName;
	
	
    /**
     * 登录名称       db_column: login_name 
     */ 	
	@Length(max=64)
	
	
	private java.lang.String loginName;
	
	
    /**
     * 密码       db_column: login_password 
     */ 	
	@Length(max=128)
	
	
	private java.lang.String loginPassword;
	
	
    /**
     * 职务       db_column: position 
     */ 	
	@Length(max=8)
	
	
	private java.lang.String position;
	
	
    /**
     * 性别       db_column: gender 
     */ 	
	
	
	
	private java.lang.Integer gender;
	
	
    /**
     * 出生日期       db_column: birth_date 
     */ 	
	
	
	@JsonSerialize(using = JsonDateSerializer.class)
	private java.util.Date birthDate;
	
	
    /**
     * 合同签订日期       db_column: hire_date 
     */ 	
	
	
	@JsonSerialize(using = JsonDateSerializer.class)
	private java.util.Date hireDate;
	
	
    /**
     * 合同到期日期       db_column: mature_date 
     */ 	
	
	
	@JsonSerialize(using = JsonDateSerializer.class)
	private java.util.Date matureDate;
	
	
    /**
     * 身份证号码       db_column: identity_card 
     */ 	
	@Length(max=32)
	
	
	private java.lang.String identityCard;
	
	
    /**
     * 住址       db_column: address 
     */ 	
	@Length(max=256)
	
	
	private java.lang.String address;
	
	
    /**
     * 电话       db_column: phone 
     */ 	
	@Length(max=32)
	
	
	private java.lang.String phone;
	
	
    /**
     * 电子邮件       db_column: email 
     */ 	
	@Email @Length(max=128)
	
	
	private java.lang.String email;
	
	
    /**
     * 创建时间       db_column: cTime 
     */ 	
	
	
	@JsonSerialize(using = JsonDateSerializer.class)
	private java.util.Date ctime;
	
	
	private java.lang.Long adminId;
	private String adminIdTxt;
	
	//columns END

	public Staff(){
	}

	public Staff(
		java.lang.Long staffId
	){
		this.staffId = staffId;
	}

	public void setStaffId(java.lang.Long value) {
		this.staffId = value;
	}
	
	public java.lang.Long getStaffId() {
		return this.staffId;
	}
	public void setDeptId(java.lang.Integer value) {
		this.deptId = value;
	}
	
	public java.lang.Integer getDeptId() {
		return this.deptId;
	}
	public String getDeptIdTxt() {
		return this.deptIdTxt;
	}
	
	public void setDeptIdTxt(String value) {
		this.deptIdTxt = value;
	}
	public void setStaffName(java.lang.String value) {
		this.staffName = value;
	}
	
	public java.lang.String getStaffName() {
		return this.staffName;
	}
	public void setLoginName(java.lang.String value) {
		this.loginName = value;
	}
	
	public java.lang.String getLoginName() {
		return this.loginName;
	}
	public void setLoginPassword(java.lang.String value) {
		this.loginPassword = value;
	}
	
	public java.lang.String getLoginPassword() {
		return this.loginPassword;
	}
	public void setPosition(java.lang.String value) {
		this.position = value;
	}
	
	public java.lang.String getPosition() {
		return this.position;
	}
	public void setGender(java.lang.Integer value) {
		this.gender = value;
	}
	
	public java.lang.Integer getGender() {
		return this.gender;
	}
	public String getBirthDateString() {
		return DateConvertUtils.format(getBirthDate(), FORMAT_BIRTH_DATE);
	}
	public void setBirthDateString(String value) {
		setBirthDate(DateConvertUtils.parse(value, FORMAT_BIRTH_DATE,java.util.Date.class));
	}
	
	public void setBirthDate(java.util.Date value) {
		this.birthDate = value;
	}
	
	public java.util.Date getBirthDate() {
		return this.birthDate;
	}
	public String getHireDateString() {
		return DateConvertUtils.format(getHireDate(), FORMAT_HIRE_DATE);
	}
	public void setHireDateString(String value) {
		setHireDate(DateConvertUtils.parse(value, FORMAT_HIRE_DATE,java.util.Date.class));
	}
	
	public void setHireDate(java.util.Date value) {
		this.hireDate = value;
	}
	
	public java.util.Date getHireDate() {
		return this.hireDate;
	}
	public String getMatureDateString() {
		return DateConvertUtils.format(getMatureDate(), FORMAT_MATURE_DATE);
	}
	public void setMatureDateString(String value) {
		setMatureDate(DateConvertUtils.parse(value, FORMAT_MATURE_DATE,java.util.Date.class));
	}
	
	public void setMatureDate(java.util.Date value) {
		this.matureDate = value;
	}
	
	public java.util.Date getMatureDate() {
		return this.matureDate;
	}
	public void setIdentityCard(java.lang.String value) {
		this.identityCard = value;
	}
	
	public java.lang.String getIdentityCard() {
		return this.identityCard;
	}
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
	public void setPhone(java.lang.String value) {
		this.phone = value;
	}
	
	public java.lang.String getPhone() {
		return this.phone;
	}
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	
	public java.lang.String getEmail() {
		return this.email;
	}
	public String getCtimeString() {
		return DateConvertUtils.format(getCtime(), FORMAT_CTIME);
	}
	public void setCtimeString(String value) {
		setCtime(DateConvertUtils.parse(value, FORMAT_CTIME,java.util.Date.class));
	}
	
	public void setCtime(java.util.Date value) {
		this.ctime = value;
	}
	
	public java.util.Date getCtime() {
		return this.ctime;
	}
	public void setAdminId(java.lang.Long value) {
		this.adminId = value;
	}
	
	public java.lang.Long getAdminId() {
		return this.adminId;
	}
	public String getAdminIdTxt() {
		return this.adminIdTxt;
	}
	
	public void setAdminIdTxt(String value) {
		this.adminIdTxt = value;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("StaffId",getStaffId())
			.append("DeptId",getDeptId())
			.append("StaffName",getStaffName())
			.append("LoginName",getLoginName())
			.append("LoginPassword",getLoginPassword())
			.append("Position",getPosition())
			.append("Gender",getGender())
			.append("BirthDate",getBirthDate())
			.append("HireDate",getHireDate())
			.append("MatureDate",getMatureDate())
			.append("IdentityCard",getIdentityCard())
			.append("Address",getAddress())
			.append("Phone",getPhone())
			.append("Email",getEmail())
			.append("Ctime",getCtime())
			.append("AdminId",getAdminId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStaffId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Staff == false) return false;
		if(this == obj) return true;
		Staff other = (Staff)obj;
		return new EqualsBuilder()
			.append(getStaffId(),other.getStaffId())
			.isEquals();
	}
}

