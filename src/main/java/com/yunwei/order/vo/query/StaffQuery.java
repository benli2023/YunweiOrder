package com.yunwei.order.vo.query;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.springrest.base.BaseQuery;

public class StaffQuery extends BaseQuery
  implements Serializable
{
  private static final long serialVersionUID = 3148176768559230877L;
  private Long staffId;
  private Integer deptId;
  private String staffName;
  private String loginName;
  private String loginPassword;
  private String position;
  private Integer gender;
  private Date birthDateBegin;
  private Date birthDateEnd;
  private Date hireDateBegin;
  private Date hireDateEnd;
  private Date matureDateBegin;
  private Date matureDateEnd;
  private String identityCard;
  private String address;
  private String phone;
  private String email;
  private Date ctimeBegin;
  private Date ctimeEnd;
  private Long adminId;

  public Long getStaffId()
  {
    return this.staffId;
  }

  public void setStaffId(Long value) {
    this.staffId = value;
  }

  public Integer getDeptId() {
    return this.deptId;
  }

  public void setDeptId(Integer value) {
    this.deptId = value;
  }

  public String getStaffName() {
    return this.staffName;
  }

  public void setStaffName(String value) {
    this.staffName = value;
  }

  public String getLoginName() {
    return this.loginName;
  }

  public void setLoginName(String value) {
    this.loginName = value;
  }

  public String getLoginPassword() {
    return this.loginPassword;
  }

  public void setLoginPassword(String value) {
    this.loginPassword = value;
  }

  public String getPosition() {
    return this.position;
  }

  public void setPosition(String value) {
    this.position = value;
  }

  public Integer getGender() {
    return this.gender;
  }

  public void setGender(Integer value) {
    this.gender = value;
  }

  public Date getBirthDateBegin() {
    return this.birthDateBegin;
  }

  public void setBirthDateBegin(Date value) {
    this.birthDateBegin = value;
  }

  public Date getBirthDateEnd() {
    return this.birthDateEnd;
  }

  public void setBirthDateEnd(Date value) {
    this.birthDateEnd = value;
  }

  public Date getHireDateBegin() {
    return this.hireDateBegin;
  }

  public void setHireDateBegin(Date value) {
    this.hireDateBegin = value;
  }

  public Date getHireDateEnd() {
    return this.hireDateEnd;
  }

  public void setHireDateEnd(Date value) {
    this.hireDateEnd = value;
  }

  public Date getMatureDateBegin() {
    return this.matureDateBegin;
  }

  public void setMatureDateBegin(Date value) {
    this.matureDateBegin = value;
  }

  public Date getMatureDateEnd() {
    return this.matureDateEnd;
  }

  public void setMatureDateEnd(Date value) {
    this.matureDateEnd = value;
  }

  public String getIdentityCard() {
    return this.identityCard;
  }

  public void setIdentityCard(String value) {
    this.identityCard = value;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String value) {
    this.address = value;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String value) {
    this.phone = value;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String value) {
    this.email = value;
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

  public Long getAdminId() {
    return this.adminId;
  }

  public void setAdminId(Long value) {
    this.adminId = value;
  }

  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
}