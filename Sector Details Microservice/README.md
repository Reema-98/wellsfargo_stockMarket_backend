#Sector Micro Service
##Exposes APIs for sector curd operations and aggregation queries

###To set up the Project
* create db stockMarket in mysql
* set db username, password in application.properties
* set "spring.jpa.hibernate.ddl-auto = create" in application.properties
* run the application
* create a .env file
* add following filled if .env file
- DB_USERNAME=username
- DB_PASSWORD=password
- DB_URL=db.url.com
- DB_PORT=3306
- DB_NAME=stockMarket
