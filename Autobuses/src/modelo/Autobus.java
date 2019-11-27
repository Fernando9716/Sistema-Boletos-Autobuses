/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
 * @author fernando
 */
@Entity
@Table(name = "AUTOBUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autobus.findAll", query = "SELECT a FROM Autobus a"),
    @NamedQuery(name = "Autobus.findByIdAutobus", query = "SELECT a FROM Autobus a WHERE a.idAutobus = :idAutobus"),
    @NamedQuery(name = "Autobus.findByNombre", query = "SELECT a FROM Autobus a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Autobus.findByNumasientos", query = "SELECT a FROM Autobus a WHERE a.numasientos = :numasientos")})
public class Autobus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_AUTOBUS")
    private Integer idAutobus;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "NUMASIENTOS")
    private Integer numasientos;

    public Autobus() {
    }

    public Autobus(Integer idAutobus) {
        this.idAutobus = idAutobus;
    }

    public Integer getIdAutobus() {
        return idAutobus;
    }

    public void setIdAutobus(Integer idAutobus) {
        this.idAutobus = idAutobus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumasientos() {
        return numasientos;
    }

    public void setNumasientos(Integer numasientos) {
        this.numasientos = numasientos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutobus != null ? idAutobus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autobus)) {
            return false;
        }
        Autobus other = (Autobus) object;
        if ((this.idAutobus == null && other.idAutobus != null) || (this.idAutobus != null && !this.idAutobus.equals(other.idAutobus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Autobus[ idAutobus=" + idAutobus + " ]";
    }
    
}
