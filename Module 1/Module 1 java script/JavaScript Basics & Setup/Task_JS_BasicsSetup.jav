import java.io.*;
import java.awt.Desktop;

public class Task_JS_BasicsSetup {
    public static void main(String[] args) {
        try {
            // Create HTML file
            File htmlFile = new File("js_task_index.html");
            FileWriter htmlWriter = new FileWriter(htmlFile);
            htmlWriter.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Community Portal</title>
</head>
<body>
    <h1>Community Portal</h1>
    <p>JavaScript Setup Test</p>

    <script src="main.js"></script>
</body>
</html>
""");
            htmlWriter.close();

            // Create JS file
            File jsFile = new File("main.js");
            FileWriter jsWriter = new FileWriter(jsFile);
            jsWriter.write("""
console.log("Welcome to the Community Portal");

window.onload = function() {
    alert("Page is fully loaded!");
};
""");
            jsWriter.close();

            // Open the HTML file in the default browser
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
