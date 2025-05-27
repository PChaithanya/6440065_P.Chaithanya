import java.io.*;
import java.awt.Desktop;

public class Task_FetchAPI_AJAX {
    public static void main(String[] args) {
        try {
            File htmlFile = new File("fetch_ajax_registration.html");
            FileWriter htmlWriter = new FileWriter(htmlFile);
            htmlWriter.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>AJAX Registration</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        .form-group { margin-bottom: 15px; }
        .status { margin-top: 20px; font-weight: bold; }
    </style>
</head>
<body>
    <h2>Register for an Event (with Fetch)</h2>
    <form id="registerForm">
        <div class="form-group">
            <label>Name:</label><br>
            <input type="text" name="name" required>
        </div>
        <div class="form-group">
            <label>Email:</label><br>
            <input type="email" name="email" required>
        </div>
        <button type="submit">Submit</button>
    </form>

    <div id="status" class="status"></div>

    <script>
        const form = document.getElementById("registerForm");
        const statusDiv = document.getElementById("status");

        form.addEventListener("submit", function(event) {
            event.preventDefault();

            const name = form.elements["name"].value;
            const email = form.elements["email"].value;

            statusDiv.textContent = "Sending...";

            // Simulate delay
            setTimeout(() => {
                fetch("https://jsonplaceholder.typicode.com/posts", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({ name, email })
                })
                .then(response => {
                    if (!response.ok) {
                        throw new Error("Network response was not ok");
                    }
                    return response.json();
                })
                .then(data => {
                    statusDiv.textContent = "✅ Registration successful!";
                    console.log("Success:", data);
                })
                .catch(error => {
                    statusDiv.textContent = "❌ Failed to register. Try again.";
                    console.error("Error:", error);
                });
            }, 2000); // simulate 2-second delay
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
