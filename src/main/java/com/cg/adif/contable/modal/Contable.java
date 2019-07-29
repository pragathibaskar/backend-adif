package com.cg.adif.contable.modal;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="contable")
public class Contable {
	@Id
	@NotNull
	@Column(name="periodo_certificacion")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date periodo_certificacion;
	
	@Column(name="fecha_cierre")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date fecha_cierre;
	
	@Transient
	private long tstamp;
	
//	private List<Provisionados> provisiones;
//	
//	@OneToMany(mappedBy = "contable")
//	public List<Provisionados> getProvisiones() {
//		return provisiones;
//	}
//	
//	public void setProvisiones(List<Provisionados> provisiones) {
//		this.provisiones = provisiones;
//	}
	
	public long getTstamp() {
		return periodo_certificacion.getTime();
	}
	
	public void setTstamp(long tstamp) {
		this.tstamp = tstamp;
	}
	
	public Date getPeriodo_certificacion() {
		return periodo_certificacion;
	}
	
	public void setPeriodo_certificacion(Date periodo_certificacion) {
		this.periodo_certificacion = periodo_certificacion;
	}
	
	public Date getFecha_cierre() {
		return fecha_cierre;
	}
	
	public void setFecha_cierre(Date fecha_cierre) {
		this.fecha_cierre = fecha_cierre;
	}

}
