import java.io.*;
import java.awt.Desktop;

public class Task8_UserPreferences {
    public static void main(String[] args) {
        try {
            String fileName = "task8_user_preferences.html";
            FileWriter writer = new FileWriter(fileName);
            writer.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Preferences</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 30px;
        }
        select, button {
            padding: 8px;
            font-size: 16px;
        }
    </style>
</head>
<body>

    <h2>Choose Your Preferred Event Type</h2>

    <select id="eventType" onchange="savePreference()">
        <option value="">--Select an Event--</option>
        <option value="Workshop">Workshop</option>
        <option value="Seminar">Seminar</option>
        <option value="Festival">Festival</option>
        <option value="Webinar">Webinar</option>
    </select>

    <br><br>
    <button onclick="clearPreferences()">Clear Preferences</button>

    <script>
        function savePreference() {
            const selectedValue = document.getElementById("eventType").value;
            localStorage.setItem("preferredEvent", selectedValue);
        }

        function loadPreference() {
            const savedValue = localStorage.getItem("preferredEvent");
            if (savedValue) {
                document.getElementById("eventType").value = savedValue;
            }
        }

        function clearPreferences() {
            localStorage.clear();
            sessionStorage.clear();
            document.getElementById("eventType").value = "";
            alert("Preferences cleared!");
        }

        window.onload = loadPreference;
    </script>

</body>
</html>
""");
            writer.close();

            File htmlFile = new File(fileName);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } else {
                System.out.println("Open the file manually: " + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
