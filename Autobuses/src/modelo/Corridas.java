/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "CORRIDAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Corridas.findAll", query = "SELECT c FROM Corridas c"),
    @NamedQuery(name = "Corridas.findByNumCorridas", query = "SELECT c FROM Corridas c WHERE c.numCorridas = :numCorridas"),
    @NamedQuery(name = "Corridas.findByOrigen", query = "SELECT c FROM Corridas c WHERE c.origen = :origen"),
    @NamedQuery(name = "Corridas.findByDestino", query = "SELECT c FROM Corridas c WHERE c.destino = :destino"),
    @NamedQuery(name = "Corridas.findByFecha", query = "SELECT c FROM Corridas c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Corridas.findByClaseAutobus", query = "SELECT c FROM Corridas c WHERE c.claseAutobus = :claseAutobus"),
    @NamedQuery(name = "Corridas.findByPrecio", query = "SELECT c FROM Corridas c WHERE c.precio = :precio"),
    @NamedQuery(name = "Corridas.findByLugares", query = "SELECT c FROM Corridas c WHERE c.lugares = :lugares"),
    @NamedQuery(name = "Corridas.findByHora", query = "SELECT c FROM Corridas c WHERE c.hora = :hora"),
    @NamedQuery(name = "Corridas.findByODF",query = "SELECT c FROM Corridas c WHERE c.origen =:origen AND c.destino =:destino AND c.fecha = :fecha")})
public class Corridas implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_CORRIDAS")
    private Integer numCorridas;
    @Column(name = "ORIGEN")
    private String origen;
    @Column(name = "DESTINO")
    private String destino;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "CLASE_AUTOBUS")
    private String claseAutobus;
    @Column(name = "PRECIO")
    private Integer precio;
    @Column(name = "LUGARES")
    private Integer lugares;
    @Column(name = "HORA")
    private String hora;

    public Corridas() {
    }

    public Corridas(Integer numCorridas) {
        this.numCorridas = numCorridas;
    }

    public Integer getNumCorridas() {
        return numCorridas;
    }

    public void setNumCorridas(Integer numCorridas) {
        Integer oldNumCorridas = this.numCorridas;
        this.numCorridas = numCorridas;
        changeSupport.firePropertyChange("numCorridas", oldNumCorridas, numCorridas);
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        String oldOrigen = this.origen;
        this.origen = origen;
        changeSupport.firePropertyChange("origen", oldOrigen, origen);
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        String oldDestino = this.destino;
        this.destino = destino;
        changeSupport.firePropertyChange("destino", oldDestino, destino);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public String getClaseAutobus() {
        return claseAutobus;
    }

    public void setClaseAutobus(String claseAutobus) {
        String oldClaseAutobus = this.claseAutobus;
        this.claseAutobus = claseAutobus;
        changeSupport.firePropertyChange("claseAutobus", oldClaseAutobus, claseAutobus);
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        Integer oldPrecio = this.precio;
        this.precio = precio;
        changeSupport.firePropertyChange("precio", oldPrecio, precio);
    }

    public Integer getLugares() {
        return lugares;
    }

    public void setLugares(Integer lugares) {
        Integer oldLugares = this.lugares;
        this.lugares = lugares;
        changeSupport.firePropertyChange("lugares", oldLugares, lugares);
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        String oldHora = this.hora;
        this.hora = hora;
        changeSupport.firePropertyChange("hora", oldHora, hora);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numCorridas != null ? numCorridas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Corridas)) {
            return false;
        }
        Corridas other = (Corridas) object;
        if ((this.numCorridas == null && other.numCorridas != null) || (this.numCorridas != null && !this.numCorridas.equals(other.numCorridas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Corridas[ numCorridas=" + numCorridas + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
