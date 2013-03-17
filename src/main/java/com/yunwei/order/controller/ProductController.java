package com.yunwei.order.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.web.scope.Flash;

import com.github.springrest.base.BaseRestSpringController;
import com.github.springrest.base.ColModelProfile;
import com.github.springrest.util.ColModelFactory;
import com.github.springrest.util.FileUploadUtil;
import com.yunwei.order.model.Product;
import com.yunwei.order.service.CategoryManager;
import com.yunwei.order.service.ProductManager;
import com.yunwei.order.vo.query.ProductQuery;

@Controller
@RequestMapping({"/product"})
public class ProductController extends BaseRestSpringController<Product, Long>
{
  protected static final String DEFAULT_SORT_COLUMNS = null;
  private ProductManager productManager;
  private CategoryManager categoryManager;
  private final String LIST_ACTION = "redirect:/product";
  private ColModelFactory colModelFactory;

	public void setColModelFactory(ColModelFactory colModelFactory) {
		this.colModelFactory = colModelFactory;
	}
	
  public void setProductManager(ProductManager manager)
  {
    this.productManager = manager;
  }

  public void setCategoryManager(CategoryManager categoryManager) {
    this.categoryManager = categoryManager;
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
  @RequestMapping({ "/index.json" })
	@ResponseBody
	public Map indexJson(ModelMap model, ProductQuery query) {
		Page page = this.productManager.findPage(query);
		return jsonPagination(page);
	}

	@RequestMapping({ "/query" })
	public String query(ModelMap model, String fieldId,String profileId) throws Exception {
		model.addAttribute("fieldId", fieldId);
		model.addAttribute("jsonURL", "/product/index.json");
		model.addAttribute("pageTitle",Product.TABLE_ALIAS);
		ColModelProfile colModelProfile=colModelFactory.getColModel("Product-colmodel.xml",profileId);
		model.addAttribute("colModelList", colModelProfile.getColModels());
		return "/popup/table_window";
	}

  @RequestMapping
  public String index(ModelMap model, ProductQuery query, HttpServletRequest request, HttpServletResponse response)
  {
	  
    if(query.getSortColumns()==null||query.getSortColumns().trim().length()==0) {
    	query.setSortColumns("cTime desc");
    	
    }
    Page page = this.productManager.findPage(query);
    model.addAllAttributes(toModelMap(page, query));
    return "/product/index";
  }

  @RequestMapping({"/{id}"})
  public String show(ModelMap model, @PathVariable Long id) throws Exception
  {
    Product product = (Product)this.productManager.getById(id);
    model.addAttribute("product", product);
    return "/product/show";
  }

  @RequestMapping({"/new"})
  public String _new(ModelMap model, Product product, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    model.addAttribute("product", product);
    product.setFlag(1);
    return "/product/new";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String create(ModelMap model, @Valid Product product, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/product/new";
    }

    if (!product.getProductImageFile().isEmpty()) {
      product.setProductImage(FileUploadUtil.saveFileUpload(product.getProductImageFile(), "fileUpload/productInfo"));
    }
    product.setCtime(new Date());
    this.productManager.save(product);
    Flash.current().success("创建成功", new Object[0]);
    return "redirect:/product";
  }

  @RequestMapping({"/{id}/edit"})
  public String edit(ModelMap model, @PathVariable Long id) throws Exception
  {
    Product product = (Product)this.productManager.getById(id);
    model.addAttribute("product", product);
    //Category category = (Category)this.categoryManager.getById(product.getCatId());
    //product.setCatIdTxt(category.getCateName());
    return "/product/edit";
  }

  @RequestMapping({"/update/{id}"})
  public String update(ModelMap model, @PathVariable Long id, @Valid Product product, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (errors.hasErrors()) {
      return "/product/edit";
    }
    if (!product.getProductImageFile().isEmpty()) {
      product.setProductImage(FileUploadUtil.saveFileUpload(product.getProductImageFile(), "fileUpload/productInfo"));
    }
    this.productManager.update(product);
    Flash.current().success("更新成功", new Object[0]);
    return "redirect:/product";
  }

  @RequestMapping(value={"/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String delete(ModelMap model, @PathVariable Long id)
  {
    this.productManager.removeById(id);
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/product";
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public String batchDelete(ModelMap model, @RequestParam("items") Long[] items)
  {
    for (int i = 0; i < items.length; i++) {
      this.productManager.removeById(items[i]);
    }
    Flash.current().success("删除成功", new Object[0]);
    return "redirect:/product";
  }
}