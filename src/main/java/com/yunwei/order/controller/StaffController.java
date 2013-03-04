package com.yunwei.order.controller;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.web.scope.Flash;
import com.yunwei.order.model.Staff;
import com.yunwei.order.service.StaffManager;
import com.yunwei.order.vo.query.StaffQuery;
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

@Controller
@RequestMapping({"/staff"})
public class StaffController extends BaseRestSpringController<Staff, Long>
{
  protected static final String DEFAULT_SORT_COLUMNS = null;
  private StaffManager staffManager;
  private final String LIST_ACTION = "redirect:/staff";

  public void setStaffManager(StaffManager manager)
  {
    this.staffManager = manager;
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
  public String index(ModelMap model, StaffQuery query, HttpServletRequest request, HttpServletResponse response)
  {
    Page page = this.staffManager.findPage(query);

    model.addAllAttributes(toModelMap(page, query));
    return "/staff/index";
  }

  @RequestMapping(params={"type=json"})
  @ResponseBody
  public Map index(ModelMap model, StaffQuery query)
  {
    Page page = this.staffManager.findPage(query);
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

  @RequestMapping({"/{id}"})
  public String show(ModelMap model, @PathVariable Long id)
    throws Exception
  {
    Staff staff = (Staff)this.staffManager.getById(id);
    model.addAttribute("staff", staff);
    return "/staff/show";
  }

  @RequestMapping({"/query"})
  public String query(ModelMap model, String fieldId) {
    model.addAttribute("fieldId", fieldId);
    return "/staff/query";
  }

  @RequestMapping({"/index.json"})
  @ResponseBody
  public Map indexJson(ModelMap model, StaffQuery query) {
    Page page = this.staffManager.findPage(query);
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

  @RequestMapping({"/new"})
  public String _new(ModelMap model, Staff staff, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    model.addAttribute("staff", staff);
    return "/staff/new";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String create(ModelMap model, @Valid Staff staff, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/staff/new";
    }

    this.staffManager.save(staff);
    Flash.current().success("创建成功", new Object[0]);
    return "redirect:/staff";
  }

  @RequestMapping({"/{id}/edit"})
  public String edit(ModelMap model, @PathVariable Long id) throws Exception
  {
    Staff staff = (Staff)this.staffManager.getById(id);
    model.addAttribute("staff", staff);
    return "/staff/edit";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.PUT})
  public String update(ModelMap model, @PathVariable Long id, @Valid Staff staff, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/staff/edit";
    }

    this.staffManager.update(staff);
    Flash.current().success("更新成功", new Object[0]);
    return "redirect:/staff";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String delete(ModelMap model, @PathVariable Long id)
  {
    this.staffManager.removeById(id);
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/staff";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String batchDelete(ModelMap model, @RequestParam("items") Long[] items)
  {
    for (int i = 0; i < items.length; i++) {
      this.staffManager.removeById(items[i]);
    }
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/staff";
  }
}