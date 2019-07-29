package com.cg.adif.provision.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.adif.provision.modal.Provisionados;
import com.cg.adif.provision.service.CodigoService;

@RequestMapping("adif")
@RestController
public class CodigoController {
//    @Autowired
//	private CodigoService codigosvc;
//    
//    @GetMapping("/codigo/{ts}/{page}/{size}")
//	Page<Provisionados> list(@PathVariable("ts") long ts,@PathVariable("page") int page,@PathVariable("size") int size)
//	{
//		Date date = new Date(ts);
//		Pageable listAll = null;
//	     listAll = PageRequest.of(page, size);
//		return codigosvc.getList(date, listAll);
//		
//	}
}
