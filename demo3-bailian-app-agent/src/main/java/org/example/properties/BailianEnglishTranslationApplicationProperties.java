package org.example.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "bailian.application.english-translation")
public class BailianEnglishTranslationApplicationProperties extends Application {

}
