package com.example.application;

import com.example.application.ec2.Ec2Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class Ec2InstanceService {

    @Autowired
    private RestTemplate restTemplate;

    public Ec2Instance createInstance(String instanceClass) {
        String createEc2Request =
                        "{\n"+
                        "        \"data\":{\n"+
                        "            \"type\":\"ec2\",\n"+
                        "            \"attributes\":{\n"+
                        "                \"name\":\"create aa instanc\",\n"+
                        "                \"plan\":{\n"+
                        "                    \"image_id\":\"image____id__3\",\n"+
                        "                            \"flavor_id\":\"flavor_id1\",\n"+
                        "                            \"az\":\"SZ\"\n"+
                        "                }\n"+
                        "            }\n"+
                        "        }\n"+
                        "    }";

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type", "application/json");

        HttpEntity<String> request = new HttpEntity<String>(createEc2Request, headers);

        ResponseEntity<Ec2Instance> ec2Instance = restTemplate.postForEntity("http://ec2/instances", request, Ec2Instance.class);
        return ec2Instance.getBody();
    }

}
