/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2013
 */

package com.yunwei.order.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.org.rapid_framework.page.Page;

import com.github.springrest.base.BaseManager;
import com.github.springrest.base.EntityDao;
import com.github.springrest.util.CollectionCallback;
import com.github.springrest.util.CollectionCallback.Callback;
import com.yunwei.order.dao.StockRecordDao;
import com.yunwei.order.dao.StockRecordLineDao;
import com.yunwei.order.model.StockRecord;
import com.yunwei.order.model.StockRecordLine;
import com.yunwei.order.model.grid.StockRecordLineEditorData;
import com.yunwei.order.vo.query.StockRecordQuery;

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
		StockRecordLineEditorData jsonData=entity.getJsonData();
		List<StockRecordLine> stockRecordLines=jsonData.getInsert();
		final java.lang.Long id=(java.lang.Long)stockRecordDao.save(entity);
		CollectionCallback.forEach(stockRecordLines, new Callback<StockRecordLine>() {
			public void with(StockRecordLine stockLine) {
				stockLine.setStockOperationId(id);
				stockRecordLineDao.save(stockLine);
			}
		});
	}
	
	
	
	

	@Override
	public void update(StockRecord entity) throws DataAccessException {
		StockRecordLineEditorData jsonData=entity.getJsonData();
		if(jsonData!=null) {
			List<StockRecordLine> insertStockRecordLines=jsonData.getInsert();
			List<StockRecordLine> deleteStockRecordLines=jsonData.getDelete();
			List<StockRecordLine> updateStockRecordLines=jsonData.getUpdate();
			final Long id= entity.getStockOperationId();
			CollectionCallback.forEach(insertStockRecordLines, new Callback<StockRecordLine>() {
				public void with(StockRecordLine stockLine) {
					stockLine.setStockOperationId(id);
					stockRecordLineDao.save(stockLine);
				}
			});
			CollectionCallback.forEach(deleteStockRecordLines, new Callback<StockRecordLine>() {
				public void with(StockRecordLine stockLine) {
					stockRecordLineDao.deleteById(stockLine.getStockOperDetailId());
				}
			});
			
			CollectionCallback.forEach(updateStockRecordLines, new Callback<StockRecordLine>() {
				public void with(StockRecordLine stockLine) {
					stockRecordLineDao.update(stockLine);
				}
			});
		}
		stockRecordDao.update(entity);
		
	}

	public EntityDao getEntityDao() {
		return this.stockRecordDao;
	}
	
	@Transactional(readOnly=true)
	public Page findPage(StockRecordQuery query) {
		return stockRecordDao.findPage(query);
	}
	
}
