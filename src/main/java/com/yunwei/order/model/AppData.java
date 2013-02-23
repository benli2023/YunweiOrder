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


public class AppData extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "AppData";
	public static final String ALIAS_APP_DATA_ID = "appDataId";
	public static final String ALIAS_DATA_CODE = "属性名";
	public static final String ALIAS_DATA_VALUE = "属性值";
	public static final String ALIAS_DATA_VALUE_TEXT = "属性值";
	public static final String ALIAS_DISPLAY_NAME = "属性显示名";
	public static final String ALIAS_SHORT_NAME = "简称";
	public static final String ALIAS_DATA_TYPE = "属性类型";
	public static final String ALIAS_IS_AVAILABLE = "是否可用";
	public static final String ALIAS_CTIME = "创建时间";
	
	//date formats
	public static final String FORMAT_CTIME = DATE_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * appDataId       db_column: app_data_id 
     */ 	
	
	private java.lang.Long appDataId;
    /**
     * 属性名       db_column: data_code 
     */ 	
	@NotBlank @Length(max=8)
	private java.lang.String dataCode;
    /**
     * 属性值       db_column: data_value 
     */ 	
	@Length(max=256)
	private java.lang.String dataValue;
    /**
     * 属性值       db_column: data_value_text 
     */ 	
	@Length(max=65535)
	private java.lang.String dataValueText;
    /**
     * 属性显示名       db_column: display_name 
     */ 	
	@Length(max=256)
	private java.lang.String displayName;
    /**
     * 简称       db_column: short_name 
     */ 	
	@Length(max=64)
	private java.lang.String shortName;
    /**
     * 属性类型       db_column: data_type 
     */ 	
	
	private java.lang.Integer dataType;
    /**
     * 是否可用       db_column: is_available 
     */ 	
	
	private java.lang.Boolean isAvailable;
    /**
     * 创建时间       db_column: cTime 
     */ 	
	
	private java.util.Date ctime;
	//columns END

	public AppData(){
	}

	public AppData(
		java.lang.Long appDataId
	){
		this.appDataId = appDataId;
	}

	public void setAppDataId(java.lang.Long value) {
		this.appDataId = value;
	}
	
	public java.lang.Long getAppDataId() {
		return this.appDataId;
	}
	public void setDataCode(java.lang.String value) {
		this.dataCode = value;
	}
	
	public java.lang.String getDataCode() {
		return this.dataCode;
	}
	public void setDataValue(java.lang.String value) {
		this.dataValue = value;
	}
	
	public java.lang.String getDataValue() {
		return this.dataValue;
	}
	public void setDataValueText(java.lang.String value) {
		this.dataValueText = value;
	}
	
	public java.lang.String getDataValueText() {
		return this.dataValueText;
	}
	public void setDisplayName(java.lang.String value) {
		this.displayName = value;
	}
	
	public java.lang.String getDisplayName() {
		return this.displayName;
	}
	public void setShortName(java.lang.String value) {
		this.shortName = value;
	}
	
	public java.lang.String getShortName() {
		return this.shortName;
	}
	public void setDataType(java.lang.Integer value) {
		this.dataType = value;
	}
	
	public java.lang.Integer getDataType() {
		return this.dataType;
	}
	public void setIsAvailable(java.lang.Boolean value) {
		this.isAvailable = value;
	}
	
	public java.lang.Boolean getIsAvailable() {
		return this.isAvailable;
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
			.append("AppDataId",getAppDataId())
			.append("DataCode",getDataCode())
			.append("DataValue",getDataValue())
			.append("DataValueText",getDataValueText())
			.append("DisplayName",getDisplayName())
			.append("ShortName",getShortName())
			.append("DataType",getDataType())
			.append("IsAvailable",getIsAvailable())
			.append("Ctime",getCtime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getAppDataId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AppData == false) return false;
		if(this == obj) return true;
		AppData other = (AppData)obj;
		return new EqualsBuilder()
			.append(getAppDataId(),other.getAppDataId())
			.isEquals();
	}
}

