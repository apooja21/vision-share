import java.rmi.*;
import javax.naming.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.net.MalformedURLException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.registry.*;

public class DesktopServer
{
    
        
    public void host() throws RemoteException 
    {
        JFrame fr = new JFrame();
        int Port = 50000;
        try{
            System.setProperty("java.security.policy", "server.policy");
            System.setSecurityManager(new SecurityManager());
            LocateRegistry.createRegistry(Port);
            //JOptionPane.showMessageDialog(fr,"Registry Created");
        }
        catch(RemoteException e)
        {
            JOptionPane.showMessageDialog(fr,"Registry already exists");
        }
        try
        {
            Desktop broadcast = new Desktop();
            InetAddress ip = InetAddress.getLocalHost();
            String Hostname = ip.getHostAddress();
            String bind_location = "rmi://"+ Hostname +":"+ Port + "/broad";
            Naming.bind(bind_location,broadcast);
            JOptionPane.showMessageDialog(fr,"Registry Created! Server is READY!. Server Ip Address is"+Hostname);

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

    public static void startChatServer() {
        JFrame fr = new JFrame();
        int port = 50001;
        try {
                System.setProperty("java.security.policy", "server.policy");
                System.setSecurityManager(new SecurityManager());

                
                LocateRegistry.createRegistry(port);
                
                ChatServer broadcast = new ChatServer();
                InetAddress ip = InetAddress.getLocalHost();
                String Hostname = ip.getHostAddress();
                String bind_location = "rmi://"+ Hostname +":"+ port + "/chat";
                Naming.bind(bind_location,broadcast);
                JOptionPane.showMessageDialog(fr,"Registry Created! Server is READY!.  Chat Server Ip Address is"+Hostname);

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