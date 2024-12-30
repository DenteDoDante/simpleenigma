package com.simpleenigma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SpringBootApplication
public class SimpleenigmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleenigmaApplication.class, args);
	}

	@GetMapping("/enigma")
	public String act(@RequestParam(value = "url", required = false) String url, Model model) {
		model.addAttribute("hint0", "what is god doing?");
		model.addAttribute("url", url);
		return "Enigma";

	}

	@GetMapping("/create")
	public String create(Model model) {

		model.addAttribute("hint1", "The act");
		return "Create";

	}

	@GetMapping("/creating")
	public String creating(RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("url", "creating");
		return "redirect:/enigma";
	}

	@GetMapping("/read")
	public String read(Model model) {

		model.addAttribute("hint2", "I think we need to...");
		return "Read";

	}

	@GetMapping("/update")
	public String update(Model model) {

		model.addAttribute("hint3", "Thanos wants to ______ everyone");
		return "Update";

	}

	@GetMapping("/delete")
	public String delete(Model model) {
		model.addAttribute("hint4", "Você já tem a resposta");
		return "Delete";
	}

	@GetMapping("/CRUD")
	public String correct(Model model) {
		model.addAttribute("correctAnswer", "The End");
		return "TheEnd";
	}

}
