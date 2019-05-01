package org.broadinstitute.ddp.route;

import java.util.List;

import org.apache.http.HttpStatus;
import org.broadinstitute.ddp.constants.RouteConstants;
import org.broadinstitute.ddp.model.Participant;
import org.broadinstitute.ddp.model.Team;
import org.broadinstitute.ddp.util.RouletteUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;

public class GetReviewersRoute implements Route {

    private static final Logger LOG = LoggerFactory.getLogger(GetReviewersRoute.class);

    public GetReviewersRoute() {
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {

        Team team = request.params(RouteConstants.PathParam.TEAM_FILE_PATH);
        List<Participant> selectedParticipants = RouletteUtil.findReviewers();

        response.status(HttpStatus.SC_OK);
    }
}
