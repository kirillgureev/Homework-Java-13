package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    // Поля
    private TicketRepository repo;

    // Конструктор
    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    // Методы
    // Добавление
    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    // Поиск
    public boolean matches(Ticket ticket, String airportFrom, String airportTo) {
        if (ticket.getAirportFrom().contains(airportFrom) && ticket.getAirportTo().contains(airportTo)) {
            return true;
        } else {
            return false;
        }
    }

    public Ticket[] searchBy(String airportFrom, String airportTo) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, airportFrom, airportTo)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}