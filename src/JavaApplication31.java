import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaApplication31 {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(30333);

        Socket soc = server.accept();
        System.out.println("Client" + soc.getInetAddress().getHostAddress()
                          + " connect");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(soc.getInputStream()));
        String str = reader.readLine();
        System.out.println("Client sent: "+ str);

        BufferedWriter writer =new BufferedWriter(
                new OutputStreamWriter(soc.getOutputStream()));
        writer.write(str);
        writer.write("- accepted");
        writer.write("\n");
        writer.flush();

    }

}
