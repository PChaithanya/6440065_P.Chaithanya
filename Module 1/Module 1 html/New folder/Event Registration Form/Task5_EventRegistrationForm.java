import java.io.*;
import java.awt.Desktop;

public class Task5_EventRegistrationForm {
    public static void main(String[] args) {
        try {
            String fileName = "task5_event_registration.html";
            FileWriter writer = new FileWriter(fileName);
            writer.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Event Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
            background-color: #f4f4f4;
        }
        form {
            background-color: #fff;
            padding: 20px;
            width: 400px;
            margin: auto;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        label {
            display: block;
            margin: 12px 0 6px;
        }
        input, select, textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }
        input[type="submit"] {
            background-color: #28a745;
            color: white;
            border: none;
            cursor: pointer;
        }
        output {
            display: block;
            margin-top: 15px;
            font-weight: bold;
            color: green;
        }
    </style>
</head>
<body>

    <form onsubmit="event.preventDefault(); document.getElementById('confirmation').innerText = 'Registration Successful!';">
        <h2>Event Registration Form</h2>
        
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" placeholder="Enter your name" required autofocus>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" placeholder="Enter your email" required>

        <label for="date">Event Date:</label>
        <input type="date" id="date" name="date" required>

        <label for="type">Event Type:</label>
        <select id="type" name="type" required>
            <option value="">--Select an event--</option>
            <option value="music">Music Night</option>
            <option value="tech">Tech Talk</option>
            <option value="art">Art Show</option>
        </select>

        <label for="message">Message:</label>
        <textarea id="message" name="message" placeholder="Your message..."></textarea>

        <input type="submit" value="Register">

        <output id="confirmation"></output>
    </form>

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
