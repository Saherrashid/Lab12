package edu.illinois.cs.cs125.spring2019.lab12;

//import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


/**
 * comment.
 */
public final class Country extends java.lang.Object {

    /**
     * country name.
     * @param json
     * @return the name
     */
    public static String getName(final java.lang.String json) {
        if (json == null) {
            return null;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonObject zero = result.get("0").getAsJsonObject();
        return zero.get("name").getAsString();
    }

    /**
     * capital.
     * @param json mam
     * @return capital
     */
    public static String getCapital(final java.lang.String json) {
        if (json == null) {
            return null;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonObject zero = result.get("0").getAsJsonObject();
        return zero.get("capital").getAsString();
    }

    /**
     * money.
     * @param json
     * @return money
     */
    public static String getMoney(final java.lang.String json) {
        if (json == null) {
            return null;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonObject zero = result.get("0").getAsJsonObject();
        return zero.get("currencies").getAsString();
    }

    /**
     * translation.
     * @param json
     * @return translation
     */
    public static String getTranslation(final java.lang.String json) {
        if (json == null) {
            return null;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonObject zero = result.get("0").getAsJsonObject();
        return zero.get("translations").getAsString();
    }

    /**
     * borders.
     * @param json
     * @return borders
     */
    public static String getBorders(final java.lang.String json) {
        if (json == null) {
            return null;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonObject zero = result.get("0").getAsJsonObject();
        return zero.get("borders").getAsString();
    }

    /**
     * pop.
     * @param json
     * @return population
     */
    public static long getPopulation(final java.lang.String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonObject zero = result.get("0").getAsJsonObject();
        return zero.get("population").getAsLong();
    }
}
