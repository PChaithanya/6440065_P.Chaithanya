import java.io.*;
import java.awt.Desktop;

public class Task11_DebugTestDevTools {
    public static void main(String[] args) {
        try {
            File htmlFile = new File("task11_index.html");
            FileWriter writer = new FileWriter(htmlFile);
            writer.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Debug and Test</title>
    <link rel="stylesheet" href="task11_styles.css">
</head>
<body>

    <nav class="navbar">
        <a href="#">Home</a>
        <a href="#">Services</a>
        <a href="#">Blog</a>
        <a href="#">Contact</a>
    </nav>

    <main>
        <h1>Welcome to the Portal</h1>
        <p>This is a test layout. Resize the screen or use Chrome DevTools to simulate devices and debug styles.</p>
    </main>

</body>
</html>
""");
            writer.close();

            File cssFile = new File("task11_styles.css");
            FileWriter cssWriter = new FileWriter(cssFile);
            cssWriter.write("""
body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    font-size: 1.1vw;
    background-color: #f4f4f4;
}

.navbar {
    display: flex;
    justify-content: space-around;
    background-color: #222;
    padding: 10px;
}

.navbar a {
    color: white;
    text-decoration: none;
    padding: 10px;
}

main {
    padding: 20px;
}

/* Responsive Test */
@media screen and (max-width: 768px) {
    .navbar {
        flex-direction: column;
        align-items: center;
    }

    body {
        font-size: 4vw;
    }

    main {
        padding: 10px;
    }
}
""");
            cssWriter.close();

            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
