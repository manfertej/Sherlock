# Sherlock
My Bachelor's final project

A semantic search application powered by Elasticsearch and public embeddings model.


## Dependencies 
### Elasticsearch
Version: 8.19.12
```bash
docker run -d \
  --name elasticsearch \
  -p 9200:9200 \
  -e "discovery.type=single-node" \
  -e "xpack.security.enabled=false" \
  -e "ES_JAVA_OPTS=-Xms1g -Xmx1g" \
  docker.elastic.co/elasticsearch/elasticsearch:8.19.12
```

### Vector
For the project to work is necessary to have a connection to some vectorization 
model to generate embeddings.

For that you can use [this project](https://github.com/manfertej/vector-service).<br>
To replace it, you need to change `feign.vector.url` and `feign.vector.endpoint`


## Endpoints

## Resources
The data used to build this project comes from: <br> 
https://www.kaggle.com/datasets/computingvictor/mercadoan-inventory