import java.util.HashMap;
import java.util.Scanner;


public class Main {


    public static boolean isAdmin;

    /**
     * Test of admin and user methods
     * @param args default.
     */
    public static void main(String[] args) {

        User user = new User();
        Admin admin = new Admin();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        HashMap<String, HashMap<String, Object>> library = new HashMap<String, HashMap<String,Object>>();




        do{
            System.out.println("Welcome Library");
            System.out.println("Press 1 if you are an admin");
            System.out.println("Press 2 if you are an user");
            int select = scanner.nextInt();
            if(select == 1){

                System.out.println("Please enter the password.");
                String password = scanner.next();
                if(!password.equals("12345")){
                    System.out.println("Invalid Password. Please try again");
                    isAdmin = false;
                    flag = true;
                }
                else{
                    isAdmin = true;
                    flag = false;
                }

            }
            else if(select == 2){
                isAdmin = false;
                flag = false;
            }
            else{
                System.out.println("Invalid entered! . Please try again");
                isAdmin = false;
                flag = true;
            }
        }while(flag);


        if(isAdmin){
            int selection = -1;
            System.out.println("Login to the system as admin");
            System.out.println("Starting the test of admin's methods ");
            do{

                System.out.println("Press 1 to add new book");
                System.out.println("Press 2 to delete book");
                System.out.println("Press 3 to update book");
                System.out.println("Press 4 to exit");
                selection = scanner.nextInt();

                if(selection == 1){
                    System.out.println("Please enter name of the author of book to add");
                    String author = scanner.next();
                    System.out.println("Please enter the title of book to add");
                    scanner.nextLine();
                    String title = scanner.next();
                    System.out.println("Please enter the location of book to add");
                    scanner.nextLine();
                    String location = scanner.next();
                    admin.addBook(library,author,title,location);
                }
                else if(selection == 2){
                    System.out.println("Please enter the name of the book to delete");
                    String title = scanner.next();
                    admin.deleteBook(library,title);
                }
                else if(selection == 3){
                    admin.updateBook(library);
                }
                else if(selection == 4){
                    break;
                }
                else{
                    System.out.println("Invalid entered");
                }

            }while (true);


        }

        System.out.println("Starting the test of user's methods");

        admin.searchByAuthorName(library,"abc");

        int selection = -1;

        do {
            System.out.println("Press 1 to search by book title");
            System.out.println("Press 2 to search by author name");
            System.out.println("Press 3 to exit");
            selection = scanner.nextInt();

            if(selection == 1){
                System.out.println("Please enter the title of the book");
                String title = scanner.next();
                user.searchByTitle(library,title);
            }
            else if(selection == 2){
                System.out.println("Please enter name of the author");
                String author = scanner.next();
                user.searchByAuthorName(library,author);
            }
            else if(selection == 3){
                break;
            }
            else{
                System.out.println("Invalid entered.");
            }

        }while (true);


    }

}
