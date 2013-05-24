package first.mac;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class FirstprojectinmacServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
	
	
	public String inserIntoNewCustomer()
	        {
	        String newCustomerId = "";
	        NewCustomers pNewCustomers = null;
	        DateFormat formatter ;
	        
	            String     dateString = "20-Jun-2012";
	        try
	        {
	            log.info("Inside insert in to new customer");
	            pNewCustomers = new  NewCustomers();
	             
	              formatter = new SimpleDateFormat("dd-MMM-yy");
	            Date  date = (Date)formatter.parse(dateString);
	        
	        UUID uuidNewCustomerId = UUID.randomUUID();
	        newCustomerId = uuidNewCustomerId.toString();

	        pNewCustomers.setNewCustomerId( newCustomerId );
	        pNewCustomers.setAccountpin( "SEN42" );
	        pNewCustomers.setDeliveryFee(0.0);
	        pNewCustomers.setAccountNumber("8662052715");
	        pNewCustomers.setInitialDollars(199.99);
	        pNewCustomers.setMonthlyRecurringCharges(0.0);
	        pNewCustomers.setRecurringPayment(false);
	        pNewCustomers.setSetUpFee(49.99);
	        pNewCustomers.setUniquepin("54CWJ5");
	        pNewCustomers.setDateAdded(date);
	        try
	        {
	            PersistenceManager pm = null;
	             pm = PersistenceManagerUtil.getPersistanceManager();
	             pm.makePersistent( pNewCustomers );
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	            log.log( java.util.logging.Level.INFO  , e.getMessage() ,  e );
	            log.info("Exception inside pm");
	        }
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	            log.log( java.util.logging.Level.INFO  , e.getMessage() ,  e );
	            log.info("Exception inside insert method");
	        }
	        return "success";
	    }
	    }
}
