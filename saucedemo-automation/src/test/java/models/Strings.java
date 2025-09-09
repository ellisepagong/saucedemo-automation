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
            return key;
        }
    }

    // Log in Error Messages
    public static final String MISSING_USERNAME = "Epic sadface: Username is required";
    public static final String MISSING_PASSWORD = "Epic sadface: Password is required";
    public static final String INCORRECT_CREDENTIALS = "Epic sadface: Username and password do not match any user in this service";
    public static final String LOCKED_OUT = "Epic sadface: Sorry, this user has been locked out.";

    // Catalog Descriptions
    public static final String BACKPACK_DESC = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
    public static final String BIKELIGHT_DESC = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";
    public static final String BOLTSHIRT_DESC = "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.";
    public static final String JACKET_DESC = "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";
    public static final String ONESIE_DESC = "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.";
    public static final String TESTTHINGSSHIRT_DESC = "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.";


}
