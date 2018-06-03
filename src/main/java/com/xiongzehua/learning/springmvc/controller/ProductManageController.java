package com.xiongzehua.learning.springmvc.controller;

import com.xiongzehua.learning.springmvc.pojo.Product;
import com.xiongzehua.learning.springmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

/**
 * Created by 31339 on 2018/5/31.
 */
@Controller
@RequestMapping("/manage/product")
public class ProductManageController {
    @Autowired
    ProductService productService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Product> list() {
        System.out.println("into /manage/product/list");
        return productService.getProductList();
    }
}
