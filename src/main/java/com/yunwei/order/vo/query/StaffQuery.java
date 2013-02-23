/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2013
 */

package com.yunwei.order.vo.query;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

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


public class StaffQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** staffId */
	private java.lang.Long staffId;
	/** deptId */
	private java.lang.Integer deptId;
	/** 员工名称 */
	private java.lang.String staffName;
	/** 登录名称 */
	private java.lang.String loginName;
	/** 密码 */
	private java.lang.String loginPassword;
	/** 职务 */
	private java.lang.String position;
	/** 性别             0=女             1=男             2=其它 */
	private java.lang.Integer gender;
	/** 出生日期 */
	private java.util.Date birthDateBegin;
	private java.util.Date birthDateEnd;
	/** 合同签订日期 */
	private java.util.Date hireDateBegin;
	private java.util.Date hireDateEnd;
	/** 合同到期日期 */
	private java.util.Date matureDateBegin;
	private java.util.Date matureDateEnd;
	/** 身份证号码 */
	private java.lang.String identityCard;
	/** 住址 */
	private java.lang.String address;
	/** 电话 */
	private java.lang.String phone;
	/** 电子邮件 */
	private java.lang.String email;
	/** 创建时间 */
	private java.util.Date ctimeBegin;
	private java.util.Date ctimeEnd;
	/** adminId */
	private java.lang.Long adminId;
	
	private String searchTerm;
	

	public java.lang.Long getStaffId() {
		return this.staffId;
	}
	
	public void setStaffId(java.lang.Long value) {
		this.staffId = value;
	}
	
	public java.lang.Integer getDeptId() {
		return this.deptId;
	}
	
	public void setDeptId(java.lang.Integer value) {
		this.deptId = value;
	}
	
	public java.lang.String getStaffName() {
		return this.staffName;
	}
	
	public void setStaffName(java.lang.String value) {
		this.staffName = value;
	}
	
	public java.lang.String getLoginName() {
		return this.loginName;
	}
	
	public void setLoginName(java.lang.String value) {
		this.loginName = value;
	}
	
	public java.lang.String getLoginPassword() {
		return this.loginPassword;
	}
	
	public void setLoginPassword(java.lang.String value) {
		this.loginPassword = value;
	}
	
	public java.lang.String getPosition() {
		return this.position;
	}
	
	public void setPosition(java.lang.String value) {
		this.position = value;
	}
	
	public java.lang.Integer getGender() {
		return this.gender;
	}
	
	public void setGender(java.lang.Integer value) {
		this.gender = value;
	}
	
	public java.util.Date getBirthDateBegin() {
		return this.birthDateBegin;
	}
	
	public void setBirthDateBegin(java.util.Date value) {
		this.birthDateBegin = value;
	}	
	
	public java.util.Date getBirthDateEnd() {
		return this.birthDateEnd;
	}
	
	public void setBirthDateEnd(java.util.Date value) {
		this.birthDateEnd = value;
	}
	
	public java.util.Date getHireDateBegin() {
		return this.hireDateBegin;
	}
	
	public void setHireDateBegin(java.util.Date value) {
		this.hireDateBegin = value;
	}	
	
	public java.util.Date getHireDateEnd() {
		return this.hireDateEnd;
	}
	
	public void setHireDateEnd(java.util.Date value) {
		this.hireDateEnd = value;
	}
	
	public java.util.Date getMatureDateBegin() {
		return this.matureDateBegin;
	}
	
	public void setMatureDateBegin(java.util.Date value) {
		this.matureDateBegin = value;
	}	
	
	public java.util.Date getMatureDateEnd() {
		return this.matureDateEnd;
	}
	
	public void setMatureDateEnd(java.util.Date value) {
		this.matureDateEnd = value;
	}
	
	public java.lang.String getIdentityCard() {
		return this.identityCard;
	}
	
	public void setIdentityCard(java.lang.String value) {
		this.identityCard = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
	
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.String getPhone() {
		return this.phone;
	}
	
	public void setPhone(java.lang.String value) {
		this.phone = value;
	}
	
	public java.lang.String getEmail() {
		return this.email;
	}
	
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	
	public java.util.Date getCtimeBegin() {
		return this.ctimeBegin;
	}
	
	public void setCtimeBegin(java.util.Date value) {
		this.ctimeBegin = value;
	}	
	
	public java.util.Date getCtimeEnd() {
		return this.ctimeEnd;
	}
	
	public void setCtimeEnd(java.util.Date value) {
		this.ctimeEnd = value;
	}
	
	public java.lang.Long getAdminId() {
		return this.adminId;
	}
	
	public void setAdminId(java.lang.Long value) {
		this.adminId = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	
	
	
}

