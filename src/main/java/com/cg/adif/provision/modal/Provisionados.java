package com.cg.adif.provision.modal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="provisionados",
       uniqueConstraints= {@UniqueConstraint(columnNames= {"codigo_sap_expediente","cod_sociedad","periodo_certificacion"})})
public class Provisionados {
	
	@EmbeddedId
	private Composite key;

	public Composite getKey() {
		return key;
	}

	public void setKey(Composite key) {
		this.key = key;
	}
	
	@Transient
	private long timestamp;

	public long getTimestamp() {
		return getKey().getPeriodo().getTime();
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
}
