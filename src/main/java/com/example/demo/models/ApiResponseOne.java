package com.example.demo.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ApiResponseOne {
    private int id;
    private String name;
    private String email;
}
