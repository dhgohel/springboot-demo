package com.example.demo.helpers;

import com.example.demo.models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import java.io.IOException;


@Component
public class ExcelUtility {

    Logger logger = LogManager.getLogger(ExcelUtility.class);

    public void writeResponseOneToExcel(ApiResponseOne[] apiCallOneList, String sheetName, Workbook workbook) throws IOException {

        logger.info("Inside Excel Utility writeResponseOneToExcel - 1");

        try {
            Sheet sheet = workbook.getSheet(sheetName);

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Name");
            header.createCell(2).setCellValue("Email");

            int rowNum = 1;
            for (ApiResponseOne user : apiCallOneList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getName());
                row.createCell(2).setCellValue(user.getEmail());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeResponseTwoToExcel(ApiResponseTwo[] apiCallOneList, String sheetName, Workbook workbook) throws IOException {

        logger.info("Inside Excel Utility writeResponseOneToExcel - 2");

        try {

            Sheet sheet = workbook.getSheet(sheetName);

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Name");
            header.createCell(2).setCellValue("Email");

            int rowNum = 1;
            for (ApiResponseTwo user : apiCallOneList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getName());
                row.createCell(2).setCellValue(user.getEmail());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeResponseThreeToExcel(ApiResponseThree[] apiCallOneList, String sheetName, Workbook workbook) throws IOException {

        logger.info("Inside Excel Utility writeResponseOneToExcel - 3");

        try{

            Sheet sheet = workbook.getSheet(sheetName);

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Name");
            header.createCell(2).setCellValue("Email");

            int rowNum = 1;
            for (ApiResponseThree user : apiCallOneList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getName());
                row.createCell(2).setCellValue(user.getEmail());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeResponseFourToExcel(ApiResponseFour[] apiCallOneList, String sheetName, Workbook workbook) throws IOException {

        logger.info("Inside Excel Utility writeResponseOneToExcel - 4");

        try{

            Sheet sheet = workbook.getSheet(sheetName);

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Name");
            header.createCell(2).setCellValue("Email");

            int rowNum = 1;
            for (ApiResponseFour user : apiCallOneList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getName());
                row.createCell(2).setCellValue(user.getEmail());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeResponseFiveToExcel(ApiResponseFive[] apiCallOneList, String sheetName, Workbook workbook) throws IOException {

        logger.info("Inside Excel Utility writeResponseOneToExcel - 5");

        try{

            Sheet sheet = workbook.getSheet(sheetName);

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Name");
            header.createCell(2).setCellValue("Email");

            int rowNum = 1;
            for (ApiResponseFive user : apiCallOneList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getName());
                row.createCell(2).setCellValue(user.getEmail());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

