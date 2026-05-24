package org.example.bai03.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.bai03.security.RequiresOTP;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OtpSecurityAspect {

    @Around("@annotation(requiresOTP)")
    public Object verifyOtp(
            ProceedingJoinPoint joinPoint,
            RequiresOTP requiresOTP
    ) throws Throwable {

        Object[] args = joinPoint.getArgs();

        String otp = null;

        for (Object arg : args) {
            if (arg instanceof String) {
                otp = (String) arg;
            }
        }

        if (otp == null || otp.trim().isEmpty()) {

            throw new RuntimeException(
                    "OTP không được để trống"
            );
        }

        if (!isValidOtp(otp)) {

            throw new RuntimeException(
                    "OTP không hợp lệ"
            );
        }

        return joinPoint.proceed();
    }

    private boolean isValidOtp(String otp) {
        return "123456".equals(otp);
    }
}