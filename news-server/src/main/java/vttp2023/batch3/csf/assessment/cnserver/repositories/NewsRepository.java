package vttp2023.batch3.csf.assessment.cnserver.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.ScrollPosition.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.DocumentEndEvent;

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

	public List<Document> getAllTags(){

			// db.news.aggregate([
			// {$unwind : "$tags"},
			// {$sort : {postDate : 1}},
			// {$project : {_id : -1, tags : 1}}

			// ])
		UnwindOperation unwindTag = Aggregation.unwind("tags");
		SortOperation sortByPostDate = Aggregation.sort(Sort.Direction.ASC, "postDate");
		ProjectionOperation projectTag = Aggregation.project("_id", "tags");
		Aggregation pipeline = Aggregation.newAggregation(unwindTag, sortByPostDate, projectTag);
		AggregationResults<Document> results = template.aggregate(pipeline, "news", Document.class);
		return results.getMappedResults();

	}


	// TODO: Task 3
	// Write the native Mongo query in the comment above the method

	public void getNewsByTag(){

		// db.news.find({tags : "<tag>"})

	}


}
