package com.manfertej.Sherlock.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manfertej.Sherlock.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;


    @GetMapping
    public ObjectNode hybridSearch() {
        return null;
    }

    @GetMapping("/text")
    public ObjectNode textSearch() {
        return null;
    }

    @GetMapping("/vector")
    public ObjectNode vectorSearch() {
        return null;
    }

}
