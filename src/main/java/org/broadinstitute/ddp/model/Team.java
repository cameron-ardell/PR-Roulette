package org.broadinstitute.ddp.model;

import java.util.List;

public class Team {

    private List<AreaOfExpertise> areasOfExpertise;
    private List<Participant> teamMembers;

    public Team(List<AreaOfExpertise> areasOfExpertise,
                List<Participant> teamMembers) {
        this.areasOfExpertise = areasOfExpertise;
        this.teamMembers = teamMembers;
    }
}
