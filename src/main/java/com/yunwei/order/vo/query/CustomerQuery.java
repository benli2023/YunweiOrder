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


public class CustomerQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** custId */
	private java.lang.Long custId;
	/** 客户名称 */
	private java.lang.String custName;
	/** 简名 */
	private java.lang.String shortName;
	/** 编码 */
	private java.lang.String custCode;
	/** 联系人 */
	private java.lang.String contactName;
	/** 国家 */
	private java.lang.String contryCode;
	/** 省份 */
	private java.lang.String provCode;
	/** 城市 */
	private java.lang.String cityCode;
	/** 详细地址 */
	private java.lang.String address;
	/** 联系人 */
	private java.lang.String contact;
	/** 联系电话 */
	private java.lang.String telephone;
	/** 传真 */
	private java.lang.String fax;
	/** 电子邮件 */
	private java.lang.String email;
	/** 主页 */
	private java.lang.String website;
	/** 开户银行 */
	private java.lang.String bank;
	/** 账号 */
	private java.lang.String bankAccount;
	/** 开户姓名 */
	private java.lang.String bankAccountName;
	/** 税号 */
	private java.lang.String taxId;
	/** 业务人员 */
	private java.lang.String businessPeople;
	/** 收款人员 */
	private java.lang.String collectionPeople;
	/** 创建时间 */
	private java.util.Date ctimeBegin;
	private java.util.Date ctimeEnd;
	/** 备注 */
	private java.lang.String remark;
	
	private String searchTerm;

	public java.lang.Long getCustId() {
		return this.custId;
	}
	
	public void setCustId(java.lang.Long value) {
		this.custId = value;
	}
	
	public java.lang.String getCustName() {
		return this.custName;
	}
	
	public void setCustName(java.lang.String value) {
		this.custName = value;
	}
	
	public java.lang.String getShortName() {
		return this.shortName;
	}
	
	public void setShortName(java.lang.String value) {
		this.shortName = value;
	}
	
	public java.lang.String getCustCode() {
		return this.custCode;
	}
	
	public void setCustCode(java.lang.String value) {
		this.custCode = value;
	}
	
	public java.lang.String getContactName() {
		return this.contactName;
	}
	
	public void setContactName(java.lang.String value) {
		this.contactName = value;
	}
	
	public java.lang.String getContryCode() {
		return this.contryCode;
	}
	
	public void setContryCode(java.lang.String value) {
		this.contryCode = value;
	}
	
	public java.lang.String getProvCode() {
		return this.provCode;
	}
	
	public void setProvCode(java.lang.String value) {
		this.provCode = value;
	}
	
	public java.lang.String getCityCode() {
		return this.cityCode;
	}
	
	public void setCityCode(java.lang.String value) {
		this.cityCode = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
	
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.String getContact() {
		return this.contact;
	}
	
	public void setContact(java.lang.String value) {
		this.contact = value;
	}
	
	public java.lang.String getTelephone() {
		return this.telephone;
	}
	
	public void setTelephone(java.lang.String value) {
		this.telephone = value;
	}
	
	public java.lang.String getFax() {
		return this.fax;
	}
	
	public void setFax(java.lang.String value) {
		this.fax = value;
	}
	
	public java.lang.String getEmail() {
		return this.email;
	}
	
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	
	public java.lang.String getWebsite() {
		return this.website;
	}
	
	public void setWebsite(java.lang.String value) {
		this.website = value;
	}
	
	public java.lang.String getBank() {
		return this.bank;
	}
	
	public void setBank(java.lang.String value) {
		this.bank = value;
	}
	
	public java.lang.String getBankAccount() {
		return this.bankAccount;
	}
	
	public void setBankAccount(java.lang.String value) {
		this.bankAccount = value;
	}
	
	public java.lang.String getBankAccountName() {
		return this.bankAccountName;
	}
	
	public void setBankAccountName(java.lang.String value) {
		this.bankAccountName = value;
	}
	
	public java.lang.String getTaxId() {
		return this.taxId;
	}
	
	public void setTaxId(java.lang.String value) {
		this.taxId = value;
	}
	
	public java.lang.String getBusinessPeople() {
		return this.businessPeople;
	}
	
	public void setBusinessPeople(java.lang.String value) {
		this.businessPeople = value;
	}
	
	public java.lang.String getCollectionPeople() {
		return this.collectionPeople;
	}
	
	public void setCollectionPeople(java.lang.String value) {
		this.collectionPeople = value;
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
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

