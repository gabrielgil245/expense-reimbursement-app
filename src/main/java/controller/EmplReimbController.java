package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Reimbursement;
import model.Response;
import service.EmplReimbService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class EmplReimbController {
    private static EmplReimbController emplReimbController;
    EmplReimbService emplReimbService;

    public EmplReimbController(EmplReimbService emplReimbService) {
        this.emplReimbService = emplReimbService;
    }

    private EmplReimbController() {
        emplReimbService = new EmplReimbService();
    }

    public static EmplReimbController getInstance() {
        if(emplReimbController == null) {
            emplReimbController = new EmplReimbController();
        }
        return emplReimbController;
    }


    public void getUserTickets(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        Integer userId = Integer.parseInt(req.getParameter("id"));

        out.println(new ObjectMapper().writeValueAsString(
                new Response("Tickets retrieved",
                        true, emplReimbService.getUserTickets(userId))
        ));
    }

    public void addTicket(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Reimbursement reimbursement = new ObjectMapper().readValue(requestBody, Reimbursement.class);

        emplReimbService.addReimbTicket(reimbursement);

        out.println(new ObjectMapper().writeValueAsString(
                new Response("Your ticket was successfully generated",
                        true, null)
        ));
    }
}
