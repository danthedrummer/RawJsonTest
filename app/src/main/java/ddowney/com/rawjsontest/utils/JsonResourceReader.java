package ddowney.com.rawjsontest.utils;

import android.content.res.Resources;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Solution taken from:
 * https://stackoverflow.com/questions/6349759/using-json-file-in-android-app-resources
 *
 * An object for reading from a Json resource file and constructing an object from it
 */
public class JsonResourceReader {

    static final String LOG_TAG = "JsonResourceReader";

    private String jsonString;

    /**
     * Read from a resources file and create a {@link JsonResourceReader} object that
     * will allow the creation of objects from this source.
     *
     * @param resources An application {@link Resources} object
     * @param id The id of the resource to be loaded
     */
    public JsonResourceReader(Resources resources, int id) {
        InputStream resourceReader = resources.openRawResource(id);
        Writer writer = new StringWriter();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(resourceReader, "UTF-8"));
            String line = reader.readLine();
            while (line!= null) {
                writer.write(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Exception using JsonResourceReader", e);
        } finally {
            try {
                resourceReader.close();
            } catch (IOException e) {
                Log.e(LOG_TAG, "Exception using JsonResourceReader", e);
            }
        }

        jsonString = writer.toString();
    }

    /**
     * Builds a Java object from the specified JSON resource
     *
     * @param type The type of the object to build
     *
     * @return An object of type T populated by Gson
     */
    public <T> T constructUsingGson(Class<T> type) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonString, type);
    }
}
