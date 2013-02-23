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


public class AppDataQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** appDataId */
	private java.lang.Long appDataId;
	/** 属性名 */
	private java.lang.String dataCode;
	/** 属性值 */
	private java.lang.String dataValue;
	/** 属性值 */
	private java.lang.String dataValueText;
	/** 属性显示名 */
	private java.lang.String displayName;
	/** 简称 */
	private java.lang.String shortName;
	/** 属性类型 */
	private java.lang.Integer dataType;
	/** 是否可用 */
	private java.lang.Boolean isAvailable;
	/** 创建时间 */
	private java.util.Date ctimeBegin;
	private java.util.Date ctimeEnd;

	public java.lang.Long getAppDataId() {
		return this.appDataId;
	}
	
	public void setAppDataId(java.lang.Long value) {
		this.appDataId = value;
	}
	
	public java.lang.String getDataCode() {
		return this.dataCode;
	}
	
	public void setDataCode(java.lang.String value) {
		this.dataCode = value;
	}
	
	public java.lang.String getDataValue() {
		return this.dataValue;
	}
	
	public void setDataValue(java.lang.String value) {
		this.dataValue = value;
	}
	
	public java.lang.String getDataValueText() {
		return this.dataValueText;
	}
	
	public void setDataValueText(java.lang.String value) {
		this.dataValueText = value;
	}
	
	public java.lang.String getDisplayName() {
		return this.displayName;
	}
	
	public void setDisplayName(java.lang.String value) {
		this.displayName = value;
	}
	
	public java.lang.String getShortName() {
		return this.shortName;
	}
	
	public void setShortName(java.lang.String value) {
		this.shortName = value;
	}
	
	public java.lang.Integer getDataType() {
		return this.dataType;
	}
	
	public void setDataType(java.lang.Integer value) {
		this.dataType = value;
	}
	
	public java.lang.Boolean getIsAvailable() {
		return this.isAvailable;
	}
	
	public void setIsAvailable(java.lang.Boolean value) {
		this.isAvailable = value;
	}
	
	public java.util.Date getCtimeBegin() {
		return this.ctimeBegin;
	}
	
	public void setCtimeBegin(java.util.Date value) {
		this.ctimeBegin = value;
	}	
	
	public java.util.Date getCtimeEnd() {
		return this.ctimeEnd;
	}
	
	public void setCtimeEnd(java.util.Date value) {
		this.ctimeEnd = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

