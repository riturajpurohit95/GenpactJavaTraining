package com.ShopSphere.shop_sphere.service;

import java.util.List;
import com.ShopSphere.shop_sphere.model.Product;

public interface ProductService {

	Product createProduct(Product product);
	Product getProductById(int productId);
	List<Product> getAllProducts();
	List<Product> getProductsByCategory(int categoryId);
	List<Product> getProductsBySeller(int userId);
	List<Product> searchProductsByName(String name);
	List<Product> searchProductsByBrand(String Brand);
	Product updateProduct(Product product);
	void deleteProduct(int ProductId);
}
