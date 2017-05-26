package io.swagger.api;

import io.swagger.model.Pet;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * A delegate to be called by the {@link PetsApiController}}.
 * Should be implemented as a controller but without the {@link org.springframework.stereotype.Controller} annotation.
 * Instead, use spring to autowire this class into the {@link PetsApiController}.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-26T15:53:30.758+08:00")

public interface PetsApiDelegate {

    /**
     * @see PetsApi#addPet
     */
    ResponseEntity<Pet> addPet(Pet pet);

    /**
     * @see PetsApi#findPets
     */
    ResponseEntity<List<Pet>> findPets();

}
