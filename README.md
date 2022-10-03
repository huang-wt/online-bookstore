# Online-Book-Store-Web-Application

### Project Structure
```
.
|-- README.md
|-- pom.xml 
|-- target
|-- src
    |-- main
    |   |-- resources
    |   |   |-- jdbc.properties
    |   |-- java/uk/ac/ucl
    |       |-- dao
    |       |   |-- BookDAO.java
    |       |   |-- OrderDAO.java
    |       |   |-- OrderItemDAO.java
    |       |   |-- UserDAO.java
    |       |   |-- impl
    |       |       |-- BaseDAO.java
    |       |       |-- BookDAOImpl.java
    |       |       |-- OrderDAOImpl.java
    |       |       |-- OrderItemDAOImpl.java
    |       |       |-- UserDAOImpl.java
    |       |-- filter
    |       |   |-- ManagerFilter.java
    |       |-- pojo
    |       |   |-- Book.java
    |       |   |-- Cart.java
    |       |   |-- CartItem.jave
    |       |   |-- Order.java
    |       |   |-- OrderItem.java
    |       |   |-- Page.java
    |       |   |-- User.java
    |       |-- service
    |       |   |-- BookService.java
    |       |   |-- OrderService.java
    |       |   |-- UserService.java
    |       |   |-- impl
    |       |       |-- BookServiceImpl.java
    |       |       |-- OrderServiceImpl.java
    |       |       |-- UserServiceImpl.java
    |       |-- utils
    |       |   |-- JdbcUtils.java
    |       |   |-- WebUtils.java
    |       |-- web
    |           |-- BaseServlet.java
    |           |-- BookServlet.java
    |           |-- CartServlet.java
    |           |-- ClientBookServlet.java
    |           |-- LoginServlet.java
    |           |-- OrderServlet.java
    |           |-- RegisterServlet.java
    |           |-- UserServlet.java
    |   |-- webapp
    |       |-- index.jsp
    |       |-- WEB-INF
    |       |   |-- web.xml
    |       |   |-- lib
    |       |-- static
    |       |   |-- script
    |       |   |-- css
    |       |   |   |-- style.css
    |       |   |-- img
    |       |       |-- code.bmp
    |       |       |-- default.jpg
    |       |       |-- logo.gif
    |       |       |-- pwd-icons-new.png
    |       |-- pages
    |           |-- cart
    |           |   |-- cart.jsp
    |           |   |-- checkout.jsp
    |           |-- client
    |           |   |-- index.jsp
    |           |-- common
    |           |   |-- footer.jsp
    |           |   |-- head.jsp
    |           |   |-- login_success_menu.jsp
    |           |   |-- manager_menu.jsp
    |           |   |-- page_nav.jsp
    |           |-- manager
    |           |   |-- book_edit.jsp
    |           |   |-- book_manager.jsp
    |           |   |-- manager.jsp
    |           |   |-- order_manager.jsp
    |           |-- order
    |           |   |-- order.jsp
    |           |-- user
    |               |-- login.jsp
    |               |-- login_success.jsp
    |               |-- register.jsp
    |               |-- register_success.jsp
    |-- test
        |-- BookDAOTest.java
        |-- BookServiceTest.java
        |-- CartTest.java
        |-- JdbcUtilsTest.java
        |-- OrderDAOTest.java
        |-- OrderItemDAOTest.java
        |-- OrderServiceTest.java
        |-- UserDAOTest.java
        |-- UserServiceTest.java


```
