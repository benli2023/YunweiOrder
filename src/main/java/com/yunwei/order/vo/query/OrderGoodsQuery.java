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


public class OrderGoodsQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** goodsId */
	private java.lang.Long goodsId;
	/** 编码或条形码 */
	private java.lang.String goodsCode;
	/** productId */
	private java.lang.Long productId;
	/** orderId */
	private java.lang.Long orderId;
	/** 单位 */
	private java.lang.String unit;
	/** 单价 */
	private Long unitPrice;
	/** 数量 */
	private java.lang.Integer quantity;
	/** 已交数量 */
	private java.lang.Integer handedQuantity;
	/** 未税金额 */
	private Long untaxedAmount;
	/** 税率 */
	private java.lang.Double taxRate;
	/** 销项税额=未税金额x(1+税率) */
	private Long outputTaxAmount;
	/** 税额=当期销项税额-当期进项税额 */
	private Long taxAmount;
	/** 型号 */
	private java.lang.String model;
	/** 备注说明 */
	private java.lang.String remark;

	public java.lang.Long getGoodsId() {
		return this.goodsId;
	}
	
	public void setGoodsId(java.lang.Long value) {
		this.goodsId = value;
	}
	
	public java.lang.String getGoodsCode() {
		return this.goodsCode;
	}
	
	public void setGoodsCode(java.lang.String value) {
		this.goodsCode = value;
	}
	
	public java.lang.Long getProductId() {
		return this.productId;
	}
	
	public void setProductId(java.lang.Long value) {
		this.productId = value;
	}
	
	public java.lang.Long getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(java.lang.Long value) {
		this.orderId = value;
	}
	
	public java.lang.String getUnit() {
		return this.unit;
	}
	
	public void setUnit(java.lang.String value) {
		this.unit = value;
	}
	
	public Long getUnitPrice() {
		return this.unitPrice;
	}
	
	public void setUnitPrice(Long value) {
		this.unitPrice = value;
	}
	
	public java.lang.Integer getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(java.lang.Integer value) {
		this.quantity = value;
	}
	
	public java.lang.Integer getHandedQuantity() {
		return this.handedQuantity;
	}
	
	public void setHandedQuantity(java.lang.Integer value) {
		this.handedQuantity = value;
	}
	
	public Long getUntaxedAmount() {
		return this.untaxedAmount;
	}
	
	public void setUntaxedAmount(Long value) {
		this.untaxedAmount = value;
	}
	
	public java.lang.Double getTaxRate() {
		return this.taxRate;
	}
	
	public void setTaxRate(java.lang.Double value) {
		this.taxRate = value;
	}
	
	public Long getOutputTaxAmount() {
		return this.outputTaxAmount;
	}
	
	public void setOutputTaxAmount(Long value) {
		this.outputTaxAmount = value;
	}
	
	public Long getTaxAmount() {
		return this.taxAmount;
	}
	
	public void setTaxAmount(Long value) {
		this.taxAmount = value;
	}
	
	public java.lang.String getModel() {
		return this.model;
	}
	
	public void setModel(java.lang.String value) {
		this.model = value;
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

