package com.yunwei.order.vo.query;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.springrest.base.BaseQuery;

public class CategoryQuery extends BaseQuery
  implements Serializable
{
  private static final long serialVersionUID = 3148176768559230877L;
  private Long cateId;
  private Long parentId;
  private String cateName;
  private int isAvailable = -1;
  private Date ctimeBegin;
  private Date ctimeEnd;
  private Long admin;

  public Long getCateId()
  {
    return this.cateId;
  }

  public void setCateId(Long value) {
    this.cateId = value;
  }

  public Long getParentId() {
    return this.parentId;
  }

  public void setParentId(Long value) {
    this.parentId = value;
  }

  public String getCateName() {
    return this.cateName;
  }

  public void setCateName(String value) {
    this.cateName = value;
  }

  public int getIsAvailable()
  {
    return this.isAvailable;
  }

  public void setIsAvailable(int isAvailable) {
    this.isAvailable = isAvailable;
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

  public Long getAdmin() {
    return this.admin;
  }

  public void setAdmin(Long value) {
    this.admin = value;
  }

  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
}