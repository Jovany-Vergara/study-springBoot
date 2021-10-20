package net.jovany.empleos

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

@Controller
@SpringBootApplication
class EmpleosApplication {

	@RequestMapping("/home")
	@ResponseBody
	String home() {
		return "home";
	}

	static void main(String[] args) {
		SpringApplication.run(EmpleosApplication, args)
	}

}
