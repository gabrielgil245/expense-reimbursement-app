package frontcontroller;

import controller.EmplReimbController;
import controller.FinMgrReimbController;
import controller.UserController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="dispatcher", urlPatterns = "/api/*")
public class Dispatcher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String uri = req.getRequestURI();
        System.err.println(uri);
        try {
            switch(uri) {
                case "/expense-reimbursement-system/api/check-session":
                    UserController.getInstance().checkSession(req, resp);
                    break;
                case "/expense-reimbursement-system/api/logout":
                    UserController.getInstance().logout(req, resp);
                    break;
                case "/expense-reimbursement-system/api/tickets":
                    EmplReimbController.getInstance().getUserTickets(req, resp);
                    break;
                case "/expense-reimbursement-system/api/mgr-tickets":
                    FinMgrReimbController.getInstance().retrieveEmplTickets(req, resp);
                    break;
                default:
                    break;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String uri = req.getRequestURI();
        System.err.println(uri);
        try {
            if(uri.equals("/expense-reimbursement-system/api/login"))
                UserController.getInstance().login(req, resp);
            if(uri.equals("/expense-reimbursement-system/api/tickets"))
                EmplReimbController.getInstance().addTicket(req, resp);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        String uri = req.getRequestURI();
        System.err.println(uri);
        try {
            if(uri.equals("/expense-reimbursement-system/api/resolve-ticket"))
                FinMgrReimbController.getInstance().resolveTicket(req, resp);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
