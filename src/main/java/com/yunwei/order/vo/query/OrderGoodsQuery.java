package com.yunwei.order.vo.query;

import java.io.Serializable;
import javacommon.base.BaseQuery;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class OrderGoodsQuery extends BaseQuery
  implements Serializable
{
  private static final long serialVersionUID = 3148176768559230877L;
  private Long goodsId;
  private String goodsCode;
  private Long productId;
  private Long orderId;
  private String unit;
  private Long unitPrice;
  private Integer quantity;
  private Integer handedQuantity;
  private Long untaxedAmount;
  private Double taxRate;
  private Long outputTaxAmount;
  private Long taxAmount;
  private String model;
  private String remark;

  public Long getGoodsId()
  {
    return this.goodsId;
  }

  public void setGoodsId(Long value) {
    this.goodsId = value;
  }

  public String getGoodsCode() {
    return this.goodsCode;
  }

  public void setGoodsCode(String value) {
    this.goodsCode = value;
  }

  public Long getProductId() {
    return this.productId;
  }

  public void setProductId(Long value) {
    this.productId = value;
  }

  public Long getOrderId() {
    return this.orderId;
  }

  public void setOrderId(Long value) {
    this.orderId = value;
  }

  public String getUnit() {
    return this.unit;
  }

  public void setUnit(String value) {
    this.unit = value;
  }

  public Long getUnitPrice() {
    return this.unitPrice;
  }

  public void setUnitPrice(Long value) {
    this.unitPrice = value;
  }

  public Integer getQuantity() {
    return this.quantity;
  }

  public void setQuantity(Integer value) {
    this.quantity = value;
  }

  public Integer getHandedQuantity() {
    return this.handedQuantity;
  }

  public void setHandedQuantity(Integer value) {
    this.handedQuantity = value;
  }

  public Long getUntaxedAmount() {
    return this.untaxedAmount;
  }

  public void setUntaxedAmount(Long value) {
    this.untaxedAmount = value;
  }

  public Double getTaxRate() {
    return this.taxRate;
  }

  public void setTaxRate(Double value) {
    this.taxRate = value;
  }

  public Long getOutputTaxAmount() {
    return this.outputTaxAmount;
  }

  public void setOutputTaxAmount(Long value) {
    this.outputTaxAmount = value;
  }

  public Long getTaxAmount() {
    return this.taxAmount;
  }

  public void setTaxAmount(Long value) {
    this.taxAmount = value;
  }

  public String getModel() {
    return this.model;
  }

  public void setModel(String value) {
    this.model = value;
  }

  public String getRemark() {
    return this.remark;
  }

  public void setRemark(String value) {
    this.remark = value;
  }

  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
}