package project.imageeditor;

import Calculations.ColourChange;
import Calculations.DrawHistogram;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class ImageController extends DrawHistogram {


    //Side Panel
    @FXML
    private Button btnSignout;
    @FXML
    private Button btnMain;
    @FXML
    private Button btnHistogram;
    @FXML
    private Pane pnlMain;
    @FXML
    private Pane pnlHistogram;
    @FXML
    public void handleClicks(ActionEvent actionEvent) throws IOException {//side panel with buttons each button corresponds to displaying a panel
        if (actionEvent.getSource() == btnMain) {
            pnlMain.setVisible(true);
            pnlHistogram.setVisible(false);
        }
        if (actionEvent.getSource() == btnHistogram) {
            pnlMain.setVisible(false);
            pnlHistogram.setVisible(true);
        }
        if (actionEvent.getSource() == btnSignout) {
            Platform.exit();
        }
    }//handles all the buttons on the left side of the screen

    //Home
    @FXML
    ImageView image;

    @FXML
    ImageView editedImage;

    @FXML
    ImageView hisImage;

    private Image defaultImage;

    private WritableImage writableImage1;

    @FXML
    private ComboBox<String> img;

    public void Chooser(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(null);
        //File file = new File();
        Image image1 = new Image(String.valueOf(file));
        image.setImage(image1);
        hisImage.setImage(image1);

        int height=(int)image1.getHeight();
        int width=(int)image1.getWidth();
        PixelReader pixelReader=image1.getPixelReader();
        WritableImage writableImage = new WritableImage(width,height);
        PixelWriter pixelWriter = writableImage.getPixelWriter();

        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                Color color = pixelReader.getColor(x, y);
                pixelWriter.setColor(x, y, color);
            }
        }

        editedImage.setImage(writableImage);
        defaultImage = image1;
        writableImage1 = writableImage;
    }

    public void blueImage(ActionEvent actionEvent){
        ColourChange colourChange = new ColourChange();
        colourChange.blueImage(defaultImage, writableImage1);
        editedImage.setImage(writableImage1);
    }

    public void redImage(ActionEvent actionEvent){
        ColourChange colourChange = new ColourChange();
        colourChange.redImage(defaultImage, writableImage1);
        editedImage.setImage(writableImage1);
    }

    public void greenImage(ActionEvent actionEvent){
        ColourChange colourChange = new ColourChange();
        colourChange.greenImage(defaultImage, writableImage1);
        editedImage.setImage(writableImage1);
    }


    public void grayscale(){
        ColourChange colourChange = new ColourChange();
        colourChange.grayscale(defaultImage, writableImage1);
        editedImage.setImage(writableImage1);
    }

    @FXML
    void pickImg(MouseEvent event) {
        Chooser();
    }

    @FXML
    private Slider slider;

    @FXML
    private Slider slider1;


    public void imageBrightness() {
        int height = (int) defaultImage.getHeight();
        int width = (int) defaultImage.getWidth();
        PixelReader pixelReader = defaultImage.getPixelReader();
        PixelWriter pixelWriter = writableImage1.getPixelWriter();
        int value = (int) slider.getValue();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = pixelReader.getColor(x, y);
                int red = (int) (color.getRed() * value);
                int green = (int) (color.getGreen() * value);
                int blue = (int) (color.getBlue() * value);
                Color color1 = Color.rgb(red, green, blue);

                pixelWriter.setColor(x, y, color1.brighter());
            }
        }

    }

    public void reset(){
        int height = (int) defaultImage.getHeight();
        int width = (int) defaultImage.getWidth();
        PixelReader pixelReader = defaultImage.getPixelReader();
        PixelWriter pixelWriter = writableImage1.getPixelWriter();
        slider.setValue(127.5);
        slider1.setValue(127.5);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = pixelReader.getColor(x, y);
                int red = (int) (color.getRed() * 255);
                int green = (int) (color.getGreen() * 255);
                int blue = (int) (color.getBlue() * 255);
                Color color1 = Color.rgb(red, green, blue);

                pixelWriter.setColor(x, y, color1);
            }
        }
    }

    public void imageSaturation(){
        int height = (int) defaultImage.getHeight();
        int width = (int) defaultImage.getWidth();
        PixelReader pixelReader = defaultImage.getPixelReader();
        PixelWriter pixelWriter = writableImage1.getPixelWriter();
        int value = (int) slider1.getValue();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = pixelReader.getColor(x, y);
                int red = (int) (color.getRed() * value);
                int green = (int) (color.getGreen() * value);
                int blue = (int) (color.getBlue() * value);
                Color color1 = Color.rgb(red, green, blue);

                pixelWriter.setColor(x, y, color1.saturate());
            }
        }
    }


    //Histogram Pane --------------------------------------------
    @FXML
    private BarChart<String, Integer> barChart;


        public void barChart() {
            DrawHistogram drawHistogram = new DrawHistogram();
            drawHistogram.barChart(defaultImage,barChart);
            grayscale();
            hisImage.setImage(writableImage1);

        }

}
