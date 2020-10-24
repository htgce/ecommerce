package com.trendyol.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
})
public class EcommerceApplication {

	public static void main(String[] args) {
		System.out.println("here i am");
		SpringApplication.run(EcommerceApplication.class, args);
	}
	/*@Bean
	public CommandLineRunner run(UserService userService) throws Exception {
		return (String[] args) -> {
			UserDto user1 = new UserDto(1L,"John", "K","john@domain.com");
			userService.addUser(user1);
			userService.getUserList().forEach(user -> System.out.println(user.getFirstName()));
		};
	}*/
}