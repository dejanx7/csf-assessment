package vttp2023.batch3.csf.assessment.cnserver.repositories;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NewsRepository {

	@Autowired
	MongoTemplate template;

	// TODO: Task 1 
	// Write the native Mongo query in the comment above the method
	public void postNews(Document news){
		template.insert(news, "news");
		
	}
	

	// TODO: Task 2 
	// Write the native Mongo query in the comment above the method


	// TODO: Task 3
	// Write the native Mongo query in the comment above the method


}
