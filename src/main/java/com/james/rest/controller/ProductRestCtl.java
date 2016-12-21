package com.james.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.james.model.Product;
import com.james.page.PagingBounds;
import com.james.service.ProductSerivce;

/**
 * Created by gaoji on 2016/11/05.
 */
@RestController
@RequestMapping(value="/product")
public class ProductRestCtl {
	
	@Autowired
	private ProductSerivce productService;

    @RequestMapping(value="/searchProductList", method = RequestMethod.POST)
    public PagingBounds<Product> test(@RequestBody Product product, HttpServletRequest request) {
    	PagingBounds<Product> pageInfo = productService.searchProductList(product);
        return pageInfo;
    }
}
