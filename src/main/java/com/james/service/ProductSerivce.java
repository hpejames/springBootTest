package com.james.service;

import com.james.model.Product;
import com.james.page.PagingBounds;

public interface ProductSerivce {

	public PagingBounds<Product> searchProductList(Product product);
}
