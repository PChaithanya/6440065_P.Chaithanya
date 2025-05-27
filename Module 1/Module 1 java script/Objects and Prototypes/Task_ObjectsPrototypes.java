import java.io.*;
import java.awt.Desktop;

public class Task_ObjectsPrototypes {
    public static void main(String[] args) {
        try {
            File htmlFile = new File("event_objects.html");
            FileWriter htmlWriter = new FileWriter(htmlFile);
            htmlWriter.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Event Objects</title>
</head>
<body>
    <h1>Event Information</h1>
    <pre id="eventInfo"></pre>
    <script src="event_script.js"></script>
</body>
</html>
""");
            htmlWriter.close();

            File jsFile = new File("event_script.js");
            FileWriter jsWriter = new FileWriter(jsFile);
            jsWriter.write("""
function Event(name, date, totalSeats) {
    this.name = name;
    this.date = date;
    this.totalSeats = totalSeats;
    this.bookedSeats = 0;
}

Event.prototype.checkAvailability = function () {
    return this.totalSeats - this.bookedSeats > 0;
};

// Create event objects
const event1 = new Event("Tech Meetup", "2025-06-15", 50);
const event2 = new Event("Art Expo", "2025-07-01", 0);

// Book some seats
event1.bookedSeats = 45;

// Display event info
const output = [];

[event1, event2].forEach(e => {
    output.push(`Event: ${e.name}`);
    output.push(`Date: ${e.date}`);
    output.push(`Available: ${e.checkAvailability() ? "Yes" : "No"}`);
    output.push("Details:");
    output.push(JSON.stringify(Object.entries(e), null, 2));
    output.push("----------");
});

document.getElementById("eventInfo").textContent = output.join("\\n");
""");
            jsWriter.close();

            // Open HTML file in default browser
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
