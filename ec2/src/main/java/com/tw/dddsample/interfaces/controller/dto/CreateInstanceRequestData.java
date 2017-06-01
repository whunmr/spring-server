package com.tw.dddsample.interfaces.controller.dto;

/**
 * Created by azhu on 26/05/2017.
 */
public class CreateInstanceRequestData {

    private String type;

    private String id;
    private Attributes attributes;
    public String getName() {
        return attributes.getName();
    }

    public String getAZ() {
        return attributes.getPlan().az;
    }

    public String getImageId() {
        //TODO: to delete
        System.out.println(attributes +"attributes");
        System.out.println(attributes +"attributes.plan");
        System.out.println(attributes.getName() +"attributes.name");
        System.out.println(attributes.getPlan().image_id +"attributes.plan.image_id");

        return attributes.getPlan().image_id;
    }

    public String getFlavorId() {
        return attributes.getPlan().flavor_id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

}
