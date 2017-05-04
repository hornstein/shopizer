<<<<<<< HEAD
package com.salesmanager.core.business.repositories.shipping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesmanager.core.model.shipping.ShippingOrigin;

public interface ShippingOriginRepository extends JpaRepository<ShippingOrigin, Long> {

	@Query("select s from ShippingOrigin as s join fetch s.merchantStore sm where sm.id = ?1")
	ShippingOrigin findByStore(Integer storeId);
}
=======
package com.salesmanager.core.business.repositories.shipping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesmanager.core.model.shipping.ShippingOrigin;

public interface ShippingOriginRepository extends JpaRepository<ShippingOrigin, Long> {

	@Query("select s from ShippingOrigin as s join fetch s.merchantStore sm where sm.id = ?1")
	ShippingOrigin findByStore(Integer storeId);
}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
