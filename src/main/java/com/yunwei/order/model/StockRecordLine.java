package com.yunwei.order.model;

import java.io.Serializable;
import javacommon.base.BaseEntity;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;

public class StockRecordLine extends BaseEntity
  implements Serializable
{
  private static final long serialVersionUID = 5454155825314635342L;
  public static final String TABLE_ALIAS = "StockRecordLine";
  public static final String ALIAS_STOCK_OPER_DETAIL_ID = "stockOperDetailId";
  public static final String ALIAS_STOCK_OPERATION_ID = "stockOperationId";
  public static final String ALIAS_PRODUCT_ID = "productId";
  public static final String ALIAS_PRICE = "price";
  public static final String ALIAS_QUANTITY = "出库数量";
  public static final String ALIAS_HAVE_INVOICE = "是否有发票";
  public static final String ALIAS_INVOICE_NUMBER = "发票号码";
  private Long stockOperDetailId;
  private Long stockOperationId;
  private Long productId;
  private Long price;
  private Integer quantity;
  private Boolean haveInvoice;

  @Length(max=32)
  private String invoiceNumber;

  public StockRecordLine()
  {
  }

  public StockRecordLine(Long stockOperDetailId)
  {
    this.stockOperDetailId = stockOperDetailId;
  }

  public void setStockOperDetailId(Long value) {
    this.stockOperDetailId = value;
  }

  public Long getStockOperDetailId() {
    return this.stockOperDetailId;
  }
  public void setStockOperationId(Long value) {
    this.stockOperationId = value;
  }

  public Long getStockOperationId() {
    return this.stockOperationId;
  }
  public void setProductId(Long value) {
    this.productId = value;
  }

  public Long getProductId() {
    return this.productId;
  }
  public void setPrice(Long value) {
    this.price = value;
  }

  public Long getPrice() {
    return this.price;
  }
  public void setQuantity(Integer value) {
    this.quantity = value;
  }

  public Integer getQuantity() {
    return this.quantity;
  }
  public void setHaveInvoice(Boolean value) {
    this.haveInvoice = value;
  }

  public Boolean getHaveInvoice() {
    return this.haveInvoice;
  }
  public void setInvoiceNumber(String value) {
    this.invoiceNumber = value;
  }

  public String getInvoiceNumber() {
    return this.invoiceNumber;
  }

  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
      .append("StockOperDetailId", getStockOperDetailId())
      .append("StockOperationId", getStockOperationId())
      .append("ProductId", getProductId())
      .append("Price", getPrice())
      .append("Quantity", getQuantity())
      .append("HaveInvoice", getHaveInvoice())
      .append("InvoiceNumber", getInvoiceNumber())
      .toString();
  }

  public int hashCode() {
    return new HashCodeBuilder()
      .append(getStockOperDetailId())
      .toHashCode();
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof StockRecordLine)) return false;
    if (this == obj) return true;
    StockRecordLine other = (StockRecordLine)obj;
    return new EqualsBuilder()
      .append(getStockOperDetailId(), other.getStockOperDetailId())
      .isEquals();
  }
}