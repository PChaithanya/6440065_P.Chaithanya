import java.io.*;
import java.awt.Desktop;

public class DebugRegistrationPage {
    public static void main(String[] args) {
        try {
            File htmlFile = new File("debug_registration.html");
            FileWriter writer = new FileWriter(htmlFile);

            writer.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Debug Registration</title>
    <style>
        body { font-family: sans-serif; padding: 20px; }
        .status { margin-top: 20px; font-weight: bold; }
    </style>
</head>
<body>
    <h2>Register with Debugging</h2>
    <form id="registerForm">
        <label>Name:</label><br>
        <input type="text" name="name" required><br><br>
        
        <label>Email:</label><br>
        <input type="email" name="email" required><br><br>

        <button type="submit">Submit</button>
    </form>

    <div id="status" class="status"></div>

    <script>
        const form = document.getElementById("registerForm");
        const statusDiv = document.getElementById("status");

        form.addEventListener("submit", function(event) {
            event.preventDefault();

            console.log("🔍 Form submitted");  // Log start
            const name = form.elements["name"].value;
            const email = form.elements["email"].value;

            console.log("Captured Name:", name);  // Inspect variable
            console.log("Captured Email:", email);

            const payload = { name, email };
            console.log("📦 Payload to send:", payload);  // Log payload

            statusDiv.textContent = "Sending request...";

            // Add a breakpoint here in DevTools for inspection
            debugger;

            fetch("https://jsonplaceholder.typicode.com/posts", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(payload)
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network error");
                }
                return response.json();
            })
            .then(data => {
                console.log("✅ Server Response:", data);
                statusDiv.textContent = "Registration successful!";
            })
            .catch(error => {
                console.error("❌ Fetch Error:", error);
                statusDiv.textContent = "Error occurred during registration.";
            });
        });
    </script>
</body>
</html>
""");

            writer.close();
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
