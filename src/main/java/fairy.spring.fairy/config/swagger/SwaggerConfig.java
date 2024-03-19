package fairy.spring.fairy.config.swagger;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
public class SwaggerConfig {

    private static final String SECURITY_SCHEME_NAME = "authorization";	// 추가

    @Bean
    @Profile("!prod")
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes(SECURITY_SCHEME_NAME, new io.swagger.v3.oas.models.security.SecurityScheme()
                                .name(SECURITY_SCHEME_NAME)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")))
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .info(apiInfo());
    }

    private io.swagger.v3.oas.models.info.Info apiInfo() {
        return new Info()
                .title("HouseworkFairy API")
                .description("집안일 요정 서비스 API 명세서입니다.")
                .version("1.0.0");
    }
}