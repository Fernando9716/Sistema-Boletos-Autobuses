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
@Table(name = "LUGARES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lugares.findAll", query = "SELECT l FROM Lugares l"),
    @NamedQuery(name = "Lugares.findByIdLugar", query = "SELECT l FROM Lugares l WHERE l.idLugar = :idLugar"),
    @NamedQuery(name = "Lugares.findByLugar", query = "SELECT l FROM Lugares l WHERE l.lugar = :lugar"),
    @NamedQuery(name = "Lugares.findByEstado", query = "SELECT l FROM Lugares l WHERE l.estado = :estado")})
public class Lugares implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_LUGAR")
    private Integer idLugar;
    @Column(name = "LUGAR")
    private String lugar;
    @Column(name = "ESTADO")
    private String estado;

    public Lugares() {
    }

    public Lugares(Integer idLugar) {
        this.idLugar = idLugar;
    }

    public Integer getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(Integer idLugar) {
        this.idLugar = idLugar;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLugar != null ? idLugar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lugares)) {
            return false;
        }
        Lugares other = (Lugares) object;
        if ((this.idLugar == null && other.idLugar != null) || (this.idLugar != null && !this.idLugar.equals(other.idLugar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Lugares[ idLugar=" + idLugar + " ]";
    }
    
}
