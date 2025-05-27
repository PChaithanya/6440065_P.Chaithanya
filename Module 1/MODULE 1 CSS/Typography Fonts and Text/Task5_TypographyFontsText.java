import java.io.*;
import java.awt.Desktop;

public class Task5_TypographyFontsText {
    public static void main(String[] args) {
        try {
            File htmlFile = new File("task5_index.html");
            FileWriter writer = new FileWriter(htmlFile);
            writer.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Typography Enhancement</title>
    
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&family=Playfair+Display:ital@1&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="task5_styles.css">
</head>
<body>

    <header class="page-header">
        <h1>City Portal Newsletter</h1>
    </header>

    <section class="intro">
        <p>Stay updated with all important announcements and events. Make sure to subscribe!</p>
    </section>

    <section class="highlight">
        <p>This is a special announcement section with styled typography using Google Fonts.</p>
    </section>

</body>
</html>
""");
            writer.close();

            File cssFile = new File("task5_styles.css");
            FileWriter cssWriter = new FileWriter(cssFile);
            cssWriter.write("""
/* Header styles */
.page-header {
    font-family: 'Playfair Display', serif;
    font-size: 36px;
    font-style: italic;
    font-weight: 700;
    text-align: center;
    margin-top: 30px;
}

/* Intro paragraph */
.intro {
    font-family: 'Roboto', sans-serif;
    font-size: 18px;
    font-weight: 400;
    text-align: justify;
    text-transform: capitalize;
    letter-spacing: 0.5px;
    line-height: 1.6;
    margin: 20px 40px;
}

/* Highlighted section */
.highlight {
    font-family: 'Roboto', sans-serif;
    font-size: 16px;
    font-style: normal;
    font-weight: bold;
    background-color: #f9f9f9;
    padding: 15px;
    margin: 20px 40px;
    text-align: left;
    letter-spacing: 1px;
    line-height: 1.8;
    border-left: 4px solid #2196f3;
}
""");
            cssWriter.close();

            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
