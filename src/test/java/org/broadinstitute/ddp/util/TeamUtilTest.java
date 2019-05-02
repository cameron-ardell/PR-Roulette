package org.broadinstitute.ddp.util;

import static org.junit.Assert.*;

import org.broadinstitute.ddp.model.Team;
import org.junit.Before;
import org.junit.Test;

public class TeamUtilTest {

    private static String testTeamPath = "src/resources/team.csv";
    private static String testFoePath = "src/resources/foe.csv";
    private static String testFoeTeamPath = "src/resources/team-to-foe.csv";

    @Before
    public void initTeamUtil() throws Exception {
        TeamUtil.setFilePaths(testTeamPath, testFoePath, testFoeTeamPath);
    }

    @Test
    public void testInitWorked() throws Exception {
        Team team = TeamUtil.getInstance().getTeam();
        assertNotNull(team);
    }

}