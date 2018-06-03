package com.xiongzehua.learning.springmvc;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * Created by 31339 on 2018/6/2.
 */
public class Main {
    public static void main(String[] args) {
        MappingJackson2HttpMessageConverter m = new MappingJackson2HttpMessageConverter();
        MappingJackson2JsonView m2 = new MappingJackson2JsonView();
    }
}
