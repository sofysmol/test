/**
 * Created by sofysmo on 16.07.16.
 * привет
 */
public class Sin {
    private static Sin ourInstance = new Sin();

    public static Sin getInstance() {
        return ourInstance;
    }

    private Sin() {
    }
}
