package al.gred.simon.cykeltour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class CykelTourApplication {

    public static void main(String[] args) {
        SpringApplication.run(CykelTourApplication.class, args);
    }

    @GetMapping
    public String index() {
        return "redirect:/swagger-ui/index.html";
    }

}
