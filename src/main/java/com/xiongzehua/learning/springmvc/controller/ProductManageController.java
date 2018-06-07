package com.xiongzehua.learning.springmvc.controller;

import com.xiongzehua.learning.springmvc.pojo.Product;
import com.xiongzehua.learning.springmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

/**
 * Created by xiongzehua on 2018/5/31.
 */


@Controller
@RequestMapping("/manage/product")
public class ProductManageController {
    @Autowired
    ProductService productService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Product> list() throws InterruptedException {
        System.out.println("into /manage/product/list");
//        Thread.sleep(9000);
        return productService.getProductList();
    }

    @RequestMapping("/add")
    @ResponseBody //404 Not Found
    public void add(String name, int price, int stock) {
        productService.add(new Product(0, name, price, stock));
        System.out.println("into /manage/product/add");
    }

    @RequestMapping("/get")
    @ResponseBody
    public Product get(int id) {
        System.out.println("into /manage/product/get");
        return productService.get(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public void add(Product p) {
        System.out.println("into /manage/product/update");
        productService.update(p);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(int id) {
        System.out.println("into /manage/product/delete");
        productService.delete(id);
    }
}
