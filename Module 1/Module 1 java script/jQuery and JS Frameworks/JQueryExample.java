import java.io.*;
import java.awt.Desktop;

public class JQueryExample {
    public static void main(String[] args) {
        try {
            File htmlFile = new File("jquery_example.html");
            FileWriter writer = new FileWriter(htmlFile);

            writer.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>jQuery Demo</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        .event-card {
            display: none;
            background-color: #e0f7fa;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #00796b;
            border-radius: 8px;
        }
    </style>
</head>
<body>

    <h2>jQuery Event Interaction</h2>
    <button id="registerBtn">Show Event Card</button>
    <button id="hideBtn">Hide Event Card</button>

    <div class="event-card" id="eventCard">
        <h3>Community Cleanup Drive</h3>
        <p>Join us this weekend to help clean and green our neighborhood.</p>
    </div>

    <script>
        $(document).ready(function() {
            $('#registerBtn').click(function() {
                $('#eventCard').fadeIn();
            });

            $('#hideBtn').click(function() {
                $('#eventCard').fadeOut();
            });
        });

        // One benefit of frameworks like React or Vue:
        // They offer component-based architecture, which makes large-scale apps easier to manage and debug.
    </script>

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
