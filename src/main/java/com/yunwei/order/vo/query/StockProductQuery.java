package com.yunwei.order.vo.query;

import java.io.Serializable;
import java.util.Date;
import javacommon.base.BaseQuery;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class StockProductQuery extends BaseQuery
  implements Serializable
{
  private static final long serialVersionUID = 3148176768559230877L;
  private Long stockProductId;
  private Long stockId;
  private Long productId;
  private Integer quantity;
  private Date firstEnterDateBegin;
  private Date firstEnterDateEnd;
  private Date outerDateBegin;
  private Date outerDateEnd;
  private Long price;

  public Long getStockProductId()
  {
    return this.stockProductId;
  }

  public void setStockProductId(Long value) {
    this.stockProductId = value;
  }

  public Long getStockId() {
    return this.stockId;
  }

  public void setStockId(Long value) {
    this.stockId = value;
  }

  public Long getProductId() {
    return this.productId;
  }

  public void setProductId(Long value) {
    this.productId = value;
  }

  public Integer getQuantity() {
    return this.quantity;
  }

  public void setQuantity(Integer value) {
    this.quantity = value;
  }

  public Date getFirstEnterDateBegin() {
    return this.firstEnterDateBegin;
  }

  public void setFirstEnterDateBegin(Date value) {
    this.firstEnterDateBegin = value;
  }

  public Date getFirstEnterDateEnd() {
    return this.firstEnterDateEnd;
  }

  public void setFirstEnterDateEnd(Date value) {
    this.firstEnterDateEnd = value;
  }

  public Date getOuterDateBegin() {
    return this.outerDateBegin;
  }

  public void setOuterDateBegin(Date value) {
    this.outerDateBegin = value;
  }

  public Date getOuterDateEnd() {
    return this.outerDateEnd;
  }

  public void setOuterDateEnd(Date value) {
    this.outerDateEnd = value;
  }

  public Long getPrice() {
    return this.price;
  }

  public void setPrice(Long value) {
    this.price = value;
  }

  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
}