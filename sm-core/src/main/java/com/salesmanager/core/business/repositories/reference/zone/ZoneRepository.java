<<<<<<< HEAD
package com.salesmanager.core.business.repositories.reference.zone;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesmanager.core.model.reference.zone.Zone;

public interface ZoneRepository extends JpaRepository<Zone, Long> {
	
	
	Zone findByCode(String code);
	
	@Query("select z from Zone z left join fetch z.descriptions zd where zd.language.id=?1")
	List<Zone> listByLanguage(Integer id);
	
	@Query("select z from Zone z left join fetch z.descriptions zd join fetch z.country zc where zc.isoCode=?1 and zd.language.id=?2")
	List<Zone> listByLanguageAndCountry(String isoCode, Integer languageId);

}
=======
package com.salesmanager.core.business.repositories.reference.zone;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesmanager.core.model.reference.zone.Zone;

public interface ZoneRepository extends JpaRepository<Zone, Long> {
	
    @Query("select z from Zone z join z.country country where z.code=?1 and country.id=?2")
	Zone findByCodeAndCountryId(String code, Integer countryId);
	
	@Query("select z from Zone z left join fetch z.descriptions zd where zd.language.id=?1")
	List<Zone> listByLanguage(Integer id);
	
	@Query("select z from Zone z left join fetch z.descriptions zd join fetch z.country zc where zc.isoCode=?1 and zd.language.id=?2")
	List<Zone> listByLanguageAndCountry(String isoCode, Integer languageId);

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
