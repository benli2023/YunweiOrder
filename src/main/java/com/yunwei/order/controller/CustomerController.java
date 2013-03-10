package com.yunwei.order.controller;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.web.scope.Flash;

import com.github.springrest.base.BaseRestSpringController;
import com.yunwei.order.model.Customer;
import com.yunwei.order.service.CustomerManager;
import com.yunwei.order.vo.query.CustomerQuery;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
@RequestMapping({"/customer"})
public class CustomerController extends BaseRestSpringController<Customer, Long>
{
  protected static final String DEFAULT_SORT_COLUMNS = null;
  private CustomerManager customerManager;
  private final String LIST_ACTION = "redirect:/customer";

  public void setCustomerManager(CustomerManager manager)
  {
    this.customerManager = manager;
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
  public String index(ModelMap model, CustomerQuery query, HttpServletRequest request, HttpServletResponse response)
  {
    Page page = this.customerManager.findPage(query);

    model.addAllAttributes(toModelMap(page, query));
    return "/customer/index";
  }
  @RequestMapping({"/index.json"})
  @ResponseBody
  public Map indexJson(ModelMap model, CustomerQuery query) {
    Page page = this.customerManager.findPage(query);
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
    return "/customer/query";
  }

  @RequestMapping({"/{id}"})
  public String show(ModelMap model, @PathVariable Long id) throws Exception
  {
    Customer customer = (Customer)this.customerManager.getById(id);
    model.addAttribute("customer", customer);
    return "/customer/show";
  }

  @RequestMapping({"/new"})
  public String _new(ModelMap model, Customer customer, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    model.addAttribute("customer", customer);
    return "/customer/new";
  }

  /**
 * @param model
 * @param customer
 * @param errors
 * @param request
 * @param response
 * @return
 * @throws Exception
 */
@RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String create(ModelMap model, @Valid Customer customer, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/customer/new";
    }
    customer.setCtime(new Date());
    this.customerManager.save(customer);
    Flash.current().success("创建成功", new Object[0]);
    return "redirect:/customer";
  }

  @RequestMapping({"/{id}/edit"})
  public String edit(ModelMap model, @PathVariable Long id) throws Exception
  {
    Customer customer = (Customer)this.customerManager.getById(id);
    model.addAttribute("customer", customer);
    return "/customer/edit";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.PUT})
  public String update(ModelMap model, @PathVariable Long id, @Valid Customer customer, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/customer/edit";
    }

    this.customerManager.update(customer);
    Flash.current().success("更新成功", new Object[0]);
    return "redirect:/customer";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String delete(ModelMap model, @PathVariable Long id)
  {
    this.customerManager.removeById(id);
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/customer";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String batchDelete(ModelMap model, @RequestParam("items") Long[] items)
  {
    for (int i = 0; i < items.length; i++) {
      this.customerManager.removeById(items[i]);
    }
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/customer";
  }
}