package ua.jdev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.jdev.data.Statistics;
import ua.jdev.data.VoteDAO;

@Controller
@RequestMapping("/")
public class WebController {
	private VoteDAO dao;
	
	@Autowired
	private void setDAO(VoteDAO dao) {
		this.dao = dao;
	}
	
	@GetMapping
	public String home(Model model) {
		Statistics statistics = dao.statistics();
		
		model.addAttribute("likes", statistics.likes());
		model.addAttribute("dislikes", statistics.dislikes());
		
		return "index";
	}
	
	@PostMapping("/like")
	public String like(Model model) {
		dao.vote(true);
		
		return "redirect:/";
	}
	
	@PostMapping("/dislike")
	public String dislike(Model model) {
		dao.vote(false);
		
		return "redirect:/";
	}
}
