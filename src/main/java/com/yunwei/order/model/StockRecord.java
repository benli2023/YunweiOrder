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
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.validator.constraints.Length;

import cn.org.rapid_framework.util.DateConvertUtils;

import com.github.springrest.base.BaseEntity;
import com.github.springrest.base.GridEditorJsonData;
import com.github.springrest.base.JsonDateSerializer;
import com.yunwei.order.model.grid.StockRecordLineEditorData;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class StockRecord extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "仓库业务单";
	public static final String ALIAS_STOCK_OPERATION_ID = "业务单ID";
	public static final String ALIAS_STOCK_OPERATION_NAME = "业务单号";
	public static final String ALIAS_DEPT_ID = "责任部门";
	public static final String ALIAS_STAFF_ID = "操作员工";
	public static final String ALIAS_OPER_TYPE = "业务类型";
	public static final String ALIAS_CUST_ID = "客户";
	public static final String ALIAS_OPER_DATE = "入库日期";
	public static final String ALIAS_APPROVAL_STATUS = "审核状态";
	public static final String ALIAS_APPROVAL_ID = "审核人";
	public static final String ALIAS_STOCK_ID = "所在仓库";
	public static final String ALIAS_TO_STOCK_ID = "目标仓库";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	public static final String FORMAT_OPER_DATE = DATE_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
    /**
     * 业务单ID       db_column: stock_operation_id 
     */ 	
	
	
	
	private java.lang.Long stockOperationId;
	
	
    /**
     * 业务单名称       db_column: stock_operation_name 
     */ 	
	@Length(max=256)
	@JsonProperty("stock_operation_name")
	
	private java.lang.String stockOperationName;
	
	
	private java.lang.Integer deptId;
	private String deptIdTxt;
	
	
	private java.lang.Long staffId;
	private String staffIdTxt;
	
	
    /**
     * 业务类型       db_column: oper_type 
     */ 	
	
	
	
	private java.lang.Integer operType;
	
	
	private java.lang.Long custId;
	private String custIdTxt;
	
	
    /**
     * 出货/退货日期       db_column: oper_date 
     */ 	
	
	
	@JsonSerialize(using = JsonDateSerializer.class)
	private java.util.Date operDate;
	
	
    /**
     * 审核状态       db_column: approval_status 
     */ 	
	
	
	
	private java.lang.Integer approvalStatus;
	
	
	private java.lang.Long approvalId;
	private String approvalIdTxt;
	
	
	private java.lang.Long stockId;
	private String stockIdTxt;
	
	
	private java.lang.Long toStockId;
	private String toStockIdTxt;
	
	
	
    /**
     * 备注       db_column: remark 
     */ 	
	@Length(max=512)
	
	
	private java.lang.String remark;
	
	
	private StockRecordLineEditorData jsonData=null;
	
	
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
	public void setStockOperationName(java.lang.String value) {
		this.stockOperationName = value;
	}
	
	public java.lang.String getStockOperationName() {
		return this.stockOperationName;
	}
	public void setDeptId(java.lang.Integer value) {
		this.deptId = value;
	}
	
	public java.lang.Integer getDeptId() {
		return this.deptId;
	}
	public String getDeptIdTxt() {
		return this.deptIdTxt;
	}
	
	public void setDeptIdTxt(String value) {
		this.deptIdTxt = value;
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
	public String getCustIdTxt() {
		return this.custIdTxt;
	}
	
	public void setCustIdTxt(String value) {
		this.custIdTxt = value;
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
	public String getApprovalIdTxt() {
		return this.approvalIdTxt;
	}
	
	public void setApprovalIdTxt(String value) {
		this.approvalIdTxt = value;
	}
	public void setStockId(java.lang.Long value) {
		this.stockId = value;
	}
	
	public java.lang.Long getStockId() {
		return this.stockId;
	}
	public String getStockIdTxt() {
		return this.stockIdTxt;
	}
	
	public void setStockIdTxt(String value) {
		this.stockIdTxt = value;
	}
	public void setToStockId(java.lang.Long value) {
		this.toStockId = value;
	}
	
	public java.lang.Long getToStockId() {
		return this.toStockId;
	}
	public String getToStockIdTxt() {
		return this.toStockIdTxt;
	}
	
	public void setToStockIdTxt(String value) {
		this.toStockIdTxt = value;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	

	

	public StockRecordLineEditorData getJsonData() {
		return jsonData;
	}

	public void setJsonData(StockRecordLineEditorData jsonData) {
		this.jsonData = jsonData;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("StockOperationId",getStockOperationId())
			.append("StockOperationName",getStockOperationName())
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

