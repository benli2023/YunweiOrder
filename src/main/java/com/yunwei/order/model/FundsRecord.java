package com.yunwei.order.model;

import cn.org.rapid_framework.util.DateConvertUtils;
import java.io.Serializable;
import java.util.Date;
import javacommon.base.BaseEntity;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;

public class FundsRecord extends BaseEntity
  implements Serializable
{
  private static final long serialVersionUID = 5454155825314635342L;
  public static final String TABLE_ALIAS = "FundsRecord";
  public static final String ALIAS_FUNDS_ID = "fundsId";
  public static final String ALIAS_APPROVAL_ID = "审核人";
  public static final String ALIAS_STAFF_ID = "收/付款人";
  public static final String ALIAS_ORDER_ID = "款项对应的订单ID";
  public static final String ALIAS_CUST_ID = "对应的客户ID";
  public static final String ALIAS_FUNDS_TYPE = "1=应付款             2=应收款";
  public static final String ALIAS_AMOUNT = "金额";
  public static final String ALIAS_PAID_AMOUNT = "已收/付金额";
  public static final String ALIAS_APPROVAL_STATUS = "审核状态                          0=未审核             1=审核通过             -1=审核未通过";
  public static final String ALIAS_APPROVAL_DATE = "审核日期";
  public static final String ALIAS_STATUS = "收付款状态             0=未收/付款             1=已收/付款             2=已收/付部分款";
  public static final String ALIAS_PAYMENT_MODE = "付款方式";
  public static final String ALIAS_REMARK = "备注";
  public static final String FORMAT_APPROVAL_DATE = "yyyy-MM-dd";
  private Long fundsId;
  private Long approvalId;
  private Long staffId;
  private Long orderId;
  private Long custId;
  private Integer fundsType;
  private Long amount;
  private Long paidAmount;
  private Integer approvalStatus;
  private Date approvalDate;
  private Integer status;

  @Length(max=8)
  private String paymentMode;

  @Length(max=512)
  private String remark;

  public FundsRecord()
  {
  }

  public FundsRecord(Long fundsId)
  {
    this.fundsId = fundsId;
  }

  public void setFundsId(Long value) {
    this.fundsId = value;
  }

  public Long getFundsId() {
    return this.fundsId;
  }
  public void setApprovalId(Long value) {
    this.approvalId = value;
  }

  public Long getApprovalId() {
    return this.approvalId;
  }
  public void setStaffId(Long value) {
    this.staffId = value;
  }

  public Long getStaffId() {
    return this.staffId;
  }
  public void setOrderId(Long value) {
    this.orderId = value;
  }

  public Long getOrderId() {
    return this.orderId;
  }
  public void setCustId(Long value) {
    this.custId = value;
  }

  public Long getCustId() {
    return this.custId;
  }
  public void setFundsType(Integer value) {
    this.fundsType = value;
  }

  public Integer getFundsType() {
    return this.fundsType;
  }
  public void setAmount(Long value) {
    this.amount = value;
  }

  public Long getAmount() {
    return this.amount;
  }
  public void setPaidAmount(Long value) {
    this.paidAmount = value;
  }

  public Long getPaidAmount() {
    return this.paidAmount;
  }
  public void setApprovalStatus(Integer value) {
    this.approvalStatus = value;
  }

  public Integer getApprovalStatus() {
    return this.approvalStatus;
  }
  public String getApprovalDateString() {
    return DateConvertUtils.format(getApprovalDate(), "yyyy-MM-dd");
  }
  public void setApprovalDateString(String value) {
    setApprovalDate(DateConvertUtils.parse(value, "yyyy-MM-dd", Date.class));
  }

  public void setApprovalDate(Date value) {
    this.approvalDate = value;
  }

  public Date getApprovalDate() {
    return this.approvalDate;
  }
  public void setStatus(Integer value) {
    this.status = value;
  }

  public Integer getStatus() {
    return this.status;
  }
  public void setPaymentMode(String value) {
    this.paymentMode = value;
  }

  public String getPaymentMode() {
    return this.paymentMode;
  }
  public void setRemark(String value) {
    this.remark = value;
  }

  public String getRemark() {
    return this.remark;
  }

  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
      .append("FundsId", getFundsId())
      .append("ApprovalId", getApprovalId())
      .append("StaffId", getStaffId())
      .append("OrderId", getOrderId())
      .append("CustId", getCustId())
      .append("FundsType", getFundsType())
      .append("Amount", getAmount())
      .append("PaidAmount", getPaidAmount())
      .append("ApprovalStatus", getApprovalStatus())
      .append("ApprovalDate", getApprovalDate())
      .append("Status", getStatus())
      .append("PaymentMode", getPaymentMode())
      .append("Remark", getRemark())
      .toString();
  }

  public int hashCode() {
    return new HashCodeBuilder()
      .append(getFundsId())
      .toHashCode();
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof FundsRecord)) return false;
    if (this == obj) return true;
    FundsRecord other = (FundsRecord)obj;
    return new EqualsBuilder()
      .append(getFundsId(), other.getFundsId())
      .isEquals();
  }
}