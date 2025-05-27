import java.io.*;
import java.awt.Desktop;

public class Task10_ResponsiveDesign {
    public static void main(String[] args) {
        try {
            File htmlFile = new File("task10_index.html");
            FileWriter writer = new FileWriter(htmlFile);
            writer.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Responsive Portal</title>
    <link rel="stylesheet" href="task10_styles.css">
</head>
<body>

    <nav class="navbar">
        <a href="#">Home</a>
        <a href="#">About</a>
        <a href="#">Events</a>
        <a href="#">Contact</a>
    </nav>

    <div class="hero">
        <img src="https://via.placeholder.com/600x300" alt="Community Image" class="responsive-img">
        <h1>Welcome to the Community Portal</h1>
        <p>Stay informed and connected with local events and news.</p>
    </div>

</body>
</html>
""");
            writer.close();

            File cssFile = new File("task10_styles.css");
            FileWriter cssWriter = new FileWriter(cssFile);
            cssWriter.write("""
body {
    margin: 0;
    font-family: Arial, sans-serif;
    font-size: 1.2vw;
}

.navbar {
    display: flex;
    justify-content: center;
    background-color: #333;
    flex-wrap: wrap;
}

.navbar a {
    color: white;
    padding: 14px 20px;
    text-decoration: none;
    text-align: center;
    flex: 1;
}

.hero {
    text-align: center;
    padding: 5vh 5vw;
}

.responsive-img {
    max-width: 100%;
    height: auto;
}

/* Media Query for smaller screens */
@media screen and (max-width: 768px) {
    .navbar {
        flex-direction: column;
    }

    body {
        font-size: 4vw;
    }

    .responsive-img {
        width: 90%;
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
