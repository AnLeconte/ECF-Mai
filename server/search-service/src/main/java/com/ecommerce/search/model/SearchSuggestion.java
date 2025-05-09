package com.ecommerce.search.model;

public class SearchSuggestion {
    private String id;
    private String text;
    private String type;
    private double score;

    public SearchSuggestion() {}

    public SearchSuggestion(String id, String text, String type, double score) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.score = score;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }
}
