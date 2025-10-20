import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class cconverter {
    public static double getExchangeRate(String baseCurrency, String targetCurrency) {
        String urlString = "https://open.er-api.com/v6/latest/" + baseCurrency;

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                StringBuilder inline = new StringBuilder();
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()) {
                    inline.append(sc.nextLine());
                }
                sc.close();

                // manually find target currency value in JSON text
                String search = "\"" + targetCurrency + "\":";
                int start = inline.indexOf(search);
                if (start == -1) {
                    System.out.println("Currency not found!");
                    return -1;
                }
                int end = inline.indexOf(",", start);
                String rateStr = inline.substring(start + search.length(), end);
                return Double.parseDouble(rateStr);
            }
        } catch (Exception e) {
            System.out.println("Error fetching exchange rate: " + e.getMessage());
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Currency Converter ===");
        System.out.print("Enter base currency (e.g., USD, INR, EUR): ");
        String base = sc.next().toUpperCase();

        System.out.print("Enter target currency (e.g., USD, INR, EUR): ");
        String target = sc.next().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = sc.nextDouble();

        double rate = getExchangeRate(base, target);

        if (rate != -1) {
            double converted = amount * rate;
            System.out.printf("💱 %.2f %s = %.2f %s%n", amount, base, converted, target);
        } else {
            System.out.println("Conversion failed. Please try again.");
        }

        sc.close();
    }
}
