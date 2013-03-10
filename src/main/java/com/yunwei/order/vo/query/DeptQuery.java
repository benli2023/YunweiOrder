package com.yunwei.order.vo.query;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.springrest.base.BaseQuery;

public class DeptQuery extends BaseQuery
  implements Serializable
{
  private static final long serialVersionUID = 3148176768559230877L;
  private Integer deptId;
  private String deptName;
  private Integer parentId;
  private String remark;

  public Integer getDeptId()
  {
    return this.deptId;
  }

  public void setDeptId(Integer value) {
    this.deptId = value;
  }

  public String getDeptName() {
    return this.deptName;
  }

  public void setDeptName(String value) {
    this.deptName = value;
  }

  public Integer getParentId() {
    return this.parentId;
  }

  public void setParentId(Integer value) {
    this.parentId = value;
  }

  public String getRemark() {
    return this.remark;
  }

  public void setRemark(String value) {
    this.remark = value;
  }

  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
}