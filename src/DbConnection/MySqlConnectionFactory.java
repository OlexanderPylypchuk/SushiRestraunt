package DbConnection;

import DbConnection.Interfaces.IDbContextFactory;

public class MySqlConnectionFactory implements IDbContextFactory {
    @Override
    public MockDbContext CreateMockDbContext() {
        return new MockDbContext();
    }

    @Override
    public RealDbContext CreateRealDbContext() {
        return null;
    }
}
