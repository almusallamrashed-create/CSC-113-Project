package Project_phase1;
import java.util.Scanner;

// main test class with menu
public class BookingAgent {
    public static void main(String[] args) {
        // create company with 10 buses max
        BusCompany company = new BusCompany("Automated Transit System", 10);
        Scanner input = new Scanner(System.in);
        
        startBot(company, input);
        
        input.close();
    }
    
    // method to run the menu loop
    private static void startBot(BusCompany company, Scanner input) {
        System.out.println("[System]: Initializing Automated Response Unit...");
        System.out.println("[Bot]: Hello! I am your virtual booking assistant.");
        
        boolean isRunning = true;
        while (isRunning) {
            printBotMenu();
            String choice = input.nextLine().trim(); // read user choice
            
            switch (choice) {
                case "1": 
                    createBus(company, input); 
                    break;
                case "2": 
                    reserveTicket(company, input); 
                    break;
                case "3": 
                    cancelBus(company, input); 
                    break;
                case "4": 
                    System.out.println("[Bot]: Generating system report...\n" + company.toString()); 
                    break;
                case "5": 
                    System.out.println("[Bot]: Thank you for using our automated service. Goodbye!"); 
                    isRunning = false; // exit loop
                    break;
                default: 
                    System.out.println("[Bot]: I'm sorry, I didn't understand that. Please reply with a valid number.");
            }
        }
    }
    
    // print the options
    private static void printBotMenu() {
        System.out.println("\n[Bot]: Main Menu. Please reply with the number of the service you need:");
        System.out.println("  [1] Register a new transport unit (Bus)");
        System.out.println("  [2] Issue a new passenger ticket");
        System.out.println("  [3] Remove a transport unit from the fleet");
        System.out.println("  [4] View system database report");
        System.out.println("  [5] End conversation");
        System.out.print("[You]: ");
    }
    
    // method to add a bus
    private static void createBus(BusCompany company, Scanner input) {
        System.out.print("[Bot]: Please enter the new Bus ID to register: \n[You]: ");
        String id = input.nextLine().trim();
        Bus b = new Bus(id);
        
        if (company.addBus(b)) 
            System.out.println("[Bot]: Success! Bus [" + id + "] has been registered in the database.");
        else 
            System.out.println("[Bot]: Error! Fleet capacity is full. Cannot register more buses.");
    }
    
    // method to add a ticket
    private static void reserveTicket(BusCompany company, Scanner input) {
        System.out.print("[Bot]: Enter the ID of the Bus for this reservation: \n[You]: ");
        String busId = input.nextLine().trim();
        Bus b = company.findBus(busId);
        
        if (b == null) {
            System.out.println("[Bot]: Alert! Bus ID not found in my database. Please check and try again.");
            return;
        }
        
        System.out.println("[Bot]: What type of ticket would you like to issue?\n  [1] Normal   [2] VIP   [3] Elder   [4] Children");
        System.out.print("[You]: ");
        String type = input.nextLine().trim();
        
        System.out.print("[Bot]: Please provide the travel distance in Kilometers: \n[You]: ");
        double distance = Double.parseDouble(input.nextLine().trim());
        
        System.out.print("[Bot]: Please assign a Ticket Number: \n[You]: ");
        String tNum = input.nextLine().trim();
        
        System.out.print("[Bot]: Enter the booking date (e.g., DD/MM/YYYY): \n[You]: ");
        String date = input.nextLine().trim();
        
        Ticket t = null;
        
        switch (type) {
            case "1": 
                t = new NormalTicket(distance, tNum, date); 
                break;
            case "2": 
                t = new VIPTicket(distance, tNum, date); 
                break;
            case "3":
                System.out.print("[Bot]: Please specify the passenger's age: \n[You]: ");
                int age = Integer.parseInt(input.nextLine().trim());
                t = new ElderTicket(distance, tNum, date, age); 
                break;
            case "4": 
                t = new ChildrenTicket(distance, tNum, date); 
                break;
            default: 
                System.out.println("[Bot]: Invalid ticket type. Canceling reservation process."); 
                return;
        }
        
        if (b.addPassenger(t)) 
            System.out.println("[Bot]: Ticket issued successfully! Passenger added to Bus [" + busId + "].");
        else 
            System.out.println("[Bot]: Booking failed! The selected bus has no available seats.");
    }
    
    // method to remove a bus
    private static void cancelBus(BusCompany company, Scanner input) {
        System.out.print("[Bot]: Please enter the ID of the Bus you wish to remove: \n[You]: ");
        String id = input.nextLine().trim();
        
        if (company.delete(id)) 
            System.out.println("[Bot]: Action confirmed. Bus deleted from the system.");
        else 
            System.out.println("[Bot]: Action failed. Bus not found.");
    }
}    private static void createBus(BusCompany company, Scanner input) {
        System.out.print("[Bot]: Please enter the new Bus ID to register: \n[You]: ");
        String id = input.nextLine().trim();
        Bus b = new Bus(id);
        if (company.addBus(b)) System.out.println("[Bot]: Success! Bus [" + id + "] has been registered in the database.");
        else System.out.println("[Bot]: Error! Fleet capacity is full. Cannot register more buses.");
    }
    private static void reserveTicket(BusCompany company, Scanner input) {
        System.out.print("[Bot]: Enter the ID of the Bus for this reservation: \n[You]: ");
        String busId = input.nextLine().trim();
        Bus b = company.findBus(busId);
        if (b == null) {
            System.out.println("[Bot]: Alert! Bus ID not found in my database. Please check and try again.");
            return;
        }
        System.out.println("[Bot]: What type of ticket would you like to issue?\n  [1] Normal   [2] VIP   [3] Elder   [4] Children");
        System.out.print("[You]: ");
        String type = input.nextLine().trim();
        System.out.print("[Bot]: Please provide the travel distance in Kilometers: \n[You]: ");
        double distance = Double.parseDouble(input.nextLine().trim());
        System.out.print("[Bot]: Please assign a Ticket Number: \n[You]: ");
        String tNum = input.nextLine().trim();
        System.out.print("[Bot]: Enter the booking date (e.g., DD/MM/YYYY): \n[You]: ");
        String date = input.nextLine().trim();
        Ticket t = null;
        switch (type) {
            case "1": t = new NormalTicket(distance, tNum, date); break;
            case "2": t = new VIPTicket(distance, tNum, date); break;
            case "3":
                System.out.print("[Bot]: Please specify the passenger's age: \n[You]: ");
                int age = Integer.parseInt(input.nextLine().trim());
                t = new ElderTicket(distance, tNum, date, age); break;
            case "4": t = new ChildrenTicket(distance, tNum, date); break;
            default: System.out.println("[Bot]: Invalid ticket type. Canceling reservation process."); return;
        }
        if (b.addPassenger(t)) System.out.println("[Bot]: Ticket issued successfully! Passenger added to Bus [" + busId + "].");
        else System.out.println("[Bot]: Booking failed! The selected bus has no available seats.");
    }
    private static void cancelBus(BusCompany company, Scanner input) {
        System.out.print("[Bot]: Please enter the ID of the Bus you wish to remove: \n[You]: ");
        String id = input.nextLine().trim();
        if (company.delete(id)) System.out.println("[Bot]: Action confirmed. Bus deleted from the system.");
        else System.out.println("[Bot]: Action failed. Bus not found.");
    }
}
