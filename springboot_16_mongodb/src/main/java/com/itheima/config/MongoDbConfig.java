package com.itheima.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Arrays;

@Configuration
public class MongoDbConfig extends AbstractMongoClientConfiguration {


        @Value("${spring.data.mongodb.uri}")
        private String connectionString;

        @Value("${spring.data.mongodb.username}")
        private String userName;

        @Value("${spring.data.mongodb.password}")
        private String password;

        @Value("${spring.data.mongodb.authentication-database}")
        private String authDatabase;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Override
        protected void configureClientSettings(MongoClientSettings.Builder builder) {
            //设置MongoDB客户端连接选项
            builder.applyToClusterSettings(settings ->
                    settings.hosts(Arrays.asList(new ServerAddress("localhost", 27017))));
        }

        @Override
        public MongoClient mongoClient() {
            //创建MongoDB客户端实例
            MongoCredential credential = MongoCredential.createCredential(userName, authDatabase, password.toCharArray());
            return MongoClients.create(MongoClientSettings.builder()
                    .applyToClusterSettings(builder ->
                            builder.hosts(Arrays.asList(new ServerAddress("localhost", 27017))))
                    .credential(credential)
                    .build());
        }

        @Bean
        public MongoTemplate mongoTemplate() {
            //创建MongoTemplate实例
            return new MongoTemplate(mongoClient(), database);
        }
}
