package com.tw.dddsample.application;

import com.tw.dddsample.domain.Flavor;
import org.springframework.stereotype.Component;

/**
 * Created by azhu on 26/05/2017.
 */
//TODO: change to be an interface
@Component
public class RegionSelectionService {
    public String selectAZ(String az, Flavor flavor) {
        //TODO: requirements: Implement choose biz requirement; should pass flavor object, not id
        // 1. if not specific az,  Choose the AZ which utilization is blow 50%,
        // 2. if specific az, but the az utilization is above 80%, chose another one.
        // 3. get region from az parameters
        return az;

    }
}
