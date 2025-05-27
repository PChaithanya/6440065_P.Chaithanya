import java.io.*;
import java.awt.Desktop;

public class Task_JS_SyntaxDataTypes {
    public static void main(String[] args) {
        try {
            // Create HTML file
            File htmlFile = new File("js_syntax_task.html");
            FileWriter htmlWriter = new FileWriter(htmlFile);
            htmlWriter.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Event Details</title>
</head>
<body>
    <h1>Event Registration</h1>
    <p id="eventInfo"></p>
    <button onclick="register()">Register</button>
    <p id="seatStatus"></p>

    <script src="event.js"></script>
</body>
</html>
""");
            htmlWriter.close();

            // Create JS file
            File jsFile = new File("event.js");
            FileWriter jsWriter = new FileWriter(jsFile);
            jsWriter.write("""
const eventName = "Community Meetup";
const eventDate = "2025-06-15";
let availableSeats = 30;

document.getElementById("eventInfo").innerText = 
    `Event: ${eventName} | Date: ${eventDate} | Seats Available: ${availableSeats}`;

function register() {
    if (availableSeats > 0) {
        availableSeats--;
        document.getElementById("seatStatus").innerText = 
            `You have successfully registered. Remaining seats: ${availableSeats}`;
    } else {
        document.getElementById("seatStatus").innerText = 
            "Sorry, no more seats available.";
    }
}
""");
            jsWriter.close();

            // Open HTML in browser
            Desktop.getDesktop().browse(htmlFile.toURI());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
