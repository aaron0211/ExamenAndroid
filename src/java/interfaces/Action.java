package interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aaron
 */
public interface Action {
    public String execute(
	            HttpServletRequest request, 
	            HttpServletResponse response
	   );
}
