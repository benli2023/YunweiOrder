package com.yunwei.order.vo.query;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.springrest.base.BaseQuery;

public class ProductSupplierQuery extends BaseQuery
  implements Serializable
{
  private static final long serialVersionUID = 3148176768559230877L;
  private Long productSupplierId;
  private Long productId;
  private Long custId;

  public Long getProductSupplierId()
  {
    return this.productSupplierId;
  }

  public void setProductSupplierId(Long value) {
    this.productSupplierId = value;
  }

  public Long getProductId() {
    return this.productId;
  }

  public void setProductId(Long value) {
    this.productId = value;
  }

  public Long getCustId() {
    return this.custId;
  }

  public void setCustId(Long value) {
    this.custId = value;
  }

  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
}