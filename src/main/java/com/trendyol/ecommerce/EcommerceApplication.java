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
	public CommandLineRunner run(ProductService productService, CategoryRepository categoryRepository) throws Exception {
		return (String[] args) -> {
			Optional<Category> byId = categoryRepository.findById(new Long(1));

			if (byId.isPresent()) {
				System.out.println(byId.get());
			ProductDto productDto = new ProductDto();
			productDto.setDescription("asd");
			productDto.setCategoryDto(new CategoryDto(byId.isPresent() ? byId.get() : null));
			productService.addNewProduct(productDto);
			productService.getAllProducts().stream().forEach(productDto1 -> {System.out.println(productDto1.toString());});
		};

	};
	}*/
}