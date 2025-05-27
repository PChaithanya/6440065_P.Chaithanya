import java.io.*;
import java.awt.Desktop;

public class Task6_LinkListStyling {
    public static void main(String[] args) {
        try {
            File htmlFile = new File("task6_index.html");
            FileWriter writer = new FileWriter(htmlFile);
            writer.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Link and List Styling</title>
    <link rel="stylesheet" href="task6_styles.css">
</head>
<body>

    <h2>Navigation Menu</h2>
    <ul class="nav-menu">
        <li><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Contact</a></li>
    </ul>

    <h2>Other List</h2>
    <ul class="custom-list">
        <li>First item</li>
        <li>Second item</li>
        <li>Third item</li>
    </ul>

</body>
</html>
""");
            writer.close();

            File cssFile = new File("task6_styles.css");
            FileWriter cssWriter = new FileWriter(cssFile);
            cssWriter.write("""
/* Link Styling */
a:link {
    color: blue;
    text-decoration: none;
}
a:visited {
    color: purple;
}
a:hover {
    color: orange;
    text-decoration: underline;
}
a:active {
    color: red;
}

/* Nav Menu Styling */
.nav-menu {
    list-style-type: none;
    list-style-position: inside;
    padding: 0;
}
.nav-menu li {
    margin: 10px 0;
}

/* Custom List Styling */
.custom-list {
    list-style-type: square;
    list-style-position: outside;
}
.custom-list li {
    margin: 8px 0;
    padding-left: 10px;
}
""");
            cssWriter.close();

            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
