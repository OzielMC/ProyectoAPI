package com.example.demo.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class inicio {
	@GetMapping("/")
	public String inicio() {
		return "inicio";
	}
}
