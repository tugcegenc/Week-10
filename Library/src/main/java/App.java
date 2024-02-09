import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        //Author Adding
        Author author = new Author();
        author.setName("Leo Tolstoy");
        author.setBirthday(LocalDate.ofEpochDay(1828-9-9));
        author.setCountry("Russian");
        entityManager.persist(author);

        //Publisher Adding
        Publisher publisher = new Publisher();
        publisher.setName("Can");
        publisher.setAddress("İstanbul");
        publisher.setEstablishmentYear(1981);
        entityManager.persist(publisher);

        //Category Adding
        Category categoryHistory = new Category();
        categoryHistory.setName("history");
        categoryHistory.setDescription("test");
        entityManager.persist(categoryHistory);

        ArrayList<Category> categoryArrayList = new ArrayList<>();
        categoryArrayList.add(categoryHistory);

        //Book Adding
        Book book = new Book();
        book.setName("Savaş ve Barış");
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setCategoryList(categoryArrayList);
        book.setStock(40);
        book.setPublicationYear(1983);
        entityManager.persist(book);

        //BookBorrowing Adding
        BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setBorrowerName("Tuğçe Genç");
        bookBorrowing.setBorrowingDate(LocalDate.ofEpochDay(2024-02-05));
        bookBorrowing.setReturnDate(LocalDate.ofEpochDay(15-02-2024));
        bookBorrowing.setBook(book);
        entityManager.persist(bookBorrowing);



        System.out.println(book);

        transaction.commit();

    }
}
