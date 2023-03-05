import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
public class skiers extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //System.out.println("I am called");
        /*HashMap<String, String> errors = new HashMap<>();
        if (request.getParameter("resortID") == null || request.getParameter("resortID").isEmpty()) {
            errors.put("resortID", "Resort ID is required");
        }
        if (request.getParameter("dayID") == null || request.getParameter("dayID").isEmpty()) {
            errors.put("dayID", "Day ID is required");
        }
        if (request.getParameter("skierID") == null || request.getParameter("skierID").isEmpty()) {
            errors.put("skierID", "Skier ID is required");
        }
        if (request.getParameter("liftID") == null || request.getParameter("liftID").isEmpty()) {
            errors.put("liftID", "Lift ID is required");
        }
        if (request.getParameter("time") == null || request.getParameter("time").isEmpty()) {
            errors.put("time", "Time is required");
        }
        if (request.getParameter("seasonID") == null || request.getParameter("seasonID").isEmpty()) {
            errors.put("season", "seasonID is required");
        }
        
        if (!errors.isEmpty()) 
        {
            // Return a 4XX response code and error message if invalid values/formats supplied
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");
            out.print(errors);
            out.close();
            return;
        }*/
        
        /*int resortID, seasonID, dayID, skierID, time, liftID;
        try 
        {
        //System.out.println(request.getParameter("resortID"));
         resortID = Integer.parseInt(request.getParameter("resortID").toString().trim());
        //System.out.println("resortID : "+resortID);
         dayID = Integer.parseInt(request.getParameter("dayID"));
        //System.out.println("dayID : "+dayID);
         skierID = Integer.parseInt(request.getParameter("skierID"));
        //System.out.println("skierID : "+skierID);
         liftID = Integer.parseInt(request.getParameter("liftID"));
        //System.out.println("liftID : "+liftID);
         time = Integer.parseInt(request.getParameter("time"));
        //System.out.println("time : "+time);
         seasonID= Integer.parseInt(request.getParameter("seasonID"));
        //System.out.println("seasonID : "+seasonID);
        }
        catch(NumberFormatException e)
        {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Invalid parameter format");
            return;
        }*/
        
        
        
        // Validate the parameters values
          StringBuffer jb = new StringBuffer();
          BufferedReader reader = request.getReader();
          String line=null;
          while ((line = reader.readLine()) != null)
          {
              jb.append(line);
          }
        Gson gson = new Gson();
        skier s = (skier) gson.fromJson(jb.toString(),skier.class);
        
        if (s.resortID < 1 || s.resortID > 10|| s.seasonID != 2022 || s.dayID !=1  || s.skierID < 1 || s.skierID >100000|| s.liftID < 1 || s.liftID >40|| s.time < 1 || s.time >360) 
        {
            System.out.println("Error");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("Invalid parameters supplied");
            out.close();
            return;
        }
        System.out.println("PARAMETER Value Received");
        // Generate some dummy data as a response body
        //String responseBody = "{ \"message\": \"success\" }";
        String responseBody = "{ "
                            + "\"message\": \"success\", " 
                            + "\"skierID\": \"" + s.skierID + "\", "
                            + "\"resortID\": \"" + s.resortID + "\", "
                            + "\"liftID\": \"" + s.liftID + "\", "
                            + "\"seasonID\": \"" + s.seasonID + "\", "
                            + "\"dayID\": \"" + s.dayID + "\", "
                            + "\"time\": \"" + s.time + "\""
                            + " }";
        
        // Set the status code to 200/201
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        out.println(responseBody);
        out.close();
    }
}
