package com.datasource.operations.models;

import com.datasource.operations.services.JsonConverter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonOutputFormat extends OutputFormat {

    public JsonOutputFormat(HttpServletResponse httpServletResponse, List<Map<String, Object>> data) {
        this.httpServletResponse = httpServletResponse;
        this.data = data;
    }

    @Override
    public void setOutput() throws IOException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        ServletOutputStream out = httpServletResponse.getOutputStream();
        JsonConverter converter = new JsonConverter();
        String output = converter.convertToJson(data);
        out.print(output);
    }
}
