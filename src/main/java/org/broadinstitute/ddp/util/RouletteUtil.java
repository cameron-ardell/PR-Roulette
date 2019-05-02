package org.broadinstitute.ddp.util;

import java.util.List;

import org.broadinstitute.ddp.model.AreaOfExpertise;
import org.broadinstitute.ddp.model.Participant;
import org.broadinstitute.ddp.model.Team;

public class RouletteUtil {

    private Team team;

    public RouletteUtil() throws Exception {
        team = TeamUtil.getInstance().getTeam();
    }

    public static List<Participant> findReviewers(AreaOfExpertise areaOfExpertise) {


        return null;
    }


}
