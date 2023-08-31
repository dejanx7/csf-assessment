package vttp2023.batch3.csf.assessment.cnserver.controllers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import vttp2023.batch3.csf.assessment.cnserver.models.News;
import vttp2023.batch3.csf.assessment.cnserver.repositories.ImageRepository;
import vttp2023.batch3.csf.assessment.cnserver.services.NewsService;

@RestController
@RequestMapping
@CrossOrigin
public class NewsController {

	@Autowired
	NewsService service;
	@Autowired
	ImageRepository imageRepo;

	// TODO: Task 1
	@PostMapping(path="/postnews", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> postNews(@RequestPart String title, @RequestPart String description, @RequestPart String photo, @RequestPart String tags){

		String[] arrOfTag = tags.split(" ", 0);

		List<String> tagList = new ArrayList<>();

		for (String t : arrOfTag) {

			tagList.add(t);
			
		}

		System.out.println("taglist is " + tagList);

		News news = new News();
		news.setTitle(title);
		news.setDescription(description);
		news.setImage(photo);
		news.setTags(tagList);

		String id =  service.postNews(news);

		JsonObject success = Json.createObjectBuilder()
			.add("News ID", id)
			.add("Message", "successfully added")
			.build();

		
			
		return ResponseEntity.ok(success.toString());

	}

	@PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> uploadFile(@RequestPart MultipartFile file) {

        try {
            String id = imageRepo.uploadFile(file);
            JsonObject successJson = Json.createObjectBuilder()
                    .add("success", id)
                    .build();

            return ResponseEntity.status(200).body(successJson.toString());

        } catch (Exception e) {
            e.printStackTrace();
            JsonObject errorJson = Json.createObjectBuilder()
                    .add("error", e.getMessage())
                    .build();

            return ResponseEntity.status(500).body(errorJson.toString());

        }

    }



	// TODO: Task 2


	// TODO: Task 3

}
