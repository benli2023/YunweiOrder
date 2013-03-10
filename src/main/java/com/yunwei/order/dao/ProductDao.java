/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2013
 */

package com.yunwei.order.dao;

import java.util.*;


import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.github.springrest.base.*;
import com.github.springrest.util.*;
import com.yunwei.order.model.*;
import com.yunwei.order.dao.*;
import com.yunwei.order.service.*;
import com.yunwei.order.vo.query.*;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


import org.springframework.stereotype.Repository;


@Repository
public class ProductDao extends BaseIbatisDao<Product,java.lang.Long>{
	
	@Override
	public String getIbatisSqlMapNamespace() {
		return "Product";
	}
	
	public void saveOrUpdate(Product entity) {
		if(entity.getProductId() == null) 
			save(entity);
		else 
			update(entity);
	}
	
	public Page findPage(ProductQuery query) {
		return pageQuery("Product.findPage",query);
	}
	

}
