package com.example.synergybackend;

import com.example.synergybackend.repository.MCQRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.synergybackend.model.Mcq;
import com.example.synergybackend.model.Choice;

import java.util.ArrayList;

import static com.mongodb.assertions.Assertions.assertNotNull;

@SpringBootTest
class SynergyBackendApplicationTests {
	@Autowired
	MCQRepository mcqRepository;

	@Test
	public void testCreateMcq(){

		Mcq m=new Mcq();
		ArrayList<Choice> choices=new ArrayList<Choice>();
		//choices.add("opt1");
		m.setId("01t");
		m.setQuestion("testing");
		m.setChoices(choices);
		m.setGoogleId("001");
		mcqRepository.save(m);
		assertNotNull(mcqRepository.findById("01t").get());
	}

}
