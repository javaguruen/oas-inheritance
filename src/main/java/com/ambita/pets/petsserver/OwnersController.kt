package com.ambita.pets.petsserver

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping(
    value = ["/api/v1/owners"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class OwnersController {
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @Operation(summary = "Create owner")
    @ApiResponses(
        value = [ApiResponse(
            responseCode = "201",
            description = "Owner created",
            content = [Content(schema = Schema(implementation = OwnerResource::class))]
        )]
    )
    fun createOwner(
        @Parameter(
            name = "Body",
            description = "Data for owner creation",
            required = true
        ) @RequestBody @Valid ownerRequest: OwnerRequest
    ): ResponseEntity<OwnerResource>{
        TODO()
    }
}


