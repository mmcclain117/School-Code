import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Server implements Runnable {
	Thread t;
	Socket client;

	Server(Socket client) {
		this.client = client;
		t = new Thread(this);
		t.start();
	}

	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String name = br.readLine();
			while (true) {
				String st1 = br.readLine();
				System.out.println(name + ": " + st1);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
