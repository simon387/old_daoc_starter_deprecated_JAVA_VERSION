/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Simone
 */
@Entity
@Table(name = "ACCOUNT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findById", query = "SELECT a FROM Account a WHERE a.id = :id"),
    @NamedQuery(name = "Account.findByName", query = "SELECT a FROM Account a WHERE a.name = :name"),
    @NamedQuery(name = "Account.findByPassword", query = "SELECT a FROM Account a WHERE a.password = :password"),
    @NamedQuery(name = "Account.findByType", query = "SELECT a FROM Account a WHERE a.type = :type")})
public class Account implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "TYPE")
    private int type;

    public Account() {
    }

    public Account(Integer id) {
	this.id = id;
    }

    public Account(Integer id, String name, String password, int type) {
	this.id = id;
	this.name = name;
	this.password = password;
	this.type = type;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	Integer oldId = this.id;
	this.id = id;
	changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	String oldName = this.name;
	this.name = name;
	changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	String oldPassword = this.password;
	this.password = password;
	changeSupport.firePropertyChange("password", oldPassword, password);
    }

    public int getType() {
	return type;
    }

    public void setType(int type) {
	int oldType = this.type;
	this.type = type;
	changeSupport.firePropertyChange("type", oldType, type);
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
	if (!(object instanceof Account)) {
	    return false;
	}
	Account other = (Account) object;
	if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	//return "com.data.Account[ id=" + id + " ]";
	if (this.name.equals("")) {
	    return "[no name entered]";
	}
	return this.name;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
	changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
	changeSupport.removePropertyChangeListener(listener);
    }
}
