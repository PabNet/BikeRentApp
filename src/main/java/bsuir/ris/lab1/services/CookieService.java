package bsuir.ris.lab1.services;

import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class CookieService {
    public void rememberValue(String name, String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(Integer.MAX_VALUE);
        response.addCookie(cookie);
    }

    public String getValue(String name, HttpServletRequest request) {
        for(var cookie : request.getCookies()) {
            if(cookie.getName().equals(name)) {
                return cookie.getValue();
            }
        }

        return null;
    }
}
