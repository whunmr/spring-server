package com.tw.dddsample.interfaces.controller.dto;

/**
 * Created by azhu on 29/05/2017.
 */
public class Attributes {
    private String name;

    private Plan plan;

    public void setName(String name) {
        this.name = name;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public String getName() {
        return name;
    }

    public Plan getPlan() {
        return plan;
    }
}
