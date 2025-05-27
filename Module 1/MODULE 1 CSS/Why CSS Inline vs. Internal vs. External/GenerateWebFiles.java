import java.io.FileWriter;
import java.io.IOException;

public class GenerateWebFiles {
    public static void main(String[] args) {
        // Create index.html
        String htmlContent = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>City Council Event Portal</title>
                    <!-- Link to external stylesheet -->
                    <link rel="stylesheet" href="styles.css">
                    <!-- Internal CSS for body background -->
                    <style>
                        /* Body background styling */
                        body {
                            background-color: #f0f2f5;
                            background-image: url('https://example.com/city-bg.jpg');
                            background-size: cover;
                            background-position: center;
                            background-repeat: no-repeat;
                        }
                    </style>
                </head>
                <body>
                    <!-- Inline style for red heading -->
                    <h1 style="color: red;">City Council Events</h1>
                    <header id="mainHeader">
                        <h2>Welcome to Our Community Events</h2>
                    </header>
                    <section class="event-section">
                        <div class="eventCard">
                            <h3>Community Cleanup</h3>
                            <p>Join us for a neighborhood cleanup event!</p>
                        </div>
                    </section>
                </body>
                </html>
                """;

        // Create styles.css
        String cssContent = """
                /* Reset styles */
                * {
                    margin: 0;
                    padding: 0;
                    box-sizing: border-box;
                }

                /* Header styles */
                h2 {
                    font-size: 2rem;
                    color: #2c3e50;
                    text-align: center;
                    background: linear-gradient(to right, #3498db, #2ecc71);
                    padding: 10px;
                }

                /* Main banner styles */
                #mainHeader {
                    background-color: rgba(52, 152, 219, 0.8);
                    padding: 20px;
                    text-align: center;
                }

                /* Event card styles */
                .eventCard {
                    border: 2px solid #3498db;
                    padding: 15px;
                    margin: 10px;
                    background-color: #ffffff;
                    border-radius: 5px;
                }

                /* Grouped styles for h3 and p */
                h3, p {
                    color: #34495e;
                    text-align: left;
                    margin: 5px 0;
                }
                """;

        // Write HTML file
        try (FileWriter htmlWriter = new FileWriter("index.html")) {
            htmlWriter.write(htmlContent);
            System.out.println("index.html created successfully.");
        } catch (IOException e) {
            System.err.println("Error writing index.html: " + e.getMessage());
        }

        // Write CSS file
        try (FileWriter cssWriter = new FileWriter("styles.css")) {
            cssWriter.write(cssContent);
            System.out.println("styles.css created successfully.");
        } catch (IOException e) {
            System.err.println("Error writing styles.css: " + e.getMessage());
        }
    }
}