/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2013
 */

package com.yunwei.order.vo.query;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.yunwei.order.model.*;
import com.yunwei.order.dao.*;
import com.yunwei.order.service.*;
import com.yunwei.order.vo.query.*;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class SaleOrderQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** orderId */
	private java.lang.Long orderId;
	/** orderNo */
	private java.lang.String orderNo;
	/** staffId */
	private java.lang.Long staffId;
	/** custId */
	private java.lang.Long custId;
	/** 订单日期 */
	private java.util.Date orderDateBegin;
	private java.util.Date orderDateEnd;
	/** 付款方式 */
	private java.lang.String paymentMode;
	/** 发票号码 */
	private java.lang.String invoiceNo;
	/** 订单说明 */
	private java.lang.String description;
	/** 核算部门 */
	private java.lang.Long accountingDeptId;
	/** 币种 */
	private java.lang.String currency;
	/** 交货方式 */
	private java.lang.String deliveryMethod;
	/** 交货日期 */
	private java.util.Date deliveryDateBegin;
	private java.util.Date deliveryDateEnd;
	/** 更多内容 */
	private java.lang.String additionalText;
	/** 是否可用 */
	private java.lang.Boolean isAvailable;
	/** 更新人 */
	private java.lang.Long updator;
	/** 更新时间 */
	private java.util.Date utimeBegin;
	private java.util.Date utimeEnd;
	/** 创建时间 */
	private java.util.Date ctimeBegin;
	private java.util.Date ctimeEnd;
	/** 创建人 */
	private java.lang.Long creatorId;

	public java.lang.Long getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(java.lang.Long value) {
		this.orderId = value;
	}
	
	public java.lang.String getOrderNo() {
		return this.orderNo;
	}
	
	public void setOrderNo(java.lang.String value) {
		this.orderNo = value;
	}
	
	public java.lang.Long getStaffId() {
		return this.staffId;
	}
	
	public void setStaffId(java.lang.Long value) {
		this.staffId = value;
	}
	
	public java.lang.Long getCustId() {
		return this.custId;
	}
	
	public void setCustId(java.lang.Long value) {
		this.custId = value;
	}
	
	public java.util.Date getOrderDateBegin() {
		return this.orderDateBegin;
	}
	
	public void setOrderDateBegin(java.util.Date value) {
		this.orderDateBegin = value;
	}	
	
	public java.util.Date getOrderDateEnd() {
		return this.orderDateEnd;
	}
	
	public void setOrderDateEnd(java.util.Date value) {
		this.orderDateEnd = value;
	}
	
	public java.lang.String getPaymentMode() {
		return this.paymentMode;
	}
	
	public void setPaymentMode(java.lang.String value) {
		this.paymentMode = value;
	}
	
	public java.lang.String getInvoiceNo() {
		return this.invoiceNo;
	}
	
	public void setInvoiceNo(java.lang.String value) {
		this.invoiceNo = value;
	}
	
	public java.lang.String getDescription() {
		return this.description;
	}
	
	public void setDescription(java.lang.String value) {
		this.description = value;
	}
	
	public java.lang.Long getAccountingDeptId() {
		return this.accountingDeptId;
	}
	
	public void setAccountingDeptId(java.lang.Long value) {
		this.accountingDeptId = value;
	}
	
	public java.lang.String getCurrency() {
		return this.currency;
	}
	
	public void setCurrency(java.lang.String value) {
		this.currency = value;
	}
	
	public java.lang.String getDeliveryMethod() {
		return this.deliveryMethod;
	}
	
	public void setDeliveryMethod(java.lang.String value) {
		this.deliveryMethod = value;
	}
	
	public java.util.Date getDeliveryDateBegin() {
		return this.deliveryDateBegin;
	}
	
	public void setDeliveryDateBegin(java.util.Date value) {
		this.deliveryDateBegin = value;
	}	
	
	public java.util.Date getDeliveryDateEnd() {
		return this.deliveryDateEnd;
	}
	
	public void setDeliveryDateEnd(java.util.Date value) {
		this.deliveryDateEnd = value;
	}
	
	public java.lang.String getAdditionalText() {
		return this.additionalText;
	}
	
	public void setAdditionalText(java.lang.String value) {
		this.additionalText = value;
	}
	
	public java.lang.Boolean getIsAvailable() {
		return this.isAvailable;
	}
	
	public void setIsAvailable(java.lang.Boolean value) {
		this.isAvailable = value;
	}
	
	public java.lang.Long getUpdator() {
		return this.updator;
	}
	
	public void setUpdator(java.lang.Long value) {
		this.updator = value;
	}
	
	public java.util.Date getUtimeBegin() {
		return this.utimeBegin;
	}
	
	public void setUtimeBegin(java.util.Date value) {
		this.utimeBegin = value;
	}	
	
	public java.util.Date getUtimeEnd() {
		return this.utimeEnd;
	}
	
	public void setUtimeEnd(java.util.Date value) {
		this.utimeEnd = value;
	}
	
	public java.util.Date getCtimeBegin() {
		return this.ctimeBegin;
	}
	
	public void setCtimeBegin(java.util.Date value) {
		this.ctimeBegin = value;
	}	
	
	public java.util.Date getCtimeEnd() {
		return this.ctimeEnd;
	}
	
	public void setCtimeEnd(java.util.Date value) {
		this.ctimeEnd = value;
	}
	
	public java.lang.Long getCreatorId() {
		return this.creatorId;
	}
	
	public void setCreatorId(java.lang.Long value) {
		this.creatorId = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

