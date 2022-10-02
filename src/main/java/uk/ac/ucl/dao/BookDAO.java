package uk.ac.ucl.dao;

import uk.ac.ucl.pojo.Book;

import java.util.List;

/**
 * @author huang-wt
 * @create 2022-09-23 19:04
 */
public interface BookDAO {

    /**
     * Insert a book record into table t_book
     * @param book
     * @return -1 if add unsuccessfully
     */
    int addBook(Book book);

    /**
     * Delete a book record (with the given id) from table t_book
     * @param id
     * @return -1 if delete unsuccessfully
     */
    int deleteBookById(Integer id);

    /**
     * Update a book record in table t_book
     * @param book
     * @return -1 if update unsuccessfully
     */
    int updateBook(Book book);

    /**
     * Select a book from table t_book by its id
     * @param id
     * @return null if book not found or exception occurs; or the selected book object
     */
    Book queryBookById(Integer id);

    /**
     * Select all book records from table t_book
     * @return null if exception occurs; or a list containing all book objects
     */
    List<Book> queryBooks();

    /**
     * Get total number of book records in table t_book
     * @return null if exception occurs; or integer of number of books
     */
    Integer queryForBooksTotalNumber();

    /**
     * Select book records in a specific page
     * @param begin index number of the first book in the page
     * @param itemsNumberPerPage number of books per page
     * @return null if exception occurs; or a list containing the selected book objects
     */
    List<Book> queryForPageBooks(int begin, int itemsNumberPerPage);

    /**
     * Select books with the price ranging between min and max
     * @param min minimum price
     * @param max maximum price
     * @return null if exception occurs; or a list containing the selected book objects
     */
    int queryForBooksTotalNumberByPrice(int min, int max);

    /**
     * Select book records with the price ranging between min and max and displayed in a specific page
     * @param begin index number of the first book in the page
     * @param itemsNumberPerPage number of books per page
     * @param min minimum price
     * @param max maximum price
     * @return null if exception occurs; or a list containing the selected book objects
     */
    List<Book> queryForPageBooksByPrice(int begin, int itemsNumberPerPage, int min, int max);
}
