/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplication.entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josel
 */
@Entity
@Table(name = "item_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemOrder.findAll", query = "SELECT i FROM ItemOrder i")
    , @NamedQuery(name = "ItemOrder.findByIdItemOrder", query = "SELECT i FROM ItemOrder i WHERE i.idItemOrder = :idItemOrder")
    , @NamedQuery(name = "ItemOrder.findByState", query = "SELECT i FROM ItemOrder i WHERE i.state = :state")})
public class ItemOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_item_order")
    private Integer idItemOrder;
    @Column(name = "state")
    private Integer state;
    @JoinColumn(name = "id_menu", referencedColumnName = "id_menus")
    @ManyToOne
    private Menus idMenu;
    @JoinColumn(name = "id_order", referencedColumnName = "id_order")
    @ManyToOne
    private OrderMenu idOrder;

    public ItemOrder() {
    }

    public ItemOrder(Integer idItemOrder) {
        this.idItemOrder = idItemOrder;
    }

    public Integer getIdItemOrder() {
        return idItemOrder;
    }

    public void setIdItemOrder(Integer idItemOrder) {
        this.idItemOrder = idItemOrder;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Menus getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Menus idMenu) {
        this.idMenu = idMenu;
    }

    public OrderMenu getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(OrderMenu idOrder) {
        this.idOrder = idOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItemOrder != null ? idItemOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemOrder)) {
            return false;
        }
        ItemOrder other = (ItemOrder) object;
        if ((this.idItemOrder == null && other.idItemOrder != null) || (this.idItemOrder != null && !this.idItemOrder.equals(other.idItemOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.backend.entitys.ItemOrder[ idItemOrder=" + idItemOrder + " ]";
    }
    
}
