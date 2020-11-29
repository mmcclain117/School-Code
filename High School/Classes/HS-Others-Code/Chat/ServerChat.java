import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(1300);
		System.out.println("Waiting for request from peer.....");
		Socket client = server.accept();
		Server s = new Server(client);
		System.out.println("Request Accepted");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		PrintStream ps2 = new PrintStream(client.getOutputStream());
		System.out.println("What's your name? ");
		String name = br2.readLine();
		ps2.println(name);
		while (true) {
			String st = br2.readLine();
			ps2.println(st);
		}
	}
}
