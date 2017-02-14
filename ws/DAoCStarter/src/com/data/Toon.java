package com.data;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Simone
 */
@Entity
@Table(name = "TOON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Toon.findAll", query = "SELECT t FROM Toon t"),
    @NamedQuery(name = "Toon.findById", query = "SELECT t FROM Toon t WHERE t.id = :id"),
    @NamedQuery(name = "Toon.findByNome", query = "SELECT t FROM Toon t WHERE t.nome = :nome"),
    @NamedQuery(name = "Toon.findByServer", query = "SELECT t FROM Toon t WHERE t.server = :server"),
    @NamedQuery(name = "Toon.findByIp", query = "SELECT t FROM Toon t WHERE t.ip = :ip"),
    @NamedQuery(name = "Toon.findByPort", query = "SELECT t FROM Toon t WHERE t.port = :port"),
    @NamedQuery(name = "Toon.findByRealm", query = "SELECT t FROM Toon t WHERE t.realm = :realm"),
    @NamedQuery(name = "Toon.findByServerid", query = "SELECT t FROM Toon t WHERE t.serverid = :serverid"),
    @NamedQuery(name = "Toon.findByAccount", query = "SELECT t FROM Toon t WHERE t.account = :account"),
    @NamedQuery(name = "Toon.findByClasse", query = "SELECT t FROM Toon t WHERE t.classe = :classe"),
    @NamedQuery(name = "Toon.findByResolution", query = "SELECT t FROM Toon t WHERE t.resolution = :resolution"),
    @NamedQuery(name = "Toon.findByWindowed", query = "SELECT t FROM Toon t WHERE t.windowed = :windowed")})
public class Toon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @Column(name = "SERVER")
    private String server;
    @Basic(optional = false)
    @Column(name = "IP")
    private String ip;
    @Basic(optional = false)
    @Column(name = "PORT")
    private int port;
    @Basic(optional = false)
    @Column(name = "REALM")
    private int realm;
    @Basic(optional = false)
    @Column(name = "SERVERID")
    private int serverid;
    @Basic(optional = false)
    @Column(name = "ACCOUNT")
    private int account;
    @Basic(optional = false)
    @Column(name = "CLASSE")
    private String classe;
    @Basic(optional = false)
    @Column(name = "RESOLUTION")
    private String resolution;
    @Basic(optional = false)
    @Column(name = "WINDOWED")
    private int windowed;

    public Toon() {
    }

    public Toon(Integer id) {
	this.id = id;
    }

    public Toon(Integer id, String nome, String server, String ip, int port, int realm, int serverid, int account, String classe, String resolution, int windowed) {
		this.id = id;
		this.nome = nome;
		this.server = server;
		this.ip = ip;
		this.port = port;
		this.realm = realm;
		this.serverid = serverid;
		this.account = account;
		this.classe = classe;
		this.resolution = resolution;
		this.windowed = windowed;
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

    public String getServer() {
	return server;
    }

    public void setServer(String server) {
	this.server = server;
    }

    public String getIp() {
	return ip;
    }

    public void setIp(String ip) {
	this.ip = ip;
    }

    public int getPort() {
	return port;
    }

    public void setPort(int port) {
	this.port = port;
    }

    public int getRealm() {
	return realm;
    }

    public void setRealm(int realm) {
	this.realm = realm;
    }

    public int getServerid() {
	return serverid;
    }

    public void setServerid(int serverid) {
	this.serverid = serverid;
    }

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

    public String getClasse() {
	return classe;
    }

    public void setClasse(String classe) {
	this.classe = classe;
    }

    public String getResolution() {
	return resolution;
    }

    public void setResolution(String resolution) {
	this.resolution = resolution;
    }

    public int getWindowed() {
	return windowed;
    }

    public void setWindowed(int windowed) {
	this.windowed = windowed;
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
	if (!(object instanceof Toon)) {
	    return false;
	}
	Toon other = (Toon) object;
	if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
		//return "com.data.Toon[ id=" + id + " ]";
		 return this.nome + " [" + this.classe + "]";
    }
}
