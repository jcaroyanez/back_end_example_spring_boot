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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author josel
 */
@Entity
@Table(name = "menus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menus.findAll", query = "SELECT m FROM Menus m")
    , @NamedQuery(name = "Menus.findByIdMenus", query = "SELECT m FROM Menus m WHERE m.idMenus = :idMenus")
    , @NamedQuery(name = "Menus.findByMenusName", query = "SELECT m FROM Menus m WHERE m.menusName = :menusName")
    , @NamedQuery(name = "Menus.findByPrice", query = "SELECT m FROM Menus m WHERE m.price = :price")
    , @NamedQuery(name = "Menus.findByState", query = "SELECT m FROM Menus m WHERE m.state = :state")})
public class Menus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_menus")
    private Integer idMenus;
    @Size(max = 45)
    @Column(name = "menus_name")
    private String menusName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Column(name = "state")
    private Integer state;
    @JoinColumn(name = "id_menu_category", referencedColumnName = "id_category")
    @ManyToOne
    private MenuCategory idMenuCategory;
    @OneToMany(mappedBy = "idMenu")
    private Collection<ItemOrder> itemOrderCollection;

    public Menus() {
    }

    public Menus(Integer idMenus) {
        this.idMenus = idMenus;
    }

    public Integer getIdMenus() {
        return idMenus;
    }

    public void setIdMenus(Integer idMenus) {
        this.idMenus = idMenus;
    }

    public String getMenusName() {
        return menusName;
    }

    public void setMenusName(String menusName) {
        this.menusName = menusName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public MenuCategory getIdMenuCategory() {
        return idMenuCategory;
    }

    public void setIdMenuCategory(MenuCategory idMenuCategory) {
        this.idMenuCategory = idMenuCategory;
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
        hash += (idMenus != null ? idMenus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menus)) {
            return false;
        }
        Menus other = (Menus) object;
        if ((this.idMenus == null && other.idMenus != null) || (this.idMenus != null && !this.idMenus.equals(other.idMenus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.backend.entitys.Menus[ idMenus=" + idMenus + " ]";
    }
    
}
