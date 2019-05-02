package org.broadinstitute.ddp.util;

import static org.broadinstitute.ddp.constants.CSVConstants.DISPLAY_NAME;
import static org.broadinstitute.ddp.constants.CSVConstants.EMAIL;
import static org.broadinstitute.ddp.constants.CSVConstants.FOE;
import static org.broadinstitute.ddp.constants.CSVConstants.FOE_ID;
import static org.broadinstitute.ddp.constants.CSVConstants.SLACK_HANDLE;
import static org.broadinstitute.ddp.constants.CSVConstants.USER_ID;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.broadinstitute.ddp.model.AreaOfExpertise;
import org.broadinstitute.ddp.model.Participant;
import org.broadinstitute.ddp.model.Team;
import spark.utils.StringUtils;

public class TeamUtil {

    private static String teamDataFilePath;
    private static String foeFilePath;
    private static String teamToFoeFilePath;
    private static TeamUtil teamUtil;
    private int DUMMY_PR_OPEN_VALUE = 0;
    private Team team;

    private TeamUtil(String teamDataFilePath,
                     String foeFilePath,
                     String teamToFoeFilePath) throws Exception {
        Iterable<CSVRecord> parser = processFile(teamDataFilePath);
        List<Participant> participants = new ArrayList<>();
        for (CSVRecord record : parser) {
            participants.add(new Participant(
                    Integer.valueOf(record.get(USER_ID)),
                    record.get(SLACK_HANDLE),
                    record.get(EMAIL),
                    record.get(DISPLAY_NAME),
                    new ArrayList<>()));
        }

        parser = processFile(foeFilePath);
        List<AreaOfExpertise> areasOfExpertise = new ArrayList<>();
        for (CSVRecord record : parser) {
            areasOfExpertise.add(new AreaOfExpertise(
                    Integer.valueOf(record.get(FOE_ID)),
                    record.get(FOE)
            ));
        }

        parser = processFile(teamToFoeFilePath);
        for (CSVRecord record : parser) {
            AreaOfExpertise areaOfExpertise = areasOfExpertise.get(Integer.valueOf(record.get(FOE_ID)));
            participants.get(Integer.valueOf(record.get(USER_ID))).addAreaOfExpertise(areaOfExpertise);
        }


        team = new Team(areasOfExpertise, participants);
    }

    public static void setFilePaths(String teamDataFilePath, String foeFilePath, String teamToFoeFilePath) {
        TeamUtil.teamDataFilePath = teamDataFilePath;
        TeamUtil.foeFilePath = foeFilePath;
        TeamUtil.teamToFoeFilePath = teamToFoeFilePath;
    }

    public synchronized static TeamUtil getInstance() throws Exception {
        if (teamUtil == null) {
            if (StringUtils.isEmpty(teamDataFilePath)
                    || StringUtils.isEmpty(foeFilePath)
                    || StringUtils.isEmpty(teamToFoeFilePath)) {
                throw new Exception("You need to call setFilePaths first!");
            }
            teamUtil = new TeamUtil(teamDataFilePath, foeFilePath, teamToFoeFilePath);
        }
        return teamUtil;
    }

    public Team getTeam() {
        return team;
    }

    private Iterable<CSVRecord> processFile(String filePath) throws Exception {
        // Check to see if file exists
        // if not, create it and store File object in ourselves for later use

        File file = new File(filePath);
        if (!file.exists()) {
            throw new Exception("File does not exist: " + filePath);
        }
        return CSVFormat.EXCEL.withHeader().parse(new FileReader(filePath));

    }
}
