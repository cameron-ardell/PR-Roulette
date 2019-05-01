package org.broadinstitute.ddp.model;

import java.util.List;

public class Participant {

    private long openPRCount;
    private String slackHandle;
    private String email;
    private String displayName;
    private List<AreaOfExpertise> areasOfExpertise;

    public Participant(long openPRCount, String slackHandle, String email, String displayName, List<AreaOfExpertise> areasOfExpertise) {
        this.openPRCount = openPRCount;
        this.slackHandle = slackHandle;
        this.email = email;
        this.displayName = displayName;
        this.areasOfExpertise = areasOfExpertise;
    }
}
