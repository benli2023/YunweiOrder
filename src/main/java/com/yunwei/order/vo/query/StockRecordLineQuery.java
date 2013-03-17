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


public class StockRecordLineQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 业务单明细 */
	private java.lang.Long stockOperDetailId;
	/** 业务单ID */
	private java.lang.Long stockOperationId;
	private String stockOperationIdTxt;
	/** 产品 */
	private java.lang.Long productId;
	private String productIdTxt;
	/** 价格 */
	private java.math.BigDecimal price;
	/** 出库数量 */
	private java.lang.Integer quantity;
	/** 是否有发票 */
	private java.lang.Integer haveInvoice=-1;
	/** 发票号码 */
	private java.lang.String invoiceNumber;

	public java.lang.Long getStockOperDetailId() {
		return this.stockOperDetailId;
	}
	
	public void setStockOperDetailId(java.lang.Long value) {
		this.stockOperDetailId = value;
	}
	
	
	public java.lang.Long getStockOperationId() {
		return this.stockOperationId;
	}
	
	public void setStockOperationId(java.lang.Long value) {
		this.stockOperationId = value;
	}
	
	public String getStockOperationIdTxt() {
		return this.stockOperationIdTxt;
	}
	
	public void setStockOperationIdTxt(String value) {
		this.stockOperationIdTxt = value;
	}
	
	
	public java.lang.Long getProductId() {
		return this.productId;
	}
	
	public void setProductId(java.lang.Long value) {
		this.productId = value;
	}
	
	public String getProductIdTxt() {
		return this.productIdTxt;
	}
	
	public void setProductIdTxt(String value) {
		this.productIdTxt = value;
	}
	
	public java.math.BigDecimal getPrice() {
		return this.price;
	}
	
	public void setPrice(java.math.BigDecimal value) {
		this.price = value;
	}
	
	public java.lang.Integer getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(java.lang.Integer value) {
		this.quantity = value;
	}
	
	public java.lang.Integer getHaveInvoice() {
		return this.haveInvoice;
	}
	
	public void setHaveInvoice(java.lang.Integer value) {
		this.haveInvoice = value;
	}
	
	public java.lang.String getInvoiceNumber() {
		return this.invoiceNumber;
	}
	
	public void setInvoiceNumber(java.lang.String value) {
		this.invoiceNumber = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

