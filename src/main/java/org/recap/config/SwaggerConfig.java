package org.recap.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by hemalathas on 22/8/16.
 */
@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Value("${version.number:UNKNOWN}")
    private String buildVersionNumber;

    @Bean
    public OpenAPI recapOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("ReCAP APIs")
                        .description("APIs to interact with ReCAP middleware are RESTful and need an API_KEY for any call to be invoked. Further NCIP protocols are also supported.")
                        .version(buildVersionNumber)
                        .license(new License().name("Apache 2.0").url("http://www.apache.org/licenses/LICENSE-2.0.html")));
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SwaggerInterceptor())
                .addPathPatterns("/dataDump/*");
    }
}
