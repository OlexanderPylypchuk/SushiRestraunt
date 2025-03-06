package DbConnection.Interfaces;

import DbConnection.MockDbContext;
import DbConnection.RealDbContext;

public interface IDbContextFactory {
    public MockDbContext CreateMockDbContext();
    public RealDbContext CreateRealDbContext();

}
