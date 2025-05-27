import java.io.*;
import java.awt.Desktop;

public class Task_JS_ConditionalsLoops {
    public static void main(String[] args) {
        try {
            // Create HTML file
            File htmlFile = new File("event_filter.html");
            FileWriter htmlWriter = new FileWriter(htmlFile);
            htmlWriter.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Available Events</title>
</head>
<body>
    <h1>Upcoming Events</h1>
    <ul id="eventList"></ul>
    <p id="status"></p>

    <script src="events.js"></script>
</body>
</html>
""");
            htmlWriter.close();

            // Create JS file
            File jsFile = new File("events.js");
            FileWriter jsWriter = new FileWriter(jsFile);
            jsWriter.write("""
const events = [
    { name: "Spring Fair", date: "2025-05-20", seats: 10 },
    { name: "Tech Meetup", date: "2025-04-01", seats: 0 },
    { name: "Music Festival", date: "2025-06-10", seats: 5 },
    { name: "Past Event", date: "2024-12-01", seats: 20 }
];

const today = new Date().toISOString().split("T")[0];
const eventList = document.getElementById("eventList");

events.forEach(event => {
    if (event.date >= today && event.seats > 0) {
        const li = document.createElement("li");
        li.innerHTML = `${event.name} on ${event.date} - Seats: ${event.seats} 
        <button onclick="register('${event.name}')">Register</button>`;
        eventList.appendChild(li);
    }
});

function register(eventName) {
    try {
        const event = events.find(e => e.name === eventName);
        if (!event) throw "Event not found.";
        if (event.seats <= 0) throw "No seats available.";
        event.seats--;
        document.getElementById("status").innerText = 
            `Registered for ${eventName}. Remaining seats: ${event.seats}`;
    } catch (err) {
        document.getElementById("status").innerText = "Error: " + err;
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
