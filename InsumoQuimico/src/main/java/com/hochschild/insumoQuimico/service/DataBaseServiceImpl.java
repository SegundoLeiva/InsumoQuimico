package com.hochschild.insumoQuimico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.DataBaseDAO;

@Service
public class DataBaseServiceImpl implements DataBaseService {
    @Autowired
    public DataBaseDAO dataBaseDAO;

    public String getBDVersion() {
        return dataBaseDAO.getDataBaseVersion();
    }
}
