package com.yunwei.order.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.web.scope.Flash;

import com.github.springrest.base.BaseRestSpringController;
import com.github.springrest.util.ColModelFactory;
import com.yunwei.order.model.StockRecordLine;
import com.yunwei.order.service.StockRecordLineManager;
import com.yunwei.order.vo.query.StockRecordLineQuery;

@Controller
@RequestMapping({"/stockrecordline"})
public class StockRecordLineController extends BaseRestSpringController<StockRecordLine, Long>
{
  protected static final String DEFAULT_SORT_COLUMNS = null;
  private StockRecordLineManager stockRecordLineManager;
  private final String LIST_ACTION = "redirect:/stockrecordline";

	private ColModelFactory colModelFactory;
	
	public void setColModelFactory(ColModelFactory colModelFactory) {
		this.colModelFactory = colModelFactory;
	}
	
  public void setStockRecordLineManager(StockRecordLineManager manager)
  {
    this.stockRecordLineManager = manager;
  }

  @InitBinder
  public void initBinder(WebDataBinder binder)
  {
    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
  }

  @ModelAttribute
  public void init(ModelMap model)
  {
    model.put("now", new Timestamp(System.currentTimeMillis()));
  }

  @RequestMapping
  public String index(ModelMap model, StockRecordLineQuery query, HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException, SAXException
  {
    Page page = this.stockRecordLineManager.findPage(query);
    model.addAllAttributes(toModelMap(page, query));
    return "/stockrecordline/index";
  }
  
	@RequestMapping({ "/index.json" })
	@ResponseBody
	public Map indexJson(ModelMap model, StockRecordLineQuery query) {
		Page page=null;
		if(query.getStockOperationId()==null) {
			page=new  Page(1,10,0);
		}else {
			 page = this.stockRecordLineManager.findPage(query);
		}
		return jsonPagination(page);
	}


  @RequestMapping({"/{id}"})
  public String show(ModelMap model, @PathVariable Long id) throws Exception
  {
    StockRecordLine stockRecordLine = (StockRecordLine)this.stockRecordLineManager.getById(id);
    model.addAttribute("stockRecordLine", stockRecordLine);
    return "/stockrecordline/show";
  }

  @RequestMapping({"/new"})
  public String _new(ModelMap model, StockRecordLine stockRecordLine, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    model.addAttribute("stockRecordLine", stockRecordLine);
    return "/stockrecordline/new";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String create(ModelMap model, @Valid StockRecordLine stockRecordLine, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/stockrecordline/new";
    }

    this.stockRecordLineManager.save(stockRecordLine);
    Flash.current().success("创建成功", new Object[0]);
    return "redirect:/stockrecordline";
  }

  @RequestMapping({"/{id}/edit"})
  public String edit(ModelMap model, @PathVariable Long id) throws Exception
  {
    StockRecordLine stockRecordLine = (StockRecordLine)this.stockRecordLineManager.getById(id);
    model.addAttribute("stockRecordLine", stockRecordLine);
    return "/stockrecordline/edit";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.PUT})
  public String update(ModelMap model, @PathVariable Long id, @Valid StockRecordLine stockRecordLine, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/stockrecordline/edit";
    }

    this.stockRecordLineManager.update(stockRecordLine);
    Flash.current().success("更新成功", new Object[0]);
    return "redirect:/stockrecordline";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String delete(ModelMap model, @PathVariable Long id)
  {
    this.stockRecordLineManager.removeById(id);
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/stockrecordline";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String batchDelete(ModelMap model, @RequestParam("items") Long[] items)
  {
    for (int i = 0; i < items.length; i++) {
      this.stockRecordLineManager.removeById(items[i]);
    }
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/stockrecordline";
  }
}