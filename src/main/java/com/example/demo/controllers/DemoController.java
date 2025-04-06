package com.example.demo.controllers;

import com.example.demo.services.DemoService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DemoController {

    Logger logger = LogManager.getLogger(DemoController.class);

    @Autowired
    DemoService demoService;

    @GetMapping("/")
    public void getDataFromServices(HttpServletResponse response) throws IOException {
        logger.info("Inside DemoController");
        demoService.getDataFromServices(response);
    }

}
