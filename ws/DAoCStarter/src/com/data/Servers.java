package com.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * MADE IN ITALY
 * @author simone
 */
@Entity
@Table(name = "SERVERS")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Servers.findAll", query = "SELECT s FROM Servers s"),
	@NamedQuery(name = "Servers.findById", query = "SELECT s FROM Servers s WHERE s.id = :id"),
	@NamedQuery(name = "Servers.findByNome", query = "SELECT s FROM Servers s WHERE s.nome = :nome"),
	@NamedQuery(name = "Servers.findByIndirizzo", query = "SELECT s FROM Servers s WHERE s.indirizzo = :indirizzo"),
	@NamedQuery(name = "Servers.findByPorta", query = "SELECT s FROM Servers s WHERE s.porta = :porta"),
	@NamedQuery(name = "Servers.findBySid", query = "SELECT s FROM Servers s WHERE s.sid = :sid")})
public class Servers implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
   @Basic(optional = false)
   @Column(name = "ID")
	private Integer id;
	@Basic(optional = false)
   @Column(name = "NOME")
	private String nome;
	@Basic(optional = false)
   @Column(name = "INDIRIZZO")
	private String indirizzo;
	@Basic(optional = false)
   @Column(name = "PORTA")
	private int porta;
	@Basic(optional = false)
   @Column(name = "SID")
	private int sid;

	public Servers() {
	}

	public Servers(Integer id) {
		this.id = id;
	}

	public Servers(Integer id, String nome, String indirizzo, int porta, int sid) {
		this.id = id;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.porta = porta;
		this.sid = sid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Servers)) {
			return false;
		}
		Servers other = (Servers) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		//return "com.data.Servers[ id=" + id + " ]";
		return this.nome;
	}
	
}
