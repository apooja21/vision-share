import java.rmi.*;

public interface IDesktop extends Remote
{
    public byte[] getDesktop() throws RemoteException;
}
    
