package com.datasource.operations.repository;

import com.datasource.operations.exceptions.QueryException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MysqlQueryExcecuterRepository extends  QueryExcecuterRepository {

    public MysqlQueryExcecuterRepository(DataSource dataSource) {
        jdbc = new JdbcTemplate(dataSource);
    }

    public int updateQuery(String query) {
        int rowsAffected;

        try
        {
            rowsAffected  = jdbc.update(query);
        }
        catch(Exception ex)
        {
            throw new QueryException(ex.getMessage());
        }
        return rowsAffected;
    }

    public List<Map<String, Object>> dataRetrievalQuery(String query) {
        List<Map<String, Object>> queryResponse;

        try
        {
            queryResponse =  jdbc.queryForList(query);
        }
        catch(Exception ex)
        {
            throw new QueryException(ex.getMessage());
        }

        return queryResponse;
    }

    @Override
    public List<Map<String, Object>> queryTypeSelector(String query)throws  QueryException {

        if(query.toLowerCase().startsWith("select") || query.toLowerCase().startsWith("show") || query.toLowerCase().startsWith("desc"))
        {
            return dataRetrievalQuery(query);
        }

        else
        {
            int rowsAffected =  updateQuery(query);
            List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
            Map<String,Object> rowData  = new HashMap<>();
            rowData.put("Rows Affected",rowsAffected);
            data.add(rowData);
            return data;
        }
    }

}
