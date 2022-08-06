package br.com.moby7.poi.conf;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JtsConfig {
    @Bean
    public JtsModule jtsModule() {
        return new JtsModule();
    }
}
