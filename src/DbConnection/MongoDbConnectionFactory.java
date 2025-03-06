package DbConnection;

import DbConnection.Interfaces.IDbContextFactory;

public class MongoDbConnectionFactory implements IDbContextFactory {
    @Override
    public MockDbContext CreateMockDbContext() {
        return null;
    }

    @Override
    public RealDbContext CreateRealDbContext() {
        return null;
    }
}
