package com.yunwei.order.vo.query;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.springrest.base.BaseQuery;

public class CustomerQuery extends BaseQuery
  implements Serializable
{
  private static final long serialVersionUID = 3148176768559230877L;
  private Long custId;
  private String custName;
  private String shortName;
  private String custCode;
  private String contactName;
  private String contryCode;
  private String provCode;
  private String cityCode;
  private String address;
  private String contact;
  private String telephone;
  private String fax;
  private String email;
  private String website;
  private String bank;
  private String bankAccount;
  private String bankAccountName;
  private String taxId;
  private String businessPeople;
  private String collectionPeople;
  private Date ctimeBegin;
  private Date ctimeEnd;
  private String remark;
  private String searchTerm;

  public Long getCustId()
  {
    return this.custId;
  }

  public void setCustId(Long value) {
    this.custId = value;
  }

  public String getCustName() {
    return this.custName;
  }

  public void setCustName(String value) {
    this.custName = value;
  }

  public String getShortName() {
    return this.shortName;
  }

  public void setShortName(String value) {
    this.shortName = value;
  }

  public String getCustCode() {
    return this.custCode;
  }

  public void setCustCode(String value) {
    this.custCode = value;
  }

  public String getContactName() {
    return this.contactName;
  }

  public void setContactName(String value) {
    this.contactName = value;
  }

  public String getContryCode() {
    return this.contryCode;
  }

  public void setContryCode(String value) {
    this.contryCode = value;
  }

  public String getProvCode() {
    return this.provCode;
  }

  public void setProvCode(String value) {
    this.provCode = value;
  }

  public String getCityCode() {
    return this.cityCode;
  }

  public void setCityCode(String value) {
    this.cityCode = value;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String value) {
    this.address = value;
  }

  public String getContact() {
    return this.contact;
  }

  public void setContact(String value) {
    this.contact = value;
  }

  public String getTelephone() {
    return this.telephone;
  }

  public void setTelephone(String value) {
    this.telephone = value;
  }

  public String getFax() {
    return this.fax;
  }

  public void setFax(String value) {
    this.fax = value;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String value) {
    this.email = value;
  }

  public String getWebsite() {
    return this.website;
  }

  public void setWebsite(String value) {
    this.website = value;
  }

  public String getBank() {
    return this.bank;
  }

  public void setBank(String value) {
    this.bank = value;
  }

  public String getBankAccount() {
    return this.bankAccount;
  }

  public void setBankAccount(String value) {
    this.bankAccount = value;
  }

  public String getBankAccountName() {
    return this.bankAccountName;
  }

  public void setBankAccountName(String value) {
    this.bankAccountName = value;
  }

  public String getTaxId() {
    return this.taxId;
  }

  public void setTaxId(String value) {
    this.taxId = value;
  }

  public String getBusinessPeople() {
    return this.businessPeople;
  }

  public void setBusinessPeople(String value) {
    this.businessPeople = value;
  }

  public String getCollectionPeople() {
    return this.collectionPeople;
  }

  public void setCollectionPeople(String value) {
    this.collectionPeople = value;
  }

  public Date getCtimeBegin() {
    return this.ctimeBegin;
  }

  public void setCtimeBegin(Date value) {
    this.ctimeBegin = value;
  }

  public Date getCtimeEnd() {
    return this.ctimeEnd;
  }

  public void setCtimeEnd(Date value) {
    this.ctimeEnd = value;
  }

  public String getRemark() {
    return this.remark;
  }

  public void setRemark(String value) {
    this.remark = value;
  }

  public String getSearchTerm()
  {
    return this.searchTerm;
  }

  public void setSearchTerm(String searchTerm) {
    this.searchTerm = searchTerm;
  }

  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
}