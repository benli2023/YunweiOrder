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


public class Dept extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Dept";
	public static final String ALIAS_DEPT_ID = "deptId";
	public static final String ALIAS_DEPT_NAME = "deptName";
	public static final String ALIAS_PARENT_ID = "parentId";
	public static final String ALIAS_REMARK = "remark";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * deptId       db_column: dept_id 
     */ 	
	
	private java.lang.Integer deptId;
    /**
     * deptName       db_column: dept_name 
     */ 	
	@Length(max=32)
	private java.lang.String deptName;
    /**
     * parentId       db_column: parent_id 
     */ 	
	
	private java.lang.Integer parentId;
    /**
     * remark       db_column: remark 
     */ 	
	@Length(max=256)
	private java.lang.String remark;
	//columns END

	public Dept(){
	}

	public Dept(
		java.lang.Integer deptId
	){
		this.deptId = deptId;
	}

	public void setDeptId(java.lang.Integer value) {
		this.deptId = value;
	}
	
	public java.lang.Integer getDeptId() {
		return this.deptId;
	}
	public void setDeptName(java.lang.String value) {
		this.deptName = value;
	}
	
	public java.lang.String getDeptName() {
		return this.deptName;
	}
	public void setParentId(java.lang.Integer value) {
		this.parentId = value;
	}
	
	public java.lang.Integer getParentId() {
		return this.parentId;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("DeptId",getDeptId())
			.append("DeptName",getDeptName())
			.append("ParentId",getParentId())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getDeptId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Dept == false) return false;
		if(this == obj) return true;
		Dept other = (Dept)obj;
		return new EqualsBuilder()
			.append(getDeptId(),other.getDeptId())
			.isEquals();
	}
}

