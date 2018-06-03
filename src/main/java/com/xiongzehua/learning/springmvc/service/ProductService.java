package com.xiongzehua.learning.springmvc.service;

import com.xiongzehua.learning.springmvc.dao.ProductDao;
import com.xiongzehua.learning.springmvc.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 31339 on 2018/6/2.
 */
@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    public List<Product> getProductList(){
        return productDao.selectList();

    }
}
