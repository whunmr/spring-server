package io.swagger.api;

import io.swagger.model.Pet;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-26T15:53:30.758+08:00")

@Api(value = "pets", description = "the pets API")
public interface PetsApi {

    @ApiOperation(value = "", notes = "Creates a new pet in store", response = Pet.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Returns the newly-added pet", response = Pet.class) })
    @RequestMapping(value = "/pets",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Pet> addPet(@ApiParam(value = "The pet to add to the store" ,required=true ) @RequestBody Pet pet);


    @ApiOperation(value = "", notes = "Returns all pets", response = Pet.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Return the matching pets", response = Pet.class) })
    @RequestMapping(value = "/pets",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Pet>> findPets();

}
