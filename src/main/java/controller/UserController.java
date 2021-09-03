package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Response;
import model.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class UserController {
    private static UserController userController;
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private UserController() {
        userService = new UserService();
    }

    public static UserController getInstance() {
        if(userController == null) {
            userController = new UserController();
        }
        return userController;
    }


    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        User user = new ObjectMapper().readValue(requestBody, User.class);

        User currentUser = userService.loginUser(user);

        if(currentUser != null){
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("activeUser", currentUser);

            out.println(new ObjectMapper().writeValueAsString(
                    new Response("Login Successful", true, currentUser)
            ));
        }else {
            out.println(new ObjectMapper().writeValueAsString(
                    new Response("Invalid username or password",
                            false, null)
            ));
        }
    }

    public void checkSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        User activeUser = (User) req.getSession().getAttribute("activeUser");

        if(activeUser != null) {
            out.println(new ObjectMapper().writeValueAsString(
                    new Response("Session found",
                            true, activeUser)
            ));
        }else {
            out.println(new ObjectMapper().writeValueAsString(
                    new Response("Session not found",
                            false, null)
            ));
        }
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        User activeUser = (User) req.getSession().getAttribute("activeUser");

        if(activeUser != null) {
            req.getSession().setAttribute("activeUser", null);

            out.println(new ObjectMapper().writeValueAsString(
                    new Response("Session terminated", true, null)
            ));
        }else {
            out.println(new ObjectMapper().writeValueAsString(
                    new Response("No session found to terminate", false, null)
            ));
        }
    }
}
