package com.codebytes.datadive.datasockets.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DataSocketsManageController  {
    @GetMapping(value="/v1/data-sockets")
    public String getAllSockets() {
        return "{1:MySQL;2:MSSQL}";
    }
}