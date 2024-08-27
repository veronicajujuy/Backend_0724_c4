package dh.backend.clinica.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;

public class GsonProvider {
    private static final Gson gson;

    static {
        gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();
    }

    public static Gson getGson() {
        return gson;
    }
}
