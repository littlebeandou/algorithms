package other;

import java.util.regex.Pattern;

public class Util {
    public static boolean regMatch(String regEx, String str) {
        Pattern pattern = Pattern.compile(regEx);
        return pattern.matcher(str).matches();
    }
}
