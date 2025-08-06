# Берём официальный образ Java 17
FROM eclipse-temurin:17-jdk-jammy

# Создаём рабочую папку
WORKDIR /app

# Копируем JAR-файл
COPY target/crm-0.0.1-SNAPSHOT.jar app.jar

# Открываем порт 808012
EXPOSE 8080

# Запускаем приложение1
ENTRYPOINT ["java", "-jar", "app.jar"]
