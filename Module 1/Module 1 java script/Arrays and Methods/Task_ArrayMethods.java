import java.io.*;
import java.awt.Desktop;

public class Task_ArrayMethods {
    public static void main(String[] args) {
        try {
            File htmlFile = new File("array_events.html");
            FileWriter htmlWriter = new FileWriter(htmlFile);
            htmlWriter.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Community Events</title>
</head>
<body>
    <h2>All Community Events</h2>
    <pre id="allEvents"></pre>

    <h2>Music Events</h2>
    <pre id="musicEvents"></pre>

    <h2>Formatted Event Cards</h2>
    <pre id="formattedEvents"></pre>

    <script src="array_script.js"></script>
</body>
</html>
""");
            htmlWriter.close();

            File jsFile = new File("array_script.js");
            FileWriter jsWriter = new FileWriter(jsFile);
            jsWriter.write("""
// Initial array of events
let events = [
    { title: "Workshop on Baking", category: "Workshop" },
    { title: "Jazz Night", category: "Music" },
    { title: "Coding Bootcamp", category: "Technology" }
];

// Add new events using push()
events.push({ title: "Rock Concert", category: "Music" });
events.push({ title: "Painting Session", category: "Art" });

// Filter music events
const musicEvents = events.filter(event => event.category === "Music");

// Format all events into display cards
const formattedCards = events.map(e => `📅 ${e.category} - ${e.title}`);

// Display
document.getElementById("allEvents").textContent = JSON.stringify(events, null, 2);
document.getElementById("musicEvents").textContent = JSON.stringify(musicEvents, null, 2);
document.getElementById("formattedEvents").textContent = formattedCards.join("\\n");
""");
            jsWriter.close();

            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
