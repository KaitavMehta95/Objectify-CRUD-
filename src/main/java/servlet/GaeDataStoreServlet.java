package servlet;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Logger;

public class GaeDataStoreServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(GaeDataStoreServlet.class.getName());

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        log.info(" GAE DataStore ");

        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();


        // Create en entity without an identifier
        Entity e = new Entity("Person");
        e.setProperty("First Name","Kaitav");
        e.setProperty("Last Name","Mehta");


        ds.put(e);
        resp.setContentType("text/plain");
        resp.getWriter().println("Hello, Welcome to GAE datastpre");
    }
}
