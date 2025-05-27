import java.io.*;
import java.awt.Desktop;

public class Task9_MultiColumnText {
    public static void main(String[] args) {
        try {
            File htmlFile = new File("task9_index.html");
            FileWriter writer = new FileWriter(htmlFile);
            writer.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Multi-Column Bulletin</title>
    <link rel="stylesheet" href="task9_styles.css">
</head>
<body>

    <h2>Community Bulletin</h2>
    <div class="news-article">
        <p>
            The city council announced a series of community events taking place this summer.
            These include festivals, cleanup drives, and art exhibitions.
            Local businesses are also invited to participate and contribute.
            The goal is to enhance civic engagement and celebrate local talent.
            A detailed calendar will be published next week.
            Volunteers are needed for logistics and coordination.
            Residents can sign up through the city portal or visit the town hall.
            Safety measures will be in place as per the latest health guidelines.
            Stay tuned for more updates on social media and local news outlets.
        </p>
    </div>

</body>
</html>
""");
            writer.close();

            File cssFile = new File("task9_styles.css");
            FileWriter cssWriter = new FileWriter(cssFile);
            cssWriter.write("""
.news-article {
    column-count: 2;
    column-gap: 30px;
    column-rule: 1px solid gray;
    font-family: Georgia, serif;
    padding: 20px;
    background-color: #f2f2f2;
}
""");
            cssWriter.close();

            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
