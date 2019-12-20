package servlet;
import com.google.gson.Gson;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Util {


        static void addCorsHeader(HttpServletResponse response) {
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
            response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
            response.addHeader("Access-Control-Max-Age", "1728000");
        }

        static String readInputText(HttpServletRequest request) {
            StringBuffer jb = new StringBuffer();
            String line = null;
            try {
                BufferedReader reader = request.getReader();
                while ((line = reader.readLine()) != null)
                    jb.append(line);
            } catch (Exception e) {
                /*report an error*/
                return "error";
            }

            return jb.toString();
        }

        static void responseOkJSON(HttpServletResponse resp) throws IOException {
            PrintWriter writer = resp.getWriter();
            Gson gson = new Gson();
            Map<String, Object> resultOk = new HashMap<>();
            resultOk.put("response", "OK");
            writer.write(gson.toJson(resultOk));
        }
    }

