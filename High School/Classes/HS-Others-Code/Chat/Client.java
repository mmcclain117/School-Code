import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Client implements Runnable {
	Thread t;
	Socket client;

	Client(Socket client) {
		this.client = client;
		t = new Thread(this);
		t.start();
	}

	public void run() {
		try {
			JFrame frame = new JFrame("Kyle Chat Application");
			frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			frame.setSize(300, 300);
			JLabel emptyLabel = new JLabel("");
			frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
			frame.pack();
			frame.setVisible(true);
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String name = br.readLine();
			frame.add(new JLabel(name), BorderLayout.NORTH);
			while (true) {
				String st1 = br.readLine();
				frame.add(new JLabel(name + ": " + st1), BorderLayout.AFTER_LAST_LINE);
				System.out.println(name + ": " + st1);
			}

		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
