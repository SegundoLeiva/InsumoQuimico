package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQuery(name = "getDataBaseVersion",
    callable = true,
    query = "SELECT CONVERT(VARCHAR(100),SERVERPROPERTY('servername'))+'\\'+ db_name() as version",
    readOnly = true,
    cacheable = false,
    resultClass = DataBaseVersion.class)
@Entity
public class DataBaseVersion implements Serializable {

    private static final long serialVersionUID = 2773772027153172025L;
    
	@Id
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}