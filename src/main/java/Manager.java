import java.util.Arrays;

public class Manager {
    protected Repository repo;

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public Ticket[] findFromTo(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getTickets()) {
            if (ticket.getFrom() == from) {
                if (ticket.getTo() == to) {
                    Ticket[] tmp = new Ticket[result.length + 1];
                    for (int i = 0; i < result.length; i++) {
                        tmp[i] = result[i];
                    }
                    tmp[tmp.length - 1] = ticket;
                    result = tmp;
                    TicketPriceComparator priceComparator = new TicketPriceComparator();
                    Arrays.sort(result, priceComparator);
                }
            }
        }
        return result;
    }
}
