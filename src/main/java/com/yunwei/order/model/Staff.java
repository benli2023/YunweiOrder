package com.yunwei.order.model;

import cn.org.rapid_framework.util.DateConvertUtils;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import com.github.springrest.base.BaseEntity;

public class Staff extends BaseEntity
  implements Serializable
{
  private static final long serialVersionUID = 5454155825314635342L;
  public static final String QUICK_SEARCH_TERM = "staff_name";
  public static final String TABLE_ALIAS = "Staff";
  public static final String ALIAS_STAFF_ID = "staffId";
  public static final String ALIAS_DEPT_ID = "deptId";
  public static final String ALIAS_STAFF_NAME = "员工名称";
  public static final String ALIAS_LOGIN_NAME = "登录名称";
  public static final String ALIAS_LOGIN_PASSWORD = "密码";
  public static final String ALIAS_POSITION = "职务";
  public static final String ALIAS_GENDER = "性别             0=女             1=男             2=其它";
  public static final String ALIAS_BIRTH_DATE = "出生日期";
  public static final String ALIAS_HIRE_DATE = "合同签订日期";
  public static final String ALIAS_MATURE_DATE = "合同到期日期";
  public static final String ALIAS_IDENTITY_CARD = "身份证号码";
  public static final String ALIAS_ADDRESS = "住址";
  public static final String ALIAS_PHONE = "电话";
  public static final String ALIAS_EMAIL = "电子邮件";
  public static final String ALIAS_CTIME = "创建时间";
  public static final String ALIAS_ADMIN_ID = "adminId";
  public static final String FORMAT_BIRTH_DATE = "yyyy-MM-dd";
  public static final String FORMAT_HIRE_DATE = "yyyy-MM-dd";
  public static final String FORMAT_MATURE_DATE = "yyyy-MM-dd";
  public static final String FORMAT_CTIME = "yyyy-MM-dd";
  private Long staffId;

  @JsonIgnore
  private Integer deptId;

  @Length(max=128)
  @JsonProperty("staff_name")
  private String staffName;

  @Length(max=64)
  @JsonIgnore
  private String loginName;

  @Length(max=128)
  @JsonIgnore
  private String loginPassword;

  @Length(max=8)
  @JsonIgnore
  private String position;
  private Integer gender;

  @JsonIgnore
  private Date birthDate;

  @JsonIgnore
  private Date hireDate;

  @JsonIgnore
  private Date matureDate;

  @Length(max=32)
  @JsonIgnore
  private String identityCard;

  @Length(max=256)
  @JsonIgnore
  private String address;

  @Length(max=32)
  @JsonIgnore
  private String phone;

  @Email
  @Length(max=128)
  @JsonIgnore
  private String email;

  @JsonIgnore
  private Date ctime;

  @JsonIgnore
  private Long adminId;

  public Staff()
  {
  }

  public Staff(Long staffId)
  {
    this.staffId = staffId;
  }

  public void setStaffId(Long value) {
    this.staffId = value;
  }

  public Long getStaffId() {
    return this.staffId;
  }
  public void setDeptId(Integer value) {
    this.deptId = value;
  }

  public Integer getDeptId() {
    return this.deptId;
  }
  public void setStaffName(String value) {
    this.staffName = value;
  }

  public String getStaffName() {
    return this.staffName;
  }
  public void setLoginName(String value) {
    this.loginName = value;
  }

  public String getLoginName() {
    return this.loginName;
  }
  public void setLoginPassword(String value) {
    this.loginPassword = value;
  }

  public String getLoginPassword() {
    return this.loginPassword;
  }
  public void setPosition(String value) {
    this.position = value;
  }

  public String getPosition() {
    return this.position;
  }
  public void setGender(Integer value) {
    this.gender = value;
  }

  public Integer getGender() {
    return this.gender;
  }
  public String getBirthDateString() {
    return DateConvertUtils.format(getBirthDate(), "yyyy-MM-dd");
  }
  public void setBirthDateString(String value) {
    setBirthDate(DateConvertUtils.parse(value, "yyyy-MM-dd", Date.class));
  }

  public void setBirthDate(Date value) {
    this.birthDate = value;
  }

  public Date getBirthDate() {
    return this.birthDate;
  }
  public String getHireDateString() {
    return DateConvertUtils.format(getHireDate(), "yyyy-MM-dd");
  }
  public void setHireDateString(String value) {
    setHireDate(DateConvertUtils.parse(value, "yyyy-MM-dd", Date.class));
  }

  public void setHireDate(Date value) {
    this.hireDate = value;
  }

  public Date getHireDate() {
    return this.hireDate;
  }
  public String getMatureDateString() {
    return DateConvertUtils.format(getMatureDate(), "yyyy-MM-dd");
  }
  public void setMatureDateString(String value) {
    setMatureDate(DateConvertUtils.parse(value, "yyyy-MM-dd", Date.class));
  }

  public void setMatureDate(Date value) {
    this.matureDate = value;
  }

  public Date getMatureDate() {
    return this.matureDate;
  }
  public void setIdentityCard(String value) {
    this.identityCard = value;
  }

  public String getIdentityCard() {
    return this.identityCard;
  }
  public void setAddress(String value) {
    this.address = value;
  }

  public String getAddress() {
    return this.address;
  }
  public void setPhone(String value) {
    this.phone = value;
  }

  public String getPhone() {
    return this.phone;
  }
  public void setEmail(String value) {
    this.email = value;
  }

  public String getEmail() {
    return this.email;
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
  public void setAdminId(Long value) {
    this.adminId = value;
  }

  public Long getAdminId() {
    return this.adminId;
  }

  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
      .append("StaffId", getStaffId())
      .append("DeptId", getDeptId())
      .append("StaffName", getStaffName())
      .append("LoginName", getLoginName())
      .append("LoginPassword", getLoginPassword())
      .append("Position", getPosition())
      .append("Gender", getGender())
      .append("BirthDate", getBirthDate())
      .append("HireDate", getHireDate())
      .append("MatureDate", getMatureDate())
      .append("IdentityCard", getIdentityCard())
      .append("Address", getAddress())
      .append("Phone", getPhone())
      .append("Email", getEmail())
      .append("Ctime", getCtime())
      .append("AdminId", getAdminId())
      .toString();
  }

  public int hashCode() {
    return new HashCodeBuilder()
      .append(getStaffId())
      .toHashCode();
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof Staff)) return false;
    if (this == obj) return true;
    Staff other = (Staff)obj;
    return new EqualsBuilder()
      .append(getStaffId(), other.getStaffId())
      .isEquals();
  }
}