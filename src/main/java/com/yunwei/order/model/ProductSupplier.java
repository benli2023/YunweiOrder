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


public class ProductSupplier extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "ProductSupplier";
	public static final String ALIAS_PRODUCT_SUPPLIER_ID = "productSupplierId";
	public static final String ALIAS_PRODUCT_ID = "productId";
	public static final String ALIAS_CUST_ID = "custId";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * productSupplierId       db_column: product_supplier_id 
     */ 	
	
	private java.lang.Long productSupplierId;
    /**
     * productId       db_column: product_id 
     */ 	
	
	private java.lang.Long productId;
    /**
     * custId       db_column: cust_id 
     */ 	
	
	private java.lang.Long custId;
	//columns END

	public ProductSupplier(){
	}

	public ProductSupplier(
		java.lang.Long productSupplierId
	){
		this.productSupplierId = productSupplierId;
	}

	public void setProductSupplierId(java.lang.Long value) {
		this.productSupplierId = value;
	}
	
	public java.lang.Long getProductSupplierId() {
		return this.productSupplierId;
	}
	public void setProductId(java.lang.Long value) {
		this.productId = value;
	}
	
	public java.lang.Long getProductId() {
		return this.productId;
	}
	public void setCustId(java.lang.Long value) {
		this.custId = value;
	}
	
	public java.lang.Long getCustId() {
		return this.custId;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("ProductSupplierId",getProductSupplierId())
			.append("ProductId",getProductId())
			.append("CustId",getCustId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getProductSupplierId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ProductSupplier == false) return false;
		if(this == obj) return true;
		ProductSupplier other = (ProductSupplier)obj;
		return new EqualsBuilder()
			.append(getProductSupplierId(),other.getProductSupplierId())
			.isEquals();
	}
}

