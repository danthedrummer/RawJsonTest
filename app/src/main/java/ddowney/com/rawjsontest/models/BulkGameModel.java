package ddowney.com.rawjsontest.models;

/**
 * Model class describing a bulk game
 */
class BulkGameModel {

    private String id;
    private GameNames names;

    /**
     * Gets the id of the bulk game
     *
     * @return the id of the game
     */
    String getId() {
        return id;
    }

    /**
     * Gets the international name of the game
     *
     * @return the international name of the game
     */
    String getInternationalName() {
        return names.getInternational();
    }

    /**
     * Gets the japanese name of the game
     *
     * @return the japanese name of the game
     */
    String getJapaneseName() {
        return names.getJapanese();
    }

    /**
     * Inner class that holds the internation and japanese game names
     */
    private static class GameNames {
        private String international;
        private String japanese;

        String getInternational() {
            return international;
        }

        String getJapanese() {
            return japanese;
        }
    }
}
