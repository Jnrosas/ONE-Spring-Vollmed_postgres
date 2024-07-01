package med.voll.api.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig { //in order to use the token in swagger
   @Bean
   public OpenAPI customOpenAPI() {
      return new OpenAPI()
            .components(new Components()
                  .addSecuritySchemes("bearer-key",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP)
                              .scheme("bearer").bearerFormat("JWT")))
            .info(new Info()
                  .title("API Vollmed_postgres")
                  .description("API Rest de la aplicación vollmed clinic, que contiene" +
                        " las funcionalidades de CRUD de medicos y pacientes"));
   }

   @Bean
   public Void message() {
      System.out.println("bearer is working");
      return null;
   }
}
