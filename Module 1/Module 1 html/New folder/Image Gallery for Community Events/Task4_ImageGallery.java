import java.io.*;
import java.awt.Desktop;

public class Task4_ImageGallery {
    public static void main(String[] args) {
        try {
            String fileName = "task4_image_gallery.html";
            FileWriter writer = new FileWriter(fileName);
            writer.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Community Events Gallery</title>
    <style>
        .gallery-img {
            border: 3px solid #444;
            width: 200px;
            height: 150px;
        }
        table {
            margin: 20px auto;
            border-spacing: 15px;
        }
        caption {
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

    <table>
        <caption>Gallery of Past Community Events</caption>
        <tr>
            <td><img src="event1.jpg" alt="Music Night" title="Music Night" class="gallery-img"></td>
            <td><img src="event2.jpg" alt="Food Festival" title="Food Festival" class="gallery-img"></td>
            <td><img src="event3.jpg" alt="Marathon" title="Marathon" class="gallery-img"></td>
        </tr>
        <tr>
            <td><img src="event4.jpg" alt="Art Exhibition" title="Art Exhibition" class="gallery-img"></td>
            <td><img src="event5.jpg" alt="Tech Talk" title="Tech Talk" class="gallery-img"></td>
            <td><img src="event6.jpg" alt="Cultural Day" title="Cultural Day" class="gallery-img"></td>
        </tr>
    </table>

</body>
</html>
""");
            writer.close();

            File htmlFile = new File(fileName);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } else {
                System.out.println("Open the file manually: " + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
