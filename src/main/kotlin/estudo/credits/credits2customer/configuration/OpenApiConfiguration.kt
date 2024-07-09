package estudo.credits.credits2customer.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springdoc.core.models.GroupedOpenApi


@Configuration
class OpenApiConfig : WebMvcConfigurer {

    // Configuração para permitir o acesso ao Swagger UI
    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/swagger-ui/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/springdoc-openapi-ui/")
    }
    //    http://localhost:8080/swagger-ui/index.htm
    @Bean
    fun publicApi(): GroupedOpenApi?{
        return GroupedOpenApi.builder()
            .group("springcredit2customerpublic")
            .pathsToMatch("/api/customers/**", "/api/credits/**")
            .build()
    }
    // Configuração para excluir o header 'X-Forwarded-Prefix', se necessário
    @Bean
    fun webMvcConfigurer(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/**")
                    .allowedMethods("*")
                    .allowedHeaders("*")
                    .exposedHeaders("X-Forwarded-Prefix") // Exclui o header 'X-Forwarded-Prefix'
            }
        }
    }
}
