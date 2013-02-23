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


public class Customer extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Customer";
	public static final String ALIAS_CUST_ID = "custId";
	public static final String ALIAS_CUST_NAME = "客户名称";
	public static final String ALIAS_SHORT_NAME = "简名";
	public static final String ALIAS_CUST_CODE = "编码";
	public static final String ALIAS_CONTACT_NAME = "联系人";
	public static final String ALIAS_CONTRY_CODE = "国家";
	public static final String ALIAS_PROV_CODE = "省份";
	public static final String ALIAS_CITY_CODE = "城市";
	public static final String ALIAS_ADDRESS = "详细地址";
	public static final String ALIAS_CONTACT = "联系人";
	public static final String ALIAS_TELEPHONE = "联系电话";
	public static final String ALIAS_FAX = "传真";
	public static final String ALIAS_EMAIL = "电子邮件";
	public static final String ALIAS_WEBSITE = "主页";
	public static final String ALIAS_BANK = "开户银行";
	public static final String ALIAS_BANK_ACCOUNT = "账号";
	public static final String ALIAS_BANK_ACCOUNT_NAME = "开户姓名";
	public static final String ALIAS_TAX_ID = "税号";
	public static final String ALIAS_BUSINESS_PEOPLE = "业务人员";
	public static final String ALIAS_COLLECTION_PEOPLE = "收款人员";
	public static final String ALIAS_CTIME = "创建时间";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	public static final String FORMAT_CTIME = DATE_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * custId       db_column: cust_id 
     */ 	
	
	private java.lang.Long custId;
    /**
     * 客户名称       db_column: cust_name 
     */ 	
	@Length(max=64)
	@JsonProperty(value="cust_name")
	private java.lang.String custName;
    /**
     * 简名       db_column: short_name 
     */ 	
	@Length(max=64)
	private java.lang.String shortName;
    /**
     * 编码       db_column: cust_code 
     */ 	
	@Length(max=128)
	private java.lang.String custCode;
    /**
     * 联系人       db_column: contact_name 
     */ 	
	@Length(max=64)
	@JsonProperty(value="contact_name")
	private java.lang.String contactName;
    /**
     * 国家       db_column: contry_code 
     */ 	
	@Length(max=8)
	private java.lang.String contryCode;
    /**
     * 省份       db_column: prov_code 
     */ 	
	@Length(max=8)
	private java.lang.String provCode;
    /**
     * 城市       db_column: city_code 
     */ 	
	@Length(max=8)
	private java.lang.String cityCode;
    /**
     * 详细地址       db_column: address 
     */ 	
	@Length(max=256)
	private java.lang.String address;
    /**
     * 联系人       db_column: contact 
     */ 	
	@Length(max=64)
	private java.lang.String contact;
    /**
     * 联系电话       db_column: telephone 
     */ 	
	@Length(max=64)
	private java.lang.String telephone;
    /**
     * 传真       db_column: fax 
     */ 	
	@Length(max=64)
	private java.lang.String fax;
    /**
     * 电子邮件       db_column: email 
     */ 	
	@Email @Length(max=64)
	private java.lang.String email;
    /**
     * 主页       db_column: website 
     */ 	
	@Length(max=256)
	private java.lang.String website;
    /**
     * 开户银行       db_column: bank 
     */ 	
	@Length(max=128)
	private java.lang.String bank;
    /**
     * 账号       db_column: bank_account 
     */ 	
	@Length(max=128)
	private java.lang.String bankAccount;
    /**
     * 开户姓名       db_column: bank_account_name 
     */ 	
	@Length(max=128)
	private java.lang.String bankAccountName;
    /**
     * 税号       db_column: tax_id 
     */ 	
	@Length(max=256)
	private java.lang.String taxId;
    /**
     * 业务人员       db_column: business_people 
     */ 	
	@Length(max=64)
	private java.lang.String businessPeople;
    /**
     * 收款人员       db_column: collection_people 
     */ 	
	@Length(max=64)
	private java.lang.String collectionPeople;
    /**
     * 创建时间       db_column: cTime 
     */ 	
	
	private java.util.Date ctime;
    /**
     * 备注       db_column: remark 
     */ 	
	@Length(max=512)
	private java.lang.String remark;
	//columns END

	public Customer(){
	}

	public Customer(
		java.lang.Long custId
	){
		this.custId = custId;
	}

	public void setCustId(java.lang.Long value) {
		this.custId = value;
	}
	
	public java.lang.Long getCustId() {
		return this.custId;
	}
	public void setCustName(java.lang.String value) {
		this.custName = value;
	}
	
	public java.lang.String getCustName() {
		return this.custName;
	}
	public void setShortName(java.lang.String value) {
		this.shortName = value;
	}
	
	public java.lang.String getShortName() {
		return this.shortName;
	}
	public void setCustCode(java.lang.String value) {
		this.custCode = value;
	}
	
	public java.lang.String getCustCode() {
		return this.custCode;
	}
	public void setContactName(java.lang.String value) {
		this.contactName = value;
	}
	
	public java.lang.String getContactName() {
		return this.contactName;
	}
	public void setContryCode(java.lang.String value) {
		this.contryCode = value;
	}
	
	public java.lang.String getContryCode() {
		return this.contryCode;
	}
	public void setProvCode(java.lang.String value) {
		this.provCode = value;
	}
	
	public java.lang.String getProvCode() {
		return this.provCode;
	}
	public void setCityCode(java.lang.String value) {
		this.cityCode = value;
	}
	
	public java.lang.String getCityCode() {
		return this.cityCode;
	}
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
	public void setContact(java.lang.String value) {
		this.contact = value;
	}
	
	public java.lang.String getContact() {
		return this.contact;
	}
	public void setTelephone(java.lang.String value) {
		this.telephone = value;
	}
	
	public java.lang.String getTelephone() {
		return this.telephone;
	}
	public void setFax(java.lang.String value) {
		this.fax = value;
	}
	
	public java.lang.String getFax() {
		return this.fax;
	}
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	
	public java.lang.String getEmail() {
		return this.email;
	}
	public void setWebsite(java.lang.String value) {
		this.website = value;
	}
	
	public java.lang.String getWebsite() {
		return this.website;
	}
	public void setBank(java.lang.String value) {
		this.bank = value;
	}
	
	public java.lang.String getBank() {
		return this.bank;
	}
	public void setBankAccount(java.lang.String value) {
		this.bankAccount = value;
	}
	
	public java.lang.String getBankAccount() {
		return this.bankAccount;
	}
	public void setBankAccountName(java.lang.String value) {
		this.bankAccountName = value;
	}
	
	public java.lang.String getBankAccountName() {
		return this.bankAccountName;
	}
	public void setTaxId(java.lang.String value) {
		this.taxId = value;
	}
	
	public java.lang.String getTaxId() {
		return this.taxId;
	}
	public void setBusinessPeople(java.lang.String value) {
		this.businessPeople = value;
	}
	
	public java.lang.String getBusinessPeople() {
		return this.businessPeople;
	}
	public void setCollectionPeople(java.lang.String value) {
		this.collectionPeople = value;
	}
	
	public java.lang.String getCollectionPeople() {
		return this.collectionPeople;
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
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("CustId",getCustId())
			.append("CustName",getCustName())
			.append("ShortName",getShortName())
			.append("CustCode",getCustCode())
			.append("ContactName",getContactName())
			.append("ContryCode",getContryCode())
			.append("ProvCode",getProvCode())
			.append("CityCode",getCityCode())
			.append("Address",getAddress())
			.append("Contact",getContact())
			.append("Telephone",getTelephone())
			.append("Fax",getFax())
			.append("Email",getEmail())
			.append("Website",getWebsite())
			.append("Bank",getBank())
			.append("BankAccount",getBankAccount())
			.append("BankAccountName",getBankAccountName())
			.append("TaxId",getTaxId())
			.append("BusinessPeople",getBusinessPeople())
			.append("CollectionPeople",getCollectionPeople())
			.append("Ctime",getCtime())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCustId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Customer == false) return false;
		if(this == obj) return true;
		Customer other = (Customer)obj;
		return new EqualsBuilder()
			.append(getCustId(),other.getCustId())
			.isEquals();
	}
}

