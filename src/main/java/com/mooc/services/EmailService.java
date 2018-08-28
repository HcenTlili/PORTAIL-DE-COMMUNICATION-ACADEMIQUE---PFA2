package com.mooc.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.memorynotfound.mail.EmailService;
import com.mooc.dao.ClasseRepository;
import com.mooc.dao.CoursRepository;
import com.mooc.dao.EnseignantRepository;
import com.mooc.dao.EtudiantRepository;
import com.mooc.dao.ExamenRepository;
import com.mooc.dao.NotificationRepository;
import com.mooc.dao.QuizRepository;
import com.mooc.entities.Classe;
import com.mooc.entities.Cours;
import com.mooc.entities.Enseignant;
import com.mooc.entities.Etudiant;
import com.mooc.entities.Examen;
import com.mooc.entities.Mail;
import com.mooc.entities.Notification;
import com.mooc.entities.Quiz;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;
    
    @Autowired
    private NotificationRepository notificationRepository;
    
    @Autowired
    private CoursRepository coursRepository;
    
    @Autowired
    private ClasseRepository classeRepository;
    
    @Autowired
    private EnseignantRepository enseignantRepository;
    
    @Autowired
    private EtudiantRepository etudiantRepository;
    
    @Autowired
    private ExamenRepository examenRepository;
    
    @Autowired
    private QuizRepository quizRepository;
    
    @Autowired
    private EmailService emailService;
    
    @Autowired
    private JavaMailSender mailSender ;

    public void sendSimpleMessage(final Mail mail){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());
        message.setTo(mail.getTo());
        message.setFrom(mail.getFrom());

        emailSender.send(message);
    }
   /* @RequestMapping(value="/recapitulation", method=RequestMethod.GET)
	public List<Recap> Recapitulation() throws IOException
	{
    	
    	  List<Notification> liste1 = notificationRepository.findAll();
    		List<Classe> liste2 = classeRepository.findAll();
    		List<Cours> liste3 = coursRepository.findAll();
    		List<Enseignant> liste4 = enseignantRepository.findAll();
    		List<Etudiant> liste5 = etudiantRepository.findAll();
    		List<Examen> liste6 = examenRepository.findAll();
    		List<Quiz> liste7 = quizRepository.findAll();
 
	}*/
  
    @RequestMapping(value="/mail/{mailResponsable:.+}/{inclusion}/{classe}", method=RequestMethod.GET)
	public List<Notification> mail(@PathVariable String mailResponsable,@PathVariable String inclusion,@PathVariable String classe) throws IOException
	{
    	List<Notification> liste8 = notificationRepository.findAll();
		List<Notification> liste1 =new ArrayList<Notification>();
		for(int i =0;i<liste8.size();i++)
		{
		
			
				if(liste8.get(i).getClasse().equals(classe))
				{
					liste1.add(liste8.get(i));
				}
			
		}
		
    	//  List<Notification> liste1 = notificationRepository.findAll();
    		List<Classe> liste2 = classeRepository.findAll();
    		List<Cours> liste3 = coursRepository.findAll();
    		List<Enseignant> liste4 = enseignantRepository.findAll();
    		List<Etudiant> liste5 = etudiantRepository.findAll();
    		List<Examen> liste6 = examenRepository.findAll();
    		List<Quiz> liste7 = quizRepository.findAll();
  String contenu = "Notre MOOC contient "+ liste2.size()+ " classes ,"+ liste4.size() +" enseignants ,"+liste5.size()+ " etudiants ," + liste3.size() + " cours ," + liste6.size() + " examens et "+liste7.size() + " quizs " ;
    		 Mail mail = new Mail();
    	        mail.setFrom("tlilihcen@gmail.com");
    	        mail.setTo(mailResponsable);
    	        mail.setSubject("Mail récapitulatif ");
    	        if(inclusion.equals("true"))
    	        {
    	        mail.setContent(contenu);
    	        }
    	        else{
    	        	 mail.setContent("ci-joint le fichier qui concerne votre institution");
    	        }
    	        File fichier = new File("C:\resume.txt");
    	        if (! fichier.exists())
    	        {
    	        	BufferedWriter writer = new BufferedWriter(new FileWriter(new File("resume.txt")));
    	        	
    	        	for(int i =0; i<liste1.size();i++)
    	        	{
    	        		writer.write(liste1.get(i).getContenu()+"\n");
    	        	}
    	        	writer.close();
    	        }
    	        //nomFichier.createNewFile();

    	       // emailService.sendSimpleMessage(mail);
    	        MimeMessage message = mailSender.createMimeMessage();
    	        try{
    	        
    			
    	 	   
    	 		MimeMessageHelper helper = new MimeMessageHelper(message, true);
    	 			
    	 		helper.setFrom(mail.getFrom());
    	 		helper.setTo(mail.getTo());
    	 		helper.setSubject(mail.getSubject());
    	 		helper.setText(String.format(
    	 			mail.getContent()));
    	 			
    	 		FileSystemResource file = new FileSystemResource("resume.txt");
    	 		helper.addAttachment(file.getFilename(), file);

    	 	     }catch (MessagingException e) {
    	 		throw new MailParseException(e);
    	 	     }
    	 	     mailSender.send(message);
    	          
    	
    	        return liste1;
	}
  
}
