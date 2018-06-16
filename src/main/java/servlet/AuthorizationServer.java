package servlet;

import com.fasterxml.jackson.databind.util.JSONPObject;
import data.AccessToken;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class AuthorizationServer {



    public static class AuthorizationEndpoint{

    }

    public static class TokenEndpoint{

    }
    public static class TokenIntrospectionEndpoint extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String recToken = req.getParameter("access_token");
            Map<String, Map<String, String>> tokenMap = AccessToken.getAccessToken();

            if(tokenMap.get(recToken)!=null){
                resp.setContentType("application/json");
                resp.setCharacterEncoding("utf-8");
                PrintWriter pw = resp.getWriter();
                JSONObject json = new JSONObject();
                json.put("active","true");
                Map<String, String> temp = tokenMap.get(recToken);
                String scope = "";
                for (Map.Entry entry: temp.entrySet())
                {
                    scope = entry.getKey().toString();
                }
                json.put("scope", scope);
                pw.print(json.toString());

            }else{
                resp.setContentType("application/json");
                resp.setCharacterEncoding("utf-8");
                PrintWriter pw = resp.getWriter();
                JSONObject json = new JSONObject();
                json.put("active","false");
                json.put("scope","");
                pw.print(json.toString());
            }

        }

    }


}
