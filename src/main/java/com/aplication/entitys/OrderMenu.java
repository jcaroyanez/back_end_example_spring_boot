/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplication.entitys;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author josel
 */
@Entity
@Table(name = "order_menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderMenu.findAll", query = "SELECT o FROM OrderMenu o")
    , @NamedQuery(name = "OrderMenu.findByIdOrder", query = "SELECT o FROM OrderMenu o WHERE o.idOrder = :idOrder")
    , @NamedQuery(name = "OrderMenu.findByIdMesa", query = "SELECT o FROM OrderMenu o WHERE o.idMesa = :idMesa")
    , @NamedQuery(name = "OrderMenu.findByState", query = "SELECT o FROM OrderMenu o WHERE o.state = :state")})
public class OrderMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_order")
    private Integer idOrder;
    @Column(name = "id_mesa")
    private Integer idMesa;
    @Column(name = "state")
    private Integer state;
    @OneToMany(mappedBy = "idOrder")
    private Collection<Bill> billCollection;
    @OneToMany(mappedBy = "idOrder")
    private Collection<ItemOrder> itemOrderCollection;

    public OrderMenu() {
    }

    public OrderMenu(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<Bill> getBillCollection() {
        return billCollection;
    }

    public void setBillCollection(Collection<Bill> billCollection) {
        this.billCollection = billCollection;
    }

    @XmlTransient
    public Collection<ItemOrder> getItemOrderCollection() {
        return itemOrderCollection;
    }

    public void setItemOrderCollection(Collection<ItemOrder> itemOrderCollection) {
        this.itemOrderCollection = itemOrderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrder != null ? idOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderMenu)) {
            return false;
        }
        OrderMenu other = (OrderMenu) object;
        if ((this.idOrder == null && other.idOrder != null) || (this.idOrder != null && !this.idOrder.equals(other.idOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.backend.entitys.OrderMenu[ idOrder=" + idOrder + " ]";
    }
    
}
