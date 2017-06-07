package com.dddsample.ec2.domain.flavor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.security.InvalidParameterException;

/**
 * Created by azhu on 27/05/2017.
 */
/*
    General purpose :M3(vCPU/MEM=1/3.75) M4(vCPU/MEM = 1/4)
    Compute optimized :C3(vCPU/MEM=2/3.75)
    Memory optimized: R3 (vCPU/MEM=2/15.25)
* */
@Entity
public class Flavor {
    @Id
    private String flavorId;
    private int vCPU;
    private float memInGiB;
    @Transient
    private Mode mode;

    public Flavor() {

    }

    public Flavor(String flavorId, int vCPU, float memInGiB) {
        mode = Mode.create(flavorId.substring(0, flavorId.indexOf(".")));
        mode.validate(vCPU, memInGiB);
        this.flavorId = flavorId;
        this.vCPU = vCPU;
        this.memInGiB = memInGiB;

    }

    public Mode getMode() {
        return this.mode;
    }

    public String getFlavorId() {
        return flavorId;
    }

    public float getMemInGiB() {
        return memInGiB;
    }

    public Integer getVCPU() {
        return vCPU;
    }

    public enum Mode {
        General {
            @Override
            public float proportion() {
                return 1/3.75f;
            }
        }, Compute {
            @Override
            public float proportion() {
                return 2/3.75f;
            }
        }, Memory {
            @Override
            public float proportion() {
                return 2/15.25f;
            }
        };

        public static Mode create(String modeName) {
            if (modeName.toUpperCase().equals("M3")) {
                return General;
            } else if (modeName.toUpperCase().equals("C3")) {
                return Compute;
            } else if (modeName.toUpperCase().equals("R3")) {
                return Memory;
            }
            throw new InvalidParameterException("The flavor id is invalid format!");
        }

        protected abstract float proportion();

        public void validate(int vCPU, float memInGiB) {
            if (vCPU / memInGiB != proportion()) {
                throw new InvalidParameterException("The proportion of vCPU/Memory is not consistent with mode!");
            }
        }
    }


}
