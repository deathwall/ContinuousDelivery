package com.fr.training.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {
	
    @RequestMapping("/error")
    String error() {
        return "C EST DE LA MERDE";
    }
}
