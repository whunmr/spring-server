package com.tw.dddsample.domain;

import java.util.HashSet;

public class Region {
    //TODO: Step 1 Add step description to all classes&package

    private String regionName;
    private static HashSet<String> EXISTED_REGION = new HashSet<>();
    {
        EXISTED_REGION.add("BJ");
        EXISTED_REGION.add("SZ");
        EXISTED_REGION.add("DG");

    }

    public Region(String name) {
        regionName = name;
    }

    private boolean isExisted(String regionName) {
        return EXISTED_REGION.contains(regionName);
    }

    public String name() {
        if (isExisted(regionName)) {
            return regionName;
        }
        return Instance.DEFAULT_REGION;
    }

}