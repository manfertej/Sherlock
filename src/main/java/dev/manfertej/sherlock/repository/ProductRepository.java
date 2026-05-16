package dev.manfertej.sherlock.repository;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.elasticsearch.indices.ExistsRequest;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final ElasticsearchClient client;
    private static final String INDEX_NAME = "products";

    @PostConstruct
    private void initialize() throws Exception {

        if(indexExists()) {
            log.info("Index already exists");
            return;
        }

        client.indices().create(c -> c
                .index(INDEX_NAME)
                .withJson(mapping()));

        log.info("Index Created");
    }



    private boolean indexExists() throws IOException {
        return client.indices().exists(ExistsRequest.of(request -> request.index(INDEX_NAME))).value();
    }

    private InputStream mapping() {
        //FIXME: This is horrible, but shouldn't be a problem (For now...)
        try {
            File file = ResourceUtils.getFile("classpath:mapping.json");
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            log.error("Mapping not found");
            return null;
        }
    }

}
