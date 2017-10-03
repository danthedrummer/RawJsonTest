package ddowney.com.rawjsontest.models;

import java.util.ArrayList;

/**
 * Base model for the games json file
 */
public class DataModel {
    private ArrayList<BulkGameModel> data;

    /**
     * Gets all the games in the list
     *
     * @return an {@link ArrayList} containing all the games
     */
    public ArrayList<BulkGameModel> getData() {
        return data;
    }

    /**
     * Gets the international name of a game with the specified id
     *
     * @param id the id of the game
     * @return the international name of the game if it exists, null otherwise
     */
    public String getNameOfGameWithId(int id) {
        try {
            return data.get(id).getInternationalName();
        } catch (IndexOutOfBoundsException e) {
            return "Game doesn't exist :(";
        }
    }

    /**
     * Gets the total number of items in the data set
     *
     * @return the size of the data set
     */
    public int getSize() {
        return data.size();
    }
}
