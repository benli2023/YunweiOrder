package com.yunwei.order.model;

import cn.org.rapid_framework.util.DateConvertUtils;
import java.io.Serializable;
import java.util.Date;
import javacommon.base.BaseEntity;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Category extends BaseEntity
  implements Serializable
{
  private static final long serialVersionUID = 5454155825314635342L;
  public static final String TABLE_ALIAS = "产品分类管理";
  public static final String ALIAS_CATE_ID = "分类ID";
  public static final String ALIAS_PARENT_ID = "父ID";
  public static final String ALIAS_CATE_NAME = "类别名称";
  public static final String ALIAS_IS_AVAILABLE = "是否有效";
  public static final String ALIAS_CTIME = "创建时间";
  public static final String ALIAS_ADMIN = "创建人";
  public static final String FORMAT_CTIME = "yyyy-MM-dd HH:mm:ss";
  private Long cateId;
  private String parentIdTxt;
  private Long parentId;

  @Length(max=128)
  @NotEmpty
  @JsonProperty("cate_name")
  private String cateName;
  private int isAvailable;
  private Date ctime;
  private Long admin;

  public Category()
  {
  }

  public Category(Long cateId)
  {
    this.cateId = cateId;
  }

  public void setCateId(Long value) {
    this.cateId = value;
  }

  public Long getCateId() {
    return this.cateId;
  }
  public void setParentId(Long value) {
    this.parentId = value;
  }

  public Long getParentId() {
    return this.parentId;
  }
  public void setCateName(String value) {
    this.cateName = value;
  }

  public String getCateName() {
    return this.cateName;
  }

  public int getIsAvailable() {
    return this.isAvailable;
  }

  public void setIsAvailable(int isAvailable) {
    this.isAvailable = isAvailable;
  }

  public String getCtimeString() {
    return DateConvertUtils.format(getCtime(), "yyyy-MM-dd HH:mm:ss");
  }
  public void setCtimeString(String value) {
    setCtime(DateConvertUtils.parse(value, "yyyy-MM-dd HH:mm:ss", Date.class));
  }

  public void setCtime(Date value) {
    this.ctime = value;
  }

  public Date getCtime() {
    return this.ctime;
  }
  public void setAdmin(Long value) {
    this.admin = value;
  }

  public Long getAdmin() {
    return this.admin;
  }

  public String getParentIdTxt() {
    return this.parentIdTxt;
  }

  public void setParentIdTxt(String parentIdTxt) {
    this.parentIdTxt = parentIdTxt;
  }

  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
      .append("CateId", getCateId())
      .append("ParentId", getParentId())
      .append("CateName", getCateName())
      .append("IsAvailable", getIsAvailable())
      .append("Ctime", getCtime())
      .append("Admin", getAdmin())
      .toString();
  }

  public int hashCode() {
    return new HashCodeBuilder()
      .append(getCateId())
      .toHashCode();
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof Category)) return false;
    if (this == obj) return true;
    Category other = (Category)obj;
    return new EqualsBuilder()
      .append(getCateId(), other.getCateId())
      .isEquals();
  }
}