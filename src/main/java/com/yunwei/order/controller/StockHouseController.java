package com.yunwei.order.controller;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.web.scope.Flash;
import com.yunwei.order.model.StockHouse;
import com.yunwei.order.service.StockHouseManager;
import com.yunwei.order.vo.query.StockHouseQuery;
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
@RequestMapping({"/stockhouse"})
public class StockHouseController extends BaseRestSpringController<StockHouse, Long>
{
  protected static final String DEFAULT_SORT_COLUMNS = null;
  private StockHouseManager stockHouseManager;
  private final String LIST_ACTION = "redirect:/stockhouse";

  public void setStockHouseManager(StockHouseManager manager)
  {
    this.stockHouseManager = manager;
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
  public String index(ModelMap model, StockHouseQuery query, HttpServletRequest request, HttpServletResponse response)
  {
    Page page = this.stockHouseManager.findPage(query);

    model.addAllAttributes(toModelMap(page, query));
    return "/stockhouse/index";
  }

  @RequestMapping({"/{id}"})
  public String show(ModelMap model, @PathVariable Long id) throws Exception
  {
    StockHouse stockHouse = (StockHouse)this.stockHouseManager.getById(id);
    model.addAttribute("stockHouse", stockHouse);
    return "/stockhouse/show";
  }

  @RequestMapping({"/new"})
  public String _new(ModelMap model, StockHouse stockHouse, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    model.addAttribute("stockHouse", stockHouse);
    return "/stockhouse/new";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String create(ModelMap model, @Valid StockHouse stockHouse, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/stockhouse/new";
    }

    this.stockHouseManager.save(stockHouse);
    Flash.current().success("创建成功", new Object[0]);
    return "redirect:/stockhouse";
  }

  @RequestMapping({"/{id}/edit"})
  public String edit(ModelMap model, @PathVariable Long id) throws Exception
  {
    StockHouse stockHouse = (StockHouse)this.stockHouseManager.getById(id);
    model.addAttribute("stockHouse", stockHouse);
    return "/stockhouse/edit";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.PUT})
  public String update(ModelMap model, @PathVariable Long id, @Valid StockHouse stockHouse, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/stockhouse/edit";
    }

    this.stockHouseManager.update(stockHouse);
    Flash.current().success("更新成功", new Object[0]);
    return "redirect:/stockhouse";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String delete(ModelMap model, @PathVariable Long id)
  {
    this.stockHouseManager.removeById(id);
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/stockhouse";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String batchDelete(ModelMap model, @RequestParam("items") Long[] items)
  {
    for (int i = 0; i < items.length; i++) {
      this.stockHouseManager.removeById(items[i]);
    }
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/stockhouse";
  }
}