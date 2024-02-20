## Диаграмма отношения сущностей

![db_diagram drawio](https://github.com/Belozertsev-av/redix-cloud-backend/assets/65508634/90fc46dd-a2e3-4c25-aaa0-77b37dd1f427)


[В формате pdf](https://github.com/Belozertsev-av/redix-cloud-backend/files/14345659/db_diagram.drawio.pdf)


## Реализованные эндпоинты

### GET

``` BASE_URL/api/users ```
  Возвращает всех зарегестрированных пользователей
  
``` BASE_URL/api/users/{id} ```
  Возвращает конкретного пользователя по его Id

### POST

``` BASE_URL/api/users ```
  Создает нового пользователя

### DELETE

``` BASE_URL/api/users/{id} ```
  Удаляет пользователя по его Id
