package com.example.demo.helpers;

import com.example.demo.controllers.DemoController;
import com.example.demo.models.ApiResponseOne;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class ExcelUtility {

    Logger logger = LogManager.getLogger(ExcelUtility.class);

    public void writeResponseOneToExcel(ApiResponseOne[] apiCallOneList, HttpServletResponse response) throws IOException {

        logger.info("Inside Excel Utility writeResponseOneToExcel");
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Users");

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

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=users.xlsx");

        workbook.write(response.getOutputStream());
        workbook.close();
    }

}

