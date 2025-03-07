import DbConnection.MockDbContext;
import DbConnection.MySqlConnectionFactory;

public class Main {
    public static void main(String[] args) {
        MySqlConnectionFactory connectionFactory = new MySqlConnectionFactory();
        MockDbContext dbSingleton = connectionFactory.CreateMockDbContext();
        System.out.println("Project is build, but still lacks functionality");
    }
}