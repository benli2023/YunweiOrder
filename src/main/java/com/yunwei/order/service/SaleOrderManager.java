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
import com.github.springrest.util.CollectionCallback.Callback;
import com.yunwei.order.model.*;
import com.yunwei.order.model.grid.OrderGoodsEditorData;
import com.yunwei.order.model.grid.StockRecordLineEditorData;
import com.yunwei.order.dao.*;
import com.yunwei.order.service.*;
import com.yunwei.order.vo.query.*;

@Service
@Transactional
public class SaleOrderManager extends BaseManager<SaleOrder, java.lang.Long> {

	private SaleOrderDao saleOrderDao;
	private OrderGoodsDao orderGoodsDao;

	public void setOrderGoodsDao(OrderGoodsDao dao) {
		this.orderGoodsDao = dao;
	}

	public void setSaleOrderDao(SaleOrderDao dao) {
		this.saleOrderDao = dao;
	}

	public EntityDao getEntityDao() {
		return this.saleOrderDao;
	}

	@Override
	public void save(SaleOrder entity) throws DataAccessException {
		OrderGoodsEditorData jsonData = entity.getJsonData();
		List<OrderGoods> orderGoods = jsonData.getInsert();
		final java.lang.Long id = (java.lang.Long) saleOrderDao.save(entity);
		CollectionCallback.forEach(orderGoods, new Callback<OrderGoods>() {
			public void with(OrderGoods obj) {
				obj.setOrderId(id);
				orderGoodsDao.save(obj);
			}
		});
	}

	@Override
	public void update(SaleOrder entity) throws DataAccessException {
		OrderGoodsEditorData jsonData = entity.getJsonData();
		if (jsonData != null) {
			List<OrderGoods> insertObjs = jsonData.getInsert();
			List<OrderGoods> deleteObjs = jsonData.getDelete();
			List<OrderGoods> updateObjs = jsonData.getUpdate();
			final Long id = entity.getOrderId();
			CollectionCallback.forEach(insertObjs, new Callback<OrderGoods>() {
				public void with(OrderGoods obj) {
					obj.setOrderId(id);
					orderGoodsDao.save(obj);
				}
			});
			CollectionCallback.forEach(deleteObjs, new Callback<OrderGoods>() {
				public void with(OrderGoods obj) {
					orderGoodsDao.deleteById(obj.getGoodsId());
				}
			});
			CollectionCallback.forEach(updateObjs, new Callback<OrderGoods>() {
				public void with(OrderGoods obj) {
					orderGoodsDao.update(obj);
				}
			});
		}
		saleOrderDao.update(entity);
	}

	@Transactional(readOnly = true)
	public Page findPage(SaleOrderQuery query) {
		return saleOrderDao.findPage(query);
	}

	@Transactional(readOnly = true)
	public SaleOrder getByOrderNo(java.lang.String v) {
		return saleOrderDao.getByOrderNo(v);
	}

}
