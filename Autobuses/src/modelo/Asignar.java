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
@Table(name = "ASIGNAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignar.findAll", query = "SELECT a FROM Asignar a"),
    @NamedQuery(name = "Asignar.findByIdAsignar", query = "SELECT a FROM Asignar a WHERE a.idAsignar = :idAsignar"),
    @NamedQuery(name = "Asignar.findByAsiento", query = "SELECT a FROM Asignar a WHERE a.asiento = :asiento"),
    @NamedQuery(name = "Asignar.findByNombrePasajero", query = "SELECT a FROM Asignar a WHERE a.nombrePasajero = :nombrePasajero"),
    @NamedQuery(name = "Asignar.findByTipoPasajero", query = "SELECT a FROM Asignar a WHERE a.tipoPasajero = :tipoPasajero")})
public class Asignar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ASIGNAR")
    private Integer idAsignar;
    @Column(name = "ASIENTO")
    private Integer asiento;
    @Column(name = "NOMBRE_PASAJERO")
    private String nombrePasajero;
    @Column(name = "TIPO_PASAJERO")
    private String tipoPasajero;

    public Asignar() {
    }

    public Asignar(Integer idAsignar) {
        this.idAsignar = idAsignar;
    }

    public Integer getIdAsignar() {
        return idAsignar;
    }

    public void setIdAsignar(Integer idAsignar) {
        this.idAsignar = idAsignar;
    }

    public Integer getAsiento() {
        return asiento;
    }

    public void setAsiento(Integer asiento) {
        this.asiento = asiento;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }

    public String getTipoPasajero() {
        return tipoPasajero;
    }

    public void setTipoPasajero(String tipoPasajero) {
        this.tipoPasajero = tipoPasajero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignar != null ? idAsignar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignar)) {
            return false;
        }
        Asignar other = (Asignar) object;
        if ((this.idAsignar == null && other.idAsignar != null) || (this.idAsignar != null && !this.idAsignar.equals(other.idAsignar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Asignar[ idAsignar=" + idAsignar + " ]";
    }
    
}
