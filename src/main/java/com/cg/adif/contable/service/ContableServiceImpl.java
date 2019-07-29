package com.cg.adif.contable.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cg.adif.contable.dao.ContableDb;
import com.cg.adif.contable.modal.Contable;
import com.fasterxml.jackson.annotation.JsonFormat;


@Service
public class ContableServiceImpl implements ContableService{
	@Autowired
	private ContableDb db;
	
	

	@Override
	public Contable createNew(Contable c) {
		Optional<Contable> con = db.findById(c.getPeriodo_certificacion());
		
		if(!(con.isPresent()))
		{
		db.saveAndFlush(c);
		return c;
		}
		else
		{
		System.out.println("it already exists");
		return null;
		}
		
	}

	@Override
	public void deleteById(Date periodo_certificacion) {
		db.deleteById(periodo_certificacion);
		
	}

	@Override
	public Contable update(Contable c) {
		Optional<Contable> old = db.findById(c.getPeriodo_certificacion());
		if((old.get().getFecha_cierre().getTime())!=(c.getFecha_cierre().getTime()))
		{
		Contable table = new Contable();
		table.setPeriodo_certificacion(c.getPeriodo_certificacion());
		table.setFecha_cierre(c.getFecha_cierre());
		db.saveAndFlush(table);
		return table;
		}
		else
			return null;
	}

	@Override
	public Page<Contable> findUsingPagination(Pageable page) {
		return db.findAll(page);
	}

	@Override
	public Page<Contable> search(String date, Pageable page)    {
			date="%"+date+"%";
		
		return db.search(date, page);
	
	}
	

	

}
