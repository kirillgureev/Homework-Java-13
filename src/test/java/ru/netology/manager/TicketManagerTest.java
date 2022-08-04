package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

public class TicketManagerTest {
    private TicketRepository repo = new TicketRepository();
    private TicketManager manager = new TicketManager(repo);
    private Ticket ticket1 = new Ticket(1, 14100, "DME", "EGO", 40);
    private Ticket ticket2 = new Ticket(2, 8700, "LED", "GOJ", 65);
    private Ticket ticket3 = new Ticket(3, 4500, "KUF", "OGZ", 30);
    private Ticket ticket4 = new Ticket(4, 8700, "FRU", "DME", 35);
    private Ticket ticket5 = new Ticket(5, 10000, "GOJ", "EGO", 120);
    private Ticket ticket6 = new Ticket(6, 9000, "LED", "GOJ", 90);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }

    @Test
    public void shouldShowAllTickets() {
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveTicketById() {
        repo.removeById(1);

        Ticket[] expected = {ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTicketsIfSeveral() {
        Ticket[] actual = manager.searchBy("LED", "GOJ");
        Ticket[] expected = {ticket2, ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTicketsIfNot() {
        Ticket[] actual = manager.searchBy("DME", "LED");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTicketsIfOne() {
        Ticket[] actual = manager.searchBy("DME", "EGO");
        Ticket[] expected = {ticket1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void showExpensiveTicket() {

        int expected = ticket1.compareTo(ticket2);
        int actual = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void showCheapTicket() {

        int expected = ticket3.compareTo(ticket5);
        int actual = -1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void showEqualTickets() {

        int expected = ticket2.compareTo(ticket4);
        int actual = 0;

        Assertions.assertEquals(expected, actual);
    }

}