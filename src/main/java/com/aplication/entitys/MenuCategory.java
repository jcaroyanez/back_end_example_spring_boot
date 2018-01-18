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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author josel
 */
@Entity
@Table(name = "menu_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuCategory.findAll", query = "SELECT m FROM MenuCategory m")
    , @NamedQuery(name = "MenuCategory.findByIdCategory", query = "SELECT m FROM MenuCategory m WHERE m.idCategory = :idCategory")
    , @NamedQuery(name = "MenuCategory.findByCategoryName", query = "SELECT m FROM MenuCategory m WHERE m.categoryName = :categoryName")
    , @NamedQuery(name = "MenuCategory.findByState", query = "SELECT m FROM MenuCategory m WHERE m.state = :state")})
public class MenuCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_category")
    private Integer idCategory;
    @Size(max = 45)
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "state")
    private Integer state;
    @OneToMany(mappedBy = "idMenuCategory")
    private Collection<Menus> menusCollection;

    public MenuCategory() {
    }

    public MenuCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<Menus> getMenusCollection() {
        return menusCollection;
    }

    public void setMenusCollection(Collection<Menus> menusCollection) {
        this.menusCollection = menusCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategory != null ? idCategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuCategory)) {
            return false;
        }
        MenuCategory other = (MenuCategory) object;
        if ((this.idCategory == null && other.idCategory != null) || (this.idCategory != null && !this.idCategory.equals(other.idCategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.backend.entitys.MenuCategory[ idCategory=" + idCategory + " ]";
    }
    
}
