import java.io.*;
import java.awt.Desktop;

public class Task7_VideoInviteMediaEvents {
    public static void main(String[] args) {
        try {
            String fileName = "task7_video_invite.html";
            FileWriter writer = new FileWriter(fileName);
            writer.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Event Video Invite</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
            text-align: center;
        }
        #statusMessage {
            color: green;
            font-weight: bold;
            margin-top: 10px;
        }
        form {
            margin-top: 30px;
        }
    </style>
</head>
<body>

    <h2>You're Invited!</h2>
    <video id="promoVideo" width="500" controls oncanplay="showMessage()">
        <source src="https://www.w3schools.com/html/mov_bbb.mp4" type="video/mp4">
        Your browser does not support the video tag.
    </video>
    <p id="statusMessage"></p>

    <form>
        <h3>RSVP to the Event</h3>
        <input type="text" placeholder="Your Name" required><br><br>
        <input type="email" placeholder="Your Email" required><br><br>
        <textarea placeholder="Your Message"></textarea><br><br>
        <button type="submit">Submit</button>
    </form>

    <script>
        function showMessage() {
            document.getElementById("statusMessage").innerText = "Video ready to play!";
        }

        window.onbeforeunload = function (e) {
            return "Are you sure you want to leave? Your form may not be submitted.";
        };
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
