package microservice;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


@Controller
@EnableAutoConfiguration
@RequestMapping("api/user")
public class ReourceServer {
    /*
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    String list(@RequestHeader HttpHeaders headers, @RequestParam("name") String name)
    {

        return "Listing of User\n";
    }*/

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    String add(@RequestHeader HttpHeaders headers, @RequestParam("name") String name){
        String accessToken =processHeaders(headers);
        final String postURL = "http://localhost:8080/APISecurityOauthforRESTfulAPI/token_introspection_endpoint";
        final String postParams = "access_token="+accessToken;
        return "Added User :\n";
    }

    private String processHeaders(HttpHeaders headers){
        String accessToken = "";
        return accessToken;
    }

    private void sendPost(String postURL, String postParams) throws IOException {
        URL obj = new URL(postURL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        OutputStream os =con.getOutputStream();
        os.write(postParams.getBytes());
        os.flush();
        os.close();

        int responseCode = con.getResponseCode();
        System.out.println("POST response code :"+responseCode);

        if(responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine())!=null){
                response.append(inputLine);
            }
            in.close();
        }else{
            System.out.println("Request did not work");
        }
    }

    /*
    Removing these as irrelavent
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    String update(@RequestHeader HttpHeaders headers, @RequestParam("name") String name){

        System.out.println(headers);
        return "Updated user :\n";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    String delete(@RequestHeader HttpHeaders headers, @RequestParam("name") String name)
    {
        return "Deleted User :"+name+"\n";
    }*/
}
