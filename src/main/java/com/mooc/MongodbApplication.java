package com.mooc;


import java.io.File;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mooc.dao.QuizRepository;
import com.mooc.entities.Question;
import com.mooc.entities.Quiz;



@SpringBootApplication
public class MongodbApplication implements CommandLineRunner{
	@Autowired
	private QuizRepository quizRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
		
		
		
		
		
	
        
	}
	@Override
	public void run(String... args) throws Exception {
		List<String> liste = new ArrayList<String>();
		liste.add("hcen");
		liste.add("hamza");
		String quest="quest";
		Question q=new Question(quest,liste);
		Question q1=new Question(quest,liste);
		String correction="123";
		List<Question> liste1=new ArrayList<Question>();
		liste1.add(q);
		liste1.add(q1);
	//	Quiz quiz =new Quiz(liste1,correction);
		
	
		
		
	//	quizRepository.save(quiz);
		
	}
	
}
