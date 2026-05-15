package dev.manfertej.sherlock.vector;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@FeignClient(
        name = "vector-service",
        url = "${feign.vector.url}")
public interface VectorClient {


    @GetMapping("${feign.vector.endpoint}/{string}")
    public List<Float> vector(@PathVariable String string);

    @GetMapping
    public List<Float> vector(@RequestBody Map<String, String> param);

}
