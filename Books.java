public class Books {

    private String author;
    private String title;
    private String location;
    private boolean isAvailable;

    /**
     * Default constructor
     */
    public Books(){
        author = "";
        title = "";
        location = "";
        isAvailable = false;
    }

    /**
     * 3 arguments constructor
     * @param author of the book
     * @param title of the book
     * @param location of the book
     * @param isAvailable show is book in library or not.
     */
    public Books(String author, String title, String location , boolean isAvailable) {
        this.author = author;
        this.title = title;
        this.location = location;
        this.isAvailable = isAvailable;
    }

    /**
     * @return true if book is available
     */
    public boolean getAvailable() {
        return isAvailable;
    }

    /**
     This method change the available status of the book.
     * @param available new status.
     */
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    /**
     * @return name of the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets author name
     * @param author 's new name.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book
     * @param title new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return location of the book
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets location of the book
     * @param location new location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Prints information of book.
     */
    public void info(){
        System.out.println("Title : " + title);
        System.out.println("Author . " + author);
        System.out.println("Location : " + location);
        if (isAvailable){
            System.out.println("Available");
        }
        else {
            System.out.println("Not available");
        }

    }

}
