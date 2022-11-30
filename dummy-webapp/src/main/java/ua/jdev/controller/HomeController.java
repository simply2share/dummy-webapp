package ua.jdev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	private int likes = 0;
	private int dislikes = 0;
	
	@GetMapping({ "/", "/home" })
	public String home(Model model) {
		
		model.addAttribute("likes", likes);
		model.addAttribute("dislikes", dislikes);
		
		return "index";
	}
	
	@GetMapping("/like")
	public String like(Model model) {
		likes++;
		
		return "redirect:/";
	}
	
	@GetMapping("/dislike")
	public String dislike(Model model) {
		dislikes++;
		
		return "redirect:/";
	}
}
