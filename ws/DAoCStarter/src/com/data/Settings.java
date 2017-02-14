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
 * MADE INI ITALY
 * @author Simone
 */
@Entity
@Table(name = "SETTINGS")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Settings.findAll", query = "SELECT s FROM Settings s"),
	@NamedQuery(name = "Settings.findById", query = "SELECT s FROM Settings s WHERE s.id = :id"),
	@NamedQuery(name = "Settings.findByShardpath", query = "SELECT s FROM Settings s WHERE s.shardpath = :shardpath"),
	@NamedQuery(name = "Settings.findByOfficialpath", query = "SELECT s FROM Settings s WHERE s.officialpath = :officialpath"),
	@NamedQuery(name = "Settings.findByVentpath", query = "SELECT s FROM Settings s WHERE s.ventpath = :ventpath"),
    @NamedQuery(name = "Settings.findByTs3path", query = "SELECT s FROM Settings s WHERE s.ts3path = :ts3path"),
    @NamedQuery(name = "Settings.findByServermode", query = "SELECT s FROM Settings s WHERE s.servermode = :servermode"),
    @NamedQuery(name = "Settings.findByQuitonstart", query = "SELECT s FROM Settings s WHERE s.quitonstart = :quitonstart"),
    @NamedQuery(name = "Settings.findByStartup", query = "SELECT s FROM Settings s WHERE s.startup = :startup"),
    @NamedQuery(name = "Settings.findByOntop", query = "SELECT s FROM Settings s WHERE s.ontop = :ontop"),
    @NamedQuery(name = "Settings.findByCoo1", query = "SELECT s FROM Settings s WHERE s.coo1 = :coo1"),
    @NamedQuery(name = "Settings.findByCoo2", query = "SELECT s FROM Settings s WHERE s.coo2 = :coo2"),
    @NamedQuery(name = "Settings.findByZsounditem1", query = "SELECT s FROM Settings s WHERE s.zsounditem1 = :zsounditem1"),
    @NamedQuery(name = "Settings.findByZsounditem2", query = "SELECT s FROM Settings s WHERE s.zsounditem2 = :zsounditem2"),
    @NamedQuery(name = "Settings.findByZsounditem3", query = "SELECT s FROM Settings s WHERE s.zsounditem3 = :zsounditem3"),
    @NamedQuery(name = "Settings.findByZsounditem4", query = "SELECT s FROM Settings s WHERE s.zsounditem4 = :zsounditem4"),
    @NamedQuery(name = "Settings.findByVolume", query = "SELECT s FROM Settings s WHERE s.volume = :volume"),
    @NamedQuery(name = "Settings.findByUddpath", query = "SELECT s FROM Settings s WHERE s.uddpath = :uddpath"),
	 @NamedQuery(name = "Settings.findByLastchar", query = "SELECT s FROM Settings s WHERE s.lastchar = :lastchar"),
})
public class Settings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "SHARDPATH")
    private String shardpath;
    @Column(name = "OFFICIALPATH")
    private String officialpath;
    @Column(name = "VENTPATH")
    private String ventpath;
    @Column(name = "TS3PATH")
    private String ts3path;
    @Basic(optional = false)
    @Column(name = "SERVERMODE")
    private int servermode;
    @Basic(optional = false)
    @Column(name = "QUITONSTART")
    private int quitonstart;
    @Basic(optional = false)
    @Column(name = "STARTUP")
    private int startup;
    @Basic(optional = false)
    @Column(name = "ONTOP")
    private int ontop;
    @Basic(optional = false)
    @Column(name = "COO1")
    private int coo1;
    @Basic(optional = false)
    @Column(name = "COO2")
    private int coo2;
    @Basic(optional = false)
    @Column(name = "ZSOUNDITEM1")
    private int zsounditem1;
    @Basic(optional = false)
    @Column(name = "ZSOUNDITEM2")
    private int zsounditem2;
    @Basic(optional = false)
    @Column(name = "ZSOUNDITEM3")
    private int zsounditem3;
    @Basic(optional = false)
    @Column(name = "ZSOUNDITEM4")
    private int zsounditem4;
    @Basic(optional = false)
    @Column(name = "VOLUME")
    private int volume;
    @Column(name = "UDDPATH")
    private String uddpath;
	 //@Basic(optional = false)
    @Column(name = "LASTCHAR")
    private int lastchar;

    public Settings() {
    }

    public Settings(Integer id) {
	this.id = id;
    }

	public Settings(Integer id, int servermode, int quitonstart, int startup, int ontop, int coo1, int coo2, int zsounditem1, int zsounditem2, int zsounditem3, int zsounditem4, int volume) {
		this.id = id;
		this.servermode = servermode;
		this.quitonstart = quitonstart;
		this.startup = startup;
		this.ontop = ontop;
		this.coo1 = coo1;
		this.coo2 = coo2;
		this.zsounditem1 = zsounditem1;
		this.zsounditem2 = zsounditem2;
		this.zsounditem3 = zsounditem3;
		this.zsounditem4 = zsounditem4;
		this.volume = volume;
	}

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getShardpath() {
	return shardpath;
    }

    public void setShardpath(String shardpath) {
	this.shardpath = shardpath;
    }

    public String getOfficialpath() {
	return officialpath;
    }

    public void setOfficialpath(String officialpath) {
	this.officialpath = officialpath;
    }

    public String getVentpath() {
	return ventpath;
    }

    public void setVentpath(String ventpath) {
	this.ventpath = ventpath;
    }

    public String getTs3path() {
	return ts3path;
    }

    public void setTs3path(String ts3path) {
	this.ts3path = ts3path;
    }

    public int getServermode() {
	return servermode;
    }

    public void setServermode(int servermode) {
	this.servermode = servermode;
    }

    public int getQuitonstart() {
	return quitonstart;
    }

    public void setQuitonstart(int quitonstart) {
	this.quitonstart = quitonstart;
    }

    public int getStartup() {
	return startup;
    }

    public void setStartup(int startup) {
	this.startup = startup;
    }

    public int getOntop() {
	return ontop;
    }

    public void setOntop(int ontop) {
	this.ontop = ontop;
    }

    public int getCoo1() {
	return coo1;
    }

    public void setCoo1(int coo1) {
	this.coo1 = coo1;
    }

    public int getCoo2() {
	return coo2;
    }

    public void setCoo2(int coo2) {
	this.coo2 = coo2;
    }

    public int getZsounditem1() {
	return zsounditem1;
    }

    public void setZsounditem1(int zsounditem1) {
	this.zsounditem1 = zsounditem1;
    }

    public int getZsounditem2() {
	return zsounditem2;
    }

    public void setZsounditem2(int zsounditem2) {
	this.zsounditem2 = zsounditem2;
    }

    public int getZsounditem3() {
	return zsounditem3;
    }

    public void setZsounditem3(int zsounditem3) {
	this.zsounditem3 = zsounditem3;
    }

    public int getZsounditem4() {
	return zsounditem4;
    }

    public void setZsounditem4(int zsounditem4) {
	this.zsounditem4 = zsounditem4;
    }

    public int getVolume() {
	return volume;
    }

    public void setVolume(int volume) {
	this.volume = volume;
    }

    public String getUddpath() {
	return uddpath;
    }

    public void setUddpath(String uddpath) {
	this.uddpath = uddpath;
    }

	 public void setLastchar(int lastchar) {
		 this.lastchar = lastchar;
	 }
	 
	 public int getLastchar() {
		 return this.lastchar;
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
	if (!(object instanceof Settings)) {
	    return false;
	}
	Settings other = (Settings) object;
	if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "com.data.Settings[ id=" + id + " ]";
    }
}
