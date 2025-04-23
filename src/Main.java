import Builders.SushiDirector;
import Builders.SushiItemBuilder;
import Models.*;
import Models.Interface.IOrderComponent;
import Models.Interface.MenuItemPrototype;
import Strategy.CardPaymentStrategy;
import Strategy.CashPaymentStrategy;
import Strategy.Interfaces.PaymentStrategy;
import SushiMaking.FishCutter;
import SushiMaking.Packager;
import SushiMaking.RicePreparer;
import SushiMaking.Roller;
import Waiter.*;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MenuGroup rootMenu = new MenuGroup("Main Menu");
    private static Order currentOrder = new Order();
    private static OrderHistory history = new OrderHistory();
    private static PaymentStrategy strategy = new CardPaymentStrategy();
    private static Waiter waiter = new Waiter();
    private static WaiterInvoker invoker = new WaiterInvoker();
    private static RicePreparer preparer = new RicePreparer();
    private static RestaurantFacadeImpl restaurantFacade = new RestaurantFacadeImpl(currentOrder);

    public static void main(String[] args) {
        invoker.addCommand(new GreetCommand(waiter));
        invoker.addCommand(new TakeOrderCommand(waiter));
        invoker.addCommand(new BringWasabiCommand(waiter));
        invoker.addCommand(new CleanTableCommand(waiter));

        Packager packager = new Packager();
        Roller roller = new Roller();
        FishCutter cutter = new FishCutter();
        roller.setNext(packager);
        cutter.setNext(roller);
        preparer.setNext(cutter);


        setupSampleMenu();
        runApp();
    }

    private static void undo(){
        currentOrder = history.undo().getState();
    }

    private static void runApp() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Welcome to Sushi Restaurant!");
            System.out.println("1. Customer Mode");
            System.out.println("2. Admin Mode");
            System.out.println("3. Exit");
            System.out.print("Select mode: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    customerMode();
                    break;
                case "2":
                    adminMode();
                    break;
                case "3":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }

    private static void setupSampleMenu() {
        MenuGroup sushiRolls = new MenuGroup("Sushi Rolls");
        SushiItemBuilder builder = new SushiItemBuilder();
        SushiDirector director = new SushiDirector();
        director.makeCaliforniaSushi(builder);
        sushiRolls.add(new SushiItem(builder));
        builder.reset();
        director.makePhiladelphiaSushi(builder);
        sushiRolls.add(new SushiItem(builder));
        builder.reset();

        MenuGroup drinks = new MenuGroup("Drinks");
        drinks.add(new MenuItem("Green Tea", 2.50));
        drinks.add(new MenuItem("Sake", 5.50));

        rootMenu.add(sushiRolls);
        rootMenu.add(drinks);
    }

    private static void customerMode() {
        boolean active = true;
        while (active) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Show menu");
            System.out.println("2. Add item to order");
            System.out.println("3. Choose order option");
            System.out.println("4. Choose payment method");
            System.out.println("5. Complete order");
            System.out.println("6. Back to main menu");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    rootMenu.display();
                    break;
                case "2":
                    System.out.print("Enter item id: ");
                    String itemId = scanner.nextLine();
                    MenuComponent found = rootMenu.find(Integer.parseInt(itemId));
                    if(found instanceof  SushiItem){
                        preparer.handle((SushiItem) found);
                        System.out.println("Extra wasabi? To confirm, type 'yes'");
                        if(Objects.equals(scanner.nextLine(), "yes")){
                            ExtraWasabiDecorator wasabiDecorator = new ExtraWasabiDecorator(new BasicOrderComponent(((SushiItem) found).getName(), ((SushiItem) found).getPrice()));
                            currentOrder.addItem(wasabiDecorator);
                            history.save(currentOrder.saveState());
                        }
                        else{
                            currentOrder.addItem(new BasicOrderComponent(((MenuItem) found).getName(), ((MenuItem) found).getPrice()));
                            history.save(currentOrder.saveState());
                        }
                        System.out.println(((MenuItem) found).getName() + " added to your order.");
                    }
                    else if (found instanceof MenuItem) {
                        currentOrder.addItem(new BasicOrderComponent(((MenuItem) found).getName(), ((MenuItem) found).getPrice()));
                        history.save(currentOrder.saveState());
                        System.out.println(((MenuItem) found).getName() + " added to your order.");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case "3":
                    System.out.print("Delivery or indoors? Type 'delivery' or 'indoors'");
                    String type = scanner.nextLine();
                    if (type.equalsIgnoreCase("indoors")) {
                        System.out.print("Choose table number: ");
                        int table = Integer.parseInt(scanner.nextLine());
                        currentOrder.setTableNumber(table);
                        System.out.println("Table " + table + " selected.");
                        history.save(currentOrder.saveState());
                    } else if (type.equalsIgnoreCase("delivery")) {
                        System.out.println("Delivery selected.");
                    } else {
                        System.out.println("Invalid option.");
                    }
                    break;
                case "4":
                    System.out.print("Payment method? Type 'card' or 'cash'");
                    switch (scanner.nextLine()){
                        case "card":
                            strategy = new CardPaymentStrategy();
                            break;
                        case "cash":
                            strategy = new CashPaymentStrategy();
                    }
                    break;
                case "5":
                    double sum = currentOrder.calculateTotal();
                    strategy.pay(new Payment(sum));
                    currentOrder = new Order();
                    history.save(currentOrder.saveState());
                    break;
                case "6":
                    active = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void adminMode() {
        boolean active = true;
        while (active) {
            System.out.println("\nAdmin menu:");
            System.out.println("1. Add menu item");
            System.out.println("2. Add menu group");
            System.out.println("3. Update menu item");
            System.out.println("4. Delete menu item");
            System.out.println("5. Show menu");
            System.out.println("6. Check waiter");
            System.out.println("0. Back to main menu");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter group number to add to: ");
                    String groupNumber = scanner.nextLine();
                    MenuComponent group = rootMenu.find(Integer.parseInt(groupNumber));
                    if (group instanceof MenuGroup) {
                        System.out.print("Enter item name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter price: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        ((MenuGroup) group).add(new MenuItem(name, price));
                        System.out.println("Item added.");
                    } else {
                        System.out.println("Group not found.");
                    }
                    break;
                case "2":
                    System.out.print("Enter group number to add to: ");
                    String number = scanner.nextLine();
                    MenuComponent parentGroup = rootMenu.find(Integer.parseInt(number));
                    if (parentGroup instanceof MenuGroup) {
                        System.out.print("Enter new group name: ");
                        String newGroupName = scanner.nextLine();
                        ((MenuGroup) parentGroup).add(new MenuGroup(newGroupName));
                        System.out.println("Group added.");
                    } else {
                        System.out.println("Parent group not found.");
                    }
                    break;
                case "3":
                    System.out.print("Enter item id to update: ");
                    String itemToUpdate = scanner.nextLine();
                    MenuComponent comp = rootMenu.find(Integer.parseInt(itemToUpdate));
                    if (comp instanceof MenuItem) {
                        System.out.print("New name: ");
                        String newName = scanner.nextLine();
                        System.out.print("New price: ");
                        double newPrice = Double.parseDouble(scanner.nextLine());
                        ((MenuItem) comp).setName(newName);
                        ((MenuItem) comp).setPrice(newPrice);
                        System.out.println("Item updated.");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case "4":
                    System.out.print("Enter id of item or group to remove: ");
                    String id = scanner.nextLine();
                    rootMenu.remove(Integer.parseInt(id));
                    System.out.println("Removed.");
                    break;
                case "5":
                    rootMenu.display();
                    break;
                case "6":
                    invoker.execute();
                    break;
                case "0":
                    active = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}