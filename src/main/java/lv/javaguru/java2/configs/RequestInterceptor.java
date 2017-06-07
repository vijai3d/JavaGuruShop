package lv.javaguru.java2.configs;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Vijai3D on 07.06.2017.
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       HttpSession session = request.getSession(false);

       String uri = request.getRequestURI();

        if (!uri.endsWith("index")) {
            if (session == null) {
                request.setAttribute("message", "Your Session is Expired!");
                request.getRequestDispatcher("index").forward(request, response);
                return false;
            }
        }
        return true;
    }
}
