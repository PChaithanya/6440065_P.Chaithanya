import java.io.*;
import java.awt.Desktop;

public class Task_ModernJSFeatures {
    public static void main(String[] args) {
        try {
            File htmlFile = new File("modern_js_demo.html");
            FileWriter htmlWriter = new FileWriter(htmlFile);
            htmlWriter.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Modern JavaScript Features</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        .event-card {
            border: 1px solid #aaa;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 6px;
        }
    </style>
</head>
<body>
    <h2>Event Highlights</h2>
    <div id="events"></div>

    <script src="modern.js"></script>
</body>
</html>
""");
            htmlWriter.close();

            File jsFile = new File("modern.js");
            FileWriter jsWriter = new FileWriter(jsFile);
            jsWriter.write("""
// Sample event list
const events = [
    { id: 1, name: "Music Fest", date: "2025-06-01", type: "music" },
    { id: 2, name: "Art Expo", date: "2025-06-15", type: "art" },
    { id: 3, name: "Tech Talk", date: "2025-07-01", type: "technology" }
];

// Function with default parameter
function displayEvents(eventList = []) {
    const container = document.getElementById("events");
    container.innerHTML = ""; // Clear

    eventList.forEach(event => {
        // Destructuring
        const { name, date, type } = event;

        const card = document.createElement("div");
        card.className = "event-card";
        card.innerHTML = `<strong>${name}</strong><br>Date: ${date}<br>Type: ${type}`;
        container.appendChild(card);
    });
}

// Spread operator to clone and filter
const musicEvents = [...events].filter(e => e.type === "music");

// Show all events
displayEvents(events);

// Console output
console.log("Original List:", events);
console.log("Filtered Music Events:", musicEvents);
""");
            jsWriter.close();

            Desktop.getDesktop().browse(htmlFile.toURI());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
