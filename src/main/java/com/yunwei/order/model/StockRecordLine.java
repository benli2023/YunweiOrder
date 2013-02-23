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


public class StockRecordLine extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "StockRecordLine";
	public static final String ALIAS_STOCK_OPER_DETAIL_ID = "stockOperDetailId";
	public static final String ALIAS_STOCK_OPERATION_ID = "stockOperationId";
	public static final String ALIAS_PRODUCT_ID = "productId";
	public static final String ALIAS_PRICE = "price";
	public static final String ALIAS_QUANTITY = "出库数量";
	public static final String ALIAS_HAVE_INVOICE = "是否有发票";
	public static final String ALIAS_INVOICE_NUMBER = "发票号码";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * stockOperDetailId       db_column: stock_oper_detail_id 
     */ 	
	
	private java.lang.Long stockOperDetailId;
    /**
     * stockOperationId       db_column: stock_operation_id 
     */ 	
	
	private java.lang.Long stockOperationId;
    /**
     * productId       db_column: product_id 
     */ 	
	
	private java.lang.Long productId;
    /**
     * price       db_column: price 
     */ 	
	
	private Long price;
    /**
     * 出库数量       db_column: quantity 
     */ 	
	
	private java.lang.Integer quantity;
    /**
     * 是否有发票       db_column: have_invoice 
     */ 	
	
	private java.lang.Boolean haveInvoice;
    /**
     * 发票号码       db_column: invoice_number 
     */ 	
	@Length(max=32)
	private java.lang.String invoiceNumber;
	//columns END

	public StockRecordLine(){
	}

	public StockRecordLine(
		java.lang.Long stockOperDetailId
	){
		this.stockOperDetailId = stockOperDetailId;
	}

	public void setStockOperDetailId(java.lang.Long value) {
		this.stockOperDetailId = value;
	}
	
	public java.lang.Long getStockOperDetailId() {
		return this.stockOperDetailId;
	}
	public void setStockOperationId(java.lang.Long value) {
		this.stockOperationId = value;
	}
	
	public java.lang.Long getStockOperationId() {
		return this.stockOperationId;
	}
	public void setProductId(java.lang.Long value) {
		this.productId = value;
	}
	
	public java.lang.Long getProductId() {
		return this.productId;
	}
	public void setPrice(Long value) {
		this.price = value;
	}
	
	public Long getPrice() {
		return this.price;
	}
	public void setQuantity(java.lang.Integer value) {
		this.quantity = value;
	}
	
	public java.lang.Integer getQuantity() {
		return this.quantity;
	}
	public void setHaveInvoice(java.lang.Boolean value) {
		this.haveInvoice = value;
	}
	
	public java.lang.Boolean getHaveInvoice() {
		return this.haveInvoice;
	}
	public void setInvoiceNumber(java.lang.String value) {
		this.invoiceNumber = value;
	}
	
	public java.lang.String getInvoiceNumber() {
		return this.invoiceNumber;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("StockOperDetailId",getStockOperDetailId())
			.append("StockOperationId",getStockOperationId())
			.append("ProductId",getProductId())
			.append("Price",getPrice())
			.append("Quantity",getQuantity())
			.append("HaveInvoice",getHaveInvoice())
			.append("InvoiceNumber",getInvoiceNumber())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStockOperDetailId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StockRecordLine == false) return false;
		if(this == obj) return true;
		StockRecordLine other = (StockRecordLine)obj;
		return new EqualsBuilder()
			.append(getStockOperDetailId(),other.getStockOperDetailId())
			.isEquals();
	}
}

