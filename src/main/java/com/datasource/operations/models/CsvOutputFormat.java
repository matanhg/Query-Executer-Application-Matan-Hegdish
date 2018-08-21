package com.datasource.operations.models;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvMapWriter;
import org.supercsv.io.ICsvMapWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CsvOutputFormat extends OutputFormat {


    public CsvOutputFormat(HttpServletResponse httpServletResponse, List<Map<String, Object>> data) {
        this.httpServletResponse = httpServletResponse;
        this.data = data;
    }

    @Override
    public void setOutput() throws IOException {
        String csvFileName = "CSVoutput.csv";
        httpServletResponse.setContentType("text/csv");
        // creates mock data
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        httpServletResponse.setHeader(headerKey, headerValue);
        ICsvMapWriter csvWriter = new CsvMapWriter(httpServletResponse.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        //if we have some data
        if(data.size() > 0 )
        {
            Map<String,Object> mapHeeaders =  data.get(0);
            List<String> headers = new ArrayList<>();
            mapHeeaders.forEach((k, v) -> headers.add(k));
            String[] headerArray = headers.toArray(new String[headers.size()]);
            CellProcessor[] processors = new CellProcessor[headers.size()];
            //init mapping
           for(int i = 0 ; i < processors.length ; i++)
            {
                processors[i] = new Optional();
            }
            csvWriter.writeHeader(headerArray);//write first line which is the headers
            for (Map<String,Object> mapEntry : data) {
                //loop over single dataObject
                csvWriter.write(mapEntry, headerArray,processors);

            }

            csvWriter.close();
        }
    }
}
