import java.io.*;
import java.awt.Desktop;

public class Task9_GeolocationEventMapping {
    public static void main(String[] args) {
        try {
            String fileName = "task9_geolocation.html";
            FileWriter writer = new FileWriter(fileName);
            writer.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Nearby Event Locator</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }
        #output {
            margin-top: 20px;
            font-weight: bold;
            color: green;
        }
        button {
            padding: 10px 20px;
            font-size: 16px;
        }
    </style>
</head>
<body>

    <h2>Find Nearby Events</h2>
    <button onclick="getLocation()">Find My Location</button>

    <div id="output"></div>

    <script>
        function getLocation() {
            const output = document.getElementById("output");

            if (!navigator.geolocation) {
                output.innerHTML = "Geolocation is not supported by your browser.";
                return;
            }

            const options = {
                enableHighAccuracy: true,
                timeout: 10000,
                maximumAge: 0
            };

            function success(position) {
                const lat = position.coords.latitude;
                const lon = position.coords.longitude;
                output.innerHTML = `Latitude: ${lat} <br> Longitude: ${lon}`;
            }

            function error(err) {
                switch(err.code) {
                    case err.PERMISSION_DENIED:
                        output.innerHTML = "Permission denied. Cannot access location.";
                        break;
                    case err.POSITION_UNAVAILABLE:
                        output.innerHTML = "Location information is unavailable.";
                        break;
                    case err.TIMEOUT:
                        output.innerHTML = "The request to get your location timed out.";
                        break;
                    default:
                        output.innerHTML = "An unknown error occurred.";
                }
            }

            output.innerHTML = "Locating...";
            navigator.geolocation.getCurrentPosition(success, error, options);
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
