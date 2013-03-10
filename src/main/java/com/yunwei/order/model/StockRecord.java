package com.yunwei.order.model;

import cn.org.rapid_framework.util.DateConvertUtils;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;

import com.github.springrest.base.BaseEntity;

public class StockRecord extends BaseEntity
  implements Serializable
{
  private static final long serialVersionUID = 5454155825314635342L;
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
  public static final String FORMAT_OPER_DATE = "yyyy-MM-dd";
  private Long stockOperationId;
  private Integer deptId;
  private Long staffId;
  private Integer operType;
  private Long custId;
  private Date operDate;
  private Integer approvalStatus;
  private Long approvalId;
  private Long stockId;
  private Long toStockId;

  @Length(max=512)
  private String remark;

  public StockRecord()
  {
  }

  public StockRecord(Long stockOperationId)
  {
    this.stockOperationId = stockOperationId;
  }

  public void setStockOperationId(Long value) {
    this.stockOperationId = value;
  }

  public Long getStockOperationId() {
    return this.stockOperationId;
  }
  public void setDeptId(Integer value) {
    this.deptId = value;
  }

  public Integer getDeptId() {
    return this.deptId;
  }
  public void setStaffId(Long value) {
    this.staffId = value;
  }

  public Long getStaffId() {
    return this.staffId;
  }
  public void setOperType(Integer value) {
    this.operType = value;
  }

  public Integer getOperType() {
    return this.operType;
  }
  public void setCustId(Long value) {
    this.custId = value;
  }

  public Long getCustId() {
    return this.custId;
  }
  public String getOperDateString() {
    return DateConvertUtils.format(getOperDate(), "yyyy-MM-dd");
  }
  public void setOperDateString(String value) {
    setOperDate(DateConvertUtils.parse(value, "yyyy-MM-dd", Date.class));
  }

  public void setOperDate(Date value) {
    this.operDate = value;
  }

  public Date getOperDate() {
    return this.operDate;
  }
  public void setApprovalStatus(Integer value) {
    this.approvalStatus = value;
  }

  public Integer getApprovalStatus() {
    return this.approvalStatus;
  }
  public void setApprovalId(Long value) {
    this.approvalId = value;
  }

  public Long getApprovalId() {
    return this.approvalId;
  }
  public void setStockId(Long value) {
    this.stockId = value;
  }

  public Long getStockId() {
    return this.stockId;
  }
  public void setToStockId(Long value) {
    this.toStockId = value;
  }

  public Long getToStockId() {
    return this.toStockId;
  }
  public void setRemark(String value) {
    this.remark = value;
  }

  public String getRemark() {
    return this.remark;
  }

  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
      .append("StockOperationId", getStockOperationId())
      .append("DeptId", getDeptId())
      .append("StaffId", getStaffId())
      .append("OperType", getOperType())
      .append("CustId", getCustId())
      .append("OperDate", getOperDate())
      .append("ApprovalStatus", getApprovalStatus())
      .append("ApprovalId", getApprovalId())
      .append("StockId", getStockId())
      .append("ToStockId", getToStockId())
      .append("Remark", getRemark())
      .toString();
  }

  public int hashCode() {
    return new HashCodeBuilder()
      .append(getStockOperationId())
      .toHashCode();
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof StockRecord)) return false;
    if (this == obj) return true;
    StockRecord other = (StockRecord)obj;
    return new EqualsBuilder()
      .append(getStockOperationId(), other.getStockOperationId())
      .isEquals();
  }
}