
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob15 {

    private void printCube() {
        System.out.println();
        printFace(U);
        System.out.println(L[0] + " " + L[1] + " " + F[0] + " " + F[1] + " " + R[0] + " " + R[1] + " " + B[0] + " " + B[1]);
        System.out.println(L[2] + " " + L[3] + " " + F[2] + " " + F[3] + " " + R[2] + " " + R[3] + " " + B[2] + " " + B[3]);
        printFace(D);
        System.out.println();
    }
    private static char[] F = new char[]{'G', 'G', 'G', 'G'};
    private static char[] L = new char[]{'O', 'O', 'O', 'O'};
    private static char[] R = new char[]{'R', 'R', 'R', 'R'};
    private static char[] B = new char[]{'B', 'B', 'B', 'B'};
    private static char[] U = new char[]{'W', 'W', 'W', 'W'};
    private static char[] D = new char[]{'Y', 'Y', 'Y', 'Y'};

    public static void main(String[] args) throws Exception {
//        Problem: Cube Rotation
//        Difficulty: Hard
//        Subject: 2D array, 3D, Pointers
        Scanner scan = new Scanner(new File("prob15.txt"));
        String a = scan.nextLine();
        System.out.println("Start");
        while (!".".equals(a)) {
            switch (a.charAt(0)) {
                case 'F':
                    char tl = F[0];
                    F[0] = F[2];
                    F[2] = F[3];
                    F[3] = F[1];
                    F[1] = tl;
                    char temp = L[1];
                    char temp2 = L[3];
                    L[1] = D[0];
                    L[3] = D[1];
                    D[0] = R[2];
                    D[1] = R[0];
                    R[2] = U[3];
                    R[0] = U[2];
                    U[3] = temp;
                    U[2] = temp2;
                    break;
                case 'B':
                    tl = B[0];
                    B[0] = B[1];
                    B[1] = B[3];
                    B[3] = B[2];
                    B[2] = tl;
                    temp = L[0];
                    temp2 = L[2];
                    L[0] = U[1];
                    L[2] = U[0];
                    U[0] = R[1];
                    U[1] = R[3];
                    R[1] = D[3];
                    R[3] = D[2];
                    D[3] = temp;
                    D[2] = temp2;
                    break;
                case 'L':
                    tl = L[0];
                    L[0] = L[2];
                    L[2] = L[3];
                    L[3] = L[1];
                    L[1] = tl;
                    temp = B[1];
                    temp2 = B[3];
                    B[1] = D[2];
                    B[3] = D[0];
                    D[2] = F[2];
                    D[0] = F[0];
                    F[2] = U[2];
                    F[0] = U[0];
                    U[2] = temp;
                    U[0] = temp2;
                    break;
                case 'R':
                    tl = R[0];
                    R[0] = R[2];
                    R[2] = R[3];
                    R[3] = R[1];
                    R[1] = tl;
                    temp = F[1];
                    temp2 = F[3];
                    F[1] = D[1];
                    F[3] = D[3];
                    D[1] = B[2];
                    D[3] = B[0];
                    B[2] = U[1];
                    B[0] = U[3];
                    U[1] = temp;
                    U[3] = temp2;
                    break;
                case 'U':
                    tl = U[0];
                    U[0] = U[2];
                    U[2] = U[3];
                    U[3] = U[1];
                    U[1] = tl;
                    temp = F[0];
                    temp2 = F[1];
                    F[0] = R[0];
                    F[1] = R[1];
                    R[0] = B[0];
                    R[1] = B[1];
                    B[0] = L[0];
                    B[1] = L[1];
                    L[0] = temp;
                    L[1] = temp2;
                    break;
                case 'D':
                    tl = D[0];
                    D[0] = D[2];
                    D[2] = D[3];
                    D[3] = D[1];
                    D[1] = tl;
                    temp = L[2];
                    temp2 = L[3];
                    L[2] = B[2];
                    L[3] = B[3];
                    B[2] = R[2];
                    B[3] = R[3];
                    R[2] = F[2];
                    R[3] = F[3];
                    F[2] = temp;
                    F[3] = temp2;
                    break;
                default:
                    break;
            }
            System.out.println(a);
            printFace(F);
            System.out.println();
            a = scan.nextLine();
        }
    }

    private static void printFace(char[] face) {
        System.out.println(face[0] + " " + face[1]);
        System.out.println(face[2] + " " + face[3]);
    }
}
