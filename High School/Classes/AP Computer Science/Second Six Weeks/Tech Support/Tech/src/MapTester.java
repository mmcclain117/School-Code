
import static java.lang.System.out;
import java.util.HashMap;

public class MapTester {

    public static void main(String[] args) {
        MTest Mp = new MTest();
    }
}

class MTest {

    public HashMap<String, String> Address;

    public MTest() {
        Address = new HashMap<>();
        enterNumber("kyle", "(214) 980 2234");
        out.println(lookupNumber("kyle"));
        enterNumber("kyle", "(216) 981 2244");
        out.println(lookupNumber("kyle"));
        enterNumber("cody", "(215) 967 2124");
        enterNumber("yyle", "(216) 980 2244");
        enterNumber("Nobody's", "(972) 814 2234");
        out.println(lookupNumber("cody"));
        out.println(Address.containsKey("Kyes"));
        out.println(lookupNumber("IS"));
        out.println(Address.size());
    }

    private void enterNumber(String name, String number) {
        Address.put(name, number);
    }

    private String lookupNumber(String name) {
        return Address.get(name);
    }
}
