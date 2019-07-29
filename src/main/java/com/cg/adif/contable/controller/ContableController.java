package com.cg.adif.contable.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.adif.budget.dao.BudgetDb;
import com.cg.adif.contable.modal.Contable;
import com.cg.adif.contable.modal.SearchContableTo;
import com.cg.adif.contable.modal.customProvionTo;
import com.cg.adif.contable.service.ContableService;
import com.cg.adif.provision.dao.CodigoDb;
import com.cg.adif.provision.modal.Composite;
import com.cg.adif.provision.modal.Provisionados;
import com.cg.adif.provision.service.CodigoService;
import com.cg.adif.budget.modal.*;





@RequestMapping("adif")
@RestController
public class ContableController {

	@Autowired
	private ContableService svc;
	
	@Autowired
	private CodigoService codigosvc;
	
	 @PostMapping("/contables")
		ResponseEntity<Contable> create(@RequestBody Contable c)
		{
		 Contable con = svc.createNew(c);
		 if(con!=null)
			    return new ResponseEntity<>(c, HttpStatus.OK);
			else
			    return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		}
	 
	 @DeleteMapping("/contables/{ts}")
	   void deleteById(@PathVariable("ts") long ts)
	   {
		 Date date = new Date(ts);
         svc.deleteById(date);
	   }
	 
	 @PutMapping("/contables")
	 ResponseEntity<Contable> update(@RequestBody Contable c)
	  {
		 Contable con = svc.update(c);
		 if(con!=null)
			    return new ResponseEntity<>(c, HttpStatus.OK);
			else
			    return new ResponseEntity<>(null, HttpStatus.CONFLICT);
	  }
	 
	 @GetMapping("/contables/{page}/{size}")
	 Page<Contable> findUsingPagination(@PathVariable("page") int page,@PathVariable("size") int size)
	 {
		 Pageable listAll = null;
	     listAll = PageRequest.of(page, size);
		 return svc.findUsingPagination(listAll);
	 }
	
	 
	 @PostMapping("/contables/search")
	 Page<Contable> search(@RequestBody SearchContableTo search)
	 {
		 Pageable listAll = null;
	     listAll = PageRequest.of(search.getPage(), search.getSize());
		 return svc.search(search.getDate(), listAll);
		 
	 }
	 
	 
	 // <----- Second page -------->
	 
	 @Autowired
	 private CodigoDb cod;
	 
	 @Autowired
	 private BudgetDb bdb;
	  
        @DeleteMapping("/codigo")
	   void deleteCodigo(@RequestBody customProvionTo c)
	   {
		 Date date = new Date(c.getTimestamp());
		 Composite obj = new Composite();
		 obj.setCodigo(c.getCodigo_sap_expediente());
		 obj.setCod_sociedad(c.getCod_sociedad());
		 obj.setPeriodo(date);
		 Provisionados pro = new Provisionados();
		 pro.setKey(obj);
         codigosvc.deleteById(pro);
	   } 
	
	 @GetMapping("/codigo/{ts}/{page}/{size}")
	 Page<Provisionados> listAll(@PathVariable("ts") long ts,@PathVariable("page") int page,@PathVariable("size") int size)
	 {
		Date date = new Date(ts);
		Pageable listAll = null;
	     listAll = PageRequest.of(page, size);
		 return cod.findByPeriodo(date, listAll);
	   
		 
	 }
	 
	 @GetMapping("/codigo/autosearch/{sap}")
	 List<Budget> searchList(@PathVariable("sap") String codigo_sap_expediente)
	 {
		 codigo_sap_expediente= "%"+codigo_sap_expediente+"%";
		return bdb.search(codigo_sap_expediente);
		 
	 }
	 
	 @GetMapping("/codigo/search/{string}/{page}/{size}")
	 Page<Provisionados> searchListAll(@PathVariable("string") String searchString,
			 @PathVariable("page") int page,@PathVariable("size") int size)
	 {
		 Pageable listAll = null;
	     listAll = PageRequest.of(page,size);
	     searchString="%"+searchString+"%";
		return cod.search(searchString, listAll);
		 
	 }
	 
	 
	 @PostMapping("/codigo")
		ResponseEntity<Provisionados> createNew(@RequestBody customProvionTo c)
		{
		 Date date = new Date(c.getTimestamp());
		 Composite obj = new Composite();
		 obj.setCodigo(c.getCodigo_sap_expediente());
		 obj.setCod_sociedad(c.getCod_sociedad());
		 obj.setPeriodo(date);
		 Provisionados pro = new Provisionados();
		 pro.setKey(obj);
		 Provisionados con = codigosvc.createNew(pro);
		 if(con!=null)
			    return new ResponseEntity<>(pro, HttpStatus.OK);
			else
			    return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		}
	
		
	 
	
}
