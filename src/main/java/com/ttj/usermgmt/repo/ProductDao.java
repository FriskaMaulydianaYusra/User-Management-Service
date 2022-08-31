package com.ttj.usermgmt.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ttj.usermgmt.domain.Product;


@Repository 
public interface ProductDao extends JpaRepository<Product, Integer>{
	
}
