package org.broadinstitute.ddp.model;

import java.util.List;

public class Team {

    private List<AreaOfExpertise> areasOfExpertise;
    private List<Participant> teamMembers;
    private List<AreaOfExpertise> possibleAreasOfExpertise;
    private long numberOfExperts;
    private long totalNumberOfSelectedParticipants;

    public Team(List<AreaOfExpertise> areasOfExpertise,
                List<Participant> teamMembers,
                List<AreaOfExpertise> possibleAreasOfExpertise,
                long numberOfExperts,
                long totalNumberOfSelectedParticipants) {
        this.areasOfExpertise = areasOfExpertise;
        this.teamMembers = teamMembers;
        this.possibleAreasOfExpertise = possibleAreasOfExpertise;
        this.numberOfExperts = numberOfExperts;
        this.totalNumberOfSelectedParticipants = totalNumberOfSelectedParticipants;
    }
}
