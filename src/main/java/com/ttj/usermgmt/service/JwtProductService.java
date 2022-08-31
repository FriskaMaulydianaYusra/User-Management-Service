package com.ttj.usermgmt.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttj.usermgmt.domain.Product;
import com.ttj.usermgmt.domain.ProductDTO;
import com.ttj.usermgmt.repo.ProductDao;


@Service
public class JwtProductService {
	@Autowired
    private ProductDao productDao;

    public Product save(ProductDTO productDTO) {
    	
        Product newProduct = new Product();
        newProduct.setName(productDTO.getName());
        newProduct.setPrice(productDTO.getPrice());

        return productDao.save(newProduct);
    }
    
    public List<Product> getProduct(){
		return productDao.findAll();
	}
    
    public void delete(Integer id) {
    	productDao.deleteById(id);
    }
    
    public Product getProductById(Integer id){
    	return productDao.findById(id).get();
	}
    
    public Product update(ProductDTO productDTO) {
        Product updateProduct = new Product();
        updateProduct.setId(productDTO.getId());
        updateProduct.setName(productDTO.getName());
        updateProduct.setPrice(productDTO.getPrice());

        return productDao.save(updateProduct);
    }
    
    

}
