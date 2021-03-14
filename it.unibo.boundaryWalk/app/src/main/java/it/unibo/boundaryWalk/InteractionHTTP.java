package it.unibo.boundaryWalk;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.net.URI;

public class InteractionHTTP {
    private  final String localHostName    = "localhost";
    private  final int port                = 8090;
    private  final String URL              = "http://"+localHostName+":"+port+"/api/move";

    protected boolean sendCmd(String move, int time)  {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            System.out.println( move + " sendCmd "  );
            //String json         = "{\"robotmove\":\"" + move + "\"}";
            String json         = "{\"robotmove\":\"" + move + "\" , \"time\": " + time + "}";
            StringEntity entity = new StringEntity(json);
            HttpUriRequest httppost = RequestBuilder.post()
                    .setUri(new URI(URL))
                    .setHeader("Content-Type", "application/json")
                    .setHeader("Accept", "application/json")
                    .setEntity(entity)
                    .build();
            CloseableHttpResponse response = httpclient.execute(httppost);
            //System.out.println( "MoveVirtualRobot | sendCmd response= " + response );
            boolean collision = RobotUtils.checkCollision(response);
            return collision;
        } catch(Exception e){
            System.out.println("ERROR:" + e.getMessage());
            return true;
        }
    }

}
