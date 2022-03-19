import com.example.dataBase.model.emptyUser
import io.ktor.routing.*


import java.sql.DriverManager


fun addUser() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver")
        val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest", "root", "root")
        val statement = connection.createStatement()
        statement.execute("INSERT INTO mydbtest.users(login, password, fio, token, email) VALUES ('${emptyUser.first().login}', '${emptyUser.first().password}', '${emptyUser.first().fio}', '${emptyUser.first().token}', '${emptyUser.first().email}')")
        println("Подключение успешно выполнено")
    } catch (e: Exception) {
        e.printStackTrace()
        println("не удалось подключиться")
    }
}
