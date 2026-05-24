package dev.manfertej.sherlock.repository;


import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import dev.manfertej.sherlock.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SearchRepository {

    private final ElasticsearchClient client;
    private static final String INDEX_NAME = "products";


    /**
     * Use hybrid search to query the products index
     * @param query
     * @return
     * @throws Exception
     */
    public List<Product> search(String query, List<Float> vectorizedQuery) throws Exception {

        SearchResponse<Product> result = client.search(s ->s
                .index(INDEX_NAME)
                .query(q -> q
                        .multiMatch(m -> m
                                .query(query)
                                .fields(List.of("name", "subtitle"))))
                        .knn(k -> k
                                .queryVector(vectorizedQuery)
                                .field("embedding")
                                .k(10)
                                .numCandidates(100))
                .source(src -> src
                        .filter(f -> f
                                .excludes("embedding")))
                ,Product.class
        );

        return result.hits().hits().stream()
                .map(Hit::source)
                .toList();
    }


    /**
     *
     * @param query
     * @return
     * @throws Exception
     */
    public List<Product> textSearch(String query) throws Exception {

        SearchResponse<Product> result = client.search(s ->s
                        .index(INDEX_NAME)
                        .query(q -> q
                                .multiMatch(m -> m
                                        .query(query)
                                        .fields(List.of("name", "subtitle"))))
                        .source(src -> src
                                .filter(f -> f
                                        .excludes("embedding")))
                ,Product.class
        );

        return result.hits().hits().stream()
                .map(Hit::source)
                .toList();
    }


    public List<Product> vectorSearch(List<Float> vectorizedQuery) throws Exception {

        SearchResponse<Product> result = client.search(s ->s
                        .index(INDEX_NAME)
                        .knn(k -> k
                                .queryVector(vectorizedQuery)
                                .field("embedding")
                                .k(10)
                                .numCandidates(100))
                        .source(src -> src
                                .filter(f -> f
                                        .excludes("embedding")))
                ,Product.class
        );

        return result.hits().hits().stream()
                .map(Hit::source)
                .toList();
    }

}
