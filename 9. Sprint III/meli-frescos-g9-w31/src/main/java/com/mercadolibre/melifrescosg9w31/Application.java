package com.mercadolibre.melifrescosg9w31;

import com.mercadolibre.melifrescosg9w31.util.ScopeUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Main class for the App.
 */
@SpringBootApplication
public class Application {

    /**
     * @param args command line arguments for the application.
     */
    public static void main(String[] args) {
        ScopeUtils.calculateScopeSuffix();
        new SpringApplicationBuilder(Application.class).registerShutdownHook(true).run(args);
    }
}
