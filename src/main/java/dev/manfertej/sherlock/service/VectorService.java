package dev.manfertej.sherlock.service;

import dev.manfertej.sherlock.model.Product;
import dev.manfertej.sherlock.vector.VectorClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class VectorService {

    private static final String KEY = "string";

    private final VectorClient vectorClient;

    public List<Float> vectorize(String string) {
        return null;
    }

    public List<Float> vectorize(Product product) {
        return vectorClient.vector(Map.of(KEY, normalizeProduct(product)));
    }


    private String normalizeProduct(Product product) {
        return "Antonio";
    }
}
