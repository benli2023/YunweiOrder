package com.yunwei.order.vo.query;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.springrest.base.BaseQuery;

public class StockRecordLineQuery extends BaseQuery
  implements Serializable
{
  private static final long serialVersionUID = 3148176768559230877L;
  private Long stockOperDetailId;
  private Long stockOperationId;
  private Long productId;
  private Long price;
  private Integer quantity;
  private Boolean haveInvoice;
  private String invoiceNumber;

  public Long getStockOperDetailId()
  {
    return this.stockOperDetailId;
  }

  public void setStockOperDetailId(Long value) {
    this.stockOperDetailId = value;
  }

  public Long getStockOperationId() {
    return this.stockOperationId;
  }

  public void setStockOperationId(Long value) {
    this.stockOperationId = value;
  }

  public Long getProductId() {
    return this.productId;
  }

  public void setProductId(Long value) {
    this.productId = value;
  }

  public Long getPrice() {
    return this.price;
  }

  public void setPrice(Long value) {
    this.price = value;
  }

  public Integer getQuantity() {
    return this.quantity;
  }

  public void setQuantity(Integer value) {
    this.quantity = value;
  }

  public Boolean getHaveInvoice() {
    return this.haveInvoice;
  }

  public void setHaveInvoice(Boolean value) {
    this.haveInvoice = value;
  }

  public String getInvoiceNumber() {
    return this.invoiceNumber;
  }

  public void setInvoiceNumber(String value) {
    this.invoiceNumber = value;
  }

  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
}