import com.example.dataBase.model.emptyUser


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
        println("Возникли проблемы")
    }
}

fun loginUser(login: String, pass:String): String? {
    val query = "select * from mydbtest.users"

    try {
        Class.forName("com.mysql.cj.jdbc.Driver")
        val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest", "root", "root")
        val statement = connection.createStatement()
        val resultSet = statement.executeQuery(query)
        while (resultSet.next()) {
            if (login == resultSet.getString("login") && pass == resultSet.getString("password")){
                val fio = resultSet.getString("fio")
                println(fio)
                return fio
            }

        }
    } catch (e: Exception) {
        e.printStackTrace()
        println("Возникли проблемы")
    }
    return ""
}