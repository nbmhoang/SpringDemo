1. Run below SQL(MySQL):
CREATE DATABASE demo_spring;
USE demo_spring;
CREATE TABLE Students (
  ID int AUTO_INCREMENT PRIMARY KEY,
  Name nvarchar(20),
  Course nvarchar(20)
);
2. Insert some example records.
3. Open IntelliJ and clone this repository(VCS -> Enable Version Control Integration... -> Git -> OK. VCS -> Git -> Clone -> Type https://github.com/expressyoona/MVCDemo in URL -> OK and wait for a second.
4. Configure your database information on application.propreties file in /src/main/resource path.
5. Run main file(/src/main/java/com.yourname/)
6. Open Postman, in request URL type:
-
-
-
