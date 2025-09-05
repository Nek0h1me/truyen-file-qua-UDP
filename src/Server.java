import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) {
        int port = 5000;
        System.out.println("Server dang chay tai port " + port);
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> handle(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handle(Socket socket) {
        try (socket;
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true)) {

            String req = in.readLine();          
            if (req == null) return;

            String[] p = req.trim().split("\\s+");
            if (p.length != 3) { out.println("Loi: dinh dang"); return; }

            double a = Double.parseDouble(p[0]);
            String op = p[1];
            double b = Double.parseDouble(p[2]);

            String result;
            switch (op) {
                case "+": result = String.valueOf(a + b); break;
                case "-": result = String.valueOf(a - b); break;
                case "*": result = String.valueOf(a * b); break;
                case "/": result = (b == 0) ? "Loi: chia 0" : String.valueOf(a / b); break;
                default:  result = "Loi: phep toan";
            }
            out.println(result);
        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
