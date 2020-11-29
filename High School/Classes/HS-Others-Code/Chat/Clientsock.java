import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Clientsock {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("Sending request to peer...");
			Socket client = new Socket("100.44.55.186", 1300);
			System.out.println("Successfully Connected");
			Client c = new Client(client);
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			PrintStream ps = new PrintStream(client.getOutputStream());
			System.out.println("What's your name? ");
			String name = br1.readLine();
			ps.println(name);
			while (true) {
				String s = br1.readLine();
				ps.println(s);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
