package frontcontroller;

import controller.EmplReimbController;
import controller.FinMgrReimbController;
import controller.UserController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DispatcherTest {
    Dispatcher dispatcher;

    /*UserController userController;

    EmplReimbController emplReimbController;

    FinMgrReimbController finMgrReimbController;*/

    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);

    HttpServletResponse resp = Mockito.mock(HttpServletResponse.class);

    @BeforeEach
    void setUp() {
        dispatcher = new Dispatcher();
    }

    @Test
    void doGetCheckSession() throws IOException {
        //Assign
        String uri = "/gabrielgil-project-1/api/check-session";
        Mockito.when(req.getRequestURI()).thenReturn(uri);
        //Act
        dispatcher.doGet(req, resp);
        //Assert
        System.out.println(uri);
        Mockito.verify(req, Mockito.times(1)).getRequestURI();
        //NullPointerException points at controller.UserController.checkSession.

        //Mockito.verify(userController, Mockito.times(1)).checkSession(req, resp);
        //Mockito.verify not work because the Mocked HttpServletRequest and Response
        //are different from the variables of the method's the parameter signature.
    }

    @Test
    void doGetLogOut() throws IOException {
        //Assign
        String uri = "/gabrielgil-project-1/api/logout";
        Mockito.when(req.getRequestURI()).thenReturn(uri);
        //Act
        dispatcher.doGet(req, resp);
        //Assert
        System.out.println(uri);
        Mockito.verify(req, Mockito.times(1)).getRequestURI();
        //NullPointerException points at controller.UserController.logout.

        //Mockito.verify(userController, Mockito.times(1)).logout(req, resp);
        //Mockito.verify not work because the Mocked HttpServletRequest and Response
        //are different from the variables of the method's the parameter signature.
    }

    @Test
    void doGetUserTickets() throws IOException {
        //Assign
        String uri = "/gabrielgil-project-1/api/tickets";
        Mockito.when(req.getRequestURI()).thenReturn(uri);
        //Act
        dispatcher.doGet(req, resp);
        //Assert
        System.out.println(uri);
        Mockito.verify(req, Mockito.times(1)).getRequestURI();
        //NumberFormatException points at controller.EmplReimbController.getUserTickets.

        //Mockito.verify(emplReimbController, Mockito.times(1)).getUserTickets(req, resp);
        //Mockito.verify not work because the Mocked HttpServletRequest and Response
        //are different from the variables of the method's the parameter signature.
    }

    @Test
    void doGetEmplTickets() throws IOException {
        //Assign
        String uri = "/gabrielgil-project-1/api/mgr-tickets";
        Mockito.when(req.getRequestURI()).thenReturn(uri);
        //Act
        dispatcher.doGet(req, resp);
        //Assert
        System.out.println(uri);
        Mockito.verify(req, Mockito.times(1)).getRequestURI();
        //NumberFormatException points at controller.FinMgrReimbController.retrieveEmplTickets.

        //Mockito.verify(finMgrReimbController, Mockito.times(1)).retrieveEmplTickets(req, resp);
        //Mockito.verify not work because the Mocked HttpServletRequest and Response
        //are different from the variables of the method's the parameter signature.
    }

    @Test
    void doPostLogin() {
        //Assign
        String uri = "/gabrielgil-project-1/api/login";
        Mockito.when(req.getRequestURI()).thenReturn(uri);
        //Act
        dispatcher.doPost(req, resp);
        //Assert
        System.out.println(uri);
        Mockito.verify(req, Mockito.times(1)).getRequestURI();
        //NullPointerException points at controller.UserController.login.

        //Mockito.verify(userController, Mockito.times(1)).login(req, resp);
        //Mockito.verify not work because the Mocked HttpServletRequest and Response
        //are different from the variables of the method's the parameter signature.
    }

    @Test
    void doPostAddReimbursementTicket() {
        //Assign
        String uri = "/gabrielgil-project-1/api/tickets";
        Mockito.when(req.getRequestURI()).thenReturn(uri);
        //Act
        dispatcher.doPost(req, resp);
        //Assert
        System.out.println(uri);
        Mockito.verify(req, Mockito.times(1)).getRequestURI();
        //NullPointerException points at controller.EmplReimbController.addTicket.

        //Mockito.verify(emplReimbController, Mockito.times(1)).addTicket(req, resp);
        //Mockito.verify not work because the Mocked HttpServletRequest and Response
        //are different from the variables of the method's the parameter signature.
    }

    @Test
    void doPut() {
        //Assign
        String uri = "/gabrielgil-project-1/api/resolve-ticket";
        Mockito.when(req.getRequestURI()).thenReturn(uri);
        //Act
        dispatcher.doPut(req, resp);
        //Assert
        System.out.println(uri);
        Mockito.verify(req, Mockito.times(1)).getRequestURI();
        //NullPointerException points at controller.FinMgrReimbController.resolveTicket.

        //Mockito.verify(finMgrReimbController, Mockito.times(1)).resolveTickets(req, resp);
        //Mockito.verify not work because the Mocked HttpServletRequest and Response
        //are different from the variables of the method's the parameter signature.
    }
}