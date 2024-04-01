package com.ohgiraffers.section02.annotation;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(value = "/annotation-lifecycle")
public class LifeCycleTestServlet extends HttpServlet {

    private int initCount = 1;
    private int serviceCount = 1;
    private int destroyCount = 1;

    public LifeCycleTestServlet(){}

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        /* 필기
            서블릿 컨테이너에 의해 호출되며 최초 요청 시에느
            init() 이후에 동작하고,
            두 번째 요청부터는 init() 호출 없이
            service() 호출
         */
        System.out.println("어노테이션 매핑 service 메소드 호출 : " + serviceCount++);
    }

    @Override
    public void destroy() {
        /* 필기
            컨테이너가 종료 될 때 호출되는 메소드이며, 주로 자원을
            반납하는 용도로 사용된다.
         */
        System.out.println("어노테이션 매핑 destroy() 메소드 호출 : "+ destroyCount++);
    }

    @Override
    public void init() throws ServletException {
        /* 필기
            최초로 서블릿 요청 시에 동작하는 메소드
         */
        System.out.println("어노테이션 매핑 init() 메소드 호출 : " + initCount++);

    }
}
