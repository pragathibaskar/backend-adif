package com.cg.adif.budget.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.adif.budget.modal.Budget;


@Repository
public interface BudgetDb extends JpaRepository<Budget, String>{
	
	@Query(value="select * from Budget b where b.codigo_sap_expediente LIKE ?1",
			nativeQuery=true)
	List<Budget> search(String cod);
}
