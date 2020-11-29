
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * An IP address acts as a mailing address for your computer. Your computer
 * usually exists on a local network with other computers. In order to talk to
 * computers outside of your local network, a routing device is needed. Many of
 * you have one of these in your home that allows you access to the web and
 * communicate with as many computers as you want.
 *
 * Communications between computers (such as accessing a web page) are made up
 * of a series of packets (small chunks of data). Each packet contains a
 * destination IP address. A router keeps a list of networks. The router
 * compares this list to the IP address in each packet. When it finds a match,
 * the packet is 'routed' to that network. There is also a default route where a
 * packet is sent when it doesn't match any of the known networks. The default
 * route usually sends the packet to another router that will know what to do
 * with the packet.
 *
 *
 * @author Master Ward and zozo
 *
 */
public class Prob13 { // Formally ipRouter

    /**
     * Location of the routing table file.
     */
    private static final String ROUTING_TABLE_FILE = "routingtable.txt";

    private ArrayList<Network> networks = new ArrayList<Network>();
    private String defaultNet;

    /**
     * Loads the routing table from a text file. The file must be tab-delimited,
     * with three columns: Network, Netmask, Network Name.
     *
     */
    public Prob13(String routingTableFile) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(routingTableFile));
        while (br.ready()) {
            String[] fields = br.readLine().split("\t");
            String network = fields[0];
            if (network.equals("default")) {
                defaultNet = fields[2];
            } else {
                ipAddress13 netIP = new ipAddress13(network);
                ipAddress13 netmask = new ipAddress13(fields[1]);
                String name = fields[2];
                networks.add(new Network(netIP, netmask, name));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Prob13 ipr = new Prob13(ROUTING_TABLE_FILE);
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(isr);
        while (stdin.ready()) {
            String ip = stdin.readLine();
            System.out.println(ipr.route(ip));
        }

    }

    /**
     * Routes an IP address to a network in the routing table, or the default
     * network if no acceptable networks exist.
     *
     * Tries each network in the order they were defined in the routing table
     * file.
     *
     * @param ip the IP address as a string (e.g. "1.2.3.4")
     * @return the name of a network, or the default network if no networks
     * match.
     */
    private String route(String ip) {
        ipAddress13 address = new ipAddress13(ip);
        for (Network net : networks) {
            if (net.contains(address)) {
                return net.getName();
            }
        }
        return defaultNet;
    }

}

/**
 * Represents a single IPv4 address.
 */
class ipAddress13 {

    private static final int NUM_OCTETS = 4;
    private int[] octets = new int[NUM_OCTETS];

    /**
     * Parses an IP address from a string. Note that since Java has no unsigned
     * byte type, the data type is int.
     *
     * @param ip an IP address as a String, e.g. "1.2.3.4"
     * @throws NumberFormatException if the string is not well-formatted.
     */
    public ipAddress13(String ip) {
        String[] address = ip.split("\\.");
        for (int i = 0; i < NUM_OCTETS; ++i) {
            octets[i] = Integer.parseInt(address[i]);
        }
    }

    public ipAddress13(int[] octets) {
        this.octets = octets;
    }

    /**
     * Performs a bitwise and of each octet of this IP with another. i.e.
     * this.and(other) == this & other
     *
     * @param other another IP address
     * @return this & other
     */
    public ipAddress13 and(ipAddress13 other) {
        int[] result = new int[NUM_OCTETS];
        for (int i = 0; i < NUM_OCTETS; ++i) {
            result[i] = octets[i] & other.octets[i];
        }
        return new ipAddress13(result);
    }

    /**
     * Compares this IP address to another based on its octets.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ipAddress13) {
            return Arrays.equals(octets, ((ipAddress13) obj).octets);
        }
        return super.equals(obj);
    }
}

/**
 * Represents a routable IP network, with a gateway IP address, netmask, and
 * identifying name.
 *
 * A network can be described by an IP address and a netmask. A netmask is a
 * filter that allows you to determine if an IP is part of a network
 */
class Network {

    private ipAddress13 network, netmask;
    private String name;

    public Network(ipAddress13 network, ipAddress13 netmask, String name) {
        this.network = network;
        this.netmask = netmask;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Determines if an IP address is part of this network.
     *
     * @param address a candidate IP address
     * @return true if and only if address & netmask == network
     */
    public boolean contains(ipAddress13 address) {
        return address.and(netmask).equals(network);
    }

}
