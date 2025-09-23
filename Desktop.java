import java.rmi.*;
import java.awt.*;
import javax.imageio.*;
import java.rmi.server.*;
import java.util.Locale;
import java.awt.image.*;
import java.io.*;

public class Desktop extends UnicastRemoteObject implements IDesktop
{
    public Desktop() throws RemoteException
    {

    }

    public byte[] getDesktop()
    {
        try
        {
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice screen= env.getDefaultScreenDevice();
            Robot robot = new Robot(screen);
            Dimension size= Toolkit.getDefaultToolkit().getScreenSize();
            BufferedImage img = robot.createScreenCapture(new Rectangle(0,0,size.width,size.height));
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            ImageIO.write(img,"jpg",bytes);
            bytes.flush();
            byte[] data = bytes.toByteArray();
            bytes.close();
            System.gc();
            return data;
             
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
}