package com.yunwei.order.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ResponseBody;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.web.scope.Flash;

import com.yunwei.order.model.Category;
import com.yunwei.order.service.CategoryManager;
import com.yunwei.order.session.UserContext;
import com.yunwei.order.vo.query.CategoryQuery;

@Controller
@RequestMapping({"/category"})
public class CategoryController extends BaseRestSpringController<Category, Long>
{
  protected static final String DEFAULT_SORT_COLUMNS = null;
  private CategoryManager categoryManager;
  private final String LIST_ACTION = "redirect:/category";

  public void setCategoryManager(CategoryManager manager)
  {
    this.categoryManager = manager;
  }

  @InitBinder
  public void initBinder(WebDataBinder binder)
  {
    binder.registerCustomEditor(Date.class, new CustomDateEditor(
      new SimpleDateFormat("yyyy-MM-dd"), true));
  }

  @ModelAttribute
  public void init(ModelMap model)
  {
    model.put("now", new Timestamp(System.currentTimeMillis()));
  }

  @RequestMapping
  public String index(ModelMap model, CategoryQuery query, HttpServletRequest request, HttpServletResponse response)
  {
    Page page = this.categoryManager.findPage(query);

    model.addAllAttributes(toModelMap(page, query));
    return "/category/index";
  }

  @RequestMapping({"/index.json"})
  @ResponseBody
  public Map indexJson(ModelMap model, CategoryQuery query)
  {
    Page page = this.categoryManager.findPage(query);
    Map map = new HashMap();
    map.put("rows", page.getResult());
    map.put("page", Integer.valueOf(page.getThisPageNumber()));
    int pageCount = page.getTotalCount();
    int pageSize = page.getPageSize();
    int totalPage = pageCount % pageSize == 0 ? pageCount / pageSize : pageCount / pageSize + 1;
    map.put("total", Integer.valueOf(totalPage));
    map.put("records", Integer.valueOf(pageCount));
    return map;
  }

  @RequestMapping({"/query"})
  public String query(ModelMap model, String fieldId) {
    model.addAttribute("fieldId", fieldId);
    return "/category/query";
  }

  @RequestMapping({"/{id}"})
  public String show(ModelMap model, @PathVariable Long id)
    throws Exception
  {
    Category category = (Category)this.categoryManager.getById(id);
    model.addAttribute("category", category);
    return "/category/show";
  }

  @RequestMapping({"/new"})
  public String _new(ModelMap model, Category category, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    category.setIsAvailable(1);
    model.addAttribute("category", category);
    return "/category/new";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String create(ModelMap model, @Valid Category category, BindingResult errors, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (errors.hasErrors()) {
      return "/category/new";
    }
    UserContext userContext = getLoginUser(request);
    category.setAdmin(Long.valueOf(userContext.getLoginId()));
    category.setCtime(new Date());
    this.categoryManager.save(category);
    Flash.current().success("创建成功", new Object[0]);
    return "redirect:/category";
  }

  @RequestMapping({"/{id}/edit"})
  public String edit(ModelMap model, @PathVariable Long id)
    throws Exception
  {
    Category category = (Category)this.categoryManager.getById(id);
    Category pcategory = (Category)this.categoryManager.getById(category.getParentId());
    if (pcategory != null) {
      category.setParentIdTxt(pcategory.getCateName());
    }
    model.addAttribute("category", category);
    return "/category/edit";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.PUT})
  public String update(ModelMap model, @PathVariable Long id, @Valid Category category, BindingResult errors, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if ((category.getParentId() != null) && 
      (category.getParentId().longValue() == category.getCateId().longValue())) {
      errors.reject("parent_id_invalid");
    }

    if (errors.hasErrors()) {
      return "/category/edit";
    }

    this.categoryManager.update(category);
    Flash.current().success("更新成功", new Object[0]);
    return "redirect:/category";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String delete(ModelMap model, @PathVariable Long id)
  {
    this.categoryManager.removeById(id);
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/category";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String batchDelete(ModelMap model, @RequestParam("items") Long[] items)
  {
    for (int i = 0; i < items.length; i++) {
      this.categoryManager.removeById(items[i]);
    }
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/category";
  }
}