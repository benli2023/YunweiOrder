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


public class StockRecord extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "StockRecord";
	public static final String ALIAS_STOCK_OPERATION_ID = "stockOperationId";
	public static final String ALIAS_DEPT_ID = "deptId";
	public static final String ALIAS_STAFF_ID = "staffId";
	public static final String ALIAS_OPER_TYPE = "1=出货             2=入库             3=退货             4=转库";
	public static final String ALIAS_CUST_ID = "custId";
	public static final String ALIAS_OPER_DATE = "出货/退货日期";
	public static final String ALIAS_APPROVAL_STATUS = "审核状态";
	public static final String ALIAS_APPROVAL_ID = "approvalId";
	public static final String ALIAS_STOCK_ID = "stockId";
	public static final String ALIAS_TO_STOCK_ID = "toStockId";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	public static final String FORMAT_OPER_DATE = DATE_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * stockOperationId       db_column: stock_operation_id 
     */ 	
	
	private java.lang.Long stockOperationId;
    /**
     * deptId       db_column: dept_id 
     */ 	
	
	private java.lang.Integer deptId;
    /**
     * staffId       db_column: staff_id 
     */ 	
	
	private java.lang.Long staffId;
    /**
     * 1=出货             2=入库             3=退货             4=转库       db_column: oper_type 
     */ 	
	
	private java.lang.Integer operType;
    /**
     * custId       db_column: cust_id 
     */ 	
	
	private java.lang.Long custId;
    /**
     * 出货/退货日期       db_column: oper_date 
     */ 	
	
	private java.util.Date operDate;
    /**
     * 审核状态       db_column: approval_status 
     */ 	
	
	private java.lang.Integer approvalStatus;
    /**
     * approvalId       db_column: approval_id 
     */ 	
	
	private java.lang.Long approvalId;
    /**
     * stockId       db_column: stock_id 
     */ 	
	
	private java.lang.Long stockId;
    /**
     * toStockId       db_column: to_stock_id 
     */ 	
	
	private java.lang.Long toStockId;
    /**
     * 备注       db_column: remark 
     */ 	
	@Length(max=512)
	private java.lang.String remark;
	//columns END

	public StockRecord(){
	}

	public StockRecord(
		java.lang.Long stockOperationId
	){
		this.stockOperationId = stockOperationId;
	}

	public void setStockOperationId(java.lang.Long value) {
		this.stockOperationId = value;
	}
	
	public java.lang.Long getStockOperationId() {
		return this.stockOperationId;
	}
	public void setDeptId(java.lang.Integer value) {
		this.deptId = value;
	}
	
	public java.lang.Integer getDeptId() {
		return this.deptId;
	}
	public void setStaffId(java.lang.Long value) {
		this.staffId = value;
	}
	
	public java.lang.Long getStaffId() {
		return this.staffId;
	}
	public void setOperType(java.lang.Integer value) {
		this.operType = value;
	}
	
	public java.lang.Integer getOperType() {
		return this.operType;
	}
	public void setCustId(java.lang.Long value) {
		this.custId = value;
	}
	
	public java.lang.Long getCustId() {
		return this.custId;
	}
	public String getOperDateString() {
		return DateConvertUtils.format(getOperDate(), FORMAT_OPER_DATE);
	}
	public void setOperDateString(String value) {
		setOperDate(DateConvertUtils.parse(value, FORMAT_OPER_DATE,java.util.Date.class));
	}
	
	public void setOperDate(java.util.Date value) {
		this.operDate = value;
	}
	
	public java.util.Date getOperDate() {
		return this.operDate;
	}
	public void setApprovalStatus(java.lang.Integer value) {
		this.approvalStatus = value;
	}
	
	public java.lang.Integer getApprovalStatus() {
		return this.approvalStatus;
	}
	public void setApprovalId(java.lang.Long value) {
		this.approvalId = value;
	}
	
	public java.lang.Long getApprovalId() {
		return this.approvalId;
	}
	public void setStockId(java.lang.Long value) {
		this.stockId = value;
	}
	
	public java.lang.Long getStockId() {
		return this.stockId;
	}
	public void setToStockId(java.lang.Long value) {
		this.toStockId = value;
	}
	
	public java.lang.Long getToStockId() {
		return this.toStockId;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("StockOperationId",getStockOperationId())
			.append("DeptId",getDeptId())
			.append("StaffId",getStaffId())
			.append("OperType",getOperType())
			.append("CustId",getCustId())
			.append("OperDate",getOperDate())
			.append("ApprovalStatus",getApprovalStatus())
			.append("ApprovalId",getApprovalId())
			.append("StockId",getStockId())
			.append("ToStockId",getToStockId())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStockOperationId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StockRecord == false) return false;
		if(this == obj) return true;
		StockRecord other = (StockRecord)obj;
		return new EqualsBuilder()
			.append(getStockOperationId(),other.getStockOperationId())
			.isEquals();
	}
}

