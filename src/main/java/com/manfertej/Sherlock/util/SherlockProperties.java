package com.manfertej.Sherlock.util;


import co.elastic.clients.elasticsearch.ml.put_trained_model.Weights;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class SherlockProperties {

    private String indexName;
    private List<String> searchableFields;
    private List<String> responseFields;
    private int responseSize;
    private String customQuery;
    private Weights weights;
}
