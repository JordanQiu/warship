package org.sevenup.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
@Configuration
@EnableMongoRepositories
public class RepositoryConfiguration extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		 return "test";
	}

	@Override
	public Mongo mongo() throws Exception {
		MongoClient mongoClient = new MongoClient("127.0.0.1");
		mongoClient.setWriteConcern(WriteConcern.SAFE);
		return mongoClient;
	}
	  @Override  
	    public @Bean MongoTemplate mongoTemplate() throws Exception {  
	   
	        return new MongoTemplate(mongo(),"test");  
	    } 
//    @Bean
//    public MongoFactoryBean mongo() {
//        MongoFactoryBean mongo = new MongoFactoryBean();
//        mongo.setHost("localhost");
//        mongo.setPort(27017);
//        return mongo;
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() throws Exception{
//        return new MongoTemplate(mongo().getObject(),"test");
//    }

}
