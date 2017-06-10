package com.dddsample.ec2.interfaces.assembler;

import com.dddsample.ec2.domain.flavor.Flavor;
import io.swagger.model.FlavorCreateRequest;
import io.swagger.model.FlavorListResponse;
import io.swagger.model.FlavorResponse;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by azhu on 07/06/2017.
 */
public class FlavorAssembler {
    public static Flavor fromDTO(FlavorCreateRequest request) {
        return new Flavor(request.getFlavorId(), request.getVCPU(), request.getMemInGiB().floatValue());
    }

    public static FlavorResponse toDTO(Flavor savedFlavor) {
        return new FlavorResponse()
                .flavorId(savedFlavor.getFlavorId())
                .memInGiB(new BigDecimal(savedFlavor.getMemInGiB()))
                .vCPU(savedFlavor.getVCPU());
    }

    public static FlavorListResponse toDTO(List<Flavor> flavors) {
        FlavorListResponse flavorResponses = new FlavorListResponse();
        for (Flavor flavor : flavors) {
            flavorResponses.add(toDTO(flavor));
        }
        return flavorResponses;
    }
}
