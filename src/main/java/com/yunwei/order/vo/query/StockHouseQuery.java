package com.yunwei.order.vo.query;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.springrest.base.BaseQuery;

public class StockHouseQuery extends BaseQuery
  implements Serializable
{
  private static final long serialVersionUID = 3148176768559230877L;
  private Long stockId;
  private Long staffId;
  private String address;
  private String phone;
  private Date ctimeBegin;
  private Date ctimeEnd;

  public Long getStockId()
  {
    return this.stockId;
  }

  public void setStockId(Long value) {
    this.stockId = value;
  }

  public Long getStaffId() {
    return this.staffId;
  }

  public void setStaffId(Long value) {
    this.staffId = value;
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