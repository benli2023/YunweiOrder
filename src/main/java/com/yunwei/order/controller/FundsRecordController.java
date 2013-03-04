package com.yunwei.order.controller;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.web.scope.Flash;
import com.yunwei.order.model.FundsRecord;
import com.yunwei.order.service.FundsRecordManager;
import com.yunwei.order.vo.query.FundsRecordQuery;
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
@RequestMapping({"/fundsrecord"})
public class FundsRecordController extends BaseRestSpringController<FundsRecord, Long>
{
  protected static final String DEFAULT_SORT_COLUMNS = null;
  private FundsRecordManager fundsRecordManager;
  private final String LIST_ACTION = "redirect:/fundsrecord";

  public void setFundsRecordManager(FundsRecordManager manager)
  {
    this.fundsRecordManager = manager;
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
  public String index(ModelMap model, FundsRecordQuery query, HttpServletRequest request, HttpServletResponse response)
  {
    Page page = this.fundsRecordManager.findPage(query);

    model.addAllAttributes(toModelMap(page, query));
    return "/fundsrecord/index";
  }

  @RequestMapping({"/{id}"})
  public String show(ModelMap model, @PathVariable Long id) throws Exception
  {
    FundsRecord fundsRecord = (FundsRecord)this.fundsRecordManager.getById(id);
    model.addAttribute("fundsRecord", fundsRecord);
    return "/fundsrecord/show";
  }

  @RequestMapping({"/new"})
  public String _new(ModelMap model, FundsRecord fundsRecord, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    model.addAttribute("fundsRecord", fundsRecord);
    return "/fundsrecord/new";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String create(ModelMap model, @Valid FundsRecord fundsRecord, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/fundsrecord/new";
    }

    this.fundsRecordManager.save(fundsRecord);
    Flash.current().success("创建成功", new Object[0]);
    return "redirect:/fundsrecord";
  }

  @RequestMapping({"/{id}/edit"})
  public String edit(ModelMap model, @PathVariable Long id) throws Exception
  {
    FundsRecord fundsRecord = (FundsRecord)this.fundsRecordManager.getById(id);
    model.addAttribute("fundsRecord", fundsRecord);
    return "/fundsrecord/edit";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.PUT})
  public String update(ModelMap model, @PathVariable Long id, @Valid FundsRecord fundsRecord, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/fundsrecord/edit";
    }

    this.fundsRecordManager.update(fundsRecord);
    Flash.current().success("更新成功", new Object[0]);
    return "redirect:/fundsrecord";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String delete(ModelMap model, @PathVariable Long id)
  {
    this.fundsRecordManager.removeById(id);
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/fundsrecord";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String batchDelete(ModelMap model, @RequestParam("items") Long[] items)
  {
    for (int i = 0; i < items.length; i++) {
      this.fundsRecordManager.removeById(items[i]);
    }
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/fundsrecord";
  }
}