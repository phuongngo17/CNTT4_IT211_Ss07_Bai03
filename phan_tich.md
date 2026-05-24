# Phân tích
## Input
- Các hàm giao dịch nhận OTP từ người dùng.
- OTP có thể:
    - hợp lệ
    - sai
    - null
    - chuỗi rỗng

## Output
- OTP đúng -> cho phép thực hiện giao dịch.
- OTP sai/null/rỗng -> chặn giao dịch và báo lỗi.

# Tại sao Custom Annotation tối ưu hơn Pointcut theo tên hàm?
Dùng Pointcut theo tên hàm:
# java
execution(* *withdraw*(..))
execution(* *transfer*(..))