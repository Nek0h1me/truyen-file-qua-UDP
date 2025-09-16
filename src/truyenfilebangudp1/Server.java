package truyenfilebangudp1;
import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class Server extends JFrame{
	   private JTextField portField;
	    private JTextArea logArea;
	    private JButton startBtn;
	    private volatile boolean running = false;

	    public Server() {
	        setTitle("UDP File Server");
	        setSize(400, 300);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setLayout(new BorderLayout());

	        // Panel nhập port
	        JPanel topPanel = new JPanel(new GridLayout(1, 2));
	        topPanel.add(new JLabel("Port:"));
	        portField = new JTextField("9876");
	        topPanel.add(portField);
	        add(topPanel, BorderLayout.NORTH);

	        // Khu vực log
	        logArea = new JTextArea();
	        logArea.setEditable(false);
	        add(new JScrollPane(logArea), BorderLayout.CENTER);

	        // Nút Start
	        startBtn = new JButton("Bắt đầu Server");
	        startBtn.addActionListener(e -> toggleServer());
	        add(startBtn, BorderLayout.SOUTH);
	    }

	    private void toggleServer() {
	        if (!running) {
	            running = true;
	            startBtn.setText("Dừng Server");
	            int port = Integer.parseInt(portField.getText());
	            new Thread(() -> startServer(port)).start();
	        } else {
	            running = false;
	            startBtn.setText("Bắt đầu Server");
	            logArea.append("Server đã dừng.\n");
	        }
	    }

	    private void startServer(int port) {
	        try (DatagramSocket socket = new DatagramSocket(port);
	             FileOutputStream fos = new FileOutputStream("received_file.txt")) {

	            logArea.append("Server đang lắng nghe trên port " + port + "...\n");

	            byte[] buffer = new byte[1024];
	            while (running) {
	                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
	                socket.receive(packet);

	                String message = new String(packet.getData(), 0, packet.getLength());
	                if (message.equals("EOF")) {
	                    logArea.append("Nhận file thành công! Đã lưu vào received_file.txt\n");
	                    break;
	                }

	                fos.write(packet.getData(), 0, packet.getLength());
	                fos.flush();
	                logArea.append("Đã nhận " + packet.getLength() + " byte\n");
	            }

	        } catch (Exception ex) {
	            ex.printStackTrace();
	            logArea.append("Lỗi server: " + ex.getMessage() + "\n");
	        }
	        running = false;
	        SwingUtilities.invokeLater(() -> startBtn.setText("Bắt đầu Server"));
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new Server().setVisible(true));
	    }
	}
