import java.io.*;
import java.awt.Desktop;

public class Task_FormHandling_JS {
    public static void main(String[] args) {
        try {
            File htmlFile = new File("form_handling.html");
            FileWriter htmlWriter = new FileWriter(htmlFile);
            htmlWriter.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Event Registration</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        .error { color: red; font-size: 0.9em; }
        .form-group { margin-bottom: 15px; }
    </style>
</head>
<body>
    <h2>Register for an Event</h2>
    <form id="eventForm">
        <div class="form-group">
            <label>Name:</label><br>
            <input type="text" name="name">
            <div id="nameError" class="error"></div>
        </div>

        <div class="form-group">
            <label>Email:</label><br>
            <input type="email" name="email">
            <div id="emailError" class="error"></div>
        </div>

        <div class="form-group">
            <label>Event:</label><br>
            <select name="event">
                <option value="">--Select--</option>
                <option value="Music">Music Concert</option>
                <option value="Tech">Tech Conference</option>
                <option value="Art">Art Workshop</option>
            </select>
            <div id="eventError" class="error"></div>
        </div>

        <button type="submit">Register</button>
    </form>

    <script>
        const form = document.getElementById("eventForm");

        form.addEventListener("submit", function(event) {
            event.preventDefault(); // prevent page reload

            // Clear previous errors
            document.getElementById("nameError").textContent = "";
            document.getElementById("emailError").textContent = "";
            document.getElementById("eventError").textContent = "";

            // Access inputs
            const name = form.elements["name"].value.trim();
            const email = form.elements["email"].value.trim();
            const selectedEvent = form.elements["event"].value;

            let valid = true;

            // Validate name
            if (name === "") {
                document.getElementById("nameError").textContent = "Name is required.";
                valid = false;
            }

            // Validate email
            if (email === "") {
                document.getElementById("emailError").textContent = "Email is required.";
                valid = false;
            } else if (!email.includes("@")) {
                document.getElementById("emailError").textContent = "Enter a valid email.";
                valid = false;
            }

            // Validate event
            if (selectedEvent === "") {
                document.getElementById("eventError").textContent = "Please select an event.";
                valid = false;
            }

            // If valid, show success (could send data)
            if (valid) {
                alert(`Registered successfully for ${selectedEvent}, ${name}!`);
            }
        });
    </script>
</body>
</html>
""");
            htmlWriter.close();

            Desktop.getDesktop().browse(htmlFile.toURI());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
