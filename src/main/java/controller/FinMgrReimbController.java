package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Reimbursement;
import model.Response;
import service.FinMgrReimbService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class FinMgrReimbController {
    private static FinMgrReimbController finMgrReimbController;
    FinMgrReimbService finMgrReimbService;

    public FinMgrReimbController(FinMgrReimbService finMgrReimbService) {
        this.finMgrReimbService = finMgrReimbService;
    }

    private FinMgrReimbController() {
        this.finMgrReimbService = new FinMgrReimbService();
    }

    public static FinMgrReimbController getInstance() {
        if(finMgrReimbController == null) {
            finMgrReimbController = new FinMgrReimbController();
        }
        return finMgrReimbController;
    }

    public void retrieveEmplTickets(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        Integer statusId = Integer.parseInt(req.getParameter("statusId"));
        List<Reimbursement> employeeTickets;

        if(statusId > 0 && statusId < 4) {
            employeeTickets = finMgrReimbService.getFilteredEmployeeTickets(statusId);
            out.println(new ObjectMapper().writeValueAsString(
                    new Response("Filtered tickets retrieved",
                            true, employeeTickets)
            ));
        }else {
            employeeTickets = finMgrReimbService.getAllEmployeesTickets();
            out.println(new ObjectMapper().writeValueAsString(
                    new Response("All tickets retrieved",
                            true, employeeTickets)
            ));
        }
    }

    public void resolveTicket(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        Reimbursement reimbTicket = new ObjectMapper().readValue(requestBody, Reimbursement.class);

        finMgrReimbService.resolveTicket(reimbTicket);

        out.println(new ObjectMapper().writeValueAsString(
                new Response("Ticket successfully resolved",
                        true,
                        null)
        ));
    }
}
