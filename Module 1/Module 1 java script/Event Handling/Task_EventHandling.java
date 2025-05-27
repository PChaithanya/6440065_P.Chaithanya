import java.io.*;
import java.awt.Desktop;

public class Task_EventHandling {
    public static void main(String[] args) {
        try {
            File htmlFile = new File("event_handling.html");
            FileWriter htmlWriter = new FileWriter(htmlFile);
            htmlWriter.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Event Interaction</title>
    <style>
        .event-card {
            border: 1px solid #555;
            border-radius: 5px;
            padding: 10px;
            margin: 10px;
            background-color: #f4f4f4;
        }
    </style>
</head>
<body>

    <h2>Community Events</h2>

    <label for="categoryFilter">Filter by Category:</label>
    <select id="categoryFilter">
        <option value="All">All</option>
        <option value="Music">Music</option>
        <option value="Workshop">Workshop</option>
        <option value="Fitness">Fitness</option>
    </select>

    <br><br>

    <input type="text" id="searchInput" placeholder="Search events by name..." />

    <div id="eventsContainer"></div>

    <script src="event_script.js"></script>
</body>
</html>
""");
            htmlWriter.close();

            File jsFile = new File("event_script.js");
            FileWriter jsWriter = new FileWriter(jsFile);
            jsWriter.write("""
// Sample events
const events = [
    { title: "Yoga Class", category: "Fitness" },
    { title: "Guitar Jam", category: "Music" },
    { title: "Painting Workshop", category: "Workshop" },
    { title: "Cardio Blast", category: "Fitness" }
];

const container = document.getElementById("eventsContainer");
const filterSelect = document.getElementById("categoryFilter");
const searchInput = document.getElementById("searchInput");

function displayEvents(filteredEvents) {
    container.innerHTML = "";
    filteredEvents.forEach((event, index) => {
        const card = document.createElement("div");
        card.className = "event-card";

        const title = document.createElement("h4");
        title.textContent = event.title;

        const button = document.createElement("button");
        button.textContent = "Register";
        button.onclick = () => {
            alert("Registered for: " + event.title);
        };

        card.appendChild(title);
        card.appendChild(button);
        container.appendChild(card);
    });
}

// Initial render
displayEvents(events);

// Filter by category
filterSelect.onchange = () => {
    const selected = filterSelect.value;
    const filtered = selected === "All" ? events : events.filter(e => e.category === selected);
    displayEvents(filtered);
};

// Search by name
searchInput.addEventListener("keydown", (e) => {
    const keyword = e.target.value.toLowerCase();
    const filtered = events.filter(e => e.title.toLowerCase().includes(keyword));
    displayEvents(filtered);
});
""");
            jsWriter.close();

            Desktop.getDesktop().browse(htmlFile.toURI());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
