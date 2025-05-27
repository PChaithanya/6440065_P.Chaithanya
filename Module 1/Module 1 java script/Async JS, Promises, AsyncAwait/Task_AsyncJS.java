import java.io.*;
import java.awt.Desktop;

public class Task_AsyncJS {
    public static void main(String[] args) {
        try {
            File htmlFile = new File("async_fetch_demo.html");
            FileWriter htmlWriter = new FileWriter(htmlFile);
            htmlWriter.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Async Events</title>
    <style>
        body { font-family: Arial; padding: 20px; }
        .event-card {
            border: 1px solid #ccc;
            padding: 10px;
            margin: 10px;
            border-radius: 6px;
        }
        #loader {
            display: none;
            font-weight: bold;
            color: green;
        }
    </style>
</head>
<body>

    <h2>Upcoming Events</h2>
    <div id="loader">Loading events...</div>
    <div id="eventList"></div>

    <script src="async_script.js"></script>
</body>
</html>
""");
            htmlWriter.close();

            File jsFile = new File("async_script.js");
            FileWriter jsWriter = new FileWriter(jsFile);
            jsWriter.write("""
// Simulate mock API endpoint
const mockEndpoint = "https://jsonplaceholder.typicode.com/posts?_limit=5";
const loader = document.getElementById("loader");
const eventList = document.getElementById("eventList");

// With .then() and .catch()
function loadEventsWithThen() {
    loader.style.display = "block";
    fetch(mockEndpoint)
        .then(response => response.json())
        .then(data => {
            loader.style.display = "none";
            renderEvents(data);
        })
        .catch(error => {
            loader.style.display = "none";
            eventList.innerHTML = "Failed to load events.";
            console.error("Error:", error);
        });
}

// Using async/await
async function loadEventsAsync() {
    loader.style.display = "block";
    try {
        const response = await fetch(mockEndpoint);
        const data = await response.json();
        renderEvents(data);
    } catch (error) {
        eventList.innerHTML = "Error fetching data.";
        console.error("Fetch Error:", error);
    } finally {
        loader.style.display = "none";
    }
}

function renderEvents(events) {
    eventList.innerHTML = "";
    events.forEach(event => {
        const div = document.createElement("div");
        div.className = "event-card";
        div.innerHTML = `<h4>${event.title}</h4><p>${event.body}</p>`;
        eventList.appendChild(div);
    });
}

// Call function
loadEventsAsync(); // or loadEventsWithThen()
""");
            jsWriter.close();

            Desktop.getDesktop().browse(htmlFile.toURI());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
