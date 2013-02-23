package com.yunwei.order.vo.query;

import java.io.Serializable;
import java.util.Date;
import javacommon.base.BaseQuery;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class FundsRecordQuery extends BaseQuery
  implements Serializable
{
  private static final long serialVersionUID = 3148176768559230877L;
  private Long fundsId;
  private Long approvalId;
  private Long staffId;
  private Long orderId;
  private Long custId;
  private Integer fundsType;
  private Long amount;
  private Long paidAmount;
  private Integer approvalStatus;
  private Date approvalDateBegin;
  private Date approvalDateEnd;
  private Integer status;
  private String paymentMode;
  private String remark;

  public Long getFundsId()
  {
    return this.fundsId;
  }

  public void setFundsId(Long value) {
    this.fundsId = value;
  }

  public Long getApprovalId() {
    return this.approvalId;
  }

  public void setApprovalId(Long value) {
    this.approvalId = value;
  }

  public Long getStaffId() {
    return this.staffId;
  }

  public void setStaffId(Long value) {
    this.staffId = value;
  }

  public Long getOrderId() {
    return this.orderId;
  }

  public void setOrderId(Long value) {
    this.orderId = value;
  }

  public Long getCustId() {
    return this.custId;
  }

  public void setCustId(Long value) {
    this.custId = value;
  }

  public Integer getFundsType() {
    return this.fundsType;
  }

  public void setFundsType(Integer value) {
    this.fundsType = value;
  }

  public Long getAmount() {
    return this.amount;
  }

  public void setAmount(Long value) {
    this.amount = value;
  }

  public Long getPaidAmount() {
    return this.paidAmount;
  }

  public void setPaidAmount(Long value) {
    this.paidAmount = value;
  }

  public Integer getApprovalStatus() {
    return this.approvalStatus;
  }

  public void setApprovalStatus(Integer value) {
    this.approvalStatus = value;
  }

  public Date getApprovalDateBegin() {
    return this.approvalDateBegin;
  }

  public void setApprovalDateBegin(Date value) {
    this.approvalDateBegin = value;
  }

  public Date getApprovalDateEnd() {
    return this.approvalDateEnd;
  }

  public void setApprovalDateEnd(Date value) {
    this.approvalDateEnd = value;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer value) {
    this.status = value;
  }

  public String getPaymentMode() {
    return this.paymentMode;
  }

  public void setPaymentMode(String value) {
    this.paymentMode = value;
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