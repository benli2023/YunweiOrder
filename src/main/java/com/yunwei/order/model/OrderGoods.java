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


public class OrderGoods extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "OrderGoods";
	public static final String ALIAS_GOODS_ID = "goodsId";
	public static final String ALIAS_GOODS_CODE = "编码或条形码";
	public static final String ALIAS_PRODUCT_ID = "productId";
	public static final String ALIAS_ORDER_ID = "orderId";
	public static final String ALIAS_UNIT = "单位";
	public static final String ALIAS_UNIT_PRICE = "单价";
	public static final String ALIAS_QUANTITY = "数量";
	public static final String ALIAS_HANDED_QUANTITY = "已交数量";
	public static final String ALIAS_UNTAXED_AMOUNT = "未税金额";
	public static final String ALIAS_TAX_RATE = "税率";
	public static final String ALIAS_OUTPUT_TAX_AMOUNT = "销项税额=未税金额x(1+税率)";
	public static final String ALIAS_TAX_AMOUNT = "税额=当期销项税额-当期进项税额";
	public static final String ALIAS_MODEL = "型号";
	public static final String ALIAS_REMARK = "备注说明";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * goodsId       db_column: goods_id 
     */ 	
	
	private java.lang.Long goodsId;
    /**
     * 编码或条形码       db_column: goods_code 
     */ 	
	@Length(max=256)
	private java.lang.String goodsCode;
    /**
     * productId       db_column: product_id 
     */ 	
	
	private java.lang.Long productId;
    /**
     * orderId       db_column: order_id 
     */ 	
	
	private java.lang.Long orderId;
    /**
     * 单位       db_column: unit 
     */ 	
	@Length(max=8)
	private java.lang.String unit;
    /**
     * 单价       db_column: unit_price 
     */ 	
	
	private Long unitPrice;
    /**
     * 数量       db_column: quantity 
     */ 	
	
	private java.lang.Integer quantity;
    /**
     * 已交数量       db_column: handed_quantity 
     */ 	
	
	private java.lang.Integer handedQuantity;
    /**
     * 未税金额       db_column: untaxed_amount 
     */ 	
	
	private Long untaxedAmount;
    /**
     * 税率       db_column: tax_rate 
     */ 	
	
	private java.lang.Double taxRate;
    /**
     * 销项税额=未税金额x(1+税率)       db_column: output_tax_amount 
     */ 	
	
	private Long outputTaxAmount;
    /**
     * 税额=当期销项税额-当期进项税额       db_column: tax_amount 
     */ 	
	
	private Long taxAmount;
    /**
     * 型号       db_column: model 
     */ 	
	@Length(max=8)
	private java.lang.String model;
    /**
     * 备注说明       db_column: remark 
     */ 	
	@Length(max=512)
	private java.lang.String remark;
	//columns END

	public OrderGoods(){
	}

	public OrderGoods(
		java.lang.Long goodsId
	){
		this.goodsId = goodsId;
	}

	public void setGoodsId(java.lang.Long value) {
		this.goodsId = value;
	}
	
	public java.lang.Long getGoodsId() {
		return this.goodsId;
	}
	public void setGoodsCode(java.lang.String value) {
		this.goodsCode = value;
	}
	
	public java.lang.String getGoodsCode() {
		return this.goodsCode;
	}
	public void setProductId(java.lang.Long value) {
		this.productId = value;
	}
	
	public java.lang.Long getProductId() {
		return this.productId;
	}
	public void setOrderId(java.lang.Long value) {
		this.orderId = value;
	}
	
	public java.lang.Long getOrderId() {
		return this.orderId;
	}
	public void setUnit(java.lang.String value) {
		this.unit = value;
	}
	
	public java.lang.String getUnit() {
		return this.unit;
	}
	public void setUnitPrice(Long value) {
		this.unitPrice = value;
	}
	
	public Long getUnitPrice() {
		return this.unitPrice;
	}
	public void setQuantity(java.lang.Integer value) {
		this.quantity = value;
	}
	
	public java.lang.Integer getQuantity() {
		return this.quantity;
	}
	public void setHandedQuantity(java.lang.Integer value) {
		this.handedQuantity = value;
	}
	
	public java.lang.Integer getHandedQuantity() {
		return this.handedQuantity;
	}
	public void setUntaxedAmount(Long value) {
		this.untaxedAmount = value;
	}
	
	public Long getUntaxedAmount() {
		return this.untaxedAmount;
	}
	public void setTaxRate(java.lang.Double value) {
		this.taxRate = value;
	}
	
	public java.lang.Double getTaxRate() {
		return this.taxRate;
	}
	public void setOutputTaxAmount(Long value) {
		this.outputTaxAmount = value;
	}
	
	public Long getOutputTaxAmount() {
		return this.outputTaxAmount;
	}
	public void setTaxAmount(Long value) {
		this.taxAmount = value;
	}
	
	public Long getTaxAmount() {
		return this.taxAmount;
	}
	public void setModel(java.lang.String value) {
		this.model = value;
	}
	
	public java.lang.String getModel() {
		return this.model;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("GoodsId",getGoodsId())
			.append("GoodsCode",getGoodsCode())
			.append("ProductId",getProductId())
			.append("OrderId",getOrderId())
			.append("Unit",getUnit())
			.append("UnitPrice",getUnitPrice())
			.append("Quantity",getQuantity())
			.append("HandedQuantity",getHandedQuantity())
			.append("UntaxedAmount",getUntaxedAmount())
			.append("TaxRate",getTaxRate())
			.append("OutputTaxAmount",getOutputTaxAmount())
			.append("TaxAmount",getTaxAmount())
			.append("Model",getModel())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getGoodsId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof OrderGoods == false) return false;
		if(this == obj) return true;
		OrderGoods other = (OrderGoods)obj;
		return new EqualsBuilder()
			.append(getGoodsId(),other.getGoodsId())
			.isEquals();
	}
}

