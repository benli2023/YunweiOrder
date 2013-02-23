package com.yunwei.order.model;

import java.io.Serializable;
import javacommon.base.BaseEntity;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ProductSupplier extends BaseEntity
  implements Serializable
{
  private static final long serialVersionUID = 5454155825314635342L;
  public static final String TABLE_ALIAS = "ProductSupplier";
  public static final String ALIAS_PRODUCT_SUPPLIER_ID = "productSupplierId";
  public static final String ALIAS_PRODUCT_ID = "productId";
  public static final String ALIAS_CUST_ID = "custId";
  private Long productSupplierId;
  private Long productId;
  private Long custId;

  public ProductSupplier()
  {
  }

  public ProductSupplier(Long productSupplierId)
  {
    this.productSupplierId = productSupplierId;
  }

  public void setProductSupplierId(Long value) {
    this.productSupplierId = value;
  }

  public Long getProductSupplierId() {
    return this.productSupplierId;
  }
  public void setProductId(Long value) {
    this.productId = value;
  }

  public Long getProductId() {
    return this.productId;
  }
  public void setCustId(Long value) {
    this.custId = value;
  }

  public Long getCustId() {
    return this.custId;
  }

  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
      .append("ProductSupplierId", getProductSupplierId())
      .append("ProductId", getProductId())
      .append("CustId", getCustId())
      .toString();
  }

  public int hashCode() {
    return new HashCodeBuilder()
      .append(getProductSupplierId())
      .toHashCode();
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof ProductSupplier)) return false;
    if (this == obj) return true;
    ProductSupplier other = (ProductSupplier)obj;
    return new EqualsBuilder()
      .append(getProductSupplierId(), other.getProductSupplierId())
      .isEquals();
  }
}