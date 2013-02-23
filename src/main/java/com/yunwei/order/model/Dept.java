package com.yunwei.order.model;

import java.io.Serializable;
import javacommon.base.BaseEntity;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Dept extends BaseEntity
  implements Serializable
{
  private static final long serialVersionUID = 5454155825314635342L;
  public static final String TABLE_ALIAS = "Dept";
  public static final String ALIAS_DEPT_ID = "deptId";
  public static final String ALIAS_DEPT_NAME = "deptName";
  public static final String ALIAS_PARENT_ID = "parentId";
  public static final String ALIAS_REMARK = "remark";
  private Integer deptId;

  @Length(max=32)
  @JsonProperty("dept_name")
  private String deptName;
  private Integer parentId;

  @Length(max=256)
  private String remark;

  public Dept()
  {
  }

  public Dept(Integer deptId)
  {
    this.deptId = deptId;
  }

  public void setDeptId(Integer value) {
    this.deptId = value;
  }

  public Integer getDeptId() {
    return this.deptId;
  }
  public void setDeptName(String value) {
    this.deptName = value;
  }

  public String getDeptName() {
    return this.deptName;
  }
  public void setParentId(Integer value) {
    this.parentId = value;
  }

  public Integer getParentId() {
    return this.parentId;
  }
  public void setRemark(String value) {
    this.remark = value;
  }

  public String getRemark() {
    return this.remark;
  }

  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
      .append("DeptId", getDeptId())
      .append("DeptName", getDeptName())
      .append("ParentId", getParentId())
      .append("Remark", getRemark())
      .toString();
  }

  public int hashCode() {
    return new HashCodeBuilder()
      .append(getDeptId())
      .toHashCode();
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof Dept)) return false;
    if (this == obj) return true;
    Dept other = (Dept)obj;
    return new EqualsBuilder()
      .append(getDeptId(), other.getDeptId())
      .isEquals();
  }
}