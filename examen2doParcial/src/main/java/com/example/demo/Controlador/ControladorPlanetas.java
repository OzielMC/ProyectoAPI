package com.example.demo.Controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.Models.Planetas;

import org.springframework.web.client.RestTemplate;


@Controller
@RequestMapping("/Planetas")
public class ControladorPlanetas {

	@GetMapping("{cl}")
	public String startMethod (@PathVariable("cl") String cl, Model model) {
		String titulo = "Pagina API con Spring Boot";
		model.addAttribute("name", cl);
		model.addAttribute("titulo", titulo);
		Planetas startMunicipioDTO = startMunicipiosDTO (cl);
		model.addAttribute("startDTO", startMunicipioDTO);
		return "planetas";
	}
	
	public Planetas startMunicipiosDTO (String numID) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Planetas> resp =
				restTemplate
				.getForEntity(
						String.format("https://myappfb-4718b.firebaseio.com/campeche/planetas/%s"+".json", numID),
						Planetas.class);
		return resp.getBody();
	}
}

