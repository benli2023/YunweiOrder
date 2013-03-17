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

import com.github.springrest.base.*;
import com.github.springrest.util.*;
import org.codehaus.jackson.annotate.*;
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


public class StockRecordQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 业务单ID */
	private java.lang.Long stockOperationId;
	/** 业务单名称 */
	private java.lang.String stockOperationName;
	/** 责任部门 */
	private java.lang.Integer deptId;
	private String deptIdTxt;
	/** 操作员工 */
	private java.lang.Long staffId;
	private String staffIdTxt;
	/** 业务类型 */
	private java.lang.Integer operType=-1;
	/** 客户 */
	private java.lang.Long custId;
	private String custIdTxt;
	/** 出货/退货日期 */
	private java.util.Date operDateBegin;
	private java.util.Date operDateEnd;
	/** 审核状态 */
	private java.lang.Integer approvalStatus=-1;
	/** 审核人 */
	private java.lang.Long approvalId;
	private String approvalIdTxt;
	/** 所在仓库 */
	private java.lang.Long stockId;
	private String stockIdTxt;
	/** 目标仓库 */
	private java.lang.Long toStockId;
	private String toStockIdTxt;
	/** 备注 */
	private java.lang.String remark;

	public java.lang.Long getStockOperationId() {
		return this.stockOperationId;
	}
	
	public void setStockOperationId(java.lang.Long value) {
		this.stockOperationId = value;
	}
	
	public java.lang.String getStockOperationName() {
		return this.stockOperationName;
	}
	
	public void setStockOperationName(java.lang.String value) {
		this.stockOperationName = value;
	}
	
	
	public java.lang.Integer getDeptId() {
		return this.deptId;
	}
	
	public void setDeptId(java.lang.Integer value) {
		this.deptId = value;
	}
	
	public String getDeptIdTxt() {
		return this.deptIdTxt;
	}
	
	public void setDeptIdTxt(String value) {
		this.deptIdTxt = value;
	}
	
	
	public java.lang.Long getStaffId() {
		return this.staffId;
	}
	
	public void setStaffId(java.lang.Long value) {
		this.staffId = value;
	}
	
	public String getStaffIdTxt() {
		return this.staffIdTxt;
	}
	
	public void setStaffIdTxt(String value) {
		this.staffIdTxt = value;
	}
	
	public java.lang.Integer getOperType() {
		return this.operType;
	}
	
	public void setOperType(java.lang.Integer value) {
		this.operType = value;
	}
	
	
	public java.lang.Long getCustId() {
		return this.custId;
	}
	
	public void setCustId(java.lang.Long value) {
		this.custId = value;
	}
	
	public String getCustIdTxt() {
		return this.custIdTxt;
	}
	
	public void setCustIdTxt(String value) {
		this.custIdTxt = value;
	}
	
	public java.util.Date getOperDateBegin() {
		return this.operDateBegin;
	}
	
	public void setOperDateBegin(java.util.Date value) {
		this.operDateBegin = value;
	}	
	
	public java.util.Date getOperDateEnd() {
		return this.operDateEnd;
	}
	
	public void setOperDateEnd(java.util.Date value) {
		this.operDateEnd = value;
	}
	
	public java.lang.Integer getApprovalStatus() {
		return this.approvalStatus;
	}
	
	public void setApprovalStatus(java.lang.Integer value) {
		this.approvalStatus = value;
	}
	
	
	public java.lang.Long getApprovalId() {
		return this.approvalId;
	}
	
	public void setApprovalId(java.lang.Long value) {
		this.approvalId = value;
	}
	
	public String getApprovalIdTxt() {
		return this.approvalIdTxt;
	}
	
	public void setApprovalIdTxt(String value) {
		this.approvalIdTxt = value;
	}
	
	
	public java.lang.Long getStockId() {
		return this.stockId;
	}
	
	public void setStockId(java.lang.Long value) {
		this.stockId = value;
	}
	
	public String getStockIdTxt() {
		return this.stockIdTxt;
	}
	
	public void setStockIdTxt(String value) {
		this.stockIdTxt = value;
	}
	
	
	public java.lang.Long getToStockId() {
		return this.toStockId;
	}
	
	public void setToStockId(java.lang.Long value) {
		this.toStockId = value;
	}
	
	public String getToStockIdTxt() {
		return this.toStockIdTxt;
	}
	
	public void setToStockIdTxt(String value) {
		this.toStockIdTxt = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

