package lit;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class UserCount
 *
 */
@WebListener
public class UserCount implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public UserCount() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    int currentuser=0,totaluser=0;
    public void sessionCreated(HttpSessionEvent se)  
    { 
         currentuser++;
         totaluser++;
         System.out.println("Total no of users connected : "+totaluser);
         System.out.println("Total no of Currently Connected : "+currentuser);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  
    { 
    	currentuser--;
        System.out.println("Total no of users connected : "+totaluser);
        System.out.println("Total no of Currently Connected : "+currentuser);
    }
	
}
