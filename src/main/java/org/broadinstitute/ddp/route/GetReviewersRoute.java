package org.broadinstitute.ddp.route;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpStatus;
import org.broadinstitute.ddp.constants.ErrorCodes;
import org.broadinstitute.ddp.model.AreaOfExpertise;
import org.broadinstitute.ddp.model.Participant;
import org.broadinstitute.ddp.util.ResponseUtil;
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

        JsonElement data = new JsonParser().parse(request.body());
        if (!data.isJsonObject() || data.getAsJsonObject().entrySet().size() == 0) {
            ResponseUtil.halt400ErrorResponse(response, ErrorCodes.MISSING_BODY);
        }
        JsonObject payload = data.getAsJsonObject();

        AreaOfExpertise areaOfExpertise = new Gson().fromJson(payload, AreaOfExpertise.class);
        List<Participant> selectedParticipants = RouletteUtil.findReviewers(areaOfExpertise);

        response.status(HttpStatus.SC_OK);
        return selectedParticipants;
    }
}
