package dev.manfertej.sherlock.controller;

import dev.manfertej.sherlock.model.Product;
import dev.manfertej.sherlock.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {


    private final SearchService searchService;

    @GetMapping
    public List<Product> search(@RequestParam String query) {
        return searchService.search(query);
    }

    @GetMapping("/text")
    public List<Product> textSearch(@RequestParam String query) {
        return searchService.textSearch(query);
    }

}
