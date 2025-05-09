package com.ecommerce.search.service;

import com.ecommerce.search.model.SearchSuggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String COMMON_DATA_SERVICE_URL = "http://common-data-service/api/products";
    private static final int MAX_SUGGESTIONS = 5;

    public List<SearchSuggestion> getSuggestions(String query) {
        // Appel à l'API du common-data-service pour récupérer les produits
        List<Product> products = restTemplate.getForObject(COMMON_DATA_SERVICE_URL, List.class);
        
        // Filtrer et trier les produits selon la pertinence de la recherche
        List<SearchSuggestion> suggestions = products.stream()
            .filter(p -> p.getName().toLowerCase().contains(query.toLowerCase())
                || p.getDescription().toLowerCase().contains(query.toLowerCase()))
            .map(p -> new SearchSuggestion(
                p.getId(),
                p.getName(),
                "product",
                calculateRelevanceScore(p, query)
            ))
            .sorted((s1, s2) -> Double.compare(s2.getScore(), s1.getScore()))
            .limit(MAX_SUGGESTIONS)
            .collect(Collectors.toList());

        return suggestions;
    }

    private double calculateRelevanceScore(Product product, String query) {
        int nameMatchCount = countMatches(product.getName().toLowerCase(), query.toLowerCase());
        int descMatchCount = countMatches(product.getDescription().toLowerCase(), query.toLowerCase());
        
        // Score basé sur le nombre d'occurrences dans le nom et la description
        return (nameMatchCount * 2 + descMatchCount) / (double) (query.length() + 1);
    }

    private int countMatches(String text, String query) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(query, index)) != -1) {
            count++;
            index += query.length();
        }
        return count;
    }
}
