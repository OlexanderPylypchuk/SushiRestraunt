package DbConnection;

import DbConnection.Interfaces.IDbContextFactory;
import DbConnection.Interfaces.IDbContext;

public class MongoDbConnectionFactory implements IDbContextFactory {
    @Override
    public MockDbContext CreateMockDbContext() {
        return new MockDbContext();
    }

    @Override
    public IDbContext CreateRealDbContext() {
        return new MongoDbContext();
    }
}
