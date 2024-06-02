import java.time.LocalDateTime;
import java.lang.IllegalArgumentException;
import Genre;

public class Material{

    private String title;
    private double price;
    private int pages;
    private int sells;
    private LocalDateTime publishedDate;
    private Genre genre;
    private String language;

    public Material(String title, double price, int pages, int sells, Genre genre, String language){

        setTitle(title);
        setPrice(price);
        setPages(pages);
        setSells(sells);
        setGenre(genre);
        setLanguage(language);

        publishedDate = LocalDateTime.now();
    }

    private void setTitle(String title){
        checkParam(title != null, "Received null instead of String.");
        this.title = title;
    }

    private void setPrice(double price){
        checkParam(price < 0.0d, "Price out of limits.");
        this.price = price;
    }

    private void setPages(int pages){
        checkParam(pages < 0, "Pages out of limits");
        this.pages = pages;
    }

    private void setSells(int sells){
        checkParam(sells < 0, "Sells out of limits");
        this.sells = sells;
    }

    private void setGenre (Genre genre){
        this.genre = genre;
    }

    private void setLanguage (String language){
        checkParam(language != null, "Received null instead of String.");
        this.language = language;
    }

    /**
     * When the condition is false, it throws an IllegalArgumentExcepiton.
     *
     * @param condition
     * @param message, message to throw if false.
     * @throws java.lang.IllegalArgumentException when false.
     */
    private void checkParam(boolean condition, String message){
        if (!condition){
            throw new IllegalArgumentException(message);
        }
    }
}