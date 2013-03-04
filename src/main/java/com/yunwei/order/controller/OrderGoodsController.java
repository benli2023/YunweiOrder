package com.yunwei.order.controller;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.web.scope.Flash;
import com.yunwei.order.model.OrderGoods;
import com.yunwei.order.service.OrderGoodsManager;
import com.yunwei.order.vo.query.OrderGoodsQuery;
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
@RequestMapping({"/ordergoods"})
public class OrderGoodsController extends BaseRestSpringController<OrderGoods, Long>
{
  protected static final String DEFAULT_SORT_COLUMNS = null;
  private OrderGoodsManager orderGoodsManager;
  private final String LIST_ACTION = "redirect:/ordergoods";

  public void setOrderGoodsManager(OrderGoodsManager manager)
  {
    this.orderGoodsManager = manager;
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
  public String index(ModelMap model, OrderGoodsQuery query, HttpServletRequest request, HttpServletResponse response)
  {
    Page page = this.orderGoodsManager.findPage(query);

    model.addAllAttributes(toModelMap(page, query));
    return "/ordergoods/index";
  }

  @RequestMapping({"/{id}"})
  public String show(ModelMap model, @PathVariable Long id) throws Exception
  {
    OrderGoods orderGoods = (OrderGoods)this.orderGoodsManager.getById(id);
    model.addAttribute("orderGoods", orderGoods);
    return "/ordergoods/show";
  }

  @RequestMapping({"/new"})
  public String _new(ModelMap model, OrderGoods orderGoods, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    model.addAttribute("orderGoods", orderGoods);
    return "/ordergoods/new";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String create(ModelMap model, @Valid OrderGoods orderGoods, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/ordergoods/new";
    }

    this.orderGoodsManager.save(orderGoods);
    Flash.current().success("创建成功", new Object[0]);
    return "redirect:/ordergoods";
  }

  @RequestMapping({"/{id}/edit"})
  public String edit(ModelMap model, @PathVariable Long id) throws Exception
  {
    OrderGoods orderGoods = (OrderGoods)this.orderGoodsManager.getById(id);
    model.addAttribute("orderGoods", orderGoods);
    return "/ordergoods/edit";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.PUT})
  public String update(ModelMap model, @PathVariable Long id, @Valid OrderGoods orderGoods, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/ordergoods/edit";
    }

    this.orderGoodsManager.update(orderGoods);
    Flash.current().success("更新成功", new Object[0]);
    return "redirect:/ordergoods";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String delete(ModelMap model, @PathVariable Long id)
  {
    this.orderGoodsManager.removeById(id);
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/ordergoods";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String batchDelete(ModelMap model, @RequestParam("items") Long[] items)
  {
    for (int i = 0; i < items.length; i++) {
      this.orderGoodsManager.removeById(items[i]);
    }
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/ordergoods";
  }
}