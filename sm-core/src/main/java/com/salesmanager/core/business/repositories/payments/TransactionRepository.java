<<<<<<< HEAD
package com.salesmanager.core.business.repositories.payments;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesmanager.core.model.payments.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query("select t from Transaction t join fetch t.order to where to.id = ?1")
	List<Transaction> findByOrder(Long orderId);
}
=======
package com.salesmanager.core.business.repositories.payments;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesmanager.core.model.payments.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query("select t from Transaction t join fetch t.order to where to.id = ?1")
	List<Transaction> findByOrder(Long orderId);
}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
