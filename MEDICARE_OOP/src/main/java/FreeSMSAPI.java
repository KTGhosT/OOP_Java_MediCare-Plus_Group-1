import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FreeSMSAPI {
    public static void main(String[] args) {
        try {
            String apiUrl = "https://smsgateway24.com/getdata/addsms"; // Example URL
            String apiKey = "97411480f265da7e024871e326429638";  // Replace with your API Key
            String phoneNumber = "+94726671712";  // Replace with recipient's number
            String message = "Hello from FreeSMS API!";

            // JSON Payload
            String jsonPayload = "{"
                + "\"apiKey\": \"" + apiKey + "\","
                + "\"number\": \"" + phoneNumber + "\","
                + "\"message\": \"" + message + "\""
                + "}";

            // Create connection
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Send request
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonPayload.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Read response
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println("Response: " + response.toString());

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
