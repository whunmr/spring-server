package com.tw.dddsample.interfaces.assembler;

import com.tw.dddsample.domain.flavor.Flavor;
import io.swagger.model.FlavorCreateRequest;
import io.swagger.model.FlavorCreateRequestData;
import io.swagger.model.FlavorResponse;

import java.math.BigDecimal;

/**
 * Created by azhu on 07/06/2017.
 */
public class FlavorAssembler {
    public static Flavor fromDTO(FlavorCreateRequest request) {
        return new Flavor(request.getData().getFlavorId(), request.getData().getVCPU(), request.getData().getMemInGiB().floatValue());
    }

    public static FlavorResponse toDTO(Flavor savedFlavor) {
        FlavorCreateRequestData response = new FlavorCreateRequestData()
                .flavorId(savedFlavor.getFlavorId())
                .memInGiB(new BigDecimal(savedFlavor.getMemInGiB()))
                .vCPU(savedFlavor.getVCPU());
        return new FlavorResponse().data(response);
    }
}
