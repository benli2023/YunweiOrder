package com.yunwei.order.controller;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.web.scope.Flash;
import com.yunwei.order.model.ProductSupplier;
import com.yunwei.order.service.ProductSupplierManager;
import com.yunwei.order.vo.query.ProductSupplierQuery;
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
@RequestMapping({"/productsupplier"})
public class ProductSupplierController extends BaseRestSpringController<ProductSupplier, Long>
{
  protected static final String DEFAULT_SORT_COLUMNS = null;
  private ProductSupplierManager productSupplierManager;
  private final String LIST_ACTION = "redirect:/productsupplier";

  public void setProductSupplierManager(ProductSupplierManager manager)
  {
    this.productSupplierManager = manager;
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
  public String index(ModelMap model, ProductSupplierQuery query, HttpServletRequest request, HttpServletResponse response)
  {
    Page page = this.productSupplierManager.findPage(query);

    model.addAllAttributes(toModelMap(page, query));
    return "/productsupplier/index";
  }

  @RequestMapping({"/{id}"})
  public String show(ModelMap model, @PathVariable Long id) throws Exception
  {
    ProductSupplier productSupplier = (ProductSupplier)this.productSupplierManager.getById(id);
    model.addAttribute("productSupplier", productSupplier);
    return "/productsupplier/show";
  }

  @RequestMapping({"/new"})
  public String _new(ModelMap model, ProductSupplier productSupplier, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    model.addAttribute("productSupplier", productSupplier);
    return "/productsupplier/new";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String create(ModelMap model, @Valid ProductSupplier productSupplier, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/productsupplier/new";
    }

    this.productSupplierManager.save(productSupplier);
    Flash.current().success("创建成功", new Object[0]);
    return "redirect:/productsupplier";
  }

  @RequestMapping({"/{id}/edit"})
  public String edit(ModelMap model, @PathVariable Long id) throws Exception
  {
    ProductSupplier productSupplier = (ProductSupplier)this.productSupplierManager.getById(id);
    model.addAttribute("productSupplier", productSupplier);
    return "/productsupplier/edit";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.PUT})
  public String update(ModelMap model, @PathVariable Long id, @Valid ProductSupplier productSupplier, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/productsupplier/edit";
    }

    this.productSupplierManager.update(productSupplier);
    Flash.current().success("更新成功", new Object[0]);
    return "redirect:/productsupplier";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String delete(ModelMap model, @PathVariable Long id)
  {
    this.productSupplierManager.removeById(id);
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/productsupplier";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String batchDelete(ModelMap model, @RequestParam("items") Long[] items)
  {
    for (int i = 0; i < items.length; i++) {
      this.productSupplierManager.removeById(items[i]);
    }
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/productsupplier";
  }
}