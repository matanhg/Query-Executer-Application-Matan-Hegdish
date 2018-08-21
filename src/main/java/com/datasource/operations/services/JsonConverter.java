package com.datasource.operations.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;

public class JsonConverter {

    private final Gson gson;

    public JsonConverter() {

        gson = new GsonBuilder().create();
    }

    public String convertToJson(List<Map<String, Object>> output) {
        JsonArray jarray = gson.toJsonTree(output).getAsJsonArray();
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("output", jarray);

        return jsonObject.toString();
    }

}
