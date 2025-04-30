package com.example.demo.services;


import com.example.demo.clients.ApiCallOneClient;
import com.example.demo.helpers.ExcelUtility;
import com.example.demo.models.*;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class DemoService {

    Logger logger = LogManager.getLogger(DemoService.class);

    @Autowired
    ApiCallOneClient apicallOne;

    @Autowired
    ExcelUtility excelUtilty;

    public void getDataFromServices(HttpServletResponse response) throws IOException {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        try (InputStream inputStream = new ClassPathResource("templates/template.xlsx").getInputStream();
             Workbook workbook = new XSSFWorkbook(inputStream)) {
            ExcelUtility excelUtilty = new ExcelUtility();

            CountDownLatch latch = new CountDownLatch(5);

            // Task 1 - API One
            executor.submit(() -> {
                try {
                    ApiResponseOne[] apiResponseDataList = apicallOne.fetchDataForAPIOne();
                    synchronized (workbook) {
                        excelUtilty.writeResponseOneToExcel(apiResponseDataList, "API-1-Data", workbook);
                    }
                } catch (Exception e) {
                    System.err.println("API 1 failed: " + e.getMessage());
                } finally {
                    latch.countDown();
                }
            });

            // Task 2 - API Two
            executor.submit(() -> {
                try {
                    ApiResponseTwo[] apiResponseDataList = apicallOne.fetchDataForAPITwo();
                    synchronized (workbook) {
                        excelUtilty.writeResponseTwoToExcel(apiResponseDataList, "API-2-Data", workbook);
                    }
                } catch (Exception e) {
                    System.err.println("API 2 failed: " + e.getMessage());
                } finally {
                    latch.countDown();
                }
            });

            // Task 3 - API Three
            executor.submit(() -> {
                try {
                    ApiResponseThree[] apiResponseDataList = apicallOne.fetchDataForAPIThree();
                    synchronized (workbook) {
                        excelUtilty.writeResponseThreeToExcel(apiResponseDataList, "API-3-Data", workbook);
                    }
                } catch (Exception e) {
                    System.err.println("API 3 failed: " + e.getMessage());
                } finally {
                    latch.countDown();
                }
            });

            // Task 4 - API Four
            executor.submit(() -> {
                try {
                    ApiResponseFour[] apiResponseDataList = apicallOne.fetchDataForAPIFour();
                    synchronized (workbook) {
                        excelUtilty.writeResponseFourToExcel(apiResponseDataList, "API-4-Data", workbook);
                    }
                } catch (Exception e) {
                    System.err.println("API 4 failed: " + e.getMessage());
                } finally {
                    latch.countDown();
                }
            });

            // Task 5 - API Five
            executor.submit(() -> {
                try {
                    ApiResponseFive[] apiResponseDataList = apicallOne.fetchDataForAPIFive();
                    synchronized (workbook) {
                        excelUtilty.writeResponseFiveToExcel(apiResponseDataList, "API-5-Data", workbook);
                    }
                } catch (Exception e) {
                    System.err.println("API 5 failed: " + e.getMessage());
                } finally {
                    latch.countDown();
                }
            });

            // Wait for all threads
            try {
                latch.await();
                executor.shutdown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=template.xlsx");

            workbook.write(response.getOutputStream());

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
