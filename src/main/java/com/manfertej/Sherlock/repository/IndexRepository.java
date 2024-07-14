package com.manfertej.Sherlock.repository;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.manfertej.Sherlock.exceptions.RepositoryException;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Locale;

@Repository
@RequiredArgsConstructor
@PropertySource("classpath:elastic.properties")
public class IndexRepository {

    private final ElasticsearchClient client;
    private final MessageSource messageSource;

    @Value("${index.name}")
    private String indexName;
    @Value("${index.idField}")
    private String idField;


    @PostConstruct
    public void start() throws Exception {

        if(checkIndex())
            return;

        String message = messageSource.getMessage(
                "index.notExist",
                null,
                Locale.ENGLISH);
        System.out.println(message);

        if(!createIndex()) {
            message = messageSource.getMessage(
                    "index.failedToCreate",
                    null,
                    Locale.ENGLISH
            );
            System.out.println(message);
        }
    }

    /**
     * Check if the index exists
     *
     * @throws RepositoryException
     */
    public boolean checkIndex() throws RepositoryException {

        try {
            return client.indices().exists(q -> q.index(indexName)).value();
        }
        catch (Exception e) {
            String message = messageSource.getMessage(
                    "index.existenceCheckFailed",
                    null,
                    Locale.ENGLISH);
            throw new RepositoryException(message, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }


    public boolean createIndex() throws RepositoryException {

        try {
            return client.indices().create(q -> q.index(indexName)).acknowledged();
        }
        catch (Exception e) {
            String message = messageSource.getMessage(
                    "index.creationFailed",
                    null,
                    Locale.ENGLISH);
            throw new RepositoryException(message,HttpStatus.SERVICE_UNAVAILABLE);
        }
    }


}
