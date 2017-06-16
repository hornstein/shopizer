<<<<<<< HEAD
package com.salesmanager.core.business.repositories.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesmanager.core.model.merchant.MerchantStore;
import com.salesmanager.core.model.system.MerchantLog;

public interface MerchantLogRepository extends JpaRepository<MerchantLog, Long> {

	public List<MerchantLog> findByStore(MerchantStore store);
}
=======
package com.salesmanager.core.business.repositories.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesmanager.core.model.merchant.MerchantStore;
import com.salesmanager.core.model.system.MerchantLog;

public interface MerchantLogRepository extends JpaRepository<MerchantLog, Long> {

	public List<MerchantLog> findByStore(MerchantStore store);
}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
