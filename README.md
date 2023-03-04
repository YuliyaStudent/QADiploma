### Запуск тестов 

Предварительные условия:

- установленная IntelliJ IDEA
- установленный Docker Desktop
- установленный Git

1. Запустить IntelliJ IDEA
2. Открыть терминал в IntelliJ IDEA и ввести команду:
`git clone https://github.com/YuliyaStudent/QADiploma.git`

3.Запустить Docker Desktop

4.в терминале 1 IntelliJ IDEA ввести команду: `docker-compose up`

#### Подключение SUT к MySQL:
1. открыть терминал 2 в IntelliJ IDEA и ввести команду:  `java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar`
2. открыть терминал 3 в IntelliJ IDEA и ввести команду: `.\gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app" `
3. формирование отчета командой: `./gradlew allureServe`
4. закрыть терминал 3
5. закрыть терминал 2

#### Подключение SUT к PostgreSQL:

1. открыть терминал 2  в IntelliJ IDEA и ввести команду: `java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar`

2. открыть терминал 3 в IntelliJ IDEA и ввести команду: `.\gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app" ` 

3. формирование отчета командой: `./gradlew allureServe`
4. закрыть терминал 3
5. закрыть терминал 2

После выполнения всех действий открыть терминал 2 в IntelliJ IDEA и остановить контейнеры командой: `docker-compose down`

Закрыть все программы.









