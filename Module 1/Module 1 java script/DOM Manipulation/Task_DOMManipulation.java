import java.io.*;
import java.awt.Desktop;

public class Task_DOMManipulation {
    public static void main(String[] args) {
        try {
            File htmlFile = new File("dom_events.html");
            FileWriter htmlWriter = new FileWriter(htmlFile);
            htmlWriter.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Event Manager</title>
    <style>
        .event-card {
            border: 1px solid #333;
            border-radius: 8px;
            padding: 15px;
            margin: 10px;
            width: 250px;
            background-color: #f0f0f0;
        }
        .event-card button {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <h1>Available Events</h1>
    <div id="eventsContainer"></div>

    <script src="dom_script.js"></script>
</body>
</html>
""");
            htmlWriter.close();

            File jsFile = new File("dom_script.js");
            FileWriter jsWriter = new FileWriter(jsFile);
            jsWriter.write("""
// Sample event data
const events = [
    { title: "Yoga Class", registered: false },
    { title: "Art Workshop", registered: false },
    { title: "Live Music Night", registered: false }
];

// Render events dynamically
const container = document.querySelector('#eventsContainer');

events.forEach((event, index) => {
    const card = document.createElement('div');
    card.className = 'event-card';

    const title = document.createElement('h3');
    title.textContent = event.title;

    const button = document.createElement('button');
    button.textContent = event.registered ? 'Cancel' : 'Register';
    button.onclick = () => {
        event.registered = !event.registered;
        button.textContent = event.registered ? 'Cancel' : 'Register';
        alert(event.registered 
            ? `You registered for ${event.title}` 
            : `You canceled registration for ${event.title}`);
    };

    card.appendChild(title);
    card.appendChild(button);
    container.appendChild(card);
});
""");
            jsWriter.close();

            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
