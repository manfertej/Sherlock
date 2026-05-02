package dev.manfertej.sherlock.configuration;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.net.URISyntaxException;


@Configuration
public class ElasticsearchConfiguration {

  @Value("${elasticsearch.url}")
  private String URL;

  @Bean
  public ElasticsearchClient elasticsearchClient() throws URISyntaxException {

      RestClient restClient = RestClient.builder(HttpHost.create("localhost:9200"))
              .build();

      ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

      return new ElasticsearchClient(transport);

  }
}
