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


    public List<Float> vectorize(Product product) {

        List<Float> algo = null;
        try {
            algo = vectorClient.vector(Map.of(KEY, normalizeProduct(product)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return algo;
    }


    // In this case it's just the name
    // Usually we also use a detailed description, tags...
    // But that's not available in this dataset
    private String normalizeProduct(Product product) {
        return product.getName();
    }
}
