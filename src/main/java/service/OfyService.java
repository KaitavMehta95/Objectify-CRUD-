package service;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import model.Comment;
import model.Employee;

public class OfyService {
    /**
     *
     * Create OfyService and register it only once.
     * Used static block to achieve this functionality
     *
     */

    static{

        ObjectifyService.register(Comment.class);
        ObjectifyService.register(Employee.class);

    }

    public static Objectify ofy(){
        return ObjectifyService.ofy();
    }
}
