
import com.model.Actor;
import com.util.HibernateUtil;
import java.util.Date;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sandra granados
 */
public class Ppal_test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
	Session session = HibernateUtil.getSessionFactory().openSession();

	session.beginTransaction();

	Actor stock = new Actor();
        stock.setFirstName("MARIA");
        stock.setLastName("DB");
        stock.setLastUpdate(new Date());
        session.save(stock);
	session.getTransaction().commit();
	System.out.println("Done");
        
        
    }
    
}
