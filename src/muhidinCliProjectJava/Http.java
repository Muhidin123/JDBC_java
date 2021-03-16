package muhidinCliProjectJava;
import java.net.*;
import java.io.*;

public class Http {
    public static void main(String[] args) throws Exception {

        URL oracle = new URL("https://jsonplaceholder.typicode.com/todos/1");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}
