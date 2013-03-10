package com.yunwei.order.controller;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.web.scope.Flash;

import com.github.springrest.base.BaseRestSpringController;
import com.yunwei.order.model.AppData;
import com.yunwei.order.service.AppDataManager;
import com.yunwei.order.vo.query.AppDataQuery;
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
@RequestMapping({"/appdata"})
public class AppDataController extends BaseRestSpringController<AppData, Long>
{
  protected static final String DEFAULT_SORT_COLUMNS = null;
  private AppDataManager appDataManager;
  private final String LIST_ACTION = "redirect:/appdata";

  public void setAppDataManager(AppDataManager manager)
  {
    this.appDataManager = manager;
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
  public String index(ModelMap model, AppDataQuery query, HttpServletRequest request, HttpServletResponse response)
  {
    Page page = this.appDataManager.findPage(query);

    model.addAllAttributes(toModelMap(page, query));
    return "/appdata/index";
  }

  @RequestMapping({"/{id}"})
  public String show(ModelMap model, @PathVariable Long id) throws Exception
  {
    AppData appData = (AppData)this.appDataManager.getById(id);
    model.addAttribute("appData", appData);
    return "/appdata/show";
  }

  @RequestMapping({"/new"})
  public String _new(ModelMap model, AppData appData, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    model.addAttribute("appData", appData);
    return "/appdata/new";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String create(ModelMap model, @Valid AppData appData, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/appdata/new";
    }

    this.appDataManager.save(appData);
    Flash.current().success("创建成功", new Object[0]);
    return "redirect:/appdata";
  }

  @RequestMapping({"/{id}/edit"})
  public String edit(ModelMap model, @PathVariable Long id) throws Exception
  {
    AppData appData = (AppData)this.appDataManager.getById(id);
    model.addAttribute("appData", appData);
    return "/appdata/edit";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.PUT})
  public String update(ModelMap model, @PathVariable Long id, @Valid AppData appData, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/appdata/edit";
    }

    this.appDataManager.update(appData);
    Flash.current().success("更新成功", new Object[0]);
    return "redirect:/appdata";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String delete(ModelMap model, @PathVariable Long id)
  {
    this.appDataManager.removeById(id);
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/appdata";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String batchDelete(ModelMap model, @RequestParam("items") Long[] items)
  {
    for (int i = 0; i < items.length; i++) {
      this.appDataManager.removeById(items[i]);
    }
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/appdata";
  }
}