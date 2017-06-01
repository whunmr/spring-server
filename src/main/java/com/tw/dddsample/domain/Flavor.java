package com.tw.dddsample.domain;

/**
 * Created by azhu on 27/05/2017.
 */
public class Flavor {
    private final String flavorId;
    private final String name;
    private final int cpuCount;
    private final int memInMega;

    public Flavor(String flavorId, String name, int cpuCount, int memInMega) {

        this.flavorId = flavorId;
        this.name = name;
        this.cpuCount = cpuCount;
        this.memInMega = memInMega;
    }
}
