import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Ping2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		String host = "192.168.128.150";  //要连接的服务端IP地址  
	    int port = 5433;   //要连接的服务端对应的监听端口  
	      //与服务端建立连接  
	    Socket client ;
	    InetSocketAddress inetSocketAddress = new InetSocketAddress(host, port);
	    
		try {
			client = new Socket();
			client.connect(inetSocketAddress, 900);
			
			
			client.close();
		} catch (SocketTimeoutException e1){
			System.out.println("Timeout!");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	      //建立连接后就可以往服务端写数据了  
	      //Writer writer = new OutputStreamWriter(client.getOutputStream());  
	      //writer.write("Hello Server.");  
	      //writer.flush();//写完后要记得flush  
	      //writer.close();  
	       
	    */
		
		InetSocketAddress inetSocketAddress2 = new InetSocketAddress("155.35.89.31", 22);
		int result = 0;
		for(int i=0;i<15;i++){
			result = doTCPPing(inetSocketAddress2);
			System.out.println("Result i: "+result);
		}
	}

	private static int doTCPPing (InetSocketAddress inetSocketAddress)
    {
    	Socket client = new Socket() ;
    	long startTime = System.currentTimeMillis();	
    	long endTime = -1;
		try {
			client.connect(inetSocketAddress, 900);
			endTime = System.currentTimeMillis() ;
			client.close();
		} catch (SocketTimeoutException e1){
			return 0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(endTime > startTime) return (int)(endTime - startTime);
		else if ( endTime == startTime) return 1;
		else return 0;
    }
}
