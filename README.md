Приложение по передаче медицинских данных в центр анализа

# Настройка:

1. Запустить docker контейнер с брокером сообщений RabbitMQ:

# run rabbitmq in docker container:

docker run -lt --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management 
docker run --help (информация о
командах)
docker ps - посмотреть запущенные контейнеры docker stop [название контейнера]