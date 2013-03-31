/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2013
 */

package com.yunwei.order.service;

import org.springframework.dao.DataAccessException;
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
public class StockRecordManager extends BaseManager<StockRecord,java.lang.Long>{
	private StockRecordLineDao stockRecordLineDao=null;
	private StockRecordDao stockRecordDao;
	public void setStockRecordDao(StockRecordDao dao) {
		this.stockRecordDao = dao;
	}
	
	public void setStockRecordLineDao(StockRecordLineDao stockRecordLineDao) {
		this.stockRecordLineDao = stockRecordLineDao;
	}
	
	

	@Override
	public void save(StockRecord entity) throws DataAccessException {
		GridEditorJsonData<StockRecordLine> jsonData=entity.getJsonData();
		List<StockRecordLine> stockRecordLines=jsonData.getInsert();
		java.lang.Long id=(java.lang.Long)stockRecordDao.save(entity);
		if(stockRecordLines!=null&&stockRecordLines.size()>0) {
			for(StockRecordLine stockLine:stockRecordLines) {
				stockLine.setStockOperationId(id);
				stockRecordLineDao.save(stockLine);
			}
		}
	}

	public EntityDao getEntityDao() {
		return this.stockRecordDao;
	}
	
	@Transactional(readOnly=true)
	public Page findPage(StockRecordQuery query) {
		return stockRecordDao.findPage(query);
	}
	
}
