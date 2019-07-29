package com.cg.adif.budget.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Budget {

	@Id
	@NotNull
	@Column(name="codigo_sap_expediente",unique=true)
	private String codigo_sap_expediente;
	
	@Column(name="cod_sociedad",columnDefinition="ENUM('2000','2100') default '2000'")
    private String cod_sociedad;
	
	public String getCodigo_sap_expediente() {
		return codigo_sap_expediente;
	}

	public void setCodigo_sap_expediente(String codigo_sap_expediente) {
		this.codigo_sap_expediente = codigo_sap_expediente;
	}

	public String getCod_sociedad() {
		return cod_sociedad;
	}

	public void setCod_sociedad(String cod_sociedad) {
		this.cod_sociedad = cod_sociedad;
	}

	
}
