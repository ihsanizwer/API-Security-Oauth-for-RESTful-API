package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationServer {



    public static class AuthorizationEndpoint{

    }

    public static class TokenEndpoint{

    }
    public static class TokenIntrospectionEndpoint extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getParameter("access_token");
        }

    }


}
