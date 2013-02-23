package com.yunwei.order.controller;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.web.scope.Flash;
import com.yunwei.order.model.Dept;
import com.yunwei.order.service.DeptManager;
import com.yunwei.order.vo.query.DeptQuery;
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
@RequestMapping({"/dept"})
public class DeptController extends BaseRestSpringController<Dept, Integer>
{
  protected static final String DEFAULT_SORT_COLUMNS = null;
  private DeptManager deptManager;
  private final String LIST_ACTION = "redirect:/dept";

  public void setDeptManager(DeptManager manager)
  {
    this.deptManager = manager;
  }

  @RequestMapping({"/index.json"})
  @ResponseBody
  public Map indexJson(ModelMap model, DeptQuery query) {
    Page page = this.deptManager.findPage(query);
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
    return "/dept/query";
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
  public String index(ModelMap model, DeptQuery query, HttpServletRequest request, HttpServletResponse response)
  {
    Page page = this.deptManager.findPage(query);

    model.addAllAttributes(toModelMap(page, query));
    return "/dept/index";
  }

  @RequestMapping({"/{id}"})
  public String show(ModelMap model, @PathVariable Integer id) throws Exception
  {
    Dept dept = (Dept)this.deptManager.getById(id);
    model.addAttribute("dept", dept);
    return "/dept/show";
  }

  @RequestMapping({"/new"})
  public String _new(ModelMap model, Dept dept, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    model.addAttribute("dept", dept);
    return "/dept/new";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String create(ModelMap model, @Valid Dept dept, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/dept/new";
    }

    this.deptManager.save(dept);
    Flash.current().success("创建成功", new Object[0]);
    return "redirect:/dept";
  }

  @RequestMapping({"/{id}/edit"})
  public String edit(ModelMap model, @PathVariable Integer id) throws Exception
  {
    Dept dept = (Dept)this.deptManager.getById(id);
    model.addAttribute("dept", dept);
    return "/dept/edit";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.PUT})
  public String update(ModelMap model, @PathVariable Integer id, @Valid Dept dept, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/dept/edit";
    }

    this.deptManager.update(dept);
    Flash.current().success("更新成功", new Object[0]);
    return "redirect:/dept";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String delete(ModelMap model, @PathVariable Integer id)
  {
    this.deptManager.removeById(id);
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/dept";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String batchDelete(ModelMap model, @RequestParam("items") Integer[] items)
  {
    for (int i = 0; i < items.length; i++) {
      this.deptManager.removeById(items[i]);
    }
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/dept";
  }
}