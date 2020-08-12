package com.indika.ninjagold.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

//	@RequestMapping("/")
//	public String index() {
//		return "redirect:/gold";
//	}
//	
	
//	@RequestMapping("/gold")    //session storage    1 - 
//	@GetMapping("/gold")
//	public String gold(HttpSession session) {
//		if(session.getAttribute("pouch") == null){
//			session.setAttribute("pouch", 0);
//			ArrayList<String> log = new ArrayList<String>();		}
//			session.setAttribute("log", log);
//		}
//		else{ return "Index.jsp";}
//	} 


	@GetMapping("/gold")
	public String gold(HttpSession session, Model model) {
		if( session.getAttribute("pouch") == null ) {
			session.setAttribute("pouch", 0);
			ArrayList<String> log = new ArrayList<String>();
			session.setAttribute("log", log);
		}
		
//		GRABBING THE CURRENT LOG FROM SESSION
		ArrayList<String> log = (ArrayList<String>) session.getAttribute("log");
//		PASSING THAT INFORMATION TO THE JSP
		model.addAttribute("log",log );
		return "Index.jsp";
	}


//	@RequestMapping(value="/processing_money", method=RequestMethod.POST)
	@PostMapping("/process_money")
	public String process(@RequestParam(value="place") String place,  HttpSession session, Model model){
		System.out.println(place);
		Date newDate = new Date();
		
		
		
//		DateFormat dateFormat = new SimpleDateFormat(" MMMM' YY DD ");
		
		//1 Grab current gold from current users session 
		int currentGold = (int) session.getAttribute("pouch");
		@SuppressWarnings("unchecked")
		ArrayList<String> log = (ArrayList<String>) session.getAttribute("log");
		//2 determine new amount of gold to be added
		if(place.equals("farm")) {
			int random_int = (int) ((Math.random() * (21-10) + 10));
			currentGold +=random_int;
			//System.out.println(random_int);
			//log.add(currentGold);
			String act = "You've made " + random_int + " from Farm " + newDate;
			System.out.println(currentGold);
			log.add(0, act);
			
			
		}
		
		else if(place.equals("cave")) {
			int random_int = (int) ((Math.random() * (11-5) + 5));
			currentGold +=random_int;
			//System.out.println(random_int);
			String act = "You've made " + random_int + " from Cave " + newDate;
			System.out.println(currentGold);
			log.add(0, act);
		}
		else if(place.equals("house")) {
			int random_int = (int) ((Math.random() * (6-2) + 2));
			currentGold +=random_int;
			//System.out.println(random_int);
			String act = "You've made " + random_int + "from House " + newDate;
			System.out.println(currentGold);
			log.add(0, act);
		}
		
		else if(place.equals("casino")) {
			int random_int = (int) ((Math.random() * (50 - -50) + -50));
			currentGold +=random_int;
			//System.out.println(random_int);
			if(random_int >0 ) {
				
				String act = "You've made " + random_int + " from Casino " + newDate;
				System.out.println(currentGold);
				log.add(0, act);
			}
			else {
				String act = "You've lost " + random_int + " from Casino " + newDate;
				System.out.println(currentGold);
				
				model.addAttribute("color", "red");
				log.add(0, act);
				
			}
			
//			String act = "You've made " + random_int + "from Casino";
//			System.out.println(currentGold);
//			log.add(0, act);
		}
		
		session.setAttribute("pouch", currentGold);
		session.setAttribute("log",log);
		return "redirect:/gold";
	}
	
	
	@GetMapping("/destroy_session")
	public String clear(HttpSession session) {
		session.invalidate();
		//session.setAttribute("pouch", 0);
		return "redirect:/gold";
	}
	
	
}
	
	
	
	

