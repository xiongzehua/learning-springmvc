package com.xiongzehua.learning.springmvc.dao;

import com.xiongzehua.learning.springmvc.pojo.Person;
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

    public void add(Product p){
        p.setId(id++);
        list.add(p);
    }

    public Product get(int id){
        for (Product p : list) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }

    public void update(Product p){
        for (int i = 0; i < list.size(); i++) {
            if (p.getId() == list.get(i).getId()) {
                list.set(i, p);
            }
        }
    }

    public void delete(int id){
        for (int i = 0; i < list.size(); i++) {
            if (id == list.get(i).getId()) {
                list.remove(i);
            }
        }
    }
}
