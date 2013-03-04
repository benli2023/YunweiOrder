package com.yunwei.order.controller;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.web.scope.Flash;
import com.yunwei.order.model.SaleOrder;
import com.yunwei.order.service.SaleOrderManager;
import com.yunwei.order.vo.query.SaleOrderQuery;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javacommon.base.BaseRestSpringController;
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
@RequestMapping({"/saleorder"})
public class SaleOrderController extends BaseRestSpringController<SaleOrder, Long>
{
  protected static final String DEFAULT_SORT_COLUMNS = null;
  private SaleOrderManager saleOrderManager;
  private final String LIST_ACTION = "redirect:/saleorder";

  public void setSaleOrderManager(SaleOrderManager manager)
  {
    this.saleOrderManager = manager;
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
  public String index(ModelMap model, SaleOrderQuery query, HttpServletRequest request, HttpServletResponse response)
  {
    Page page = this.saleOrderManager.findPage(query);

    model.addAllAttributes(toModelMap(page, query));
    return "/saleorder/index";
  }

  @RequestMapping({"/{id}"})
  public String show(ModelMap model, @PathVariable Long id) throws Exception
  {
    SaleOrder saleOrder = (SaleOrder)this.saleOrderManager.getById(id);
    model.addAttribute("saleOrder", saleOrder);
    return "/saleorder/show";
  }

  @RequestMapping({"/new"})
  public String _new(ModelMap model, SaleOrder saleOrder, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    model.addAttribute("saleOrder", saleOrder);
    return "/saleorder/new";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String create(ModelMap model, @Valid SaleOrder saleOrder, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/saleorder/new";
    }

    this.saleOrderManager.save(saleOrder);
    Flash.current().success("创建成功", new Object[0]);
    return "redirect:/saleorder";
  }

  @RequestMapping({"/{id}/edit"})
  public String edit(ModelMap model, @PathVariable Long id) throws Exception
  {
    SaleOrder saleOrder = (SaleOrder)this.saleOrderManager.getById(id);
    model.addAttribute("saleOrder", saleOrder);
    return "/saleorder/edit";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.PUT})
  public String update(ModelMap model, @PathVariable Long id, @Valid SaleOrder saleOrder, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/saleorder/edit";
    }

    this.saleOrderManager.update(saleOrder);
    Flash.current().success("更新成功", new Object[0]);
    return "redirect:/saleorder";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String delete(ModelMap model, @PathVariable Long id)
  {
    this.saleOrderManager.removeById(id);
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/saleorder";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String batchDelete(ModelMap model, @RequestParam("items") Long[] items)
  {
    for (int i = 0; i < items.length; i++) {
      this.saleOrderManager.removeById(items[i]);
    }
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/saleorder";
  }
}