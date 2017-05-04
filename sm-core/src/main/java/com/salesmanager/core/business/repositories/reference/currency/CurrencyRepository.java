<<<<<<< HEAD
package com.salesmanager.core.business.repositories.reference.currency;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesmanager.core.model.reference.currency.Currency;

public interface CurrencyRepository extends JpaRepository <Currency, Long> {

	
	Currency getByCode(String code);
}
=======
package com.salesmanager.core.business.repositories.reference.currency;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesmanager.core.model.reference.currency.Currency;

public interface CurrencyRepository extends JpaRepository <Currency, Long> {

	
	Currency getByCode(String code);
}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
