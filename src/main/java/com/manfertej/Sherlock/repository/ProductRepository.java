package com.manfertej.Sherlock.repository;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
@RequiredArgsConstructor
@PropertySource("classpath:elastic.properties")
public class ProductRepository {

    private final ElasticsearchClient client;
    private final MessageSource messageSource;
    //private BulkIngester<Void> ingester;

    @Value("${index.name}")
    private String indexName;
    @Value("${index.idField}")
    private String idField;





    public Object search(String query, ArrayNode vectorizedQuery) throws IOException {


        SearchResponse<ObjectNode> response = client.search(s -> s
                .index(indexName)
                        .query(q -> q
                                .multiMatch(v -> v
                                        .query(query)
                                        .fields("name", "description")))
                ,ObjectNode.class
        );
        return null;
    }





    public void index(ObjectNode node) throws IOException {

        IndexResponse ir = this.client.index(i -> i.index(indexName).id(idField).document(node));
    }



}
