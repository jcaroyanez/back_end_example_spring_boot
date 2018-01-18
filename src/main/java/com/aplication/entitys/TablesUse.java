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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josel
 */
@Entity
@Table(name = "tables_use")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TablesUse.findAll", query = "SELECT t FROM TablesUse t")
    , @NamedQuery(name = "TablesUse.findByIdTable", query = "SELECT t FROM TablesUse t WHERE t.idTable = :idTable")
    , @NamedQuery(name = "TablesUse.findByTableName", query = "SELECT t FROM TablesUse t WHERE t.tableName = :tableName")
    , @NamedQuery(name = "TablesUse.findByStateU", query = "SELECT t FROM TablesUse t WHERE t.stateU = :stateU")
    , @NamedQuery(name = "TablesUse.findByState", query = "SELECT t FROM TablesUse t WHERE t.state = :state")})
public class TablesUse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_table")
    private Integer idTable;
    @Size(max = 45)
    @Column(name = "table_name")
    private String tableName;
    @Size(max = 20)
    @Column(name = "state_u")
    private String stateU;
    @Column(name = "state")
    private Integer state;

    public TablesUse() {
    }

    public TablesUse(Integer idTable) {
        this.idTable = idTable;
    }

    public Integer getIdTable() {
        return idTable;
    }

    public void setIdTable(Integer idTable) {
        this.idTable = idTable;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getStateU() {
        return stateU;
    }

    public void setStateU(String stateU) {
        this.stateU = stateU;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTable != null ? idTable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TablesUse)) {
            return false;
        }
        TablesUse other = (TablesUse) object;
        if ((this.idTable == null && other.idTable != null) || (this.idTable != null && !this.idTable.equals(other.idTable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.backend.entitys.TablesUse[ idTable=" + idTable + " ]";
    }
    
}
