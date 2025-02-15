package shop.kavatar.kavatarbackend.global.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "server")
public record SwaggerProperties(
        String url
) {
}