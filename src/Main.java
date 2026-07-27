//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import com.objectmentor.utilities.args.*;

public class Main {
    public static void main(String[] args) {
        try {
            Args arg = new Args("l,p#,d*", args);
            boolean logging = arg.getBoolean('l');
            int port = arg.getInt('p');
            String directory = arg.getString('d');
            executeApplication(logging, port, directory);
        } catch (ArgsException e) {
            System.out.printf("Argument error: %s\n", e.errorMessage());
        }
    }

    private static void executeApplication(boolean logging, int port, String directory) {
        System.out.printf("logging is %s, port:%d, directory:%s\n",logging, port, directory);
    }
}