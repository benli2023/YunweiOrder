package com.yunwei.order.model;

import cn.org.rapid_framework.util.DateConvertUtils;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.springrest.base.BaseEntity;

public class StockProduct extends BaseEntity
  implements Serializable
{
  private static final long serialVersionUID = 5454155825314635342L;
  public static final String TABLE_ALIAS = "StockProduct";
  public static final String ALIAS_STOCK_PRODUCT_ID = "stockProductId";
  public static final String ALIAS_STOCK_ID = "stockId";
  public static final String ALIAS_PRODUCT_ID = "productId";
  public static final String ALIAS_QUANTITY = "quantity";
  public static final String ALIAS_FIRST_ENTER_DATE = "首次入库时间";
  public static final String ALIAS_OUTER_DATE = "最新出库时间";
  public static final String ALIAS_PRICE = "price";
  public static final String FORMAT_FIRST_ENTER_DATE = "yyyy-MM-dd";
  public static final String FORMAT_OUTER_DATE = "yyyy-MM-dd";
  private Long stockProductId;
  private Long stockId;
  private Long productId;
  private Integer quantity;
  private Date firstEnterDate;
  private Date outerDate;
  private Long price;

  public StockProduct()
  {
  }

  public StockProduct(Long stockProductId)
  {
    this.stockProductId = stockProductId;
  }

  public void setStockProductId(Long value) {
    this.stockProductId = value;
  }

  public Long getStockProductId() {
    return this.stockProductId;
  }
  public void setStockId(Long value) {
    this.stockId = value;
  }

  public Long getStockId() {
    return this.stockId;
  }
  public void setProductId(Long value) {
    this.productId = value;
  }

  public Long getProductId() {
    return this.productId;
  }
  public void setQuantity(Integer value) {
    this.quantity = value;
  }

  public Integer getQuantity() {
    return this.quantity;
  }
  public String getFirstEnterDateString() {
    return DateConvertUtils.format(getFirstEnterDate(), "yyyy-MM-dd");
  }
  public void setFirstEnterDateString(String value) {
    setFirstEnterDate(DateConvertUtils.parse(value, "yyyy-MM-dd", Date.class));
  }

  public void setFirstEnterDate(Date value) {
    this.firstEnterDate = value;
  }

  public Date getFirstEnterDate() {
    return this.firstEnterDate;
  }
  public String getOuterDateString() {
    return DateConvertUtils.format(getOuterDate(), "yyyy-MM-dd");
  }
  public void setOuterDateString(String value) {
    setOuterDate(DateConvertUtils.parse(value, "yyyy-MM-dd", Date.class));
  }

  public void setOuterDate(Date value) {
    this.outerDate = value;
  }

  public Date getOuterDate() {
    return this.outerDate;
  }
  public void setPrice(Long value) {
    this.price = value;
  }

  public Long getPrice() {
    return this.price;
  }

  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
      .append("StockProductId", getStockProductId())
      .append("StockId", getStockId())
      .append("ProductId", getProductId())
      .append("Quantity", getQuantity())
      .append("FirstEnterDate", getFirstEnterDate())
      .append("OuterDate", getOuterDate())
      .append("Price", getPrice())
      .toString();
  }

  public int hashCode() {
    return new HashCodeBuilder()
      .append(getStockProductId())
      .toHashCode();
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof StockProduct)) return false;
    if (this == obj) return true;
    StockProduct other = (StockProduct)obj;
    return new EqualsBuilder()
      .append(getStockProductId(), other.getStockProductId())
      .isEquals();
  }
}