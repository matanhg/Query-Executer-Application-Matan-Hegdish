package com.datasource.operations.services;


import com.datasource.operations.models.OutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class OutputFormatService {

    @Autowired
    OutputFormatFactory outputFormatFactory;

    public void setOutputFormat(List<Map<String,Object>> data, String format, HttpServletResponse httpServletResponse) throws IOException {
        OutputFormat outputFormat = outputFormatFactory.Create(data,format,httpServletResponse);
        //now we set the output  response
        outputFormat.setOutput();

    }
}
