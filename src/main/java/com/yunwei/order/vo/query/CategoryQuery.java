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



/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class CategoryQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** cateId */
	private java.lang.Long cateId;
	/** parentId */
	private java.lang.Long parentId;
	private String parentIdTxt;
	/** cateName */
	private java.lang.String cateName;
	/** 是否有效 */
	private java.lang.Integer isAvailable=-1;
	/** 创建时间 */
	private java.util.Date ctimeBegin;
	private java.util.Date ctimeEnd;
	/** 创建人 */
	private java.lang.Long admin;

	public java.lang.Long getCateId() {
		return this.cateId;
	}
	
	public void setCateId(java.lang.Long value) {
		this.cateId = value;
	}
	
	
	public java.lang.Long getParentId() {
		return this.parentId;
	}
	
	public void setParentId(java.lang.Long value) {
		this.parentId = value;
	}
	
	public String getParentIdTxt() {
		return this.parentIdTxt;
	}
	
	public void setParentIdTxt(String value) {
		this.parentIdTxt = value;
	}
	
	public java.lang.String getCateName() {
		return this.cateName;
	}
	
	public void setCateName(java.lang.String value) {
		this.cateName = value;
	}
	
	public java.lang.Integer getIsAvailable() {
		return this.isAvailable;
	}
	
	public void setIsAvailable(java.lang.Integer value) {
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
	
	public java.lang.Long getAdmin() {
		return this.admin;
	}
	
	public void setAdmin(java.lang.Long value) {
		this.admin = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

