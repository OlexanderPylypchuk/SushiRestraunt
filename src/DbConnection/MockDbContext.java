package DbConnection;

import DbConnection.Interfaces.IDbContext;
import Models.Interface.MenuItemPrototype;

import java.util.ArrayList;
import java.util.List;

public class MockDbContext implements IDbContext {
    private static MockDbContext instance;
    public static MockDbContext getInstance() {
        if(instance == null){
            instance = new MockDbContext();
        }
        return instance;
    }

    private MockDbContext() {
        
    }
    private List<MenuItemPrototype> MenuItems;
    public List<MenuItemPrototype> GetMenuItems(){
        return  MenuItems;
    }
    public void SetMenuItems(List<MenuItemPrototype> menuItems){
        MenuItems = menuItems;
    }
}
