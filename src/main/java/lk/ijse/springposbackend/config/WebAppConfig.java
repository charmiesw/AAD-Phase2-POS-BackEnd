package lk.ijse.springposbackend.config;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "lk.ijse.springposbackend")
@EnableJpaRepositories(basePackages = "lk.ijse.springposbackend")
@EnableTransactionManagement
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,  //2MB
        maxFileSize = 1024 * 1024 * 10, //10MB
        maxRequestSize = 1024 * 1024 * 50 //50MB
)
public class WebAppConfig {
}
