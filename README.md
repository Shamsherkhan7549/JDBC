# Connection to database mysql

## code to load class
### connect() method:- 
####  It is a method of Driver Interface, It performs following tasks on execution:-
    1> it establisdhes connection with database(Database Server)
    2> It creates and returns object of Connecrion Interface.

    Since , connect() method is called by getConnection() method, so connect()
    method will retrun obhect of Connection Interface to the getConnection()
    method which return this object to our program.
     
    Our program must keep the reference of this object, in order to call methods of 
    Connection Interface.

### Steps of JDBC Program :-
    1> loading the Driver
    2> Creating Connection object 
    3> Creating Statement object
    4> Executing sql queries
    5> Closing Connection

### 1> Loading the Driver:- 
     Load the MySQL JDBC driver
     Class.forName("com.mysql.cj.jdbc.Driver");
#### Following method of the Driver Interface should be called to create a connection with database ->

    Public Connection connect(String url , Properties p)

    Implementation of this method is available in class defined by Database vendors. 
    This class is known as Driver class

     Name of this class is MySQL is "com.mysql.cj.jdbc.Driver".
     Name of this class in Oracle is "oracle.jdbc.driver.OracleDriver".

    Implementation of these Interfaces are provided by Database vendors. JAR file of these implementaion (classes) must be added  into our project.
    These implementation is called JDBC Driver.
 
### 2> Creating Connection object 

    DriverManager.getConnection("url of the database", "username of the database" , "password of the database" ) ;

    if our  database is MySQL :-
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myjava","root","mysql")

    if our  database is Oracle :-
    DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle")
    
    DriverManager class must have the reference of (object) respective Driver class.
    Every Driver class, on loading , creates an object of itself and gives that object to the DriverManager class.

    Remember that , all classes that our program is using directly will ber loaded by JVM,
    but our program is not using Drive class directly , so, it will not be loaded automatically.
    
### 3> Creating Statement object
    This obect is required to execute sql queries(insert, delete, update, select etc.)
#### Following three types of Statement obhects can be created:-
    1> Object of Statement Interface
    2> Object of PreparedStatement Interface
    3> Object of CallbackStatement Interface

###  Executing queries:-

###  Statement Interface(for DDL Queries) :- 

    Our program will use the object of this interface when program wants
    to execute sql non-parameterized queries. Some of non-parameterized queries
    are as :-
    
    a> SELECT * FROM students
    b> DELETE FROM students;
    etc.
    To create this object, we will have to call createStatement()
    method of Connection interface.

    String query = "CREATE TABLE students (sid PRIMARY KEY, name 
    VARCHAR(30));

    Statement st = con.createStatement ;
    st.execute(query);
    con.close();

#### Method to call for specific queries:- 
    -> Call execute() method for DDL queries(create , alter, drop, etc)
    -> Call executeUpdate() method for DML queries(insert, delete, update)
    -> Call executeQuery() method for DQL queries (select queries)

### Creating PreparedStatement object(for DML queries):-
    Object of this interface is required to execute sql parameterized queries.
    a> insert into employeeInfo values(101,"Aman");
    b> update employeeInfo set name = "Rohit" where eid=102;
    
    String query = "insert into employeeInfo values(?,?)";
    PreparedStatement ps = con.preparedStatement(query);
    ps.setInt(1,101);
    ps.setString(2, "Aman");
    ps.executeUpdate();
