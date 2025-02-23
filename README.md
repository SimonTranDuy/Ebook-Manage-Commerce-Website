# Ebook App

Ebook App là một ứng dụng web quản lý sách trực tuyến, cho phép người dùng đăng nhập, đăng ký, xem sách, thêm vào giỏ hàng, thanh toán, xem đơn hàng, và quản lý hồ sơ cá nhân. Quản trị viên có thể quản lý sách và đơn hàng thông qua các trang quản trị.

## Công nghệ sử dụng

- **IDE**: Visual Studio Code
- **Server**: Apache Tomcat 10.1.34
- **JDK**: Java Development Kit (JDK) 23
- **Database**: MySQL Workbench 8.0

## Các Tính Năng Chính

### Người dùng

- **Đăng ký**: Người dùng có thể đăng ký tài khoản mới.
- **Đăng nhập**: Người dùng có thể đăng nhập vào hệ thống.
- **Xem sách**: Người dùng có thể xem danh sách sách mới, sách cũ và sách gần đây.
- **Thêm vào giỏ hàng**: Người dùng có thể thêm sách vào giỏ hàng.
- **Thanh toán**: Người dùng có thể thanh toán và đặt hàng.
- **Xem đơn hàng**: Người dùng có thể xem danh sách đơn hàng của mình.
- **Cập nhật hồ sơ**: Người dùng có thể cập nhật thông tin cá nhân.
- **Đăng xuất**: Người dùng có thể đăng xuất khỏi hệ thống.

### Quản trị viên

- **Đăng nhập**: Quản trị viên có thể đăng nhập vào hệ thống.
- **Thêm sách**: Quản trị viên có thể thêm sách mới vào thư viện.
- **Chỉnh sửa sách**: Quản trị viên có thể chỉnh sửa thông tin sách.
- **Xóa sách**: Quản trị viên có thể xóa sách khỏi thư viện.
- **Xem sách**: Quản trị viên có thể xem danh sách sách trong thư viện.
- **Xem đơn hàng**: Quản trị viên có thể xem danh sách đơn hàng.
- **Quản lý người dùng**: Quản trị viên có thể quản lý thông tin người dùng.
- **Đăng xuất**: Quản trị viên có thể đăng xuất khỏi hệ thống.

## Hướng dẫn cài đặt và chạy dự án

1. **Cài đặt JDK 23**: Tải và cài đặt JDK 17 từ trang web chính thức của Oracle.
2. **Cài đặt Apache Tomcat**: Tải và cài đặt Apache Tomcat từ trang web chính thức của Apache.
3. **Cài đặt MySQL**: Tải và cài đặt MySQL từ trang web chính thức của MySQL.
4. **Cấu hình cơ sở dữ liệu**: Tạo cơ sở dữ liệu MySQL và cấu hình kết nối trong tệp `DBConnect.java`.
5. **Build dự án**: Sử dụng Maven để build dự án bằng lệnh `mvn clean install`.
6. **Triển khai ứng dụng**: Triển khai tệp `ebook-app.war` lên Apache Tomcat.
7. **Chạy ứng dụng**: Truy cập ứng dụng qua trình duyệt tại địa chỉ `http://localhost:8080/ebook-app`.
