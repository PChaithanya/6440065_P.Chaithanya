import java.io.*;
import java.awt.Desktop;

public class Task3_WelcomeMessageStyling {
    public static void main(String[] args) {
        try {
            String fileName = "task3_welcome_message.html";
            FileWriter writer = new FileWriter(fileName);
            writer.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome Banner</title>
    <style>
        #welcomeBanner {
            background-color: blue;
            color: white;
            padding: 20px;
            text-align: center;
            font-size: 24px;
        }

        .highlight {
            background-color: yellow;
            padding: 5px;
        }
    </style>
</head>
<body>

    <div id="welcomeBanner">
        Welcome, <span class="highlight">Student</span>!
    </div>

    <p>Enjoy your dashboard experience. <span style="color: red; font-weight: bold;">Special Offer: 50% Off on Events!</span></p>

    <p class="highlight">Make sure to check your profile updates weekly.</p>

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
