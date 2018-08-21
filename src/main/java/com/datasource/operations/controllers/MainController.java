package com.datasource.operations.controllers;


import com.datasource.operations.models.QueryExecuterRequest;
import com.datasource.operations.repository.QueryExcecuterRepository;
import com.datasource.operations.services.ConnectionHandlerService;
import com.datasource.operations.services.OutputFormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/1.0")
public class MainController
{

   @Autowired
   ConnectionHandlerService connectionHandlerService;

   @Autowired
    OutputFormatService outputFormatService;


    @CrossOrigin
    @RequestMapping(value = "/executeQuery", method = RequestMethod.POST)
    public void executeQuery(@RequestBody QueryExecuterRequest queryExecuterRequest, HttpServletResponse response) throws IOException {

        QueryExcecuterRepository queryExcecuterRepository = connectionHandlerService.getConnection(queryExecuterRequest.getDataSource());
        List<Map<String, Object>> objectsList =  queryExcecuterRepository.queryTypeSelector(queryExecuterRequest.getQuery());
        outputFormatService.setOutputFormat(objectsList,queryExecuterRequest.getOutputFormat(),response);

    }

}
