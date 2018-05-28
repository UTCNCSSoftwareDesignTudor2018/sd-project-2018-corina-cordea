package sd.project.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sd.project.business.dto.CategoryDto;
import sd.project.business.dto.ProductDto;
import sd.project.data.entity.Category;
import sd.project.data.entity.Product;
import sd.project.data.repository.CategoryJpaRepository;
import sd.project.data.repository.ProductJpaRepository;

@Service
public class ProductService {
	@Autowired
	ProductJpaRepository productJpaRepository;
	@Autowired
	CategoryJpaRepository categoryJpaRepository;
	public ArrayList<ProductDto> findProducts() {	
		List<Product> products = productJpaRepository.findAll();
		ArrayList<ProductDto> productsDto = new ArrayList<>();
		for(Product p: products) {
			ProductDto pDto = new ProductDto();
			pDto.setProductId(p.getProductId());
			pDto.setCategory(p.getCategory());
			pDto.setProductImage(p.getProductImage());
			pDto.setProductName(p.getProductName());
			pDto.setProductPrice(p.getProductPrice());
			pDto.setProductQuantity(p.getProductQuantity());
			pDto.setSeller(p.getSeller());
			productsDto.add(pDto);
		}
		return productsDto;
	}
	
	public ProductDto findProductByImage(String image) {	
		Product p = productJpaRepository.findByProductImage(image);
			ProductDto pDto = new ProductDto();
			pDto.setProductId(p.getProductId());
			pDto.setCategory(p.getCategory());
			pDto.setProductImage(p.getProductImage());
			pDto.setProductName(p.getProductName());
			pDto.setProductPrice(p.getProductPrice());
			pDto.setProductQuantity(p.getProductQuantity());
			pDto.setSeller(p.getSeller());
		return pDto;
	}
	
	public ArrayList<CategoryDto> findCategories() {	
		List<Category> categories = categoryJpaRepository.findAll();
		ArrayList<CategoryDto> categoriesDto = new ArrayList<>();
		for(Category c: categories) {
			CategoryDto cDto = new CategoryDto();
			cDto.setCategoryId(c.getCategoryId());
			cDto.setCategoryName(c.getCategoryName());
			cDto.setProducts(c.getProducts());
			categoriesDto.add(cDto);
		}
		return categoriesDto;
	}
	
	public Category findCategoryByName(String name) {	
		return categoryJpaRepository.findByCategoryName(name);
	}
	
	public void updateProduct(ProductDto p) {
		Product product = new Product();
		product.setProductId(p.getProductId());
		product.setProductName(p.getProductName());
		product.setProductPrice(p.getProductPrice());
		product.setProductQuantity(p.getProductQuantity());
		product.setProductImage(p.getProductImage());
		product.setCategory(p.getCategory());
		product.setSeller(p.getSeller());
		productJpaRepository.save(product);
	}
}
