import java.rmi.*;
import java.rmi.registry.*;
import java.awt.Dimension;
import java.awt.image.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.swing.*;
import javax.imageio.*;
import javax.naming.*;
import java.rmi.ConnectException;
import java.net.MalformedURLException;
import java.util.Scanner;
import javax.swing.JButton;

public class DesktopClient extends JFrame
{
    

    public class ImageThreader extends Thread
    {
        public void run()
        {
            while(true)
            {
                try
                {
                    
                    byte[] data = obj.getDesktop();
                    InputStream in = new ByteArrayInputStream(data);
                    BufferedImage img = ImageIO.read(in);
                    setIcon(img);
                    Thread.sleep(1);
                    
                }
                catch(Exception e)
                {
                    System.out.println();
                }
            }
        }
    }
    public IDesktop obj;
    public JLabel lbl;
    public DesktopClient() throws RemoteException, NamingException
    {
        lbl = new JLabel();
        add(lbl);

        //System.out.println("Enter server ip address");
        //Scanner scan = new Scanner(System.in);
        String Remote_host = JOptionPane.showInputDialog(null,"Server Address","127.0.0.1");
        int Port = 50000;
        String Lookup_location = "rmi://" + Remote_host + ":" + Port + "/broad";
        try
        {
            System.setProperty("java.security.policy" , "client.Policy");
            System.setSecurityManager( new SecurityManager());
            // Registry registry = LocateRegistry.getRegistry(Port);
            obj = (IDesktop)Naming.lookup(Lookup_location);
            ImageThreader t = new ImageThreader();
            t.start();

        }
        catch(RemoteException e)
        {
            e.printStackTrace();
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();

        }
        catch(NotBoundException e)
        {
            e.printStackTrace();
        }
    }
    public void setIcon(BufferedImage img)
    {
        lbl.setIcon(new ImageIcon(img));
    }

    // public void connect() throws ConnectException, RemoteException, NamingException
    // {
        

        
    // }
}