/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2013
 */

package com.yunwei.order.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

@Service
@Transactional
public class StockRecordLineManager extends BaseManager<StockRecordLine,java.lang.Long>{

	private StockRecordLineDao stockRecordLineDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setStockRecordLineDao(StockRecordLineDao dao) {
		this.stockRecordLineDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.stockRecordLineDao;
	}
	
	@Transactional(readOnly=true)
	public Page findPage(StockRecordLineQuery query) {
		return stockRecordLineDao.findPage(query);
	}
	
}
