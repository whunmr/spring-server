package com.dddsample.ec2.interfaces;

import com.dddsample.ec2.application.FlavorService;
import com.dddsample.ec2.domain.flavor.Flavor;
import com.dddsample.ec2.domain.flavor.FlavorRepository;
import com.dddsample.ec2.interfaces.assembler.FlavorAssembler;
import io.swagger.api.FlavorsApiDelegate;
import io.swagger.model.FlavorCreateRequest;
import io.swagger.model.FlavorListResponse;
import io.swagger.model.FlavorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by azhu on 07/06/2017.
 */
@Component
public class FlavorsFacade implements FlavorsApiDelegate {

    @Autowired
    private FlavorRepository flavorRepository;

    @Autowired
    private FlavorService flavorService;

    @Override
    public ResponseEntity<FlavorResponse> createFlavors(FlavorCreateRequest body) {
        Flavor flavor = FlavorAssembler.fromDTO(body);
        Flavor savedFlavor = flavorService.save(flavor);
        return new ResponseEntity<>(FlavorAssembler.toDTO(savedFlavor), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<FlavorResponse> findFlavor(String flavorId) {
        return ResponseEntity.ok(FlavorAssembler.toDTO(flavorRepository.findFlavor(flavorId)));
    }

    @Override
    public ResponseEntity<FlavorListResponse> findFlavors(Integer vCPU, BigDecimal memInGiB) {
        //TODO: Implement to find by paramenters
        return ResponseEntity.ok(FlavorAssembler.toDTO(flavorRepository.findAll()));
    }
}
