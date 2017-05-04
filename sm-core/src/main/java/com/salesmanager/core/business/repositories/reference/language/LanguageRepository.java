<<<<<<< HEAD
package com.salesmanager.core.business.repositories.reference.language;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesmanager.core.business.exception.ServiceException;
import com.salesmanager.core.model.reference.language.Language;

public interface LanguageRepository extends JpaRepository <Language, Integer> {
	
	Language findByCode(String code) throws ServiceException;
	


}
=======
package com.salesmanager.core.business.repositories.reference.language;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesmanager.core.business.exception.ServiceException;
import com.salesmanager.core.model.reference.language.Language;

public interface LanguageRepository extends JpaRepository <Language, Integer> {
	
	Language findByCode(String code) throws ServiceException;
	


}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
