package org.broadinstitute.ddp.transformers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.ResponseTransformer;

public class SimpleJsonTransformer implements ResponseTransformer {

    private final Gson gson;

    public SimpleJsonTransformer() {
        this(new GsonBuilder().serializeNulls().create());
    }

    public SimpleJsonTransformer(Gson gson) {
        this.gson = gson;
    }

    @Override
    public String render(Object model) {
        return gson.toJson(model);
    }
}
