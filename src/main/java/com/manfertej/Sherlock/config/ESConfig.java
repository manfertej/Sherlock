package com.manfertej.Sherlock.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.lang.NonNull;

@Configuration
@PropertySource("classpath:elastic.properties")
public class ESConfig extends ElasticsearchConfiguration {


    @Value("${elastic.url}")
    private String URL;


    @Override
    @NonNull
    public ClientConfiguration clientConfiguration() {

        return ClientConfiguration.builder()
                .connectedTo(URL)
                .build();
    }
}
