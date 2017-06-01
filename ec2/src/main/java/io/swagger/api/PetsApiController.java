package io.swagger.api;

import io.swagger.model.Pet;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-26T15:53:30.758+08:00")

@Controller
public class PetsApiController implements PetsApi {
    private final PetsApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    PetsApiController(PetsApiDelegate delegate) {
        this.delegate = delegate;
    }


    public ResponseEntity<Pet> addPet(@ApiParam(value = "The pet to add to the store" ,required=true ) @RequestBody Pet pet) {
        // do some magic!
        return delegate.addPet(pet);
    }

    public ResponseEntity<List<Pet>> findPets() {
        // do some magic!
        return delegate.findPets();
    }

}
