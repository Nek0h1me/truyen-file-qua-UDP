<h2 align="center">
    <a href="https://dainam.edu.vn/vi/khoa-cong-nghe-thong-tin">
    🎓 Faculty of Information Technology (DaiNam University)
    </a>
</h2>
<h2 align="center">
   TRUYỀN FILE QUA UDP
</h2>
<div align="center">
    <p align="center">
        <img src="docs/aiotlab_logo.png" alt="AIoTLab Logo" width="170"/>
        <img src="docs/fitdnu_logo.png" alt="AIoTLab Logo" width="180"/>
        <img src="docs/dnu_logo.png" alt="DaiNam University Logo" width="200"/>
    </p>

[![AIoTLab](https://img.shields.io/badge/AIoTLab-green?style=for-the-badge)](https://www.facebook.com/DNUAIoTLab)
[![Faculty of Information Technology](https://img.shields.io/badge/Faculty%20of%20Information%20Technology-blue?style=for-the-badge)](https://dainam.edu.vn/vi/khoa-cong-nghe-thong-tin)
[![DaiNam University](https://img.shields.io/badge/DaiNam%20University-orange?style=for-the-badge)](https://dainam.edu.vn)

</div>

# 📡 Truyền File Qua UDP

## 📖 1. Giới thiệu
Đề tài minh hoạ cách xây dựng một ứng dụng **truyền file qua giao thức UDP** dựa trên mô hình **Client/Server**.  
Ứng dụng cho phép:
- Client chia nhỏ file thành nhiều gói tin và gửi tới Server.
- Server nhận, ghép lại các gói tin và lưu thành file hoàn chỉnh.
- Minh họa lập trình mạng với **UDP socket** trong Java.


---

## 🔧 2. Ngôn ngữ lập trình sử dụng 
<div align="center">
  <img src="https://img.shields.io/badge/Java-orange?logo=java&logoColor=white&style=for-the-badge" alt="Java"/>
  <img src="https://img.shields.io/badge/UDP%20Socket-blue?logo=socketdotio&logoColor=white&style=for-the-badge" alt="UDP Socket"/>
  <img src="https://img.shields.io/badge/GitHub-black?logo=github&logoColor=white&style=for-the-badge" alt="GitHub"/>
  <img src="https://img.shields.io/badge/Git-red?logo=git&logoColor=white&style=for-the-badge" alt="Git"/>
</div>

Java UDP Socket GitHub Git

Java: Ngôn ngữ lập trình chính, sử dụng gói java.net để xử lý DatagramSocket và DatagramPacket (UDP), cùng với java.io để đọc/ghi file qua stream. Phiên bản Java 8 trở lên được khuyến nghị để đảm bảo tương thích.

UDP Socket: Giao thức cốt lõi, không kết nối (connectionless), truyền dữ liệu theo gói (datagram), tốc độ nhanh, không đảm bảo thứ tự và độ tin cậy như TCP. Phù hợp cho ứng dụng truyền file nhỏ, chat, hoặc game thời gian thực.

JDK (Java Development Kit): Phiên bản 8 trở lên để biên dịch và chạy code Java. Hỗ trợ sẵn các API mạng (java.net) và IO (java.io).

IDE (Môi trường phát triển): Có thể dùng VS Code (với extension "Extension Pack for Java") hoặc Eclipse (phù hợp cho project lớn). IDE giúp compile, debug và chạy Java dễ dàng.

GitHub: Nền tảng lưu trữ và chia sẻ mã nguồn, thuận tiện để quản lý project và làm việc nhóm.

Git: Hệ thống quản lý phiên bản phân tán, hỗ trợ theo dõi, quay lại lịch sử code, và cộng tác hiệu quả.

Môi trường chạy
<div align="center">
  <img src="https://img.shields.io/badge/JDK-green?logo=coffeescript&logoColor=white&style=for-the-badge" alt="JDK"/>
  <img src="https://img.shields.io/badge/VS%20Code-blue?logo=visualstudiocode&logoColor=white&style=for-the-badge" alt="VS Code"/>
</div>

JDK: Phiên bản 8 trở lên để biên dịch và chạy chương trình Java.

IDE: VS Code (nhẹ, tích hợp terminal) hoặc Eclipse (mạnh mẽ, hỗ trợ project Java phức tạp).

---

## 🖼 3. Hình ảnh các chức năng

Giao diện của Cient

<img width="728" height="484" alt="image" src="" />

Giao diện của Server

<img width="733" height="437" alt="image" src="" />

Chọn file gửi từ Client

<img width="726" height="481" alt="image" src="" />

Chọn thư mục lưu trữ trên Server

<img width="729" height="494" alt="image" " />

Lịch sử và thông tin file đã được gửi

<img width="1501" height="502" alt="image"" />


---

## ▶️ 4.  Hướng dẫn cài đặt và sử dụng

### Yêu cầu hệ thống
- **JDK 8+** (Java Development Kit)
- **Eclipse IDE** (có hỗ trợ Java Project)
- **Git** (nếu muốn clone project từ GitHub)

---

### Cài đặt project với Eclipse

1. **Clone project từ GitHub** (nếu dùng Git):
   ```bash
   git clone https://github.com/<username>/<repository>.git
Mở Eclipse → Import project

Vào File → Import…

Chọn Existing Projects into Workspace

Chọn thư mục project vừa clone (hoặc copy source code vào)

Nhấn Finish

Đảm bảo đã cài JDK 8+ trong Eclipse:

Vào Window → Preferences → Java → Installed JREs

Thêm JDK (nếu chưa có) và chọn làm mặc định.

***Cách chạy chương trình:***

Bước 1. Chạy Server

Trong Eclipse, mở file Server.java

Nhấn chuột phải → Run As → Java Application

Server sẽ bắt đầu chạy và lắng nghe kết nối UDP.

Bước 2. Chạy Client

Trong Eclipse, mở file Client.java

Nhấn chuột phải → Run As → Java Application

Ứng dụng Client sẽ mở cửa sổ chọn file (File Chooser).

Chọn bất kỳ file .txt nào từ máy tính của bạn để gửi.

Bước 3. Quá trình gửi file

Client sẽ gửi file .txt đã chọn tới Server qua UDP Socket.

Server nhận được file và lưu vào thư mục đích đã định nghĩa trong code.

---
   
## 📝5: Thông tin cá nhân
- Nguyễn Cao Tùng - CNTT 16-03
- Email: nguyentungxneko@gmail.com
- Phone: 0838986386
© 2025 AIoTLab, Faculty of Information Technology, DaiNam University. All rights reserved.
