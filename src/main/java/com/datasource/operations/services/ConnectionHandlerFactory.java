package com.datasource.operations.services;

import com.datasource.operations.repository.MysqlQueryExcecuterRepository;
import com.datasource.operations.repository.QueryExcecuterRepository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public  class ConnectionHandlerFactory {

    public  QueryExcecuterRepository Create(String dbType, DataSource dataSource)
    {
        if(dbType.equals("mysql"))
        {
            QueryExcecuterRepository mysqlExcecuterRepository = new MysqlQueryExcecuterRepository(dataSource);
            return mysqlExcecuterRepository;
        }
        return null;
    }
}
