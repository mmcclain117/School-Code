
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import static java.lang.System.out;

public class BaseEncrypt {

    public static void main(String[] args) throws Exception {
        String ar = "This is my password";
        char ch[] = ar.toCharArray();
        byte b[] = ar.getBytes();
        byte t[] = "t".getBytes();
        String en = Base64.encode(b);
        out.println(en);
        out.println(Base64.encode(t));
    }
}
