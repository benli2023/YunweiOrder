package com.yunwei.order.controller;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.web.scope.Flash;

import com.github.springrest.base.BaseRestSpringController;
import com.yunwei.order.model.StockProduct;
import com.yunwei.order.service.StockProductManager;
import com.yunwei.order.vo.query.StockProductQuery;
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
@RequestMapping({"/stockproduct"})
public class StockProductController extends BaseRestSpringController<StockProduct, Long>
{
  protected static final String DEFAULT_SORT_COLUMNS = null;
  private StockProductManager stockProductManager;
  private final String LIST_ACTION = "redirect:/stockproduct";

  public void setStockProductManager(StockProductManager manager)
  {
    this.stockProductManager = manager;
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
  public String index(ModelMap model, StockProductQuery query, HttpServletRequest request, HttpServletResponse response)
  {
    Page page = this.stockProductManager.findPage(query);

    model.addAllAttributes(toModelMap(page, query));
    return "/stockproduct/index";
  }

  @RequestMapping({"/{id}"})
  public String show(ModelMap model, @PathVariable Long id) throws Exception
  {
    StockProduct stockProduct = (StockProduct)this.stockProductManager.getById(id);
    model.addAttribute("stockProduct", stockProduct);
    return "/stockproduct/show";
  }

  @RequestMapping({"/new"})
  public String _new(ModelMap model, StockProduct stockProduct, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    model.addAttribute("stockProduct", stockProduct);
    return "/stockproduct/new";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String create(ModelMap model, @Valid StockProduct stockProduct, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/stockproduct/new";
    }

    this.stockProductManager.save(stockProduct);
    Flash.current().success("创建成功", new Object[0]);
    return "redirect:/stockproduct";
  }

  @RequestMapping({"/{id}/edit"})
  public String edit(ModelMap model, @PathVariable Long id) throws Exception
  {
    StockProduct stockProduct = (StockProduct)this.stockProductManager.getById(id);
    model.addAttribute("stockProduct", stockProduct);
    return "/stockproduct/edit";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.PUT})
  public String update(ModelMap model, @PathVariable Long id, @Valid StockProduct stockProduct, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/stockproduct/edit";
    }

    this.stockProductManager.update(stockProduct);
    Flash.current().success("更新成功", new Object[0]);
    return "redirect:/stockproduct";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String delete(ModelMap model, @PathVariable Long id)
  {
    this.stockProductManager.removeById(id);
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/stockproduct";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String batchDelete(ModelMap model, @RequestParam("items") Long[] items)
  {
    for (int i = 0; i < items.length; i++) {
      this.stockProductManager.removeById(items[i]);
    }
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/stockproduct";
  }
}