package DbConnection;

import DbConnection.Interfaces.IDbContext;
import Models.Interface.MenuItemPrototype;

import java.util.List;

public class MockDbContext implements IDbContext {
    private static boolean instance = false;
    public MockDbContext(){
        if(instance){
            return;
        }
        instance = true;
    }
    private List<MenuItemPrototype> MenuItems;
    public List<MenuItemPrototype> GetMenuItems(){
        return  MenuItems;
    }
    public void SetMenuItems(List<MenuItemPrototype> menuItems){
        MenuItems = menuItems;
    }
}
