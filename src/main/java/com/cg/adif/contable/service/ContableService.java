package com.cg.adif.contable.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cg.adif.contable.modal.Contable;
import com.fasterxml.jackson.annotation.JsonFormat;

public interface ContableService {
	
	Contable createNew(Contable c);
	void deleteById(Date periodo_certificacion);
	Contable update(Contable c);
	Page<Contable> findUsingPagination(Pageable page);
	Page<Contable> search(String date,Pageable page);

	

}
