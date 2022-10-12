import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();

    ProductManager manager = new ProductManager(repository);

    Book item1 = new Book(1, "For Whom The Bells Tolls", 350, "Ernest Hemingway");
    Smartphone item2 = new Smartphone(2, "Xiaomi 12", 2000, "Xiaomi");
    Book item3 = new Book(3, "If Tomorrow Comes", 250, "Sidney Sheldon");
    Smartphone item4 = new Smartphone(2, "Honor 5d", 2000, "Honor");
    Book item5 = new Book(5, "The Doomsday Conspiracy", 260, "Sidney Sheldon");
    Smartphone item6 = new Smartphone(6, "Honor 5z", 2000, "Honor");

    @Test
    public void shouldListAllInZeroLengthRepository() {
        Product[] expected = new Product[0];
        Product[] actual = manager.listAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOne() {
        Product[] expected = {item1};
        manager.add(item1);
        Product[] actual = manager.listAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddSome() {
        Product[] expected = {item1, item2, item3, item4, item5, item6};
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        Product[] actual = manager.listAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWhenNoSearchStringOccurrence() {
        Product[] expected = {};
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        Product[] actual = manager.searchBy("absent string");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWhenOneSearchStringOccurrence() {
        Product[] expected = {item1};
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        Product[] actual = manager.searchBy("Whom");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWhenSomeSearchStringOccurrence() {
        Product[] expected = {item1, item5};
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        Product[] actual = manager.searchBy("The");
        Assertions.assertArrayEquals(expected, actual);
    }
}

