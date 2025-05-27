import java.io.*;
import java.awt.Desktop;

public class Task8_BoxModelLayout {
    public static void main(String[] args) {
        try {
            File htmlFile = new File("task8_index.html");
            FileWriter writer = new FileWriter(htmlFile);
            writer.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Box Model & Layout</title>
    <link rel="stylesheet" href="task8_styles.css">
</head>
<body>

    <div class="eventCard">
        <h2>Community Workshop</h2>
        <p>Learn about sustainable living and meet local experts.</p>
    </div>

    <form>
        <label for="name">Name:</label><br>
        <input type="text" id="name" class="selected-field"><br><br>

        <label for="email">Email:</label><br>
        <input type="email"><br><br>
    </form>

    <div class="hidden-box">This is hidden using visibility: hidden</div>
    <div class="none-box">This is hidden using display: none</div>

</body>
</html>
""");
            writer.close();

            File cssFile = new File("task8_styles.css");
            FileWriter cssWriter = new FileWriter(cssFile);
            cssWriter.write("""
.eventCard {
    margin: 20px;
    padding: 15px;
    border: 2px solid #4CAF50;
    background-color: #f9f9f9;
}

.selected-field {
    outline: 2px solid blue;
}

.hidden-box {
    visibility: hidden;
    background-color: yellow;
    padding: 10px;
    margin: 10px;
}

.none-box {
    display: none;
    background-color: orange;
    padding: 10px;
    margin: 10px;
}
""");
            cssWriter.close();

            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
