package kr.ac.jbnu.ath.practice1.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoggingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // api 요청이 들어올 때마다 콘솔에 http 메소드와 url을 출력.
        System.out.println("[Request Log] Method: " + request.getMethod() + " | URI: " + request.getRequestURI());
        return true;
    }
}