package it.unibo.boundaryWalk;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RobotUtils {

    InteractionHTTP supportHTTP = new InteractionHTTP();

    public boolean moveForward(int duration)  { return supportHTTP.sendCmd("moveForward", duration);  }
    public boolean moveBackward(int duration) { return supportHTTP.sendCmd("moveBackward", duration); }
    public boolean moveLeft(int duration)     { return supportHTTP.sendCmd("turnLeft", duration);     }
    public boolean moveRight(int duration)    { return supportHTTP.sendCmd("turnRight", duration);    }
    public boolean moveStop(int duration)     { return supportHTTP.sendCmd("alarm", duration);        }


    protected static boolean checkCollision(CloseableHttpResponse response) throws Exception {

        try {
            //response.getEntity().getContent() is an InputStream
            String jsonStr = EntityUtils.toString(response.getEntity());
            System.out.println("MoveVirtualRobot | checkCollision_simple jsonStr= " + jsonStr);
            //jsonStr = {"endmove":true,"move":"moveForward"}
            JSONObject jsonObj = new JSONObject(jsonStr);
            boolean collision = false;
            if (jsonObj.get("endmove") != null) {
                collision = !jsonObj.get("endmove").toString().equals("true");
                System.out.println("MoveVirtualRobot | checkCollision_simple collision=" + collision);
            }
            return collision;
        } catch (Exception e) {
            System.out.println("MoveVirtualRobot | checkCollision_simple ERROR:" + e.getMessage());
            throw (e);
        }
    }

}
