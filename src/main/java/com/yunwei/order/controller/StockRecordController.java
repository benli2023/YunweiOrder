package com.yunwei.order.controller;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.web.scope.Flash;

import com.github.springrest.base.BaseRestSpringController;
import com.yunwei.order.model.StockRecord;
import com.yunwei.order.service.StockRecordManager;
import com.yunwei.order.vo.query.StockRecordQuery;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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

@Controller
@RequestMapping({"/stockrecord"})
public class StockRecordController extends BaseRestSpringController<StockRecord, Long>
{
  protected static final String DEFAULT_SORT_COLUMNS = null;
  private StockRecordManager stockRecordManager;
  private final String LIST_ACTION = "redirect:/stockrecord";

  public void setStockRecordManager(StockRecordManager manager)
  {
    this.stockRecordManager = manager;
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
  public String index(ModelMap model, StockRecordQuery query, HttpServletRequest request, HttpServletResponse response)
  {
    Page page = this.stockRecordManager.findPage(query);

    model.addAllAttributes(toModelMap(page, query));
    return "/stockrecord/index";
  }

  @RequestMapping({"/{id}"})
  public String show(ModelMap model, @PathVariable Long id) throws Exception
  {
    StockRecord stockRecord = (StockRecord)this.stockRecordManager.getById(id);
    model.addAttribute("stockRecord", stockRecord);
    return "/stockrecord/show";
  }

  @RequestMapping({"/new"})
  public String _new(ModelMap model, StockRecord stockRecord, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    model.addAttribute("stockRecord", stockRecord);
    return "/stockrecord/new";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String create(ModelMap model, @Valid StockRecord stockRecord, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/stockrecord/new";
    }

    this.stockRecordManager.save(stockRecord);
    Flash.current().success("创建成功", new Object[0]);
    return "redirect:/stockrecord";
  }

  @RequestMapping({"/{id}/edit"})
  public String edit(ModelMap model, @PathVariable Long id) throws Exception
  {
    StockRecord stockRecord = (StockRecord)this.stockRecordManager.getById(id);
    model.addAttribute("stockRecord", stockRecord);
    return "/stockrecord/edit";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.PUT})
  public String update(ModelMap model, @PathVariable Long id, @Valid StockRecord stockRecord, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/stockrecord/edit";
    }

    this.stockRecordManager.update(stockRecord);
    Flash.current().success("更新成功", new Object[0]);
    return "redirect:/stockrecord";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String delete(ModelMap model, @PathVariable Long id)
  {
    this.stockRecordManager.removeById(id);
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/stockrecord";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String batchDelete(ModelMap model, @RequestParam("items") Long[] items)
  {
    for (int i = 0; i < items.length; i++) {
      this.stockRecordManager.removeById(items[i]);
    }
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/stockrecord";
  }
}