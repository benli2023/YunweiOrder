package com.yunwei.order.vo.query;

import java.io.Serializable;
import java.util.Date;
import javacommon.base.BaseQuery;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class SaleOrderQuery extends BaseQuery
  implements Serializable
{
  private static final long serialVersionUID = 3148176768559230877L;
  private Long orderId;
  private String orderNo;
  private Long staffId;
  private Long custId;
  private Date orderDateBegin;
  private Date orderDateEnd;
  private String paymentMode;
  private String invoiceNo;
  private String description;
  private Long accountingDeptId;
  private String currency;
  private String deliveryMethod;
  private Date deliveryDateBegin;
  private Date deliveryDateEnd;
  private String additionalText;
  private Boolean isAvailable;
  private Long updator;
  private Date utimeBegin;
  private Date utimeEnd;
  private Date ctimeBegin;
  private Date ctimeEnd;
  private Long creatorId;

  public Long getOrderId()
  {
    return this.orderId;
  }

  public void setOrderId(Long value) {
    this.orderId = value;
  }

  public String getOrderNo() {
    return this.orderNo;
  }

  public void setOrderNo(String value) {
    this.orderNo = value;
  }

  public Long getStaffId() {
    return this.staffId;
  }

  public void setStaffId(Long value) {
    this.staffId = value;
  }

  public Long getCustId() {
    return this.custId;
  }

  public void setCustId(Long value) {
    this.custId = value;
  }

  public Date getOrderDateBegin() {
    return this.orderDateBegin;
  }

  public void setOrderDateBegin(Date value) {
    this.orderDateBegin = value;
  }

  public Date getOrderDateEnd() {
    return this.orderDateEnd;
  }

  public void setOrderDateEnd(Date value) {
    this.orderDateEnd = value;
  }

  public String getPaymentMode() {
    return this.paymentMode;
  }

  public void setPaymentMode(String value) {
    this.paymentMode = value;
  }

  public String getInvoiceNo() {
    return this.invoiceNo;
  }

  public void setInvoiceNo(String value) {
    this.invoiceNo = value;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String value) {
    this.description = value;
  }

  public Long getAccountingDeptId() {
    return this.accountingDeptId;
  }

  public void setAccountingDeptId(Long value) {
    this.accountingDeptId = value;
  }

  public String getCurrency() {
    return this.currency;
  }

  public void setCurrency(String value) {
    this.currency = value;
  }

  public String getDeliveryMethod() {
    return this.deliveryMethod;
  }

  public void setDeliveryMethod(String value) {
    this.deliveryMethod = value;
  }

  public Date getDeliveryDateBegin() {
    return this.deliveryDateBegin;
  }

  public void setDeliveryDateBegin(Date value) {
    this.deliveryDateBegin = value;
  }

  public Date getDeliveryDateEnd() {
    return this.deliveryDateEnd;
  }

  public void setDeliveryDateEnd(Date value) {
    this.deliveryDateEnd = value;
  }

  public String getAdditionalText() {
    return this.additionalText;
  }

  public void setAdditionalText(String value) {
    this.additionalText = value;
  }

  public Boolean getIsAvailable() {
    return this.isAvailable;
  }

  public void setIsAvailable(Boolean value) {
    this.isAvailable = value;
  }

  public Long getUpdator() {
    return this.updator;
  }

  public void setUpdator(Long value) {
    this.updator = value;
  }

  public Date getUtimeBegin() {
    return this.utimeBegin;
  }

  public void setUtimeBegin(Date value) {
    this.utimeBegin = value;
  }

  public Date getUtimeEnd() {
    return this.utimeEnd;
  }

  public void setUtimeEnd(Date value) {
    this.utimeEnd = value;
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

  public Long getCreatorId() {
    return this.creatorId;
  }

  public void setCreatorId(Long value) {
    this.creatorId = value;
  }

  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
}