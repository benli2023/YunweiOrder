package com.yunwei.order.vo.query;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.springrest.base.BaseQuery;

public class AppDataQuery extends BaseQuery
  implements Serializable
{
  private static final long serialVersionUID = 3148176768559230877L;
  private Long appDataId;
  private String dataCode;
  private String dataValue;
  private String dataValueText;
  private String displayName;
  private String shortName;
  private Integer dataType;
  private Boolean isAvailable;
  private Date ctimeBegin;
  private Date ctimeEnd;

  public Long getAppDataId()
  {
    return this.appDataId;
  }

  public void setAppDataId(Long value) {
    this.appDataId = value;
  }

  public String getDataCode() {
    return this.dataCode;
  }

  public void setDataCode(String value) {
    this.dataCode = value;
  }

  public String getDataValue() {
    return this.dataValue;
  }

  public void setDataValue(String value) {
    this.dataValue = value;
  }

  public String getDataValueText() {
    return this.dataValueText;
  }

  public void setDataValueText(String value) {
    this.dataValueText = value;
  }

  public String getDisplayName() {
    return this.displayName;
  }

  public void setDisplayName(String value) {
    this.displayName = value;
  }

  public String getShortName() {
    return this.shortName;
  }

  public void setShortName(String value) {
    this.shortName = value;
  }

  public Integer getDataType() {
    return this.dataType;
  }

  public void setDataType(Integer value) {
    this.dataType = value;
  }

  public Boolean getIsAvailable() {
    return this.isAvailable;
  }

  public void setIsAvailable(Boolean value) {
    this.isAvailable = value;
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

  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
}