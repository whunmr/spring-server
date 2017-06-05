package io.swagger.api;

import io.swagger.model.Failure;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse202;
import io.swagger.model.NewServiceRequest;

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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-05T13:54:25.717+08:00")

@Controller
public class InstancesApiController implements InstancesApi {
    private final InstancesApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    InstancesApiController(InstancesApiDelegate delegate) {
        this.delegate = delegate;
    }


    public ResponseEntity<InlineResponse200> instancesGet(@ApiParam(value = "content type of the request, should be application/vnd.hic+json" ,required=true ) @RequestHeader(value="Content-type", required=true) String contentType,
        @ApiParam(value = "accept type of the request, should be application/vnd.hic+json" ,required=true ) @RequestHeader(value="Accept", required=true) String accept,
        @ApiParam(value = "区域" ,required=true ) @RequestHeader(value="X-region", required=true) String xRegion) {
        // do some magic!
        return delegate.instancesGet(contentType, accept, xRegion);
    }

    public ResponseEntity<InlineResponse202> instancesPost(@ApiParam(value = "content type of the request, should be application/vnd.hic+json" ,required=true ) @RequestHeader(value="Content-type", required=true) String contentType,
        @ApiParam(value = "accept type of the request, should be application/vnd.hic+json" ,required=true ) @RequestHeader(value="Accept", required=true) String accept,
        @ApiParam(value = "new instance info"  ) @RequestBody NewServiceRequest body) {
        // do some magic!
        return delegate.instancesPost(contentType, accept, body);
    }

}
