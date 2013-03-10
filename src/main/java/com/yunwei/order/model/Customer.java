package com.yunwei.order.model;

import cn.org.rapid_framework.util.DateConvertUtils;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.github.springrest.base.BaseEntity;

public class Customer extends BaseEntity
  implements Serializable
{
  private static final long serialVersionUID = 5454155825314635342L;
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
  public static final String FORMAT_CTIME = "yyyy-MM-dd";
  private Long custId;

  @Length(max=64)
  @JsonProperty("cust_name")
  @NotEmpty
  private String custName;

  @Length(max=64)
  private String shortName;

  @Length(max=128)
  private String custCode;

  @Length(max=64)
  @JsonProperty("contact_name")
  @NotEmpty
  private String contactName;

  @Length(max=8)
  private String contryCode;

  @Length(max=8)
  private String provCode;

  @Length(max=8)
  private String cityCode;

  @Length(max=256)
  private String address;

  @Length(max=64)
  private String contact;

  @Length(max=64)
  @NotEmpty
  private String telephone;

  @Length(max=64)
  private String fax;

  @Email
  @Length(max=64)
  private String email;

  @Length(max=256)
  private String website;

  @Length(max=128)
  private String bank;

  @Length(max=128)
  private String bankAccount;

  @Length(max=128)
  private String bankAccountName;

  @Length(max=256)
  private String taxId;

  @Length(max=64)
  private String businessPeople;

  @Length(max=64)
  private String collectionPeople;
  private Date ctime;

  @Length(max=512)
  private String remark;

  public Customer()
  {
  }

  public Customer(Long custId)
  {
    this.custId = custId;
  }

  public void setCustId(Long value) {
    this.custId = value;
  }

  public Long getCustId() {
    return this.custId;
  }
  public void setCustName(String value) {
    this.custName = value;
  }

  public String getCustName() {
    return this.custName;
  }
  public void setShortName(String value) {
    this.shortName = value;
  }

  public String getShortName() {
    return this.shortName;
  }
  public void setCustCode(String value) {
    this.custCode = value;
  }

  public String getCustCode() {
    return this.custCode;
  }
  public void setContactName(String value) {
    this.contactName = value;
  }

  public String getContactName() {
    return this.contactName;
  }
  public void setContryCode(String value) {
    this.contryCode = value;
  }

  public String getContryCode() {
    return this.contryCode;
  }
  public void setProvCode(String value) {
    this.provCode = value;
  }

  public String getProvCode() {
    return this.provCode;
  }
  public void setCityCode(String value) {
    this.cityCode = value;
  }

  public String getCityCode() {
    return this.cityCode;
  }
  public void setAddress(String value) {
    this.address = value;
  }

  public String getAddress() {
    return this.address;
  }
  public void setContact(String value) {
    this.contact = value;
  }

  public String getContact() {
    return this.contact;
  }
  public void setTelephone(String value) {
    this.telephone = value;
  }

  public String getTelephone() {
    return this.telephone;
  }
  public void setFax(String value) {
    this.fax = value;
  }

  public String getFax() {
    return this.fax;
  }
  public void setEmail(String value) {
    this.email = value;
  }

  public String getEmail() {
    return this.email;
  }
  public void setWebsite(String value) {
    this.website = value;
  }

  public String getWebsite() {
    return this.website;
  }
  public void setBank(String value) {
    this.bank = value;
  }

  public String getBank() {
    return this.bank;
  }
  public void setBankAccount(String value) {
    this.bankAccount = value;
  }

  public String getBankAccount() {
    return this.bankAccount;
  }
  public void setBankAccountName(String value) {
    this.bankAccountName = value;
  }

  public String getBankAccountName() {
    return this.bankAccountName;
  }
  public void setTaxId(String value) {
    this.taxId = value;
  }

  public String getTaxId() {
    return this.taxId;
  }
  public void setBusinessPeople(String value) {
    this.businessPeople = value;
  }

  public String getBusinessPeople() {
    return this.businessPeople;
  }
  public void setCollectionPeople(String value) {
    this.collectionPeople = value;
  }

  public String getCollectionPeople() {
    return this.collectionPeople;
  }
  public String getCtimeString() {
    return DateConvertUtils.format(getCtime(), "yyyy-MM-dd");
  }
  public void setCtimeString(String value) {
    setCtime(DateConvertUtils.parse(value, "yyyy-MM-dd", Date.class));
  }

  public void setCtime(Date value) {
    this.ctime = value;
  }

  public Date getCtime() {
    return this.ctime;
  }
  public void setRemark(String value) {
    this.remark = value;
  }

  public String getRemark() {
    return this.remark;
  }

  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
      .append("CustId", getCustId())
      .append("CustName", getCustName())
      .append("ShortName", getShortName())
      .append("CustCode", getCustCode())
      .append("ContactName", getContactName())
      .append("ContryCode", getContryCode())
      .append("ProvCode", getProvCode())
      .append("CityCode", getCityCode())
      .append("Address", getAddress())
      .append("Contact", getContact())
      .append("Telephone", getTelephone())
      .append("Fax", getFax())
      .append("Email", getEmail())
      .append("Website", getWebsite())
      .append("Bank", getBank())
      .append("BankAccount", getBankAccount())
      .append("BankAccountName", getBankAccountName())
      .append("TaxId", getTaxId())
      .append("BusinessPeople", getBusinessPeople())
      .append("CollectionPeople", getCollectionPeople())
      .append("Ctime", getCtime())
      .append("Remark", getRemark())
      .toString();
  }

  public int hashCode() {
    return new HashCodeBuilder()
      .append(getCustId())
      .toHashCode();
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof Customer)) return false;
    if (this == obj) return true;
    Customer other = (Customer)obj;
    return new EqualsBuilder()
      .append(getCustId(), other.getCustId())
      .isEquals();
  }
}