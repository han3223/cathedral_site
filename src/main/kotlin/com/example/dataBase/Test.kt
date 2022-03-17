import com.example.dataBase.model.UserModel
import com.example.dataBase.model.UserResponseModel
import java.sql.DriverManager



fun main() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver")
        DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest", "root", "root")
        println("Подключение успешно выполнено")
    } catch (e: Exception) {
        e.printStackTrace()
        println("не удалось подключиться")
    }
}