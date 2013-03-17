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
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.github.springrest.base.JsonDateSerializer;

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


public class StockHouse extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "仓库";
	public static final String ALIAS_STOCK_ID = "仓库ID";
	public static final String ALIAS_STAFF_ID = "仓库负责人";
	public static final String ALIAS_STOCK_NAME = "仓库名称";
	public static final String ALIAS_ADDRESS = "地址";
	public static final String ALIAS_PHONE = "电话";
	public static final String ALIAS_CTIME = "创建时间";
	
	//date formats
	public static final String FORMAT_CTIME = DATE_TIME_FORMAT;
	public static final String FORMAT_CTIME_DATE = DATE_FORMAT;
	
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
    /**
     * 仓库ID       db_column: stock_id 
     */ 	
	
	
	
	private java.lang.Long stockId;
	
	
	private java.lang.Long staffId;
	private String staffIdTxt;
	
	
    /**
     * 仓库名称       db_column: stock_name 
     */ 	
	@Length(max=256)
	@JsonProperty("stock_name")
	
	private java.lang.String stockName;
	
	
    /**
     * 地址       db_column: address 
     */ 	
	@Length(max=256)
	
	
	private java.lang.String address;
	
	
    /**
     * 电话       db_column: phone 
     */ 	
	@Length(max=32)
	
	
	private java.lang.String phone;
	
	
    /**
     * 创建时间       db_column: cTime 
     */ 	
	
	
	@JsonSerialize(using = JsonDateSerializer.class)
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
	public String getStaffIdTxt() {
		return this.staffIdTxt;
	}
	
	public void setStaffIdTxt(String value) {
		this.staffIdTxt = value;
	}
	public void setStockName(java.lang.String value) {
		this.stockName = value;
	}
	
	public java.lang.String getStockName() {
		return this.stockName;
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
			.append("StockName",getStockName())
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

