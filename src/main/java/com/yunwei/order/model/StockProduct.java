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


public class StockProduct extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "StockProduct";
	public static final String ALIAS_STOCK_PRODUCT_ID = "stockProductId";
	public static final String ALIAS_STOCK_ID = "stockId";
	public static final String ALIAS_PRODUCT_ID = "productId";
	public static final String ALIAS_QUANTITY = "quantity";
	public static final String ALIAS_FIRST_ENTER_DATE = "首次入库时间";
	public static final String ALIAS_OUTER_DATE = "最新出库时间";
	public static final String ALIAS_PRICE = "price";
	
	//date formats
	public static final String FORMAT_FIRST_ENTER_DATE = DATE_FORMAT;
	public static final String FORMAT_OUTER_DATE = DATE_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * stockProductId       db_column: stock_product_id 
     */ 	
	
	private java.lang.Long stockProductId;
    /**
     * stockId       db_column: stock_id 
     */ 	
	
	private java.lang.Long stockId;
    /**
     * productId       db_column: product_id 
     */ 	
	
	private java.lang.Long productId;
    /**
     * quantity       db_column: quantity 
     */ 	
	
	private java.lang.Integer quantity;
    /**
     * 首次入库时间       db_column: first_enter_date 
     */ 	
	
	private java.util.Date firstEnterDate;
    /**
     * 最新出库时间       db_column: outer_date 
     */ 	
	
	private java.util.Date outerDate;
    /**
     * price       db_column: price 
     */ 	
	
	private Long price;
	//columns END

	public StockProduct(){
	}

	public StockProduct(
		java.lang.Long stockProductId
	){
		this.stockProductId = stockProductId;
	}

	public void setStockProductId(java.lang.Long value) {
		this.stockProductId = value;
	}
	
	public java.lang.Long getStockProductId() {
		return this.stockProductId;
	}
	public void setStockId(java.lang.Long value) {
		this.stockId = value;
	}
	
	public java.lang.Long getStockId() {
		return this.stockId;
	}
	public void setProductId(java.lang.Long value) {
		this.productId = value;
	}
	
	public java.lang.Long getProductId() {
		return this.productId;
	}
	public void setQuantity(java.lang.Integer value) {
		this.quantity = value;
	}
	
	public java.lang.Integer getQuantity() {
		return this.quantity;
	}
	public String getFirstEnterDateString() {
		return DateConvertUtils.format(getFirstEnterDate(), FORMAT_FIRST_ENTER_DATE);
	}
	public void setFirstEnterDateString(String value) {
		setFirstEnterDate(DateConvertUtils.parse(value, FORMAT_FIRST_ENTER_DATE,java.util.Date.class));
	}
	
	public void setFirstEnterDate(java.util.Date value) {
		this.firstEnterDate = value;
	}
	
	public java.util.Date getFirstEnterDate() {
		return this.firstEnterDate;
	}
	public String getOuterDateString() {
		return DateConvertUtils.format(getOuterDate(), FORMAT_OUTER_DATE);
	}
	public void setOuterDateString(String value) {
		setOuterDate(DateConvertUtils.parse(value, FORMAT_OUTER_DATE,java.util.Date.class));
	}
	
	public void setOuterDate(java.util.Date value) {
		this.outerDate = value;
	}
	
	public java.util.Date getOuterDate() {
		return this.outerDate;
	}
	public void setPrice(Long value) {
		this.price = value;
	}
	
	public Long getPrice() {
		return this.price;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("StockProductId",getStockProductId())
			.append("StockId",getStockId())
			.append("ProductId",getProductId())
			.append("Quantity",getQuantity())
			.append("FirstEnterDate",getFirstEnterDate())
			.append("OuterDate",getOuterDate())
			.append("Price",getPrice())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStockProductId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StockProduct == false) return false;
		if(this == obj) return true;
		StockProduct other = (StockProduct)obj;
		return new EqualsBuilder()
			.append(getStockProductId(),other.getStockProductId())
			.isEquals();
	}
}

