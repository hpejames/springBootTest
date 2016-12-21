package com.james.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.james.mapper.ProductMapper;
import com.james.model.Product;
import com.james.page.PagingBounds;
import com.james.service.ProductSerivce;

@Service(value="productService")
public class ProductServiceImp implements ProductSerivce {

	@Autowired
	private ProductMapper productMapper;

	public PagingBounds<Product> searchProductList(Product product) {
		PagingBounds<Product> page= new PagingBounds<Product>();
		page.setPageNo(product.getPageNo());
		List<Product> products = productMapper.selectProductList(page);
		page.setResults(products);
		return page;
	}
}
