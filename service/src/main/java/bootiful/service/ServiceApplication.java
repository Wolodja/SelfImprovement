package bootiful.service;

import org.springframework.ai.client.AiClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Map;

@SpringBootApplication
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

}

interface CustomerRepository extends ListCrudRepository<Customer, Integer>{}
record Customer (@Id Integer id, String name){}

@Controller
@ResponseBody
class CustomerController {
	private final CustomerRepository customerRepository;

    CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

	@GetMapping("/customers")
	Collection<Customer> customers(){
		return customerRepository.findAll();
	}
}

@Controller
@ResponseBody
class StoryController {
	private final AiClient singularity;

    StoryController(AiClient singularity) {
        this.singularity = singularity;
    }

	@GetMapping("/story")
	Map<String, String> story() {

		var prompt = """
    
    			Dear Singularity,
    			
    			Would you please tell me a story about the wonderful CERN research center in Switzerland and France. 
    			
    			About its people, local food and amazing culture.
    			
    			Also, please write it in the style of famed children author Dr. Seuss.
    			
    			Cordially,
    			Josh
    
				""";

		return Map.of("story", singularity.generate(prompt) );
	}
}