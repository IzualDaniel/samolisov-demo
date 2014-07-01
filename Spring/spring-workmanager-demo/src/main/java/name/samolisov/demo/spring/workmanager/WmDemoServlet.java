package name.samolisov.demo.spring.workmanager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import name.samolisov.demo.spring.workmanager.services.RunnableService;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class WmDemoServlet extends HttpServlet {

    private static final long serialVersionUID = -4412451206671232231L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("servlet running into thread: " + 
            Thread.currentThread().getName());
        ApplicationContext ctx = WebApplicationContextUtils
                .getWebApplicationContext(getServletContext());
        RunnableService service = ctx.getBean("runnableService", RunnableService.class);
        service.doIt();
    }
}
