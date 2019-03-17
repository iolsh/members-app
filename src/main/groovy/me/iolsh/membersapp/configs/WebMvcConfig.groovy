package me.iolsh.membersapp.configs

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.web.ResourceProperties
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.Resource
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.resource.PathResourceResolver

//TODO review this config
@Configuration
class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private ResourceProperties resourceProperties = new ResourceProperties();


    @Override
    void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "PUT", "POST", "DELETE", )
                .allowedHeaders("*")
                .exposedHeaders("Access-Control-Allow-Origin")
                .allowCredentials(false).maxAge(3600)
        ;
    }

    @Override
    void addResourceHandlers(ResourceHandlerRegistry registry) {
        Integer cachePeriod = resourceProperties.getCachePeriod();

        final String[] staticLocations = resourceProperties.getStaticLocations();
        final String[] indexLocations = new String[staticLocations.length];
        for (int i = 0; i < staticLocations.length; i++) {
            indexLocations[i] = staticLocations[i] + "index.html";
        }
        registry.addResourceHandler(
                "/**/*.css",
                "/**/*.html",
                "/**/*.js",
                "/**/*.json",
                "/**/*.bmp",
                "/**/*.jpeg",
                "/**/*.jpg",
                "/**/*.png",
                "/**/*.ttf",
                "/**/*.eot",
                "/**/*.svg",
                "/**/*.woff",
                "/**/*.woff2"
        )
        .addResourceLocations(staticLocations)
        .setCachePeriod(cachePeriod);

        registry.addResourceHandler("/**")
            .addResourceLocations(indexLocations)
            .setCachePeriod(cachePeriod)
            .resourceChain(true)
            .addResolver(new PathResourceResolver() {
            @Override
            protected Resource getResource(String resourcePath, Resource location) throws IOException {
                return location.exists() && location.isReadable() ? location : null;
            }
        })

    }
}