<h2 align="center">
    <a href="https://dainam.edu.vn/vi/khoa-cong-nghe-thong-tin">
    🎓 Faculty of Information Technology (DaiNam University)
    </a>
</h2>
<h2 align="center">
TRUYỀN DẪN FILE BẰNG UDP
</h2>
<div align="center">
    <p align="center">
        <img src="img/aiotlab_logo.png" alt="AIoTLab Logo" width="170"/>
        <img src="img/fitdnu_logo.png" alt="AIoTLab Logo" width="180"/>
        <img src="img/dnu_logo.png" alt="DaiNam University Logo" width="200"/>
    </p>

[![AIoTLab](https://img.shields.io/badge/AIoTLab-green?style=for-the-badge)](https://www.facebook.com/DNUAIoTLab)
[![Faculty of Information Technology](https://img.shields.io/badge/Faculty%20of%20Information%20Technology-blue?style=for-the-badge)](https://dainam.edu.vn/vi/khoa-cong-nghe-thong-tin)
[![DaiNam University](https://img.shields.io/badge/DaiNam%20University-orange?style=for-the-badge)](https://dainam.edu.vn)

</div>


## 📖 1. Giới thiệu
Trang bị cho sinh viên hiểu về cách thức kết nối cơ bản của UDP từ client tới server bằng cách gửi 1 file txt có sẵn text trong đó đến server sẽ nhận file , tạo và lưu trữ vào trong code


### 🎯 Mục tiêu hệ thống
- Nghiên cứu lý thuyết về giao thức UDP và so sánh với TCP.
- Hiểu rõ cách thức hoạt động của UDP trong việc truyền tải dữ liệu.
- Xây dựng chương trình Client – Server bằng ngôn ngữ Java để gửi và nhận file .
- Vận dụng kiến thức về lập trình socket trong Java.

## 🔧 2. Ngôn ngữ lập trình sử dụng: 
<div align="center">
  <img src="https://img.shields.io/badge/Java-orange?logo=java&logoColor=white&style=flat-square" alt="Java"/>
  <img src="https://img.shields.io/badge/UDP%20Socket-blue?logo=socketdotio&logoColor=white&style=flat-square" alt="UDP Socket"/>
  <img src="https://img.shields.io/badge/GitHub-black?logo=github&logoColor=white&style=flat-square" alt="GitHub"/>
  <img src="https://img.shields.io/badge/Git-red?logo=git&logoColor=white&style=flat-square" alt="Git"/>
</div>
**Java**: Ngôn ngữ lập trình chính, sử dụng gói `java.net` để xử lý **DatagramSocket** và **DatagramPacket** (UDP), cùng với `java.io` để đọc/ghi file. Phiên bản **Java 8 trở lên** được khuyến nghị để đảm bảo tương thích.  

**UDP Socket**: Giao thức cốt lõi, **không kết nối (connectionless)**, truyền dữ liệu theo gói (datagram), tốc độ nhanh, không đảm bảo thứ tự và độ tin cậy như TCP. Phù hợp cho truyền file nhỏ, ứng dụng chat, hoặc game thời gian thực.  

**JDK (Java Development Kit)**: Phiên bản 8 trở lên để biên dịch và chạy code Java. Hỗ trợ sẵn các API mạng (`java.net`) và IO (`java.io`).  

**IDE (Môi trường phát triển)**: Có thể dùng **VS Code** (với extension *Extension Pack for Java*) hoặc **Eclipse**. IDE giúp compile, debug và chạy Java dễ dàng.  

**GitHub**: Nền tảng lưu trữ và chia sẻ repo Git online.  

**Git**: Công cụ quản lý phiên bản phân tán, giúp theo dõi xử lý và tìm lại lịch sử code.  

---

### Môi trường chạy  

<div align="center">
  <img src="https://img.shields.io/badge/JDK-orange?logo=coffeescript&logoColor=white&style=flat-square" alt="JDK"/>
  <img src="https://img.shields.io/badge/VS%20Code-blue?logo=visualstudiocode&logoColor=white&style=flat-square" alt="VS Code"/>
</div>

- **JDK**: Phiên bản 8 trở lên để biên dịch và chạy chương trình Java.  
- **VS Code / Eclipse**: IDE để biên dịch, debug và chạy ứng dụng Java, ưu tiên Eclipse để hỗ trợ chạy java tốt hơn.


##   3 Hình ảnh các chức năng 

<div style="text-align:center;">
  <img src="img/1.png" alt="Mô tả" style="max-width:100%; display:block; margin:0 auto;">
  <p align="center" style="margin:8px 0 0;">1: Server</p>
</div>
<div style="text-align:center;">
  <img src="img/2.png" alt="Mô tả" style="max-width:100%; display:block; margin:0 auto;">
  <p align="center" style="margin:8px 0 0;">2: Client</p>
</div>
<div style="text-align:center;">
  <img src="img/3.png" alt="Mô tả" style="max-width:100%; display:block; margin:0 auto;">
  <p align="center" style="margin:8px 0 0;">3: Chọn file đưa vào Client</p>
</div>

## 🚀 4. Hướng dẫn chạy

### Yêu cầu hệ thống
- **JDK 8+** (Java Development Kit)
- **Eclipse IDE** (có hỗ trợ Java Project)
- **Git** (nếu muốn clone project từ GitHub)

---

### Cài đặt project với Eclipse
1. **Clone project từ GitHub** (nếu dùng Git):
   ```bash
   git clone [https://github.com/Nek0h1me/truyen-file-qua-UDP.git]
Mở Eclipse → Import project

Vào File → Import…

Chọn Existing Projects into Workspace

Chọn thư mục project vừa clone (hoặc copy source code vào)

Nhấn Finish

Đảm bảo đã cài JDK 8+ trong Eclipse:

Vào Window → Preferences → Java → Installed JREs

Thêm JDK (nếu chưa có) và chọn làm mặc định.

Cách chạy chương trình:

Bước 1. Chạy Server
Trong Eclipse, mở file Server.java

Nhấn chuột phải → Run As → Java Application

Nhấn vào Bắt đầu Server

Server sẽ bắt đầu chạy và lắng nghe kết nối UDP.

Bước 2. Chạy Client

Trong Eclipse, mở file Client.java

Nhấn chuột phải → Run As → Java Application

Ứng dụng Client sẽ mở cửa sổ chọn file (File Chooser).

Chọn bất kỳ file .txt nào từ trong máy tính của bạn để gửi.

Bước 3. Quá trình gửi file

Client sẽ gửi file .txt đã chọn tới Server qua UDP Socket.

Server nhận được file và lưu vào thư mục đích đã nằm trong folder chứa code.


##  5. Liên hệ 
**Họ tên**: Nguyễn Cao Tùng.  
**Lớp**: CNTT 16-03.  
**Email**: nguyentungxneko@gmail.com.

© 2025 AIoTLab, Faculty of Information Technology, DaiNam University. All rights reserved.

---
