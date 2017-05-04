<<<<<<< HEAD
package com.salesmanager.core.business.repositories.catalog.product.type;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesmanager.core.model.catalog.product.type.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

	ProductType findByCode(String code);
}
=======
package com.salesmanager.core.business.repositories.catalog.product.type;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesmanager.core.model.catalog.product.type.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

	ProductType findByCode(String code);
}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
