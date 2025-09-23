import java.rmi.*;
import javax.naming.*;
import java.net.MalformedURLException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.registry.*;

 
public class StartServer {
	public static void main(String[] args) {
		try {
				System.setProperty("java.security.policy", "server.policy");
	            System.setSecurityManager(new SecurityManager());

	            int port = 50001;
	            LocateRegistry.createRegistry(port);
				
			 	// 	java.rmi.registry.LocateRegistry.createRegistry(port);
			 	
				// ChatServerInt b=new ChatServer();	
				// Naming.rebind("rmi://127.0.0.1/myabc", b);
				ChatServer broadcast = new ChatServer();
	            InetAddress ip = InetAddress.getLocalHost();
	            String Hostname = ip.getHostAddress();
	            String bind_location = "rmi://"+ Hostname +":"+ port + "/chat";
	            Naming.bind(bind_location,broadcast);
				System.out.println("[System] Chat Server is ready.");
			}
		catch(UnknownHostException e)
        {
            System.out.println("Error In Host Address");
            e.printStackTrace();
        }
        catch(RemoteException e)
        {
            e.printStackTrace();
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
	}
}