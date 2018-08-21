package com.datasource.operations.services;


import com.datasource.operations.models.CsvOutputFormat;
import com.datasource.operations.models.JsonOutputFormat;
import com.datasource.operations.models.OutputFormat;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Service
public class OutputFormatFactory {

    public OutputFormat Create(List<Map<String,Object>> data, String format, HttpServletResponse httpServletResponse)
    {
        if(format.equals("csv"))
        {
            OutputFormat csvForamt = new CsvOutputFormat(httpServletResponse,data);
            return csvForamt;
        }
        if(format.equals("json"))
        {
            OutputFormat jsonFormat = new JsonOutputFormat(httpServletResponse,data);
            return jsonFormat;
        }

        return null;
    }
}
