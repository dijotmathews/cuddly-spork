// Import the Aerospike client library and other modules
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.aerospike.client.proxy.AerospikeClientFactory;
import com.aerospike.client.IAerospikeClient;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.WritePolicy;
import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.client.policy.TlsPolicy;
import com.aerospike.client.Host;
import com.aerospike.client.Key;
import com.aerospike.client.Bin;
import com.aerospike.client.AerospikeException;
import com.aerospike.client.Record;
import com.aerospike.client.cdt.MapOrder;

public class App {
    public static void main(String[] args) {


        ClientPolicy clientPolicy = new ClientPolicy();
        // clientPolicy.user = "<<YOUR_USERID_HERE>>";
        // clientPolicy.password = "<<YOUR_KEY_HERE>>";

        clientPolicy.tlsPolicy = new TlsPolicy();

        Policy policy = new Policy();
        policy.sendKey = true;
        WritePolicy writePolicy = new WritePolicy(policy);

        final String NAMESPACE = "aerospike_cloud";
        final String SET_NAME = "TestSet1";
        Boolean isProxy = true;


        Host[] hosts = new Host[1];
        hosts[0] = new Host("localhost", 3000);

        // Call factory code to create a new client.  This should work for both native and proxy clients
        IAerospikeClient client = AerospikeClientFactory.getClient(clientPolicy, isProxy, hosts);


        // Create a key in namespace "sandbox" and set "ufodata"
        Key key = new Key(NAMESPACE, SET_NAME, 5001);

        // Create a list of shapes to add to the report map
        ArrayList<String> shape = new ArrayList<String>();
        shape.add("circle");
        shape.add("flash");
        shape.add("disc");

        // Create the report map
        Map<String, Object> reportMap = new TreeMap<String, Object>();
        reportMap.put("city", "Ann Arbor");
        reportMap.put("state", "Michigan");
        reportMap.put("shape", shape);
        reportMap.put("duration", "5 minutes");
        reportMap.put("summary", "Large flying disc flashed in the sky above the student union. Craziest thing I've ever seen!");

        // Create the bins as Bin("binName", value)
        Bin occurred = new Bin("occurred", 20220531);
        Bin reported = new Bin("reported", 20220601);
        Bin posted = new Bin("posted", 20220601);
        Bin report = new Bin("report", reportMap, MapOrder.KEY_ORDERED);

        // Write the record to Aerospike
        try {
            client.put(writePolicy, key, occurred, reported, posted, report);
            Record record = client.get(null, key);
            System.out.format("Create succeeded\nKey: %s\n", key.userKey);
        }
        catch (AerospikeException ae) {
            System.out.format("Create Failed\nError: %s", ae.getMessage());
        }
        finally {
            // Close the client
            client.close();
        }
    }
}