package com.datasource.operations.models;

public class QueryExecuterRequest {
    private String query;
    private String outputFormat;
    private String dataSource;


    public QueryExecuterRequest(String query, String outputFormat, String dataSource) {
        this.query = query;
        this.outputFormat = outputFormat;
        this.dataSource = dataSource;
    }

    public QueryExecuterRequest() {
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
}
