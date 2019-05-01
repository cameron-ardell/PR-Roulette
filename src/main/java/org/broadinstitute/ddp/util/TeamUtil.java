package org.broadinstitute.ddp.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.broadinstitute.ddp.model.AreaOfExpertise;
import org.broadinstitute.ddp.model.Team;

public class TeamUtil {

    private int DUMMY_PR_OPEN_VALUE = 0;

    private static boolean isInitialized;
    private static DataStore dataStore;

    private TeamUtil() {
        dataStore = new DataStore(null);
        isInitialized = false;
    }

    public DataStore getDataStore() {
        return dataStore;
    }

    public static boolean isInitialized() {
        return isInitialized;
    }

    public static void init(String teamFilePath) {
        dataStore.setTeam(renderExistingTeam(teamFilePath));
        isInitialized = true;
    }

    private static Team renderExistingTeam(String teamFilePath) {
        List<List<String>> participants = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(teamFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                participants.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV file: " + e);
        }

        if (participants.size() == 0) {
            return new Team(new ArrayList<>(), new ArrayList<>());
        } else {
            List<AreaOfExpertise> areasOfExpertise = participants.get(0)
                    .stream()
                    .filter(header -> !header.equals("participant")
                    && !header.equals("slackHandle")
                    && !header.equals("email"))
                    .map(header -> new AreaOfExpertise(header))
                    .collect(Collectors.toList());

            if (participants.size() == 1) {
                return new Team(areasOfExpertise, new ArrayList<>());
            } else {
                int counter = 0;
                for (List<String> participantInformation : participants) {
                    if (counter == 0) {
                        continue;
                    }
                    String displayName = participantInformation.get(0);
                    String slackHanlde = participantInformation.get(1);
                    String email = participantInformation.get(2);

                    for (int info = 0; info < participantInformation.size(); info++) {
                        if (info == 0) {

                        }
                    }

                    counter++;
                }
            }
        }
    }



    public class DataStore {
        private Team team;

        public DataStore(Team team) {
            this.team = team;
        }

        public Team getTeam() {
            return team;
        }

        public void setTeam(Team team) {
            this.team = team;
        }
    }
}
