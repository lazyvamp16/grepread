import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PassageSplitter {

    private static String getPassageFromServer(String urlString) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line).append("\n");
            }
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    private static String[] splitPassageIntoSections(String passage) {
        return passage.split("\\n\\n");
    }

    public static void main(String[] args) {
        String url = "http://example.com/passage"; // Replace with actual URL

        String passage = getPassageFromServer(url);

        String[] sections = splitPassageIntoSections(passage);

        for (int i = 0; i < sections.length; i++) {
            System.out.println("Section " + (i + 1) + ":");
            System.out.println(sections[i]);
            System.out.println("-----------------------");
        }
    }
}
