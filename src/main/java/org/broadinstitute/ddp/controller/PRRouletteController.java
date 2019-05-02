package org.broadinstitute.ddp.controller;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

public class PRRouletteController implements Route {

    public static Route servePRPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("name", "Cam");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/Hello.vm"));
    };

    @Override
    public Object handle(Request request, Response response) throws Exception {
        return null;
    }
}
