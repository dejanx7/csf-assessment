package vttp2023.batch3.csf.assessment.cnserver.services;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2023.batch3.csf.assessment.cnserver.models.News;
import vttp2023.batch3.csf.assessment.cnserver.models.TagCount;
import vttp2023.batch3.csf.assessment.cnserver.repositories.NewsRepository;

@Service
public class NewsService {

	@Autowired
	NewsRepository repo;
	
	// TODO: Task 1
	// Do not change the method name and the return type
	// You may add any number of parameters
	// Returns the news id
	public String postNews(News news) {

		String id = UUID.randomUUID().toString().substring(0, 8);

		Document newsDoc = new Document();

		// JsonReader reader = Json.createReader(new StringReader(news));
		// JsonObject newsObj = reader.readObject();

		// newsDoc.append("_id", id);
		// newsDoc.append("postDate", System.currentTimeMillis());
		// newsDoc.append("title", newsObj.getString("title"));
		// newsDoc.append("description", newsObj.getString("description"));
		// newsDoc.append("image", newsObj.getString("image"));
		// newsDoc.append("tags", newsObj.getString("tags"));


		newsDoc.append("_id", id);
		newsDoc.append("postDate", System.currentTimeMillis());
		newsDoc.append("title", news.getTitle());
		newsDoc.append("description", news.getDescription());
		newsDoc.append("image", news.getImage());
		newsDoc.append("tags", news.getTags());


		repo.postNews(newsDoc);

		System.out.println("id is " + id);


		return id;
		
	}
	 
	// TODO: Task 2
	// Do not change the method name and the return type
	// You may add any number of parameters
	// Returns a list of tags and their associated count
	public List<TagCount> getTags(/* Any number of parameters */) {
		return new LinkedList<>();
	}

	// TODO: Task 3
	// Do not change the method name and the return type
	// You may add any number of parameters
	// Returns a list of news
	public List<News> getNewsByTag(/* Any number of parameters */) {
		return new LinkedList<>();
	}
	
}
