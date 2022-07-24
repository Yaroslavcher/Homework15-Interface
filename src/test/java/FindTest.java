import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
public class FindTest {
    Ticket ticket1 = new Ticket(1, 1000, "SVO", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 2000, "VKO", "TGK", 95);
    Ticket ticket3 = new Ticket(3, 1500, "SVO", "RND", 75);
    Ticket ticket4 = new Ticket(4, 2300, "VKO", "TGK", 105);
    Ticket ticket5 = new Ticket(5, 1100, "VKO", "TGK", 115);
    Ticket ticket6 = new Ticket(6, 2350, "VKO", "TGK", 100);
    Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
    Repository repo = Mockito.mock(Repository.class);
    Manager manager = new Manager(repo);

    @Test
    public void shouldFindFromTo() {
        doReturn(tickets).when(repo).getTickets();
        Ticket[] expected = {ticket5, ticket2, ticket4, ticket6};
        assertArrayEquals(expected, manager.findFromTo("VKO", "TGK"));
    }
    @Test
    public void shouldFindNone() {
        doReturn(tickets).when(repo).getTickets();
        Ticket[] expected = {};
        assertArrayEquals(expected, manager.findFromTo("SVO", "TGK"));
    }
}
