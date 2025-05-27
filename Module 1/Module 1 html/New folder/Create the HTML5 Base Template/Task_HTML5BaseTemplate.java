import java.io.*;
import java.awt.Desktop;

public class Task_HTML5BaseTemplate {
    public static void main(String[] args) {
        try {
            File htmlFile = new File("index.html");
            FileWriter writer = new FileWriter(htmlFile);
            writer.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Portal Base</title>
</head>
<body>

    <!-- Navigation -->
    <nav>
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Results</a></li>
        </ul>
    </nav>

    <!-- Main -->
    <main>
        <h1>Welcome to the Student Portal</h1>
        <p>This is the base HTML5 structure for all pages in the portal.</p>
    </main>

    <!-- Footer -->
    <footer>
        <p>&copy; 2025 Student Portal. All rights reserved.</p>
    </footer>

</body>
</html>
""");
            writer.close();

            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
