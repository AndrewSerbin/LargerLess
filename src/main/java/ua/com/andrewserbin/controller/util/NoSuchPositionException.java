package ua.com.andrewserbin.controller.util;

/**
 * Created by admin on 31.07.2017.
 */
public class NoSuchPositionException extends RuntimeException {

    private int position;

    public NoSuchPositionException(int position) {
        this.position = position;
    }

    public NoSuchPositionException(String message, int position) {
        super(message);
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
