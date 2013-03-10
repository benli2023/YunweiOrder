package com.yunwei.order.model;

import cn.org.rapid_framework.util.DateConvertUtils;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;

import com.github.springrest.base.BaseEntity;

public class StockHouse extends BaseEntity
  implements Serializable
{
  private static final long serialVersionUID = 5454155825314635342L;
  public static final String TABLE_ALIAS = "StockHouse";
  public static final String ALIAS_STOCK_ID = "stockId";
  public static final String ALIAS_STAFF_ID = "仓库保管";
  public static final String ALIAS_ADDRESS = "address";
  public static final String ALIAS_PHONE = "phone";
  public static final String ALIAS_CTIME = "创建时间";
  public static final String FORMAT_CTIME = "yyyy-MM-dd";
  private Long stockId;
  private Long staffId;

  @Length(max=256)
  private String address;

  @Length(max=32)
  private String phone;
  private Date ctime;

  public StockHouse()
  {
  }

  public StockHouse(Long stockId)
  {
    this.stockId = stockId;
  }

  public void setStockId(Long value) {
    this.stockId = value;
  }

  public Long getStockId() {
    return this.stockId;
  }
  public void setStaffId(Long value) {
    this.staffId = value;
  }

  public Long getStaffId() {
    return this.staffId;
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

  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
      .append("StockId", getStockId())
      .append("StaffId", getStaffId())
      .append("Address", getAddress())
      .append("Phone", getPhone())
      .append("Ctime", getCtime())
      .toString();
  }

  public int hashCode() {
    return new HashCodeBuilder()
      .append(getStockId())
      .toHashCode();
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof StockHouse)) return false;
    if (this == obj) return true;
    StockHouse other = (StockHouse)obj;
    return new EqualsBuilder()
      .append(getStockId(), other.getStockId())
      .isEquals();
  }
}