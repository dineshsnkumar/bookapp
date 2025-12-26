package io.projects.book_search_service.config

import org.elasticsearch.client.RestHighLevelClient
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration

@Configuration
class ElasticSearchConfig: AbstractElasticsearchConfiguration() {
    override fun elasticsearchClient(): RestHighLevelClient {
        TODO("Not yet implemented")
    }
}