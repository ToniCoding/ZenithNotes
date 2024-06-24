package src.libraryObjects;

import java.time.LocalDateTime;
import java.lang.IllegalArgumentException;

public class Material {
    private String title;
    private double price;
    private int pages;
    private int sells;
    private eGenre genre;
    private String language;
    private final LocalDateTime publishedDate;

    public Material(String title, double price, int pages, int sells, eGenre genre, String language) {
        this.title = title;
        this.price = price;
        this.pages = pages;
        this.sells = sells;
        this.genre = genre;
        this.language = language;
        this.publishedDate = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        checkParam(title != null, "Received null instead of String.");
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        checkParam(price < 0.0d, "Price out of limits.");
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        checkParam(pages < 0, "Pages out of limits");
        this.pages = pages;
    }

    public int getSells() {
        return sells;
    }

    public void setSells(int sells) {
        checkParam(sells < 0, "Sells out of limits");
        this.sells = sells;
    }

    public eGenre getGenre() {
        return genre;
    }

    public void setGenre(eGenre genre) {
        checkParam(isNotInEnum(eGenre.class, genre.name()), "The prompted genre is not allowed.");
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        checkParam(language != null, "Received null instead of String.");
        this.language = language;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    /**
     * When the condition is false, it throws an IllegalArgumentException.
     *
     * @param condition Condition to be met
     * @param message message to throw if false.
     * @throws java.lang.IllegalArgumentException when false.
     */
    private void checkParam(boolean condition, String message){
        if (!condition){
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Check whether if an element is present inside an enumeration class or not.
     *
     * @param enumClass - Enumeration class. This is a constraint to only accept "enum".
     * @param value - Value to be checked inside an enumeration class.
     * @return - Returns true if the element is present in the enum class and false if not.
     */
    public static boolean isNotInEnum(Class<? extends Enum<?>> enumClass, String value) {
        for (Enum<?> enumValue : enumClass.getEnumConstants()) {
            if (enumValue.name().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
}
