package DbConnection;

import DbConnection.Interfaces.IDbContextFactory;
import DbConnection.Interfaces.IDbContext;

public class MySqlConnectionFactory implements IDbContextFactory {
    @Override
    public MockDbContext CreateMockDbContext() {
        return MockDbContext.theInstance();
    }

    @Override
    public IDbContext CreateRealDbContext() {
        return new MySqlDbContext("connectionString2");
    }
}
