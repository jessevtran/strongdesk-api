package com.strongdesk.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(initializers = ConfigDataApplicationContextInitializer.class)
@EnableConfigurationProperties(value = AppSettings.class)
public class AppSettingsTest {
  @Autowired private AppSettings appSettings;

  @Test
  public void nonSecureEndpoints() {
    List<String> expected = Arrays.asList("/swagger-ui/**", "/v3/api-docs/**");
    assertEquals(expected, appSettings.getNonSecureEndpoints());
  }
}
