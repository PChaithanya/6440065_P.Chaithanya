import java.io.*;
import java.awt.Desktop;

public class Task2_NavigationAndLinking {
    public static void main(String[] args) {
        try {
            String fileName = "task2_index.html";
            FileWriter writer = new FileWriter(fileName);
            writer.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Navigation Example</title>
</head>
<body>

    <!-- Navigation -->
    <nav>
        <ul>
            <li><a href="#home">Home</a></li>
            <li><a href="#events">Events</a></li>
            <li><a href="#contact">Contact</a></li>
            <li><a href="help.html" target="_blank">Help</a></li>
        </ul>
    </nav>

    <!-- Sections -->
    <section id="home">
        <h2>Home</h2>
        <p>Welcome to the homepage of our portal.</p>
    </section>

    <section id="events">
        <h2>Events</h2>
        <p>Here you will find information about upcoming events.</p>
    </section>

    <section id="contact">
        <h2>Contact</h2>
        <p>Reach out to us via email or phone.</p>
    </section>

</body>
</html>
""");
            writer.close();

            File htmlFile = new File(fileName);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } else {
                System.out.println("Desktop is not supported. Open the file manually: " + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
