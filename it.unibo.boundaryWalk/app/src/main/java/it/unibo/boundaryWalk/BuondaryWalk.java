
package it.unibo.boundaryWalk;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.net.URI;

    public class BuondaryWalk {

        public BuondaryWalk() { }

    RobotUtils supportMove = new RobotUtils();

        public String doBoundary(){
            String result = "";
            boolean moveFailed = false;
            for(int i=1; i<=4; i++) {
                System.out.println("Wall n° "+i);
                while (!moveFailed)
                    moveFailed = supportMove.moveForward(250);
                    result += "w";
                moveFailed = supportMove.moveLeft(100);
                result += "l";
            }
            return result;
        }


        public static void main(String[] args)   {
            BuondaryWalk appl = new BuondaryWalk();
            appl.doBoundary();
            System.out.println("Done");

        }

    }

