package files;

public class Endpoint {

    public static String placePostData() {
        String res = "/maps/api/place/add/json";
        return res;
    }

    public static String getPlaceData() {
        String res = "/maps/api/place/nearbysearch/json";
        return res;
    }
}
