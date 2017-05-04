<<<<<<< HEAD
package com.salesmanager.core.business.repositories.merchant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesmanager.core.model.merchant.MerchantStore;

public interface MerchantRepository extends JpaRepository<MerchantStore, Integer> {

	@Query("select m from MerchantStore m left join fetch m.country mc left join fetch m.currency mc left join fetch m.zone mz left join fetch m.defaultLanguage md left join fetch m.languages mls where m.code = ?1")
	MerchantStore findByCode(String code);
}
=======
package com.salesmanager.core.business.repositories.merchant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesmanager.core.model.merchant.MerchantStore;

public interface MerchantRepository extends JpaRepository<MerchantStore, Integer> {

	@Query("select m from MerchantStore m left join fetch m.country mc left join fetch m.currency mc left join fetch m.zone mz left join fetch m.defaultLanguage md left join fetch m.languages mls where m.code = ?1")
	MerchantStore findByCode(String code);
}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
