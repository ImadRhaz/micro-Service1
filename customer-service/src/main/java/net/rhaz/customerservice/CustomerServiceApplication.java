package net.rhaz.customerservice;

import jakarta.xml.bind.annotation.XmlElementDecl;
import net.rhaz.customerservice.config.GlobalConfig;
import net.rhaz.customerservice.entities.Customer;
import net.rhaz.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({GlobalConfig.class})
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {

            List<Customer> customerList=List.of(
                    Customer.builder()
                            .firstName("Imad")
                                .lastName("Rhazouani")
                            .email("rhazouani@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("Prenom")
                            .lastName("Nom")
                            .email("Nom@gmail.com")
                            .build()

            );
            customerRepository.saveAll(customerList);
        };
    }

}