package za.ac.nwu.as.web.springboot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.as.web.springboot.controller",
        "za.ac.nwu.as.web.springboot.exception"
})

public class WebConfiguration {

}
