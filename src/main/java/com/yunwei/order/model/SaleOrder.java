/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2013
 */

package com.yunwei.order.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import cn.org.rapid_framework.util.DateConvertUtils;

import com.github.springrest.base.BaseEntity;
import com.github.springrest.base.JsonDateSerializer;
import com.yunwei.order.model.grid.OrderGoodsEditorData;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class SaleOrder extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "SaleOrder";
	public static final String ALIAS_ORDER_ID = "orderId";
	public static final String ALIAS_ORDER_NO = "orderNo";
	public static final String ALIAS_STAFF_ID = "业务员";
	public static final String ALIAS_CUST_ID = "客户";
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
	public static final String ALIAS_CREATOR_ID = "创建人ID";
	
	//date formats
	public static final String FORMAT_ORDER_DATE = DATE_FORMAT;
	public static final String FORMAT_DELIVERY_DATE = DATE_FORMAT;
	public static final String FORMAT_UTIME = DATE_FORMAT;
	public static final String FORMAT_CTIME = DATE_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
    /**
     * orderId       db_column: order_id 
     */ 	
	
	
	
	private java.lang.Long orderId;
	
	
    /**
     * orderNo       db_column: order_no 
     */ 	
	@NotBlank @Length(max=16)
	
	
	private java.lang.String orderNo;
	
	
	private java.lang.Long staffId;
	private String staffIdTxt;
	
	
	private java.lang.Long custId;
	private String custIdTxt;
	
	
    /**
     * 订单日期       db_column: order_date 
     */ 	
	
	
	@JsonSerialize(using = JsonDateSerializer.class)
	private java.util.Date orderDate;
	
	
    /**
     * 付款方式       db_column: payment_mode 
     */ 	
	private java.lang.Integer paymentMode;
	
	
    /**
     * 发票号码       db_column: invoice_no 
     */ 	
	@Length(max=128)
	
	
	private java.lang.String invoiceNo;
	
	
    /**
     * 订单说明       db_column: description 
     */ 	
	@Length(max=512)
	
	
	private java.lang.String description;
	
	
	private java.lang.Long accountingDeptId;
	private String accountingDeptIdTxt;
	
	
    /**
     * 币种       db_column: currency 
     */ 	
	private java.lang.Integer currency;
	
	
    /**
     * 交货方式       db_column: delivery_method 
     */ 	
	
	private java.lang.Integer deliveryMethod;
	
	
    /**
     * 交货日期       db_column: delivery_date 
     */ 	
	
	
	@JsonSerialize(using = JsonDateSerializer.class)
	private java.util.Date deliveryDate;
	
	
    /**
     * 更多内容       db_column: additional_text 
     */ 	
	@Length(max=65535)
	
	
	private java.lang.String additionalText;
	
	
    /**
     * 是否可用       db_column: is_available 
     */ 	
	
	
	private java.lang.Integer isAvailable;
	
	
    /**
     * 更新人       db_column: updator 
     */ 	
	
	
	
	private java.lang.Long updator;
	
	
    /**
     * 更新时间       db_column: uTime 
     */ 	
	
	
	@JsonSerialize(using = JsonDateSerializer.class)
	private java.util.Date utime;
	
	
    /**
     * 创建时间       db_column: cTime 
     */ 	
	
	
	@JsonSerialize(using = JsonDateSerializer.class)
	private java.util.Date ctime;
	
	
    /**
     * 创建人ID       db_column: creator_Id 
     */ 	
	
	private OrderGoodsEditorData jsonData=null;
	
	private java.lang.Long creatorId;
	
	//columns END

	public SaleOrder(){
	}

	public SaleOrder(
		java.lang.Long orderId
	){
		this.orderId = orderId;
	}

	public void setOrderId(java.lang.Long value) {
		this.orderId = value;
	}
	
	public java.lang.Long getOrderId() {
		return this.orderId;
	}
	public void setOrderNo(java.lang.String value) {
		this.orderNo = value;
	}
	
	public java.lang.String getOrderNo() {
		return this.orderNo;
	}
	public void setStaffId(java.lang.Long value) {
		this.staffId = value;
	}
	
	public java.lang.Long getStaffId() {
		return this.staffId;
	}
	public String getStaffIdTxt() {
		return this.staffIdTxt;
	}
	
	public void setStaffIdTxt(String value) {
		this.staffIdTxt = value;
	}
	public void setCustId(java.lang.Long value) {
		this.custId = value;
	}
	
	public java.lang.Long getCustId() {
		return this.custId;
	}
	public String getCustIdTxt() {
		return this.custIdTxt;
	}
	
	public void setCustIdTxt(String value) {
		this.custIdTxt = value;
	}
	public String getOrderDateString() {
		return DateConvertUtils.format(getOrderDate(), FORMAT_ORDER_DATE);
	}
	public void setOrderDateString(String value) {
		setOrderDate(DateConvertUtils.parse(value, FORMAT_ORDER_DATE,java.util.Date.class));
	}
	
	public void setOrderDate(java.util.Date value) {
		this.orderDate = value;
	}
	
	public java.util.Date getOrderDate() {
		return this.orderDate;
	}
	public void setPaymentMode(java.lang.Integer value) {
		this.paymentMode = value;
	}
	
	public java.lang.Integer getPaymentMode() {
		return this.paymentMode;
	}
	public void setInvoiceNo(java.lang.String value) {
		this.invoiceNo = value;
	}
	
	public java.lang.String getInvoiceNo() {
		return this.invoiceNo;
	}
	public void setDescription(java.lang.String value) {
		this.description = value;
	}
	
	public java.lang.String getDescription() {
		return this.description;
	}
	public void setAccountingDeptId(java.lang.Long value) {
		this.accountingDeptId = value;
	}
	
	public java.lang.Long getAccountingDeptId() {
		return this.accountingDeptId;
	}
	public String getAccountingDeptIdTxt() {
		return this.accountingDeptIdTxt;
	}
	
	public void setAccountingDeptIdTxt(String value) {
		this.accountingDeptIdTxt = value;
	}
	public void setCurrency(java.lang.Integer value) {
		this.currency = value;
	}
	
	public java.lang.Integer getCurrency() {
		return this.currency;
	}
	public void setDeliveryMethod(java.lang.Integer value) {
		this.deliveryMethod = value;
	}
	
	public java.lang.Integer getDeliveryMethod() {
		return this.deliveryMethod;
	}
	public String getDeliveryDateString() {
		return DateConvertUtils.format(getDeliveryDate(), FORMAT_DELIVERY_DATE);
	}
	public void setDeliveryDateString(String value) {
		setDeliveryDate(DateConvertUtils.parse(value, FORMAT_DELIVERY_DATE,java.util.Date.class));
	}
	
	public void setDeliveryDate(java.util.Date value) {
		this.deliveryDate = value;
	}
	
	public java.util.Date getDeliveryDate() {
		return this.deliveryDate;
	}
	public void setAdditionalText(java.lang.String value) {
		this.additionalText = value;
	}
	
	public java.lang.String getAdditionalText() {
		return this.additionalText;
	}
	public void setIsAvailable(java.lang.Integer value) {
		this.isAvailable = value;
	}
	
	public java.lang.Integer getIsAvailable() {
		return this.isAvailable;
	}
	public void setUpdator(java.lang.Long value) {
		this.updator = value;
	}
	
	public java.lang.Long getUpdator() {
		return this.updator;
	}
	public String getUtimeString() {
		return DateConvertUtils.format(getUtime(), FORMAT_UTIME);
	}
	public void setUtimeString(String value) {
		setUtime(DateConvertUtils.parse(value, FORMAT_UTIME,java.util.Date.class));
	}
	
	public void setUtime(java.util.Date value) {
		this.utime = value;
	}
	
	public java.util.Date getUtime() {
		return this.utime;
	}
	public String getCtimeString() {
		return DateConvertUtils.format(getCtime(), FORMAT_CTIME);
	}
	public void setCtimeString(String value) {
		setCtime(DateConvertUtils.parse(value, FORMAT_CTIME,java.util.Date.class));
	}
	
	public void setCtime(java.util.Date value) {
		this.ctime = value;
	}
	
	public java.util.Date getCtime() {
		return this.ctime;
	}
	public void setCreatorId(java.lang.Long value) {
		this.creatorId = value;
	}
	
	public java.lang.Long getCreatorId() {
		return this.creatorId;
	}
	
	public OrderGoodsEditorData getJsonData() {
		return jsonData;
	}

	public void setJsonData(OrderGoodsEditorData jsonData) {
		this.jsonData = jsonData;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("OrderId",getOrderId())
			.append("OrderNo",getOrderNo())
			.append("StaffId",getStaffId())
			.append("CustId",getCustId())
			.append("OrderDate",getOrderDate())
			.append("PaymentMode",getPaymentMode())
			.append("InvoiceNo",getInvoiceNo())
			.append("Description",getDescription())
			.append("AccountingDeptId",getAccountingDeptId())
			.append("Currency",getCurrency())
			.append("DeliveryMethod",getDeliveryMethod())
			.append("DeliveryDate",getDeliveryDate())
			.append("AdditionalText",getAdditionalText())
			.append("IsAvailable",getIsAvailable())
			.append("Updator",getUpdator())
			.append("Utime",getUtime())
			.append("Ctime",getCtime())
			.append("CreatorId",getCreatorId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getOrderId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SaleOrder == false) return false;
		if(this == obj) return true;
		SaleOrder other = (SaleOrder)obj;
		return new EqualsBuilder()
			.append(getOrderId(),other.getOrderId())
			.isEquals();
	}
}

