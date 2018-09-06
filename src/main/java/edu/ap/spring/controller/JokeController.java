package edu.ap.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.ap.spring.jpa.Grade;
import edu.ap.spring.jpa.GradeRepository;
import edu.ap.spring.jpa.Joke;
import edu.ap.spring.jpa.JokeRepository;

@Controller
@Scope("session")
public class JokeController {
   
   public JokeController() {
   }
   
   @Autowired
  JokeRepository repository;
       
   @RequestMapping("/joke")
   public String joke() {
	   return "joke";
   }
		   
   @RequestMapping("/joke_post")
   public String joke_post() {
	   return "";
   }
   
   
   @RequestMapping(path = "/api.icndb.com/jokes/random?firstName={firstName}&lastName={lastName}", method = RequestMethod.GET)
   public Joke setJoke(@PathVariable String firstName, @PathVariable String lastName) {
	return null;
      
   }

   
   @PostMapping("/joke")
   public String setGrade(@RequestParam("firstName") String firstName, 
		   				 @RequestParam("lastName") String lastName,
		   				 @RequestParam("joke") String joke,
		   				 Model model) {

      model.addAttribute("firstName", firstName);
      model.addAttribute("lastName", lastName);
      model.addAttribute("joke", joke);
      
      repository.save(new Joke(firstName, lastName, joke));
      
      return "result";
   }
   
   @RequestMapping("/")
   public String root() {
	   return "redirect:/joke";
   }
}
