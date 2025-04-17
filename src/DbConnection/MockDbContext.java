package DbConnection;

import DbConnection.Interfaces.IDbContext;
import Models.Interface.MenuItemPrototype;

import java.util.ArrayList;
import java.util.List;

public class MockDbContext implements IDbContext {
    protected static MockDbContext instance = new MockDbContext();
    public static MockDbContext theInstance() {
        return instance;
    }

    protected MockDbContext() {
        MenuItems = new ArrayList<MenuItemPrototype>();
    }
    private List<MenuItemPrototype> MenuItems;
    public List<MenuItemPrototype> GetMenuItems(){
        return  MenuItems;
    }
    public void SetMenuItems(List<MenuItemPrototype> menuItems){
        MenuItems = menuItems;
    }
}
