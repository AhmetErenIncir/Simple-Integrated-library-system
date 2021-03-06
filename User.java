import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class User {

    /**
     * This method search all library according to author name.
     * @param map library database
     * @param authorName of book
     * @return true if method finds the book.
     */
    public boolean searchByAuthorName(HashMap<String, HashMap<String, Object>> map, String authorName){
        Scanner scanner = new Scanner(System.in);
        if(map.containsKey(authorName)){
            HashMap<String,Object> temp = map.get(authorName);
            System.out.println("The list of author's book. Please enter the name of the book to check information of book");
            System.out.println(temp.keySet());
            String theName = scanner.nextLine();
            if(temp.containsKey(theName)){
                Books tempBook = (Books) temp.get(theName);
                System.out.println("Location : " + tempBook.getLocation());
                return true;
            }
            else{
                System.out.println("You entered invalid book name");
                return false;
            }
        }
        else{
            System.out.println("You entered invalid author name");
            return false;
        }
    }

    /**
     * This method search all library according to title.
     * @param map library database
     * @param title of the book
     * @return true if method finds the book.
     */
    public boolean searchByTitle(HashMap<String, HashMap<String, Object>> map,String title){
        ArrayList<Set<String>> authorList = new ArrayList<>();
        authorList.add(map.keySet());
        String[] list = new String[0];

        for(int i=0 ; i<authorList.size() ; i++){
           list = authorList.get(i).toArray(new String[authorList.get(i).size()]);
        }

        
        boolean flag = false;

        for (int i=0; i<list.length ; i++){
            HashMap<String,Object> temp = map.get(list[i]);
            if(temp.containsKey(title)){
                Books tempBook = (Books) temp.get(title);
                tempBook.info();
                flag = true;
            }
        }
        if(!flag){
            System.out.println("Book not found! ");
        }
        return flag;
    }


}
