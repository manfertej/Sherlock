package dev.manfertej.sherlock.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import dev.manfertej.sherlock.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


@Service
@SuppressWarnings({"rawtypes", "unchecked"})
public class IndexService {


    public void indexFile(MultipartFile file) throws Exception {

        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Product.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build();

            Stream<Product> stream = StreamSupport.stream(
                    Spliterators.spliteratorUnknownSize(
                            csvToBean.iterator(),
                            Spliterator.ORDERED
                    ),
                    false
            );

            stream.forEach(this::print);

        } catch (Exception ex) {
            throw new Exception(ex.getCause().getMessage());
        }

    }


    private void print(Product product) {
        System.out.println(product);
    }

}
