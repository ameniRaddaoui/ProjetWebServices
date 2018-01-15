package tn.iit.projet.controllers;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import tn.iit.projet.dao.CoursRepositorie;
import tn.iit.projet.dao.SeanceRepositorie;
import tn.iit.projet.entities.Cours;
import tn.iit.projet.entities.Enseignant;
import tn.iit.projet.entities.Seance;

@Controller
@RequestMapping("user/acceuilAgent")
public class AgentController {

	@Autowired
	private SeanceRepositorie seanceDao;
	
	@Autowired
	private CoursRepositorie coursDao;
	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getSeances(HttpServletRequest request, HttpServletResponse response) {
		
		List<Seance> seances = seanceDao.findAll();

		ModelAndView model = new ModelAndView("acceuilAgent");
		
		model.addObject("seances", seances);
		
		
		return model;
	}
	@RequestMapping(value = "filtrer", method = RequestMethod.POST)
	public ModelAndView filtrer(@RequestParam Long seance, @RequestParam String date,
			HttpServletRequest request, HttpServletResponse response) {
		
		List<Seance> seances = seanceDao.findAll();

		

		ModelAndView model = new ModelAndView("acceuilAgent");
		
		
		
		request.setAttribute("date", date);
		request.setAttribute("seance", seance);
		Seance seance2 = seanceDao.getOne(Long.valueOf(seance));
		
		List<Cours> cours = seance2.getCours();
		
		model.addObject("cours", cours);
		model.addObject("seances", seances);
		
		
		return model;
	}
	
	@RequestMapping(value = "envoie", method = RequestMethod.POST)
	public RedirectView createOrUpdateConge(HttpServletRequest request, HttpServletResponse response) {
		
		String date = request.getParameter("date");
		String seance = request.getParameter("seance");

		Seance seance2 = seanceDao.getOne(Long.valueOf(seance));

		String[] cours = request.getParameterValues("cours");

		for (String id : cours) {
			try{
				Cours coursc = coursDao.getOne(Long.valueOf(id));
				SendMail(coursc.getEnseignant(),date,seance2.getLibelle());
			}catch(Exception e){
				 
			}
		}
	 return new RedirectView("list");
			
		
	}
	
	private void SendMail(Enseignant enseignant,String date, String seance) {

		

		final String username = "ameniraddaoui1@gmail.com";
		final String password = "AmaniRaddaoui1234";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-email@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(enseignant.getEmail()));

			message.setSubject("Absence");
			message.setText("Bonjour "+enseignant.getNom() +" "+ enseignant.getPrenom()
			+ "\n\n Je voulais vous informer que vous étiez absents le " + date + " pendant la séance "+ seance 
			+ " \n merci de prévoir votre ratrappage ! \n\n coordialement .");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
}
