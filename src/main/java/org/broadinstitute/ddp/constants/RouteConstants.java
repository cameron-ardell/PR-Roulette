package org.broadinstitute.ddp.constants;

public class RouteConstants {

    public static final class API {
        public static final String VERSION = "v1";
        public static final String BASE = "/pr-roulette/" + VERSION;

        public static final String INTERNAL_ERROR = "/error";

        public static final String VIEW_PARTICIPANTS = BASE + "/team";
        public static final String SET_AREAS_OF_EXPERTISE = BASE + "/set-areas-of-expertise";
        public static final String GET_REVIEWERS = BASE + "/get-reviewers";
    }

    public static final class PathParam {
        public static final String TEAM_FILE_PATH = ":teamFilePath";
    }
}
