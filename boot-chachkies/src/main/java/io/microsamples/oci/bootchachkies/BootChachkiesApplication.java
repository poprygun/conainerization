package io.microsamples.oci.bootchachkies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class BootChachkiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootChachkiesApplication.class, args);
	}

}

@RestController
class ChachkiesController{
	@GetMapping("/")
	List<Chackie> chachkies(){
		return Stream.of(new Chackie(UUID.randomUUID(), 0.1331, 0.8888)
		, new Chackie(UUID.randomUUID(), 0.777, 0.999)
		, new Chackie(UUID.randomUUID(), 0.888, 0.333)).collect(Collectors.toList());
	}
}

record Chackie(UUID id, double latitudes, double longitude){}