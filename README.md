## Для запуска приложения:

Запустить Docker;
Открыть проект в IntelliJ IDEA;
В терминале IntelliJ IDEA запустить необходимые контейнеры командой docker-compose up;
В новой вкладке терминала запустить приложение java командой: java -jar ./artifacts/aqa-shop.jar
Проверить доступность приложения в браузере по адресу: http://localhost:8080/
## Для запуска авто-тестов:

В новой вкладке терминала прописать команду: ./gradlew clean test
По завершению тестов выполнить команду ./gradlew allureServe
## Для просмотра отчетов:

Если отчет не открывается автоматически в браузере, то выполнить команду: ./gradlew allureReport и открыть отчет вручную (файл index.html) по адресу: .\build\reports\allure-report\allureReport