# Demo of MyBatis

### Build
- run gradle, use IntelliJ to open the *.ipr file : ```./gradlew cleanIdea idea```

### Database (Mysql)
- Create a database named 'elemento':  ``` CREATE DATABASE elemento; ```
- create a table named 'member' with the column 'id, name, office' : ``` id is INT NOT NULL AUTO_INCREMENT/SERIAL PRIMARY KEY ```; ``` name is VARCHAR(50) NOT NULL UNIQUE KEY ```; ``` office is VARCHAR(50) NOT NULL```;
