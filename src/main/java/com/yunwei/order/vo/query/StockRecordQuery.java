package com.yunwei.order.vo.query;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.springrest.base.BaseQuery;

public class StockRecordQuery extends BaseQuery
  implements Serializable
{
  private static final long serialVersionUID = 3148176768559230877L;
  private Long stockOperationId;
  private Integer deptId;
  private Long staffId;
  private Integer operType;
  private Long custId;
  private Date operDateBegin;
  private Date operDateEnd;
  private Integer approvalStatus;
  private Long approvalId;
  private Long stockId;
  private Long toStockId;
  private String remark;

  public Long getStockOperationId()
  {
    return this.stockOperationId;
  }

  public void setStockOperationId(Long value) {
    this.stockOperationId = value;
  }

  public Integer getDeptId() {
    return this.deptId;
  }

  public void setDeptId(Integer value) {
    this.deptId = value;
  }

  public Long getStaffId() {
    return this.staffId;
  }

  public void setStaffId(Long value) {
    this.staffId = value;
  }

  public Integer getOperType() {
    return this.operType;
  }

  public void setOperType(Integer value) {
    this.operType = value;
  }

  public Long getCustId() {
    return this.custId;
  }

  public void setCustId(Long value) {
    this.custId = value;
  }

  public Date getOperDateBegin() {
    return this.operDateBegin;
  }

  public void setOperDateBegin(Date value) {
    this.operDateBegin = value;
  }

  public Date getOperDateEnd() {
    return this.operDateEnd;
  }

  public void setOperDateEnd(Date value) {
    this.operDateEnd = value;
  }

  public Integer getApprovalStatus() {
    return this.approvalStatus;
  }

  public void setApprovalStatus(Integer value) {
    this.approvalStatus = value;
  }

  public Long getApprovalId() {
    return this.approvalId;
  }

  public void setApprovalId(Long value) {
    this.approvalId = value;
  }

  public Long getStockId() {
    return this.stockId;
  }

  public void setStockId(Long value) {
    this.stockId = value;
  }

  public Long getToStockId() {
    return this.toStockId;
  }

  public void setToStockId(Long value) {
    this.toStockId = value;
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