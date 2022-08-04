package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketRepository {
    // Массив
    private Ticket[] tickets = new Ticket[0];

    public Ticket[] getTickets() {
        return tickets;
    }

    // Конструктор
    public TicketRepository() {
        this.tickets = tickets;
    }

    // Методы
    // 1. Добавление билета
    public void save(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    // 2. Удаление билета по id
    public Ticket[] removeById(int id) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tickets = tmp;
        return tmp;
    }

    // 3. Получить набор билетов
    //public Ticket[] findAll(String airportFrom, String airportTo) {
    //return tickets;
    //}
    public Ticket[] findAll() {
        Ticket[] all = getTickets();
        Ticket[] list = new Ticket[all.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = all[i];
        }
        return list;
    }
}
