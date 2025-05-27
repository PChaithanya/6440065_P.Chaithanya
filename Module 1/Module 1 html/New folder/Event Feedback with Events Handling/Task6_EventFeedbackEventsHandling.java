import java.io.*;
import java.awt.Desktop;

public class Task6_EventFeedbackEventsHandling {
    public static void main(String[] args) {
        try {
            String fileName = "task6_event_feedback.html";
            FileWriter writer = new FileWriter(fileName);
            writer.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Event Feedback</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }
        form {
            width: 400px;
            margin: auto;
        }
        label {
            display: block;
            margin-top: 10px;
        }
        input, select, textarea {
            width: 100%;
            padding: 8px;
            margin: 5px 0;
        }
        #eventImage {
            width: 200px;
            transition: transform 0.3s ease;
        }
        #eventImage.enlarged {
            transform: scale(1.5);
        }
        #charCount {
            font-size: 14px;
            color: gray;
        }
    </style>
</head>
<body>

    <form onsubmit="event.preventDefault(); alert('Feedback Submitted Successfully!');">
        <h2>Event Feedback</h2>

        <label for="phone">Phone Number:</label>
        <input type="text" id="phone" placeholder="Enter phone number" onblur="validatePhone()">

        <label for="eventType">Select Event:</label>
        <select id="eventType" onchange="showFee()">
            <option value="">--Choose--</option>
            <option value="music">Music Night - $20</option>
            <option value="tech">Tech Talk - $15</option>
            <option value="art">Art Show - $10</option>
        </select>
        <p id="feeDisplay" style="font-weight: bold;"></p>

        <label for="feedback">Your Feedback:</label>
        <textarea id="feedback" rows="4" onkeyup="countChars()"></textarea>
        <p id="charCount">Characters: 0</p>

        <input type="submit" value="Submit Feedback" onclick="alert('Thank you for your feedback!')">
    </form>

    <br>
    <div style="text-align: center;">
        <p>Double-click the image to enlarge:</p>
        <img src="https://via.placeholder.com/200" alt="Event" title="Double-click to enlarge" id="eventImage"
             ondblclick="toggleImageSize()">
    </div>

    <script>
        function validatePhone() {
            let phone = document.getElementById("phone").value;
            if (!/^\\d{10}$/.test(phone)) {
                alert("Please enter a valid 10-digit phone number.");
            }
        }

        function showFee() {
            let select = document.getElementById("eventType");
            let selectedText = select.options[select.selectedIndex].text;
            document.getElementById("feeDisplay").innerText = "Selected: " + selectedText;
        }

        function toggleImageSize() {
            let img = document.getElementById("eventImage");
            img.classList.toggle("enlarged");
        }

        function countChars() {
            let feedback = document.getElementById("feedback").value;
            document.getElementById("charCount").innerText = "Characters: " + feedback.length;
        }
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
