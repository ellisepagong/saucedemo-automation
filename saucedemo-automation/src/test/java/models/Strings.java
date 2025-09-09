package models;

public class Strings {

    /**
     * Retrieves a string constant from this class by its field name.
     *
     * @param key the name of the constant field (e.g., "BACKPACK_DESC")
     * @return the value of the string constant OR the string itself
     */
    public static String getString(String key) {
        try {
            return Strings.class.getField(key).get(null).toString();
        }  catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("  No String found, returning key.");
            return key;
        }
    }

    public static final String BACKPACK_DESC = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";

}
