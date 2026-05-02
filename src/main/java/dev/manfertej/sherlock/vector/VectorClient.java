package dev.manfertej.sherlock.vector;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "vector-service",
        url = "${feign.vector.url}")
public interface VectorClient {


    @GetMapping("${feign.vector.endpoint}/{string}")
    public List<Float> vector(@PathVariable String string);
}
