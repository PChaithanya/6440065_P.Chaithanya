import java.io.*;
import java.awt.Desktop;

public class Task4_ColorBackgroundStyling {
    public static void main(String[] args) {
        try {
            File htmlFile = new File("task4_index.html");
            FileWriter writer = new FileWriter(htmlFile);
            writer.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>City Council Theming</title>
    <link rel="stylesheet" href="task4_styles.css">
</head>
<body>

    <header class="main-header">
        <h1>City Council Portal</h1>
    </header>

    <section class="info">
        <p>Welcome to the official city council portal. Stay updated with community news and initiatives.</p>
    </section>

</body>
</html>
""");
            writer.close();

            File cssFile = new File("task4_styles.css");
            FileWriter cssWriter = new FileWriter(cssFile);
            cssWriter.write("""
/* Body with background image and fallback color */
body {
    background-color: #e0f7fa;
    background-image: url('https://via.placeholder.com/1500x1000');
    background-size: cover;
    background-repeat: no-repeat;
    background-position: center;
    color: rgba(0, 0, 0, 0.85);
    font-family: 'Segoe UI', sans-serif;
    margin: 0;
    padding: 0;
}

/* Gradient background for header */
.main-header {
    background: linear-gradient(to right, #004d40, #26a69a);
    color: #ffffff;
    padding: 40px 20px;
    text-align: center;
}

/* HEX and RGBA color usage */
.info {
    background-color: rgba(255, 255, 255, 0.85);
    padding: 20px;
    margin: 20px;
    border: 1px solid #009688;
    border-radius: 8px;
    color: #333333;
}
""");
            cssWriter.close();

            // Open in browser
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
