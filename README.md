# 🖼️ JavaFX Image Editor - Color Filters & Histograms

A simple JavaFX-based image editor that allows users to apply color filters (Red, Green, Blue, Grayscale), adjust brightness and saturation, 
and view RGB histograms. The app provides a basic yet effective way to manipulate and analyze images using pixel-level operations.

## ✨ Features
- 🟥🟩🟦 Apply color filters: Red, Green, Blue
- ⚫ Convert images to Grayscale
- 💡 Adjust Brightness with slider
- 🎨 Modify Saturation
- 📊 Generate RGB Histogram
- 📂 Load image using FileChooser
- 🔁 Reset image to original state
- 🧩 Simple and intuitive UI with JavaFX and FXML

## ⚙️ Installation and Setup
**Clone the repository:**
- ```git clone https://github.com/your-username/javafx-image-editor.git```
- ```cd javafx-image-editor```

**Open in your preferred Java IDE (e.g., IntelliJ, Eclipse)**

**Ensure you have:**
- Java 11 or higher
- JavaFX SDK properly configured
  
**Run the application:**
- Run the HelloApplication.java class from your IDE.

## 🚀 Usage
- Launch the application.
- Use the Open File dialog to choose an image.
- Apply filters using buttons (Red, Green, Blue, Grayscale).
- Adjust brightness and saturation using sliders.
- Switch panels to view the histogram using side navigation.
- Click Reset to revert to the original image.
- Click Sign Out to close the application.

## 📂 Code Structure Overview
```
├── Calculations/
│   ├── ColourChange.java      # Handles pixel-based color manipulation
│   └── DrawHistogram.java     # Creates RGB histograms
│
├── project/imageeditor/
│   ├── HelloApplication.java  # JavaFX Application entry point
│   ├── ImageController.java   # UI logic and event handling
│   └── ImageEditor.fxml       # JavaFX FXML layout
```

## 🛠️ Important Classes and Methods
- ColourChange.java
- blueImage(...): Sets red & green, keeps blue to max.
- redImage(...): Sets blue & green, keeps red to max.
- greenImage(...): Sets red & blue, keeps green to max.
- grayscale(...): Converts image to grayscale.
- DrawHistogram.java
- barChart(...): Builds RGB histogram data and displays it.
- ImageController.java
- Handles UI interactions: file selection, filter buttons, sliders.
- Dynamically updates ImageView based on user input.

## 🔮 Future Improvements
- 💾 Save edited image to disk
- 🔄 Undo/Redo support
- 🖌️ Add support for drawing on images
- 📐 Crop and resize functionality
- 🧪 Add more advanced filters (e.g., Sepia, Blur)
