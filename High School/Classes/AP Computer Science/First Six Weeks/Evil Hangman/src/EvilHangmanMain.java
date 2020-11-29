
/**
 * EvilHangmanMain.java 06/04/2015
 *
 * @author - Robert Glen MartinR
 * @author - School for the Talented and Gifted
 * @author - Dallas ISDA
 */
public class EvilHangmanMain {

    public static void main(String[] args) throws Exception {
        //EvilHangman evil = new EvilHangman("test.txt", true);
        EvilHangman evil = new EvilHangman("dictionary.txt", false);
        evil.playGame();
    }
}
