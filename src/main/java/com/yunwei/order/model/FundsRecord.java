/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2013
 */

package com.yunwei.order.model;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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


public class FundsRecord extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
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
	
	//date formats
	public static final String FORMAT_APPROVAL_DATE = DATE_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * fundsId       db_column: funds_id 
     */ 	
	
	private java.lang.Long fundsId;
    /**
     * 审核人       db_column: approval_id 
     */ 	
	
	private java.lang.Long approvalId;
    /**
     * 收/付款人       db_column: staff_id 
     */ 	
	
	private java.lang.Long staffId;
    /**
     * 款项对应的订单ID       db_column: order_id 
     */ 	
	
	private java.lang.Long orderId;
    /**
     * 对应的客户ID       db_column: cust_id 
     */ 	
	
	private java.lang.Long custId;
    /**
     * 1=应付款             2=应收款       db_column: funds_type 
     */ 	
	
	private java.lang.Integer fundsType;
    /**
     * 金额       db_column: amount 
     */ 	
	
	private Long amount;
    /**
     * 已收/付金额       db_column: paid_amount 
     */ 	
	
	private Long paidAmount;
    /**
     * 审核状态                          0=未审核             1=审核通过             -1=审核未通过       db_column: approval_status 
     */ 	
	
	private java.lang.Integer approvalStatus;
    /**
     * 审核日期       db_column: approval_date 
     */ 	
	
	private java.util.Date approvalDate;
    /**
     * 收付款状态             0=未收/付款             1=已收/付款             2=已收/付部分款       db_column: status 
     */ 	
	
	private java.lang.Integer status;
    /**
     * 付款方式       db_column: payment_mode 
     */ 	
	@Length(max=8)
	private java.lang.String paymentMode;
    /**
     * 备注       db_column: remark 
     */ 	
	@Length(max=512)
	private java.lang.String remark;
	//columns END

	public FundsRecord(){
	}

	public FundsRecord(
		java.lang.Long fundsId
	){
		this.fundsId = fundsId;
	}

	public void setFundsId(java.lang.Long value) {
		this.fundsId = value;
	}
	
	public java.lang.Long getFundsId() {
		return this.fundsId;
	}
	public void setApprovalId(java.lang.Long value) {
		this.approvalId = value;
	}
	
	public java.lang.Long getApprovalId() {
		return this.approvalId;
	}
	public void setStaffId(java.lang.Long value) {
		this.staffId = value;
	}
	
	public java.lang.Long getStaffId() {
		return this.staffId;
	}
	public void setOrderId(java.lang.Long value) {
		this.orderId = value;
	}
	
	public java.lang.Long getOrderId() {
		return this.orderId;
	}
	public void setCustId(java.lang.Long value) {
		this.custId = value;
	}
	
	public java.lang.Long getCustId() {
		return this.custId;
	}
	public void setFundsType(java.lang.Integer value) {
		this.fundsType = value;
	}
	
	public java.lang.Integer getFundsType() {
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
	public void setApprovalStatus(java.lang.Integer value) {
		this.approvalStatus = value;
	}
	
	public java.lang.Integer getApprovalStatus() {
		return this.approvalStatus;
	}
	public String getApprovalDateString() {
		return DateConvertUtils.format(getApprovalDate(), FORMAT_APPROVAL_DATE);
	}
	public void setApprovalDateString(String value) {
		setApprovalDate(DateConvertUtils.parse(value, FORMAT_APPROVAL_DATE,java.util.Date.class));
	}
	
	public void setApprovalDate(java.util.Date value) {
		this.approvalDate = value;
	}
	
	public java.util.Date getApprovalDate() {
		return this.approvalDate;
	}
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	
	public java.lang.Integer getStatus() {
		return this.status;
	}
	public void setPaymentMode(java.lang.String value) {
		this.paymentMode = value;
	}
	
	public java.lang.String getPaymentMode() {
		return this.paymentMode;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("FundsId",getFundsId())
			.append("ApprovalId",getApprovalId())
			.append("StaffId",getStaffId())
			.append("OrderId",getOrderId())
			.append("CustId",getCustId())
			.append("FundsType",getFundsType())
			.append("Amount",getAmount())
			.append("PaidAmount",getPaidAmount())
			.append("ApprovalStatus",getApprovalStatus())
			.append("ApprovalDate",getApprovalDate())
			.append("Status",getStatus())
			.append("PaymentMode",getPaymentMode())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getFundsId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FundsRecord == false) return false;
		if(this == obj) return true;
		FundsRecord other = (FundsRecord)obj;
		return new EqualsBuilder()
			.append(getFundsId(),other.getFundsId())
			.isEquals();
	}
}

