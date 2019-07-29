package com.cg.adif.contable.dao;

import org.springframework.data.domain.Pageable;
import java.util.Date;
import java.util.List;
import javax.websocket.server.PathParam;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.adif.contable.modal.Contable;;

@Repository
public interface ContableDb extends JpaRepository<Contable, Date>{
	
	
	
	@Query(value="select * from Contable m where (DATE_FORMAT(m.periodo_certificacion,'%d/%m/%Y')) LIKE ?1 or (DATE_FORMAT(m.fecha_cierre,\"%d/%m/%Y\")) LIKE ?1",
	nativeQuery=true)
Page<Contable> search(String date,Pageable page);

}
