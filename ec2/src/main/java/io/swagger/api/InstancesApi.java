package io.swagger.api;

import io.swagger.model.Failure;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse202;
import io.swagger.model.NewServiceRequest;

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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-05T13:54:25.717+08:00")

@Api(value = "instances", description = "the instances API")
public interface InstancesApi {

    @ApiOperation(value = "获取实例基本信息", notes = "", response = InlineResponse200.class, tags={ "Instance", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = InlineResponse200.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = InlineResponse200.class),
        @ApiResponse(code = 406, message = "Not Acceptable", response = InlineResponse200.class),
        @ApiResponse(code = 500, message = "Unexpected error", response = InlineResponse200.class) })
    @RequestMapping(value = "/instances",
        method = RequestMethod.GET)
    ResponseEntity<InlineResponse200> instancesGet(@ApiParam(value = "content type of the request, should be application/vnd.hic+json" ,required=true ) @RequestHeader(value="Content-type", required=true) String contentType,
        @ApiParam(value = "accept type of the request, should be application/vnd.hic+json" ,required=true ) @RequestHeader(value="Accept", required=true) String accept,
        @ApiParam(value = "区域" ,required=true ) @RequestHeader(value="X-region", required=true) String xRegion);


    @ApiOperation(value = "新建EC2实例", notes = "user wants to create a new instance", response = InlineResponse202.class, tags={ "Instance", })
    @ApiResponses(value = { 
        @ApiResponse(code = 202, message = "Accepted", response = InlineResponse202.class),
        @ApiResponse(code = 400, message = "Bad Request", response = InlineResponse202.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = InlineResponse202.class),
        @ApiResponse(code = 403, message = "Forbidden", response = InlineResponse202.class),
        @ApiResponse(code = 406, message = "Not Acceptable", response = InlineResponse202.class),
        @ApiResponse(code = 415, message = "Unsupported Media Type", response = InlineResponse202.class),
        @ApiResponse(code = 500, message = "Unexpected error", response = InlineResponse202.class) })
    @RequestMapping(value = "/instances",
        method = RequestMethod.POST)
    ResponseEntity<InlineResponse202> instancesPost(@ApiParam(value = "content type of the request, should be application/vnd.hic+json" ,required=true ) @RequestHeader(value="Content-type", required=true) String contentType,
        @ApiParam(value = "accept type of the request, should be application/vnd.hic+json" ,required=true ) @RequestHeader(value="Accept", required=true) String accept,
        @ApiParam(value = "new instance info"  ) @RequestBody NewServiceRequest body);

}
