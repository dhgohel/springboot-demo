package com.example.demo.services;


import com.example.demo.clients.ApiCallOneClient;
import com.example.demo.helpers.ExcelUtility;
import com.example.demo.models.ApiResponseOne;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DemoService {

    Logger logger = LogManager.getLogger(DemoService.class);

    @Autowired
    ApiCallOneClient apicallOne;

    @Autowired
    ExcelUtility excelUtilty;

    public void getDataFromServices(HttpServletResponse response) throws IOException {
        //API One Call
        ApiResponseOne[] apiResponseDataList = apicallOne.fetchDataForAPIOne(response);

        //Write API Call One response to Excel
        excelUtilty.writeResponseOneToExcel(apiResponseDataList, response);

        //API two Call

        //Write API Call two response to Excel

    }

}
