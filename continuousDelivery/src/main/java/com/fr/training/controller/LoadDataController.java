package com.fr.training.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.training.data.initialization.DataImporter;

@RestController
public class LoadDataController {

    @RequestMapping("/loadData")
    String loadData() {
    	//DataImporter.importData();
        return "Data loading call ...";
    }

}
