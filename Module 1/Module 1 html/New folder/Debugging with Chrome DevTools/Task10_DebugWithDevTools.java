import java.io.*;
import java.awt.Desktop;

public class Task10_DebugWithDevTools {
    public static void main(String[] args) {
        try {
            String fileName = "task10_debug.html";
            FileWriter writer = new FileWriter(fileName);
            writer.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Debugging Demo</title>
    <style>
        #demoBox {
            width: 200px;
            height: 100px;
            background-color: lightblue;
            text-align: center;
            line-height: 100px;
            margin: 20px;
            font-size: 18px;
        }
    </style>
</head>
<body>

    <h2>Debugging with DevTools</h2>

    <div id="demoBox" onclick="changeBox()">Click Me</div>

    <script>
        console.log("Page loaded. Ready to debug.");

        let counter = 0;

        function changeBox() {
            counter++;
            console.log("Box clicked. Counter = " + counter);
            
            // Add breakpoint on this line in Chrome DevTools
            document.getElementById("demoBox").style.backgroundColor = 
                counter % 2 === 0 ? "lightblue" : "lightgreen";

            document.getElementById("demoBox").innerText = "Clicked " + counter + " times";
        }

        // Simulate script error (uncomment to test)
        // nonExistentFunction(); 
    </script>

</body>
</html>
""");
            writer.close();

            File htmlFile = new File(fileName);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } else {
                System.out.println("Open manually: " + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
