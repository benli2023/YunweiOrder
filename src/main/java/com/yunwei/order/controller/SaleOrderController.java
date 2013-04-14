/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2013
 */


package com.yunwei.order.controller;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.web.scope.Flash;

import com.github.springrest.base.BaseRestSpringController;
import com.github.springrest.base.ColModelProfile;
import com.github.springrest.base.GridEditorJsonData;
import com.github.springrest.util.ColModelFactory;
import com.yunwei.order.model.OrderGoods;
import com.yunwei.order.model.SaleOrder;
import com.yunwei.order.model.grid.OrderGoodsEditorData;
import com.yunwei.order.service.SaleOrderManager;
import com.yunwei.order.vo.query.SaleOrderQuery;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

@Controller
@RequestMapping("/saleorder")
public class SaleOrderController extends BaseRestSpringController<SaleOrder,java.lang.Long>{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	Log ERROR_LOGGER=LogFactory.getLog("ERROR."+this.getClass().getName());
	
	private SaleOrderManager saleOrderManager;
	private ColModelFactory colModelFactory;
	private ObjectMapper objectMapper;
	

	public void setColModelFactory(ColModelFactory colModelFactory) {
		this.colModelFactory = colModelFactory;
	}
	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}
	private final String LIST_ACTION = "redirect:/saleorder";
	
	/** 
	 * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写
	 **/
	public void setSaleOrderManager(SaleOrderManager manager) {
		this.saleOrderManager = manager;
	}
	
	/** binder用于bean属性的设置 */
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	        binder.registerCustomEditor(OrderGoodsEditorData.class, new PropertyEditorSupport() {
	        	@Override
	        	public void setAsText(String jsonContent) throws IllegalArgumentException {
	        		if(jsonContent==null||jsonContent.trim().length()==0) {
	        			this.setValue(null);
	        			return;
	        		}
	        		GridEditorJsonData<OrderGoods> data=null;
	        		try {
	        			data=objectMapper.readValue(jsonContent, OrderGoodsEditorData.class);
	        		} catch (JsonParseException e) {
	        			ERROR_LOGGER.error("ERROR occur during parse json data", e);
	        			throw new IllegalArgumentException(e);
	        		} catch (JsonMappingException e) {
	        			ERROR_LOGGER.error("ERROR occur during parse json data", e);
	        			throw new IllegalArgumentException(e);
	        		} catch (IOException e) {
	        			ERROR_LOGGER.error("ERROR occur during parse json data", e);
	        			throw new IllegalArgumentException(e);
	        		}
	        		this.setValue(data);
	        	}
	        	
	        });
	}
	   
	/**
	 * 增加了@ModelAttribute的方法可以在本controller方法调用前执行,可以存放一些共享变量,如枚举值,或是一些初始化操作
	 */
	@ModelAttribute
	public void init(ModelMap model) {
		model.put("now", new java.sql.Timestamp(System.currentTimeMillis()));
	}
	
	/** 列表 */
	@RequestMapping
	public String index(ModelMap model,SaleOrderQuery query,HttpServletRequest request,HttpServletResponse response) {
		Page page = this.saleOrderManager.findPage(query);
		
		model.addAllAttributes(toModelMap(page, query));
		return "/saleorder/index";
	}

	
	
	/** 显示 */
	@RequestMapping(value="/{id}")
	public String show(ModelMap model,@PathVariable java.lang.Long id) throws Exception {
		SaleOrder saleOrder = (SaleOrder)saleOrderManager.getById(id);
		model.addAttribute("saleOrder",saleOrder);
		return "/saleorder/show";
	}

	/** 进入新增 */
	@RequestMapping(value="/new")
	public String _new(ModelMap model,SaleOrder saleOrder,HttpServletRequest request,HttpServletResponse response) throws Exception {
		model.addAttribute("saleOrder",saleOrder);
		ColModelProfile colModelProfile=colModelFactory.getColModel("OrderGoods-colmodel.xml",null);
		model.addAttribute("colModelList", colModelProfile.getColModels());
		return "/saleorder/new";
	}
	
	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping(method=RequestMethod.POST)
	public String create(ModelMap model,@Valid SaleOrder saleOrder,BindingResult errors,HttpServletRequest request,HttpServletResponse response) throws Exception {
		if(errors.hasErrors()) {
			return  "/saleorder/new";
		}
		saleOrder.setCreatorId(this.getLoginUser(request).getLoginId());
		saleOrder.setCtime(new Date());
		saleOrderManager.save(saleOrder);
		Flash.current().success(CREATED_SUCCESS); //存放在Flash中的数据,在下一次http请求中仍然可以读取数据,error()用于显示错误消息
		return LIST_ACTION;
	}
	
	/** 编辑 */
	@RequestMapping(value="/{id}/edit")
	public String edit(ModelMap model,@PathVariable java.lang.Long id) throws Exception {
		SaleOrder saleOrder = (SaleOrder)saleOrderManager.getById(id);
		model.addAttribute("saleOrder",saleOrder);
		ColModelProfile colModelProfile=colModelFactory.getColModel("OrderGoods-colmodel.xml",null);
		model.addAttribute("colModelList", colModelProfile.getColModels());
		return "/saleorder/edit";
	}
	
	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String update(ModelMap model,@PathVariable java.lang.Long id,@Valid SaleOrder saleOrder,BindingResult errors,HttpServletRequest request,HttpServletResponse response) throws Exception {
		if(errors.hasErrors()) {
			return "/saleorder/edit";
		}
		saleOrder.setUpdator(this.getLoginUser(request).getLoginId());
		saleOrder.setUtime(new Date());
		saleOrderManager.update(saleOrder);
		Flash.current().success(UPDATE_SUCCESS);
		return LIST_ACTION;
	}
	
	/** 删除 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String delete(ModelMap model,@PathVariable java.lang.Long id) {
		saleOrderManager.removeById(id);
		Flash.current().success(DELETE_SUCCESS);
		return LIST_ACTION;
	}

	/** 批量删除 */
	@RequestMapping(method=RequestMethod.DELETE)
	public String batchDelete(ModelMap model,@RequestParam("items") java.lang.Long[] items) {
		for(int i = 0; i < items.length; i++) {
			saleOrderManager.removeById(items[i]);
		}
		Flash.current().success(DELETE_SUCCESS);
		return LIST_ACTION;
	}
	
}

