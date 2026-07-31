
import com.objectmentor.utilities.args.*;

public class Main {
    public static void main(String[] args) {
        Args arg = new Args("l,p#,d*", args);
        boolean logging = arg.getBoolean('l');
        executeApplication(logging);
    }

    private static void executeApplication(boolean logging) {
        System.out.printf("logging is %s",logging);
    }
}