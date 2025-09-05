import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client extends JFrame {
    private JTextField txtA, txtB, txtResult;
    private JButton btnAdd, btnSub, btnMul, btnDiv;

    public Client() {
        setTitle("NguyenCaoTung");
        setSize(520, 230);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 8, 6, 8);
        gbc.anchor = GridBagConstraints.WEST;

        add(new JLabel("Số 1:"), pos(gbc,0,0));
        txtA = new JTextField(18); add(txtA, pos(gbc,1,0));

        add(new JLabel("Số 2:"), pos(gbc,0,1));
        txtB = new JTextField(18); add(txtB, pos(gbc,1,1));

        add(new JLabel("Kết quả:"), pos(gbc,0,2));
        txtResult = new JTextField(18); txtResult.setEditable(false);
        add(txtResult, pos(gbc,1,2));

        JPanel p = new JPanel(new FlowLayout());
        btnAdd = new JButton("Cộng (+)");
        btnSub = new JButton("Trừ (-)");
        btnMul = new JButton("Nhân (*)");
        btnDiv = new JButton("Chia (/)");
        p.add(btnAdd); p.add(btnSub); p.add(btnMul); p.add(btnDiv);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        add(p, gbc);

        // gắn sự kiện
        btnAdd.addActionListener(e -> request("+"));
        btnSub.addActionListener(e -> request("-"));
        btnMul.addActionListener(e -> request("*"));
        btnDiv.addActionListener(e -> request("/"));
    }

    private GridBagConstraints pos(GridBagConstraints gbc, int x, int y) {
        GridBagConstraints c = (GridBagConstraints) gbc.clone();
        c.gridx = x; c.gridy = y; c.gridwidth = 1;
        return c;
    }

    private void request(String op) {
        try {
            double a = Double.parseDouble(txtA.getText().trim());
            double b = Double.parseDouble(txtB.getText().trim());

            try (Socket s = new Socket("127.0.0.1", 5000);
                 BufferedReader in = new BufferedReader(
                         new InputStreamReader(s.getInputStream(), StandardCharsets.UTF_8));
                 PrintWriter out = new PrintWriter(
                         new OutputStreamWriter(s.getOutputStream(), StandardCharsets.UTF_8), true)) {

                out.println(a + " " + op + " " + b);   // gửi sang server
                String resp = in.readLine();           // nhận kết quả
                txtResult.setText(resp != null ? resp : "Không có phản hồi");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Không kết nối được Server (hãy chạy Server trước và cho phép qua Firewall).");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Client().setVisible(true));
    }
}
