package dev.manfertej.sherlock.service;

import dev.manfertej.sherlock.model.Product;
import dev.manfertej.sherlock.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final SearchRepository repository;

    /**
     * Hybrid query
     * @param query
     * @return
     */
    public List<Product> search(String query) {

        List<Product> result;

        try {
            result = repository.search(query);
        }
        catch (Exception e) {
            result = List.of();
        }

        return result;
    }


    public List<Product> textSearch(String query) {

        List<Product> result;

        try {
            result = repository.textSearch(query);
        }
        catch (Exception e) {
            result = List.of();
        }

        return result;
    }

}
