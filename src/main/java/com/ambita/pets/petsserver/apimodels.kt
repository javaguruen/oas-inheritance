package com.ambita.pets.petsserver

import io.swagger.v3.oas.annotations.media.Schema

data class OwnerRequest(
    val name: String,
    val animal: AnimalRequest
)

open class AnimalRequest(
    val name: String,
    var animalType: AnimalType? = null
){
    init {
        if (animalType == null){
            animalType = AnimalType.ANIMAL
        }
    }
}

class Cat(name: String, val micePerWeek: Int) : AnimalRequest(name, AnimalType.CAT)
class Dog(name: String, val eatsPostman: Boolean) : AnimalRequest(name, AnimalType.DOG)

@Schema(enumAsRef = true)
enum class AnimalType{
    ANIMAL, CAT, DOG
}

data class OwnerResource(
    val id: Long,
    val name: String,
    val animal: AnimalDto
)

open class AnimalDto(
    val id: Long,
    val name: String,
    val animalType: AnimalType
)

class DogDto(
    id: Long,
    name: String,
    val eatsPostman: Boolean
) : AnimalDto(id, name, AnimalType.DOG)

class CatDto(
    id: Long,
    name: String,
    val micePerWeek: Int
) : AnimalDto(id, name, AnimalType.CAT)
