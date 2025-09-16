package truyenfilebangudp1;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.net.*;
public class Client  extends JFrame{
	    private JTextField ipField, portField;
	    private JTextArea logArea;
	    private File selectedFile;

	    public Client() {
	        setTitle("UDP File Client");
	        setSize(400, 300);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setLayout(new BorderLayout());

	        // Panel nhập IP và Port
	        JPanel topPanel = new JPanel(new GridLayout(2, 2));
	        topPanel.add(new JLabel("Server IP:"));
	        ipField = new JTextField("127.0.0.1");
	        topPanel.add(ipField);
	        topPanel.add(new JLabel("Port:"));
	        portField = new JTextField("9876");
	        topPanel.add(portField);
	        add(topPanel, BorderLayout.NORTH);

	        // Khu vực log
	        logArea = new JTextArea();
	        logArea.setEditable(false);
	        add(new JScrollPane(logArea), BorderLayout.CENTER);

	        // Nút chọn file và gửi
	        JPanel bottomPanel = new JPanel();
	        JButton chooseBtn = new JButton("Chọn file");
	        JButton sendBtn = new JButton("Gửi file");

	        chooseBtn.addActionListener(e -> chooseFile());
	        sendBtn.addActionListener(e -> sendFile());

	        bottomPanel.add(chooseBtn);
	        bottomPanel.add(sendBtn);
	        add(bottomPanel, BorderLayout.SOUTH);
	    }

	    private void chooseFile() {
	        JFileChooser chooser = new JFileChooser();
	        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
	            selectedFile = chooser.getSelectedFile();
	            logArea.append("Đã chọn file: " + selectedFile.getName() + "\n");
	        }
	    }

	    private void sendFile() {
	        if (selectedFile == null) {
	            JOptionPane.showMessageDialog(this, "Chưa chọn file!");
	            return;
	        }
	        new Thread(() -> {
	            try (DatagramSocket socket = new DatagramSocket();
	                 FileInputStream fis = new FileInputStream(selectedFile)) {

	                InetAddress serverAddr = InetAddress.getByName(ipField.getText());
	                int port = Integer.parseInt(portField.getText());
	                byte[] buffer = new byte[1024];
	                int bytesRead;

	                while ((bytesRead = fis.read(buffer)) != -1) {
	                    DatagramPacket packet = new DatagramPacket(buffer, bytesRead, serverAddr, port);
	                    socket.send(packet);
	                }

	                byte[] endMsg = "EOF".getBytes();
	                DatagramPacket endPacket = new DatagramPacket(endMsg, endMsg.length, serverAddr, port);
	                socket.send(endPacket);

	                logArea.append("Gửi file xong!\n");
	            } catch (Exception ex) {
	                ex.printStackTrace();
	                logArea.append("Lỗi khi gửi file: " + ex.getMessage() + "\n");
	            }
	        }).start();
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new Client().setVisible(true));
	    }
	}
