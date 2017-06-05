package io.swagger.api;

import io.swagger.model.Failure;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse202;
import io.swagger.model.NewServiceRequest;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * A delegate to be called by the {@link InstancesApiController}}.
 * Should be implemented as a controller but without the {@link org.springframework.stereotype.Controller} annotation.
 * Instead, use spring to autowire this class into the {@link InstancesApiController}.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-05T13:54:25.717+08:00")

public interface InstancesApiDelegate {

    /**
     * @see InstancesApi#instancesGet
     */
    ResponseEntity<InlineResponse200> instancesGet(String contentType,
        String accept,
        String xRegion);

    /**
     * @see InstancesApi#instancesPost
     */
    ResponseEntity<InlineResponse202> instancesPost(String contentType,
        String accept,
        NewServiceRequest body);

}
