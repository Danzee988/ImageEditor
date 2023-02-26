package Calculations;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class ColourChange {
    public void blueImage(Image defaultImage, WritableImage writableImage1){

        int height = (int) defaultImage.getHeight();
        int width = (int) defaultImage.getWidth();
        PixelReader pixelReader = defaultImage.getPixelReader();
        PixelWriter pixelWriter = writableImage1.getPixelWriter();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = pixelReader.getColor(x, y);
                int red = (int) (color.getRed() * 255);
                int green = (int) (color.getGreen() * 255);
                Color color1 = Color.rgb(red, green, 255);


                pixelWriter.setColor(x, y, color1);

            }
        }
    }

    public void redImage(Image defaultImage, WritableImage writableImage1){

        int height = (int) defaultImage.getHeight();
        int width = (int) defaultImage.getWidth();
        PixelReader pixelReader = defaultImage.getPixelReader();
        PixelWriter pixelWriter = writableImage1.getPixelWriter();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = pixelReader.getColor(x, y);
                int blue = (int) (color.getBlue() * 255);
                int green = (int) (color.getGreen() * 255);
                Color color1 = Color.rgb(255, green, blue);


                pixelWriter.setColor(x, y, color1);

            }
        }
    }

    public void greenImage(Image defaultImage, WritableImage writableImage1){

        int height = (int) defaultImage.getHeight();
        int width = (int) defaultImage.getWidth();
        PixelReader pixelReader = defaultImage.getPixelReader();
        PixelWriter pixelWriter = writableImage1.getPixelWriter();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = pixelReader.getColor(x, y);
                int red = (int) (color.getRed() * 255);
                int blue = (int) (color.getBlue() * 255);
                Color color1 = Color.rgb(red, 255, blue);


                pixelWriter.setColor(x, y, color1);

            }
        }
    }


    public void grayscale(Image defaultImage, WritableImage writableImage1){
        int height = (int) defaultImage.getHeight();
        int width = (int) defaultImage.getWidth();
        PixelReader pixelReader = defaultImage.getPixelReader();
        PixelWriter pixelWriter = writableImage1.getPixelWriter();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = pixelReader.getColor(x, y);


                pixelWriter.setColor(x, y, color.grayscale());

            }
        }
    }
}
