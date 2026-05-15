package dev.manfertej.sherlock.repository;


public class TextSearchRepository {
    String query = """
    {
        "query": {
        "multi_match": {
            "query": "pizza",
            "fields": ["name", "subtitle"]
        }
    }
    """;
}
