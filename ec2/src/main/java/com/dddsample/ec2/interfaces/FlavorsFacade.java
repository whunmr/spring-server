package com.dddsample.ec2.interfaces;

import com.dddsample.ec2.domain.flavor.Flavor;
import com.dddsample.ec2.domain.flavor.FlavorRepository;
import com.dddsample.ec2.interfaces.assembler.FlavorAssembler;
import io.swagger.api.FlavorsApiDelegate;
import io.swagger.model.FlavorCreateRequest;
import io.swagger.model.FlavorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Created by azhu on 07/06/2017.
 */
@Component
public class FlavorsFacade implements FlavorsApiDelegate {

    @Autowired
    private FlavorRepository flavorRepository;

    @Override
    public ResponseEntity<FlavorResponse> createFlavors(FlavorCreateRequest body) {
        Flavor flavor = FlavorAssembler.fromDTO(body);
        Flavor savedFlavor = flavorRepository.save(flavor);
        return new ResponseEntity<>(FlavorAssembler.toDTO(savedFlavor), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FlavorResponse> findFlavor(String flavorId) {
        return new ResponseEntity<>(FlavorAssembler.toDTO(flavorRepository.findFlavor(flavorId)), HttpStatus.OK);
    }
}
