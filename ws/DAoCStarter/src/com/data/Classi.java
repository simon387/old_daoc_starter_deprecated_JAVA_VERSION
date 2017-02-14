/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Simone
 */
@Entity
@Table(name = "CLASSI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classi.findAll", query = "SELECT c FROM Classi c"),
    @NamedQuery(name = "Classi.findById", query = "SELECT c FROM Classi c WHERE c.id = :id"),
    @NamedQuery(name = "Classi.findByReame", query = "SELECT c FROM Classi c WHERE c.reame = :reame"),
    @NamedQuery(name = "Classi.findByClasse", query = "SELECT c FROM Classi c WHERE c.classe = :classe")})
public class Classi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "REAME", nullable = false, length = 10)
    private String reame;
    @Basic(optional = false)
    @Column(name = "CLASSE", nullable = false, length = 20)
    private String classe;

    public Classi() {
    }

    public Classi(Integer id) {
	this.id = id;
    }

    public Classi(Integer id, String reame, String classe) {
	this.id = id;
	this.reame = reame;
	this.classe = classe;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getReame() {
	return reame;
    }

    public void setReame(String reame) {
	this.reame = reame;
    }

    public String getClasse() {
	return classe;
    }

    public void setClasse(String classe) {
	this.classe = classe;
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
	if (!(object instanceof Classi)) {
	    return false;
	}
	Classi other = (Classi) object;
	if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
		//return "com.data.Classi[ id=" + id + " ]";
		return this.getClasse();
    }
    
}
