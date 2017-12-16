package app;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Vlad on 11-Dec-17.
 */
@Configuration
public class MVCConfig extends WebMvcConfigurerAdapter {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
    }
}
