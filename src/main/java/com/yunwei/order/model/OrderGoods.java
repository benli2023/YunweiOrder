package com.yunwei.order.model;

import java.io.Serializable;
import javacommon.base.BaseEntity;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;

public class OrderGoods extends BaseEntity
  implements Serializable
{
  private static final long serialVersionUID = 5454155825314635342L;
  public static final String TABLE_ALIAS = "OrderGoods";
  public static final String ALIAS_GOODS_ID = "goodsId";
  public static final String ALIAS_GOODS_CODE = "编码或条形码";
  public static final String ALIAS_PRODUCT_ID = "productId";
  public static final String ALIAS_ORDER_ID = "orderId";
  public static final String ALIAS_UNIT = "单位";
  public static final String ALIAS_UNIT_PRICE = "单价";
  public static final String ALIAS_QUANTITY = "数量";
  public static final String ALIAS_HANDED_QUANTITY = "已交数量";
  public static final String ALIAS_UNTAXED_AMOUNT = "未税金额";
  public static final String ALIAS_TAX_RATE = "税率";
  public static final String ALIAS_OUTPUT_TAX_AMOUNT = "销项税额=未税金额x(1+税率)";
  public static final String ALIAS_TAX_AMOUNT = "税额=当期销项税额-当期进项税额";
  public static final String ALIAS_MODEL = "型号";
  public static final String ALIAS_REMARK = "备注说明";
  private Long goodsId;

  @Length(max=256)
  private String goodsCode;
  private Long productId;
  private Long orderId;

  @Length(max=8)
  private String unit;
  private Long unitPrice;
  private Integer quantity;
  private Integer handedQuantity;
  private Long untaxedAmount;
  private Double taxRate;
  private Long outputTaxAmount;
  private Long taxAmount;

  @Length(max=8)
  private String model;

  @Length(max=512)
  private String remark;

  public OrderGoods()
  {
  }

  public OrderGoods(Long goodsId)
  {
    this.goodsId = goodsId;
  }

  public void setGoodsId(Long value) {
    this.goodsId = value;
  }

  public Long getGoodsId() {
    return this.goodsId;
  }
  public void setGoodsCode(String value) {
    this.goodsCode = value;
  }

  public String getGoodsCode() {
    return this.goodsCode;
  }
  public void setProductId(Long value) {
    this.productId = value;
  }

  public Long getProductId() {
    return this.productId;
  }
  public void setOrderId(Long value) {
    this.orderId = value;
  }

  public Long getOrderId() {
    return this.orderId;
  }
  public void setUnit(String value) {
    this.unit = value;
  }

  public String getUnit() {
    return this.unit;
  }
  public void setUnitPrice(Long value) {
    this.unitPrice = value;
  }

  public Long getUnitPrice() {
    return this.unitPrice;
  }
  public void setQuantity(Integer value) {
    this.quantity = value;
  }

  public Integer getQuantity() {
    return this.quantity;
  }
  public void setHandedQuantity(Integer value) {
    this.handedQuantity = value;
  }

  public Integer getHandedQuantity() {
    return this.handedQuantity;
  }
  public void setUntaxedAmount(Long value) {
    this.untaxedAmount = value;
  }

  public Long getUntaxedAmount() {
    return this.untaxedAmount;
  }
  public void setTaxRate(Double value) {
    this.taxRate = value;
  }

  public Double getTaxRate() {
    return this.taxRate;
  }
  public void setOutputTaxAmount(Long value) {
    this.outputTaxAmount = value;
  }

  public Long getOutputTaxAmount() {
    return this.outputTaxAmount;
  }
  public void setTaxAmount(Long value) {
    this.taxAmount = value;
  }

  public Long getTaxAmount() {
    return this.taxAmount;
  }
  public void setModel(String value) {
    this.model = value;
  }

  public String getModel() {
    return this.model;
  }
  public void setRemark(String value) {
    this.remark = value;
  }

  public String getRemark() {
    return this.remark;
  }

  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
      .append("GoodsId", getGoodsId())
      .append("GoodsCode", getGoodsCode())
      .append("ProductId", getProductId())
      .append("OrderId", getOrderId())
      .append("Unit", getUnit())
      .append("UnitPrice", getUnitPrice())
      .append("Quantity", getQuantity())
      .append("HandedQuantity", getHandedQuantity())
      .append("UntaxedAmount", getUntaxedAmount())
      .append("TaxRate", getTaxRate())
      .append("OutputTaxAmount", getOutputTaxAmount())
      .append("TaxAmount", getTaxAmount())
      .append("Model", getModel())
      .append("Remark", getRemark())
      .toString();
  }

  public int hashCode() {
    return new HashCodeBuilder()
      .append(getGoodsId())
      .toHashCode();
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof OrderGoods)) return false;
    if (this == obj) return true;
    OrderGoods other = (OrderGoods)obj;
    return new EqualsBuilder()
      .append(getGoodsId(), other.getGoodsId())
      .isEquals();
  }
}