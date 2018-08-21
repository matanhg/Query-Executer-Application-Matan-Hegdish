package com.datasource.operations.services;


import com.datasource.operations.repository.QueryExcecuterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class ConnectionHandlerService {

    @Autowired
    ConnectionHandlerFactory connectionHandlerFactory;

    @Autowired
    private ApplicationContext context;

    public QueryExcecuterRepository getConnection(String dbType)
    {
        DataSource dataSource =  context.getBean(dbType,DataSource.class);
        QueryExcecuterRepository queryExcecuterRepository = connectionHandlerFactory.Create(dbType,dataSource);
        return queryExcecuterRepository;
    }
}
