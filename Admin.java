import java.util.*;

public class Admin extends User {

    /**
     * General Password for admin (12345)
     */
    private String password;

    /**
     * This method add new book into library.
     * @param map library database
     * @param author book's author
     * @param title Book's title
     * @param location Book's location
     */
    public void addBook(HashMap<String, HashMap<String, Object>> map , String author , String title , String location){

        Books newBook = new Books(author,title,location,true);

        if(map.containsKey(author)){
            HashMap<String,Object> temp = map.get(newBook.getAuthor());
            if(temp.containsKey(newBook.getTitle())){
                Books tempBook = (Books) temp.get(newBook.getTitle());
                tempBook.setLocation(tempBook.getLocation() + "," + newBook.getLocation());
                temp.put(newBook.getTitle(),tempBook);
            }
            else{
                temp.put(newBook.getTitle(),newBook);
                map.put(newBook.getAuthor(),temp);
            }

        }
        else{
            map.put(newBook.getAuthor(),new HashMap<String, Object>());
            map.get(newBook.getAuthor()).put(newBook.getTitle(),newBook);
        }

    }

    /**
     * This method removes the book from library.
     * @param map library database
     * @param theBook removed book
     */
    public void deleteBook(HashMap<String, HashMap<String, Object>> map, String theBook){
        ArrayList<Set<String>> authorList = new ArrayList<>();
        authorList.add(map.keySet());
        String[] list = new String[0];

        for(int i=0 ; i<authorList.size() ; i++){
            list = authorList.get(i).toArray(new String[authorList.get(i).size()]);
        }


        boolean flag = false;

        for (int i=0; i<list.length ; i++){
            HashMap<String,Object> temp = map.get(list[i]);
            if(temp.containsKey(theBook)){
                temp.remove(theBook);
                flag = true;
            }
        }
        if(!flag){
            System.out.println("Book not found! ");
        }
    }

    /**
     * This method updates the information of the book
     * @param map library database
     */
    public void updateBook(HashMap<String, HashMap<String, Object>> map){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter the name of author");
        String authorName = scanner.nextLine();
        System.out.println("Please Enter the name of the book");
        String bookName = scanner.nextLine();

        System.out.println("\nThe book information before update operation");
        searchByTitle(map,bookName);
        System.out.println();

        if(!map.containsKey(authorName)){
            throw new InputMismatchException("Invalid book information");
        }

        HashMap<String,Object> temp = map.get(authorName);
        if(!temp.containsKey(bookName)){
            throw new InputMismatchException("Invalid book information");
        }

        System.out.println("Press 1 to change status of book");
        System.out.println("Press 2 to change the name of author");
        System.out.println("Press 3 to change title of the book");
        System.out.println("Press 4 to change location of the book");

        int selection = scanner.nextInt();


        if(selection == 1){
            Books tempBook = (Books) temp.get(bookName);
            tempBook.setAvailable(!tempBook.getAvailable());
            temp.put(tempBook.getTitle(),tempBook);
            map.put(tempBook.getAuthor(),temp);
        }
        else if(selection == 2){
            System.out.println("Please Enter the new author name");
            scanner.nextLine();
            String newAuthor = scanner.next();
            Books tempBook = (Books) temp.get(bookName);
            tempBook.setAuthor(newAuthor);
            temp.put(tempBook.getTitle(),tempBook);
            map.put(tempBook.getAuthor(),temp);
        }
        else if(selection == 3){
            System.out.println("Please Enter the new book name");
            scanner.nextLine();
            String newTitle = scanner.next();
            Books tempBook = (Books) temp.get(bookName);
            tempBook.setTitle(newTitle);
            temp.put(tempBook.getTitle(),tempBook);
            map.put(tempBook.getAuthor(),temp);
        }
        else if(selection == 4){
            System.out.println("Please Enter the new location of the book");
            scanner.nextLine();
            String newLoc = scanner.next();
            Books tempBook = (Books) temp.get(bookName);
            tempBook.setLocation(newLoc);
            temp.put(tempBook.getTitle(),tempBook);
            map.put(tempBook.getAuthor(),temp);
        }
        else {
            System.out.println("Invalid entered!");
        }

        System.out.println("\nThe book information after update operation");
        searchByTitle(map,bookName);


    }

}
