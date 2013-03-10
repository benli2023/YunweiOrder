package com.yunwei.order.model;

import cn.org.rapid_framework.util.DateConvertUtils;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.github.springrest.base.BaseEntity;

public class SaleOrder extends BaseEntity
  implements Serializable
{
  private static final long serialVersionUID = 5454155825314635342L;
  public static final String TABLE_ALIAS = "SaleOrder";
  public static final String ALIAS_ORDER_ID = "orderId";
  public static final String ALIAS_ORDER_NO = "orderNo";
  public static final String ALIAS_STAFF_ID = "staffId";
  public static final String ALIAS_CUST_ID = "custId";
  public static final String ALIAS_ORDER_DATE = "订单日期";
  public static final String ALIAS_PAYMENT_MODE = "付款方式";
  public static final String ALIAS_INVOICE_NO = "发票号码";
  public static final String ALIAS_DESCRIPTION = "订单说明";
  public static final String ALIAS_ACCOUNTING_DEPT_ID = "核算部门";
  public static final String ALIAS_CURRENCY = "币种";
  public static final String ALIAS_DELIVERY_METHOD = "交货方式";
  public static final String ALIAS_DELIVERY_DATE = "交货日期";
  public static final String ALIAS_ADDITIONAL_TEXT = "更多内容";
  public static final String ALIAS_IS_AVAILABLE = "是否可用";
  public static final String ALIAS_UPDATOR = "更新人";
  public static final String ALIAS_UTIME = "更新时间";
  public static final String ALIAS_CTIME = "创建时间";
  public static final String ALIAS_CREATOR_ID = "创建人";
  public static final String FORMAT_ORDER_DATE = "yyyy-MM-dd";
  public static final String FORMAT_DELIVERY_DATE = "yyyy-MM-dd";
  public static final String FORMAT_UTIME = "yyyy-MM-dd";
  public static final String FORMAT_CTIME = "yyyy-MM-dd";
  private Long orderId;

  @NotBlank
  @Length(max=16)
  private String orderNo;
  private Long staffId;
  private Long custId;
  private Date orderDate;

  @Length(max=8)
  private String paymentMode;

  @Length(max=128)
  private String invoiceNo;

  @Length(max=512)
  private String description;
  private Long accountingDeptId;

  @Length(max=8)
  private String currency;

  @Length(max=8)
  private String deliveryMethod;
  private Date deliveryDate;

  @Length(max=65535)
  private String additionalText;
  private Boolean isAvailable;
  private Long updator;
  private Date utime;
  private Date ctime;
  private Long creatorId;

  public SaleOrder()
  {
  }

  public SaleOrder(Long orderId)
  {
    this.orderId = orderId;
  }

  public void setOrderId(Long value) {
    this.orderId = value;
  }

  public Long getOrderId() {
    return this.orderId;
  }
  public void setOrderNo(String value) {
    this.orderNo = value;
  }

  public String getOrderNo() {
    return this.orderNo;
  }
  public void setStaffId(Long value) {
    this.staffId = value;
  }

  public Long getStaffId() {
    return this.staffId;
  }
  public void setCustId(Long value) {
    this.custId = value;
  }

  public Long getCustId() {
    return this.custId;
  }
  public String getOrderDateString() {
    return DateConvertUtils.format(getOrderDate(), "yyyy-MM-dd");
  }
  public void setOrderDateString(String value) {
    setOrderDate(DateConvertUtils.parse(value, "yyyy-MM-dd", Date.class));
  }

  public void setOrderDate(Date value) {
    this.orderDate = value;
  }

  public Date getOrderDate() {
    return this.orderDate;
  }
  public void setPaymentMode(String value) {
    this.paymentMode = value;
  }

  public String getPaymentMode() {
    return this.paymentMode;
  }
  public void setInvoiceNo(String value) {
    this.invoiceNo = value;
  }

  public String getInvoiceNo() {
    return this.invoiceNo;
  }
  public void setDescription(String value) {
    this.description = value;
  }

  public String getDescription() {
    return this.description;
  }
  public void setAccountingDeptId(Long value) {
    this.accountingDeptId = value;
  }

  public Long getAccountingDeptId() {
    return this.accountingDeptId;
  }
  public void setCurrency(String value) {
    this.currency = value;
  }

  public String getCurrency() {
    return this.currency;
  }
  public void setDeliveryMethod(String value) {
    this.deliveryMethod = value;
  }

  public String getDeliveryMethod() {
    return this.deliveryMethod;
  }
  public String getDeliveryDateString() {
    return DateConvertUtils.format(getDeliveryDate(), "yyyy-MM-dd");
  }
  public void setDeliveryDateString(String value) {
    setDeliveryDate(DateConvertUtils.parse(value, "yyyy-MM-dd", Date.class));
  }

  public void setDeliveryDate(Date value) {
    this.deliveryDate = value;
  }

  public Date getDeliveryDate() {
    return this.deliveryDate;
  }
  public void setAdditionalText(String value) {
    this.additionalText = value;
  }

  public String getAdditionalText() {
    return this.additionalText;
  }
  public void setIsAvailable(Boolean value) {
    this.isAvailable = value;
  }

  public Boolean getIsAvailable() {
    return this.isAvailable;
  }
  public void setUpdator(Long value) {
    this.updator = value;
  }

  public Long getUpdator() {
    return this.updator;
  }
  public String getUtimeString() {
    return DateConvertUtils.format(getUtime(), "yyyy-MM-dd");
  }
  public void setUtimeString(String value) {
    setUtime(DateConvertUtils.parse(value, "yyyy-MM-dd", Date.class));
  }

  public void setUtime(Date value) {
    this.utime = value;
  }

  public Date getUtime() {
    return this.utime;
  }
  public String getCtimeString() {
    return DateConvertUtils.format(getCtime(), "yyyy-MM-dd");
  }
  public void setCtimeString(String value) {
    setCtime(DateConvertUtils.parse(value, "yyyy-MM-dd", Date.class));
  }

  public void setCtime(Date value) {
    this.ctime = value;
  }

  public Date getCtime() {
    return this.ctime;
  }
  public void setCreatorId(Long value) {
    this.creatorId = value;
  }

  public Long getCreatorId() {
    return this.creatorId;
  }

  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
      .append("OrderId", getOrderId())
      .append("OrderNo", getOrderNo())
      .append("StaffId", getStaffId())
      .append("CustId", getCustId())
      .append("OrderDate", getOrderDate())
      .append("PaymentMode", getPaymentMode())
      .append("InvoiceNo", getInvoiceNo())
      .append("Description", getDescription())
      .append("AccountingDeptId", getAccountingDeptId())
      .append("Currency", getCurrency())
      .append("DeliveryMethod", getDeliveryMethod())
      .append("DeliveryDate", getDeliveryDate())
      .append("AdditionalText", getAdditionalText())
      .append("IsAvailable", getIsAvailable())
      .append("Updator", getUpdator())
      .append("Utime", getUtime())
      .append("Ctime", getCtime())
      .append("CreatorId", getCreatorId())
      .toString();
  }

  public int hashCode() {
    return new HashCodeBuilder()
      .append(getOrderId())
      .toHashCode();
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof SaleOrder)) return false;
    if (this == obj) return true;
    SaleOrder other = (SaleOrder)obj;
    return new EqualsBuilder()
      .append(getOrderId(), other.getOrderId())
      .isEquals();
  }
}