package org.broadinstitute.ddp.model;

import java.util.List;

public class Participant {

    private long openPRCount;
    private String name;
    private List<AreaOfExpertise> areasOfExpertise;

    public Participant(long openPRCount, String name, List<AreaOfExpertise> areasOfExpertise) {
        this.openPRCount = openPRCount;
        this.name = name;
        this.areasOfExpertise = areasOfExpertise;
    }
}
