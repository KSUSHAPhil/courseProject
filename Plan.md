# Перечень автоматизируемых сценариев

## Предусловия

1. Перейти на сайт localhost:8080
2. Нажать кнопку Купить

## 1. Покупка тура

1. Ввести номер карты 1111 2222 3333 4444
2. В поле месяц ввести текущий месяц
3. В поле год ввести текущий год
4. В поле владелец ввести PASHKA POTAPOV
5. В поле CVC ввести 123
6. Нажать Продолжить

Ожидаемый результат: Появляется сообщение об успешной оплате, в БД есть запись об оплате

## 2. Покупка тура картой, которая отклонена

1. Ввести номер карты 5555 6666 7777 8888
2. В поле месяц ввести текущий месяц
3. В поле год ввести текущий год
4. В поле владелец ввести PASHKA POTAPOV
5. В поле CVC ввести 123
6. Нажать Продолжить

Ожидаемый результат: Появляется сообщение об отклонении оплаты, оплата не проходит, в БД есть запись об отклоненной
оплате

## 3. Покупка невалидной картой

1. Ввести номер карты 5555 6666 7777 8890
2. В поле месяц ввести текущий месяц
3. В поле год ввести текущий год
4. В поле владелец ввести PASHKA POTAPOV
5. В поле CVC ввести 123
6. Нажать Продолжить

Ожидаемый результат: Появляется сообщение об отклонении оплаты, оплата не проходит, в БД нет записи об оплате

## 4. Покупка тура без данных о карте

1. В поле месяц ввести текущий месяц
2. В поле год ввести текущий год
3. В поле владелец ввести PASHKA POTAPOV
4. В поле CVC ввести 123
5. Нажать Продолжить

Ожидаемый результат: Появляется сообщение о неверном формате карты, в БД нет записи об оплате

## 5. Покупка тура картой с номером меньше 16ти цифр

1. Ввести номер карты 5555 6666 7777 889
2. В поле месяц ввести текущий месяц
3. В поле год ввести текущий год
4. В поле владелец ввести PASHKA POTAPOV
5. В поле CVC ввести 123
6. Нажать Продолжить

Ожидаемый результат: Появляется сообщение о неверном формате карты, в БД нет записи об оплате

## 6. Покупка тура картой с номером из нулей

1. Ввести номер карты 0000 0000 0000 0000
2. В поле месяц ввести текущий месяц
3. В поле год ввести текущий год
4. В поле владелец ввести PASHKA POTAPOV
5. В поле CVC ввести 123
6. Нажать Продолжить

Ожидаемый результат: Появляется сообщение о неверном формате карты, в БД нет записи об оплате

## 7. Покупка тура с нулевым месяцем

1. Ввести номер карты 1111 2222 3333 4444
2. В поле месяц ввести 00
3. В поле год ввести текущий год
4. В поле владелец ввести PASHKA POTAPOV
5. В поле CVC ввести 123
6. Нажать Продолжить

Ожидаемый результат: Появляется сообщение о неверном формате месяца, в БД нет записи об оплате

## 8. Покупка тура с пустым месяцем

1. Ввести номер карты 1111 2222 3333 4444
2. В поле год ввести текущий год
3. В поле владелец ввести PASHKA POTAPOV
4. В поле CVC ввести 123
5. Нажать Продолжить

Ожидаемый результат: Появляется сообщение о неверном формате месяца, в БД нет записи об оплате

## 9. Покупка тура с невалидным месяцем

1. Ввести номер карты 1111 2222 3333 4444
2. В поле месяц ввести 25
3. В поле год ввести текущий год
4. В поле владелец ввести PASHKA POTAPOV
5. В поле CVC ввести 123
6. Нажать Продолжить

Ожидаемый результат: Появляется сообщение о неверной дате, в БД нет записи об оплате

## 10. Покупка тура с месяцем из одной цифры

1. Ввести номер карты 1111 2222 3333 4444
2. В поле месяц ввести 2
3. В поле год ввести текущий год
4. В поле владелец ввести PASHKA POTAPOV
5. В поле CVC ввести 123
6. Нажать Продолжить

Ожидаемый результат: Появляется сообщение о неверной дате, в БД нет записи об оплате

## 11. Покупка тура с годом из одной цифры

1. Ввести номер карты 1111 2222 3333 4444
2. В поле месяц ввести текущий месяц
3. В поле год ввести 2
4. В поле владелец ввести PASHKA POTAPOV
5. В поле CVC ввести 123
6. Нажать Продолжить

Ожидаемый результат: Появляется сообщение о неверной дате, в БД нет записи об оплате

## 12. Покупка тура с нулевым годом

1. Ввести номер карты 1111 2222 3333 4444
2. В поле месяц ввести текущий месяц
3. В поле год ввести 00
4. В поле владелец ввести PASHKA POTAPOV
5. В поле CVC ввести 123
6. Нажать Продолжить

Ожидаемый результат: Появляется сообщение об истекшим сроком карты, в БД нет записи об оплате

## 13. Покупка тура с пустым годом

1. Ввести номер карты 1111 2222 3333 4444
2. В поле месяц ввести текущий месяц
3. В поле владелец ввести PASHKA POTAPOV
4. В поле CVC ввести 123
5. Нажать Продолжить

Ожидаемый результат: Появляется сообщение о неверной дате, в БД нет записи об оплате

## 14. Покупка тура с текущим годом + 10 лет

1. Ввести номер карты 1111 2222 3333 4444
2. В поле месяц ввести текущий месяц
3. В поле год ввести текущий год + 10 лет
4. В поле владелец ввести PASHKA POTAPOV
5. В поле CVC ввести 123
6. Нажать Продолжить

Ожидаемый результат: Появляется сообщение об успешной оплате, в БД есть запись об оплате

## 15. Покупка тура с прошлым годом

1. Ввести номер карты 1111 2222 3333 4444
2. В поле месяц ввести текущий месяц
3. В поле год ввести прошлый год
4. В поле владелец ввести PASHKA POTAPOV
5. В поле CVC ввести 123
6. Нажать Продолжить

Ожидаемый результат: Появляется сообщение о неверной дате, в БД нет записи об оплате

## 16. Покупка тура с именем на кириллице

1. Ввести номер карты 1111 2222 3333 4444
2. В поле месяц ввести текущий месяц
3. В поле год ввести текущий год
4. В поле владелец ввести пашка потапов
5. В поле CVC ввести 123
6. Нажать Продолжить

Ожидаемый результат: Появляется сообщение о неверном формате владельца, в БД нет записи об оплате

## 17. Покупка тура с именем из спецсимволов

1. Ввести номер карты 1111 2222 3333 4444
2. В поле месяц ввести текущий месяц
3. В поле год ввести текущий год
4. В поле владелец ввести !"№
5. В поле CVC ввести 123
6. Нажать Продолжить

Ожидаемый результат: Появляется сообщение о неверном формате владельца, в БД нет записи об оплате

## 18. Покупка тура с двойным именем

1. Ввести номер карты 1111 2222 3333 4444
2. В поле месяц ввести текущий месяц
3. В поле год ввести текущий год
4. В поле владелец ввести PASHKA-PASHKA POTAPOV
5. В поле CVC ввести 123
6. Нажать Продолжить

Ожидаемый результат: Появляется сообщение об успешной оплате, в БД есть запись об оплате

## 19. Покупка тура с именем из цифр

1. Ввести номер карты 1111 2222 3333 4444
2. В поле месяц ввести текущий месяц
3. В поле год ввести текущий год
4. В поле владелец ввести 677868
5. В поле CVC ввести 123
6. Нажать Продолжить

Ожидаемый результат: Появляется сообщение о неверном формате владельца, в БД нет записи об оплате

## 20. Покупка тура с пустым именем

1. Ввести номер карты 1111 2222 3333 4444
2. В поле месяц ввести текущий месяц
3. В поле год ввести текущий год
4. В поле CVC ввести 123
5. Нажать Продолжить

Ожидаемый результат: Появляется сообщение о неверном формате владельца, в БД нет записи об оплате

## 21. Покупка тура с двумя цифрами CVC

1. Ввести номер карты 1111 2222 3333 4444
2. В поле месяц ввести текущий месяц
3. В поле год ввести текущий год
4. В поле владелец ввести PASHKA POTAPOV
5. В поле CVC ввести 12
6. Нажать Продолжить

Ожидаемый результат: Появляется сообщение о неверном формате CVC, в БД нет записи об оплате

## 22. Покупка тура с CVC из нулей

1. Ввести номер карты 1111 2222 3333 4444
2. В поле месяц ввести текущий месяц
3. В поле год ввести текущий год
4. В поле владелец ввести PASHKA POTAPOV
5. В поле CVC ввести 000
6. Нажать Продолжить

Ожидаемый результат: Появляется сообщение о неверном формате CVC, в БД нет записи об оплате

## 23. Покупка тура с пустым CVC

1. Ввести номер карты 1111 2222 3333 4444
2. В поле месяц ввести текущий месяц
3. В поле год ввести текущий год
4. В поле владелец ввести PASHKA POTAPOV
5. Нажать Продолжить
   Ожидаемый результат: Появляется сообщение о неверном формате CVC, в БД нет записи об оплате

Для формы покупки в кредит те же самые действия.

# Перечень инструментов

1. Selenide - фреймворк для автоматизации тестирования веб-приложений
2. Gradle - для сборки кода
3. Allure - для создавания отчетов о тестировании
4. Git - для контроля версий и отслеживания изменений кода
5. SQL - для развертывания баз данных
6. Docker - для запуска контейнрных приложений
7. Faker - для создания тестовых данных
8. Lombok - для сокращения шаблонного кода
9. IDEA - среда для разработки

# Перечень возможных рисков

1. Изменение верстки. Из-за этого возникнет необходимость поддержания автотестов или написание новых
2. Падение тестов и решение причин падений
3. Низкое покрытие автотестов, написание новых кейсов
4. Плохое ТЗ, которое может повлиять на пересборку автотестов

# Оценка времени с учетом рисков

90 часов для подготовки всех этапов

# План сдачи работ

Написание, поддержка и полишинг автотестов + результаты тестирования планируется сдать в течении 3х недель