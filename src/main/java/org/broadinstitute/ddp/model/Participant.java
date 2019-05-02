package org.broadinstitute.ddp.model;

import java.util.List;

public class Participant {

    private int userId;
    private String slackHandle;
    private String email;
    private String displayName;
    private List<AreaOfExpertise> areasOfExpertise;

    public Participant(int userId, String slackHandle, String email, String displayName, List<AreaOfExpertise> areasOfExpertise) {
        this.userId = userId;
        this.slackHandle = slackHandle;
        this.email = email;
        this.displayName = displayName;
        this.areasOfExpertise = areasOfExpertise;
    }

    public void addAreaOfExpertise(AreaOfExpertise areaOfExpertise) {
        areasOfExpertise.add(areaOfExpertise);
    }
}
