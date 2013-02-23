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


public class Product extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Product";
	public static final String ALIAS_PRODUCT_ID = "productId";
	public static final String ALIAS_CAT_ID = "产品分类";
	public static final String ALIAS_PRODUCT_NAME = "商品名称";
	public static final String ALIAS_PRODUCT_CODE = "商品编码";
	public static final String ALIAS_CEIL_LIMIT = "库存上限";
	public static final String ALIAS_LOW_LIMIT = "库存下限";
	public static final String ALIAS_PINY_CODE = "拼音编码";
	public static final String ALIAS_PRODUCT_SPEC = "规格型号";
	public static final String ALIAS_SALE_PRICE = "预设售价";
	public static final String ALIAS_PURCHASE_PRICE = "预设进价";
	public static final String ALIAS_IS_AVAILABLE = "是否有效";
	public static final String ALIAS_IS_SELLABLE = "是否可卖";
	public static final String ALIAS_IS_NEGATIVE = "是否允许负库存";
	public static final String ALIAS_IS_PURCHASABLE = "是否允许采购";
	public static final String ALIAS_PRODUCT_IMAGE = "产品图片";
	public static final String ALIAS_MANUFACTURER = "生产商";
	public static final String ALIAS_ORGINAL_PLACE = "产地";
	public static final String ALIAS_CTIME = "创建时间";
	
	//date formats
	public static final String FORMAT_CTIME = DATE_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * productId       db_column: product_id 
     */ 	
	
	private java.lang.Long productId;
	
	private String catIdTxt; 
    /**
     * catId       db_column: cat_id 
     */ 	
	
	private java.lang.Long catId;
    /**
     * 商品名称       db_column: product_name 
     */ 	
	@Length(max=64)
	private java.lang.String productName;
    /**
     * 商品编码       db_column: product_code 
     */ 	
	@Length(max=64)
	private java.lang.String productCode;
    /**
     * 库存上限       db_column: ceil_limit 
     */ 	
	
	private java.lang.Integer ceilLimit;
    /**
     * 库存下限       db_column: low_limit 
     */ 	
	
	private java.lang.Integer lowLimit;
    /**
     * 拼音编码       db_column: piny_code 
     */ 	
	@Length(max=64)
	private java.lang.String pinyCode;
    /**
     * 规格型号       db_column: product_spec 
     */ 	
	@Length(max=64)
	private java.lang.String productSpec;
    /**
     * 预设售价       db_column: sale_price 
     */ 	
	
	private Long salePrice;
    /**
     * 预设进价       db_column: purchase_price 
     */ 	
	
	private Long purchasePrice;
    /**
     * 是否有效       db_column: is_available 
     */ 	
	
	private int isAvailable=-1;
    /**
     * 是否可卖       db_column: is_sellable 
     */ 	
	
	private int isSellable=-1;
    /**
     * 是否允许负库存       db_column: is_negative 
     */ 	
	
	private int isNegative=-1;
    /**
     * 是否允许采购       db_column: is_purchasable 
     */ 	
	
	private int isPurchasable=-1;
    /**
     * 产品图片       db_column: product_image 
     */ 	
	@Length(max=256)
	private java.lang.String productImage;
    /**
     * 生产商       db_column: manufacturer 
     */ 	
	@Length(max=256)
	private java.lang.String manufacturer;
    /**
     * 产地       db_column: orginal_place 
     */ 	
	@Length(max=256)
	private java.lang.String orginalPlace;
    /**
     * 创建时间       db_column: cTime 
     */ 	
	
	
	
	private java.util.Date ctime;
	//columns END

	public String getCatIdTxt() {
		return catIdTxt;
	}

	public void setCatIdTxt(String catIdTxt) {
		this.catIdTxt = catIdTxt;
	}

	public Product(){
	}

	public Product(
		java.lang.Long productId
	){
		this.productId = productId;
	}

	public void setProductId(java.lang.Long value) {
		this.productId = value;
	}
	
	public java.lang.Long getProductId() {
		return this.productId;
	}
	public void setCatId(java.lang.Long value) {
		this.catId = value;
	}
	
	public java.lang.Long getCatId() {
		return this.catId;
	}
	public void setProductName(java.lang.String value) {
		this.productName = value;
	}
	
	public java.lang.String getProductName() {
		return this.productName;
	}
	public void setProductCode(java.lang.String value) {
		this.productCode = value;
	}
	
	public java.lang.String getProductCode() {
		return this.productCode;
	}
	public void setCeilLimit(java.lang.Integer value) {
		this.ceilLimit = value;
	}
	
	public java.lang.Integer getCeilLimit() {
		return this.ceilLimit;
	}
	public void setLowLimit(java.lang.Integer value) {
		this.lowLimit = value;
	}
	
	public java.lang.Integer getLowLimit() {
		return this.lowLimit;
	}
	public void setPinyCode(java.lang.String value) {
		this.pinyCode = value;
	}
	
	public java.lang.String getPinyCode() {
		return this.pinyCode;
	}
	public void setProductSpec(java.lang.String value) {
		this.productSpec = value;
	}
	
	public java.lang.String getProductSpec() {
		return this.productSpec;
	}
	public void setSalePrice(Long value) {
		this.salePrice = value;
	}
	
	public Long getSalePrice() {
		return this.salePrice;
	}
	public void setPurchasePrice(Long value) {
		this.purchasePrice = value;
	}
	
	public Long getPurchasePrice() {
		return this.purchasePrice;
	}
	public int getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getIsSellable() {
		return isSellable;
	}

	public void setIsSellable(int isSellable) {
		this.isSellable = isSellable;
	}

	public int getIsNegative() {
		return isNegative;
	}

	public void setIsNegative(int isNegative) {
		this.isNegative = isNegative;
	}

	public int getIsPurchasable() {
		return isPurchasable;
	}

	public void setIsPurchasable(int isPurchasable) {
		this.isPurchasable = isPurchasable;
	}

	public void setProductImage(java.lang.String value) {
		this.productImage = value;
	}
	
	public java.lang.String getProductImage() {
		return this.productImage;
	}
	public void setManufacturer(java.lang.String value) {
		this.manufacturer = value;
	}
	
	public java.lang.String getManufacturer() {
		return this.manufacturer;
	}
	public void setOrginalPlace(java.lang.String value) {
		this.orginalPlace = value;
	}
	
	public java.lang.String getOrginalPlace() {
		return this.orginalPlace;
	}
	public String getCtimeString() {
		return DateConvertUtils.format(getCtime(), FORMAT_CTIME);
	}
	public void setCtimeString(String value) {
		setCtime(DateConvertUtils.parse(value, FORMAT_CTIME,java.util.Date.class));
	}
	
	public void setCtime(java.util.Date value) {
		this.ctime = value;
	}
	
	public java.util.Date getCtime() {
		return this.ctime;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("ProductId",getProductId())
			.append("CatId",getCatId())
			.append("ProductName",getProductName())
			.append("ProductCode",getProductCode())
			.append("CeilLimit",getCeilLimit())
			.append("LowLimit",getLowLimit())
			.append("PinyCode",getPinyCode())
			.append("ProductSpec",getProductSpec())
			.append("SalePrice",getSalePrice())
			.append("PurchasePrice",getPurchasePrice())
			.append("IsAvailable",getIsAvailable())
			.append("IsSellable",getIsSellable())
			.append("IsNegative",getIsNegative())
			.append("IsPurchasable",getIsPurchasable())
			.append("ProductImage",getProductImage())
			.append("Manufacturer",getManufacturer())
			.append("OrginalPlace",getOrginalPlace())
			.append("Ctime",getCtime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getProductId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Product == false) return false;
		if(this == obj) return true;
		Product other = (Product)obj;
		return new EqualsBuilder()
			.append(getProductId(),other.getProductId())
			.isEquals();
	}
}

