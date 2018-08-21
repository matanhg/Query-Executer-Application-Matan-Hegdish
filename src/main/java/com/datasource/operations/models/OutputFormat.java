package com.datasource.operations.models;



import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract class OutputFormat {
    protected  HttpServletResponse httpServletResponse;
    protected List<Map<String, Object>> data;

    abstract public  void setOutput() throws IOException;
}
