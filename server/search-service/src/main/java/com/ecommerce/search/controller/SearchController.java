package com.ecommerce.search.controller;

import com.ecommerce.search.model.SearchSuggestion;
import com.ecommerce.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/suggestions")
    public ResponseEntity<List<SearchSuggestion>> getSuggestions(@RequestParam String query) {
        List<SearchSuggestion> suggestions = searchService.getSuggestions(query);
        return ResponseEntity.ok(suggestions);
    }
}
