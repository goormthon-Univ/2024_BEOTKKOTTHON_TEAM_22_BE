package fairy.spring.fairy;

import fairy.spring.fairy.Community.Request.CommunityRequest;
import fairy.spring.fairy.Community.controller.Questioncontroller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FairyApplicationTests {
	@Autowired
	private Questioncontroller questioncontroller;



	@Test
	void contextLoads() {

		CommunityRequest communityRequest = new CommunityRequest();
		CommunityRequest.questionRequestDTO questionRequestDTO = communityRequest.new questionRequestDTO();


		String title = "Test Title";
		String content = "This is test content.";




		questionRequestDTO.setContent(title);
		questionRequestDTO.setTitle(content);
		questioncontroller.createQuestion(questionRequestDTO);


	}

}
