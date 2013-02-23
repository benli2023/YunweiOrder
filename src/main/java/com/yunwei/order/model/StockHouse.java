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


public class StockHouse extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "StockHouse";
	public static final String ALIAS_STOCK_ID = "stockId";
	public static final String ALIAS_STAFF_ID = "仓库保管";
	public static final String ALIAS_ADDRESS = "address";
	public static final String ALIAS_PHONE = "phone";
	public static final String ALIAS_CTIME = "创建时间";
	
	//date formats
	public static final String FORMAT_CTIME = DATE_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * stockId       db_column: stock_id 
     */ 	
	
	private java.lang.Long stockId;
    /**
     * 仓库保管       db_column: staff_id 
     */ 	
	
	private java.lang.Long staffId;
    /**
     * address       db_column: address 
     */ 	
	@Length(max=256)
	private java.lang.String address;
    /**
     * phone       db_column: phone 
     */ 	
	@Length(max=32)
	private java.lang.String phone;
    /**
     * 创建时间       db_column: cTime 
     */ 	
	
	private java.util.Date ctime;
	//columns END

	public StockHouse(){
	}

	public StockHouse(
		java.lang.Long stockId
	){
		this.stockId = stockId;
	}

	public void setStockId(java.lang.Long value) {
		this.stockId = value;
	}
	
	public java.lang.Long getStockId() {
		return this.stockId;
	}
	public void setStaffId(java.lang.Long value) {
		this.staffId = value;
	}
	
	public java.lang.Long getStaffId() {
		return this.staffId;
	}
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
	public void setPhone(java.lang.String value) {
		this.phone = value;
	}
	
	public java.lang.String getPhone() {
		return this.phone;
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
			.append("StockId",getStockId())
			.append("StaffId",getStaffId())
			.append("Address",getAddress())
			.append("Phone",getPhone())
			.append("Ctime",getCtime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStockId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StockHouse == false) return false;
		if(this == obj) return true;
		StockHouse other = (StockHouse)obj;
		return new EqualsBuilder()
			.append(getStockId(),other.getStockId())
			.isEquals();
	}
}

