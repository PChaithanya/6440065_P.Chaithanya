import java.io.*;
import java.awt.Desktop;

public class Task7_TableStyling {
    public static void main(String[] args) {
        try {
            File htmlFile = new File("task7_index.html");
            FileWriter writer = new FileWriter(htmlFile);
            writer.write("""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Table Styling</title>
    <link rel="stylesheet" href="task7_styles.css">
</head>
<body>

    <h2>Events Admin Table</h2>
    <table>
        <tr>
            <th>Event</th>
            <th>Date</th>
            <th>Location</th>
        </tr>
        <tr>
            <td>Community Meeting</td>
            <td>June 5</td>
            <td>Town Hall</td>
        </tr>
        <tr>
            <td>Art Festival</td>
            <td>June 12</td>
            <td>Central Park</td>
        </tr>
        <tr>
            <td>Cleanup Drive</td>
            <td>June 20</td>
            <td>River Side</td>
        </tr>
    </table>

</body>
</html>
""");
            writer.close();

            File cssFile = new File("task7_styles.css");
            FileWriter cssWriter = new FileWriter(cssFile);
            cssWriter.write("""
table {
    width: 80%;
    margin: 20px auto;
    border-collapse: collapse;
    text-align: center;
    font-family: Arial, sans-serif;
}

th, td {
    border: 1px solid #999;
    padding: 12px;
    background-color: #f2f2f2;
}

tr:nth-child(even) td {
    background-color: #e0e0e0;
}
""");
            cssWriter.close();

            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
