import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class HttpGetMain {

    public static final String SEPARATOR = ",";
    private static String TABLE_REGEX = ".*\\[(.*)\\].*";
    private static Pattern regexp = Pattern.compile(TABLE_REGEX);

    public static void main(String[] args) {
        System.setProperty("http.agent", "Chrome");
        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/rest-get-simple");
            try {
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                String inputData = toString(inputStream);
                Matcher matcher = regexp.matcher(inputData);
                while (matcher.find()) {
                    MatchResult result = matcher.toMatchResult();
                    System.out.println(result.group(1).split(SEPARATOR));
                    Stream<String> hobbies = Arrays.stream(result.group(1).split(SEPARATOR));
                    System.out.println(hobbies.map(h -> h.replaceAll("\\\"", "")).collect(Collectors.joining(", ")));
                }

            } catch (IOException ioEx) {
                System.out.println(ioEx);
            }
        } catch (MalformedURLException malEx) {
            System.out.println(malEx);
        }
    }

    public static String toString(InputStream input) throws IOException {
        return new String(input.readAllBytes(), StandardCharsets.UTF_8);
    }
}
