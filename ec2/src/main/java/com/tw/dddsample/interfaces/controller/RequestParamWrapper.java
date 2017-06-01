package com.tw.dddsample.interfaces.controller;

import com.tw.dddsample.interfaces.controller.dto.CreateInstanceRequestData;

/**
 * Created by azhu on 26/05/2017.
 */
public class RequestParamWrapper {
    public CreateInstanceRequestData get() {
        return data;
    }

    public void setData(CreateInstanceRequestData data) {
        this.data = data;
    }

    private CreateInstanceRequestData data;

}
