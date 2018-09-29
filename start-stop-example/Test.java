import java.io.*;
import java.net.*;

public class Test {
  public static void main(String[] args)  throws Exception {
      try(
        ServerSocket serverSocket = new ServerSocket(9000);
      ){
        while (true) {
            Socket socket = serverSocket.accept();
        
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String info = null;
            
            while((info=br.readLine()) != null) {
                System.out.println("Client said: " + info);
            }
            socket.shutdownInput();
            
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("You're welcome!");
            pw.flush();
            
            pw.close();
            os.close();
            br.close();
            isr.close();
            is.close();
            
            socket.close();
          }
      }
  }
}

