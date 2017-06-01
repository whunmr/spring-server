package com.tw.dddsample.interfaces.controller.dto;

/**
 * Created by azhu on 29/05/2017.
 */
public class Plan {
    public void setAz(String az) {
        this.az = az;
    }

    //        public void setAlias(String alias) {
//            this.alias = alias;
//        }
//
//        public void setCreated_by(String created_by) {
//            this.created_by = created_by;
//        }
//
//        public void setVolumns(String[] volumns) {
//            this.volumns = volumns;
//        }
//
//        public void setItems(String items) {
//            this.items = items;
//        }
//
//        public void setExprired_days(String exprired_days) {
//            this.exprired_days = exprired_days;
//        }
//
    public void setFlavor_id(String flavor_id) {
        this.flavor_id = flavor_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }
//
//        public void setNumber(String number) {
//            this.number = number;
//        }
//
//        public void setSecurity(String security) {
//            this.security = security;
//        }
//
//        public void setBiz_type(String biz_type) {
//            this.biz_type = biz_type;
//        }
//
//        public void setStrategy_type(String strategy_type) {
//            this.strategy_type = strategy_type;
//        }
//
//        public void setVpc_id(String vpc_id) {
//            this.vpc_id = vpc_id;
//        }


    //        String alias;
//        String created_by;
//        String[] volumns;
//        String items;
//        String exprired_days;
    String flavor_id;
    String image_id;
    String az;//openstack: az:host:node
//        String number;
//        String security;
//        String biz_type;
//        String strategy_type;
//        String vpc_id;
}
