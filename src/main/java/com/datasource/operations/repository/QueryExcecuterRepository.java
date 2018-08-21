package com.datasource.operations.repository;


import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


public abstract class QueryExcecuterRepository {
    protected JdbcTemplate jdbc;
    abstract public List<Map<String, Object>> queryTypeSelector(String query);

}
