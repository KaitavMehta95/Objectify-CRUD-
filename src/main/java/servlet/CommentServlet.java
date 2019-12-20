package servlet;

import com.google.gson.Gson;
import model.Comment;
import service.OfyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class CommentServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(CommentServlet.class.getName());

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("CommentServlet.doGet");
        String postID = req.getParameter("postID");
        log.info("CommentServlet.postID=" + postID);
        Util.addCorsHeader(resp);
        List<Comment> comments;

        if (postID != null && !postID.equals("")) {
            comments = OfyService.ofy().load().type(Comment.class).filter("postID", postID).order("-date").list();
        } else {
            comments = OfyService.ofy().load().type(Comment.class).order("-date").list();
        }
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        Gson gson = new Gson();
        writer.write(gson.toJson(comments));
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("CommentServlet.doPost");
        String jsonPost = Util.readInputText(req);

        Map result = new Gson().fromJson(jsonPost, Map.class);

        String author = (String) result.get("author");
        String text = (String) result.get("text");
        String postID = (String) result.get("postID");

        Comment comment = new Comment(author, text, postID);
        OfyService.ofy().save().entity(comment).now();

        Util.responseOkJSON(resp);
    }

    @Override
    public void doOptions(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        log.info("CommentServlet.doOptions");
        String origin = req.getHeader("Origin");
        log.info("Origin:" + origin);
        Util.addCorsHeader(resp);
    }

}
