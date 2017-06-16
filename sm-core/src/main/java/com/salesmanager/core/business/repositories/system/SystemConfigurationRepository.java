<<<<<<< HEAD
package com.salesmanager.core.business.repositories.system;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesmanager.core.model.system.SystemConfiguration;

public interface SystemConfigurationRepository extends JpaRepository<SystemConfiguration, Long> {


	SystemConfiguration findByKey(String key);

}
=======
package com.salesmanager.core.business.repositories.system;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesmanager.core.model.system.SystemConfiguration;

public interface SystemConfigurationRepository extends JpaRepository<SystemConfiguration, Long> {


	SystemConfiguration findByKey(String key);

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
