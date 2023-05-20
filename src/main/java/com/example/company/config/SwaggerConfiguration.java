package com.example.company.config;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfiguration {
	   
    public Docket api() {                
        return new Docket(DocumentationType.SWAGGER_2)
          .apiInfo(getInfo())
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.companydatabase"))
          .paths(PathSelectors.any())
          .build();
    }

	private ApiInfo getInfo() {
	
		return new ApiInfoBuilder()
				 .title("Company Management Application")
				  .description("This is company management project ")
				  .license("Apache 2.0")
				  .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				  .version("1.0.0")
				  .contact(new Contact("Pranita More", "https://github.com/pranita8", "pranitamore842@gmail.com"))
		            .build();
	}

}

//http://localhost:8082/swagger-ui/index.html

