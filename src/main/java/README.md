В приложение notebook я сделала следующее: 
1) Реализовала удаление пользователя через метод Delete в UserRepository
2) Перенесла метод createUser в UserRepository
3) Добавила в методы Update и Delete в UserView Runtime Exception с сообщением о том, что идентификатор не может быть пустым
4) Добавила в команду Exit текстовый вывод "Работа приложения завершена"
5) Перенесла логику dao в слой UserRepository