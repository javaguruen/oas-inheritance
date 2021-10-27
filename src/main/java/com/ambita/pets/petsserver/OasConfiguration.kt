package com.ambita.pets.petsserver

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.info.BuildProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OasConfiguration @Autowired constructor(val properties: BuildProperties?) {

    @Bean
    fun configureOas(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Pet server")
                    .version(properties?.version ?: "v1")
                    .description("Pet and owners")
                    .contact(Contact().name("Kundeservice").url("https://www.ambita.com/kundeservice/"))
                    .termsOfService("https://www.ambita.com/kundeavtale/")
            )
    }
}
