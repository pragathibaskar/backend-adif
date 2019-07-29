package com.cg.adif.provision.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cg.adif.budget.dao.BudgetDb;
import com.cg.adif.contable.modal.Contable;
import com.cg.adif.provision.dao.CodigoDb;
import com.cg.adif.provision.modal.Provisionados;


@Service
public class CodigoServiceImpl implements CodigoService{
	
	@Autowired
	private CodigoDb db;

	@Override
	public void deleteById(Provisionados entity) {
		db.delete(entity);
		
	}

	@Override
	public Provisionados createNew(Provisionados p) {
       List<Provisionados> con = db.findByCodigoAndPeriodo(p.getKey().getCodigo(), p.getKey().getPeriodo());
		if(con.isEmpty())
		{
		db.saveAndFlush(p);
		return p;
		}
		else
		{
		System.out.println("it already exists");
		return null;
		}
		
		
	}

	

}
