package org.broadinstitute.ddp.model;

public class AreaOfExpertise {

    private int foeId;
    private String name;

    public AreaOfExpertise(int foeId, String name) {
        this.foeId = foeId;
        this.name = name;
    }

    public int getFoeId() {
        return foeId;
    }

    public String getName() {
        return name;
    }
}
