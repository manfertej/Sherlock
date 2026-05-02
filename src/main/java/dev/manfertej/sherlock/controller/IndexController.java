package dev.manfertej.sherlock.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import dev.manfertej.sherlock.vector.VectorClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/index")
@RequiredArgsConstructor
public class IndexController {


    private final ElasticsearchClient client;
    private final VectorClient vectorClient;

    @PostMapping("/file")
    public ResponseEntity indexFile(@RequestParam("catalog") MultipartFile file) {

        if(file.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("File is Empty");


        return null;
    }


    @PostMapping("/creteIndex")
    @SuppressWarnings("rawtypes")
    public ResponseEntity createIndex() throws IOException {
        

        CreateIndexResponse response = client.indices().create(builder -> builder
                .index("products"));

        return null;
    }


    @GetMapping("/vector")
    public List<Float> test() {
        return vectorClient.vector("Something");
    }

}
