package DbConnection.Interfaces;

import DbConnection.MockDbContext;

public interface IDbContextFactory {
    public MockDbContext CreateMockDbContext();
    public IDbContext CreateRealDbContext();

}
