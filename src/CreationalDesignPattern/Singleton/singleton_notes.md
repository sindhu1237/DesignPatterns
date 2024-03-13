### **What problem are we solving?**
* Design a class
* Such that clients are able to make only one object of it.

### Why singleton is required ?
* costly to create [ takes a lot of time to create ]
* shared 

eg :


**App Server** 
* App Server contains 
    - Employees class                 
    - Customers class
    - Orders class

**Database Server**
* Database contains
    - Employees info
    - Customers info
    - Orders info

* To establish DBconnection between App server and DB server.

`class DBConnection {
String url; [location of db server]
String username;
String Password;
TCPConnection tconn;
}
DBConnection db = new DBConnection(url, username, Password);
`
* It might take time to create object for DBConnection because a tcp connection has to be established  between Appserver and DBServer which uses a 3 way hand-shakes, means it needs 3 messages to be exchanged between Appserver and DBserver.  

eg 2 : Logger

`Logger logger = new Logger();`

Here **logger** is single object and shared among all files in the project.

`try{
}catch() {
logger.log("");
}`

### **Version 0 :**

`class DBConnection {
String url; [location of db server]
String username;
String Password;
TCPConnection tconn;
public DBConnection(String url, String username, String password) {
  url = url;
username = username;
password = password;
tconn = new TCPConnection();
}
}`

**Problem :**
`class Client{
main() {
DBConnection db1 = new DBConnection(url, username, Password);
DBConnection db2 = new DBConnection(url, username, Password);
}
}`

* Multiple objects can be created, not a singleton.

### **Version 1 :**

`class DBConnection {
String url; [location of db server]
String username;
String Password;
TCPConnection tconn;
// Java added Default Constructor
}`

**Problem :**
`class Client{
main() {
DBConnection db1 = new DBConnection();
DBConnection db2 = new DBConnection();
}
}`

* Multiple objects can be created, not a singleton.

### **Version 2 :**

`class DBConnection {
String url; [location of db server]
String username;
String Password;
TCPConnection tconn;
private DBConnection(String url, String username, String password) {
url = url;
username = username;
password = password;
tconn = new TCPConnection();
}
}`

**Problem :**
`class Client{
main() {
DBConnection db1 ;
}
}`

* Constructor is private .cannot create object.
* No Objects 

### **Version 3 :**
`class DBConnection {
String url; [location of db server]
String username;
String Password;
TCPConnection tconn;
private DBConnection(String url, String username, String password) {
url = url;
username = username;
password = password;
tconn = new TCPConnection();
}
public DBConnection getInstance() {
DBConnection instance = new DBConnection();
return instance;
}
}`

**Problem :**
`class Client{
main() {
DBConnection db1 = ? ;
}
}`

* To call getInstance method we should create a object so it is not possible here.

### **Version 4 :**
* To solve version 3 problem we use **static keyword** is used to declare a method as a class-level method rather than an object-level method.

`class DBConnection {
String url; [location of db server]
String username;
String Password;
TCPConnection tconn;
private DBConnection(String url, String username, String password) {
url = url;
username = username;
password = password;
tconn = new TCPConnection();
}
public static DBConnection getInstance() {
DBConnection instance = new DBConnection();
return instance;
}
}`

**Problem :**
`class Client{
main() {
DBConnection db1 = DBConnection.getInstance();
DBConnection db2 = DBConnection.getInstance() ;
}
}`

* Multiple objects can be created.So singleton failed.

### **Version 5 :**

`class DBConnection {
String url; [location of db server]
String username;
String Password;
TCPConnection tconn;
private static DBConnection instance;
private DBConnection(String url, String username, String password) {
url = url;
username = username;
password = password;
tconn = new TCPConnection();
}
public static DBConnection getInstance() {
    instance = new DBConnection();
return instance;
}
}`

**Problem :**
`class Client{
main() {
DBConnection db1 = DBConnection.getInstance();
DBConnection db2 = DBConnection.getInstance() ;
}
}`

* Multiple objects not a singleton.


### **Version 6 :**

`class DBConnection {
String url; [location of db server]
String username;
String Password;
TCPConnection tconn;
private static DBConnection instance;
private DBConnection(String url, String username, String password) {
url = url;
username = username;
password = password;
tconn = new TCPConnection();
}
public static DBConnection getInstance() {
if(instance ==  null){
instance = new DBConnection();
}
return instance;
}
}`

`class Client{
main() {
DBConnection db1 = DBConnection.getInstance();
}
}`

* The version 6 seems like a **Singleton**.

**Problem :**
* The above version works for single threaded applications.
* Multiple threads can make multiple objects via Race Condition.