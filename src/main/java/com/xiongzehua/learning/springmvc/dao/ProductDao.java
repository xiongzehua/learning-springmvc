package com.xiongzehua.learning.springmvc.dao;

import com.xiongzehua.learning.springmvc.pojo.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 31339 on 2018/6/1.
 */
@Repository
public class ProductDao {
    List<Product> list;
    int id;
    {
        System.out.println("ProductDao对象创建");
        list = new ArrayList<Product>();
        id = 1;
        list.add(new Product(id++, "手表", 30000, 100));
        list.add(new Product(id++, "iphone", 50000, 100));
        list.add(new Product(id++, "衣服", 200, 300));
        list.add(new Product(id++, "香水", 500, 50));
        list.add(new Product(id++, "牛奶", 5, 500));
    }
    public List<Product> selectList(){
        return list;
    }
}
