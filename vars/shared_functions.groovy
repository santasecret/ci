import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import hudson.tasks.test.AbstractTestResultAction;
import hudson.model.Actionable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;


def sendGotifyNotification(status) {
    GOTIFY_URL = "https://gotify.codingcoffee.me/message"

    def url = new URL(GOTIFY_URL)
    def conn = url.openConnection()
    conn.setDoOutput(true)
    def writer = new OutputStreamWriter(conn.getOutputStream())

    writer.write("token=AVtxK9UMRBFESY.&title=Rusty&message=${status}&priority=5")
    writer.flush()
    String line
    def reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))
    while ((line = reader.readLine()) != null) {
      println line
    }
    writer.close()
    reader.close()
}

