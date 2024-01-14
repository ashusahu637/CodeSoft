package currencyConverter;

import java.net.*;
import java.util.Scanner;
import org.json.JSONObject;

public class CurrencyConverter {

    public static void main(String[] args) {
        // Get user input for base and target currencies
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the base currency code: ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency code: ");
        String targetCurrency = scanner.next().toUpperCase();

        // Get user input for the amount to convert
        System.out.print("Enter the amount to convert: ");
        double amountToConvert = scanner.nextDouble();

        // Fetch real-time exchange rates from a reliable API
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

        // Perform currency conversion
        double convertedAmount = amountToConvert * exchangeRate;

        // Display the result to the user
        System.out.println(amountToConvert + " " + baseCurrency + " is equal to " + convertedAmount + " " + targetCurrency);
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
        try {
            // Replace this URL with the actual API URL and API key
            String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency;
            URL url = new URL(apiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the response and parse the JSON
            Scanner scanner = new Scanner(connection.getInputStream());
            StringBuilder response = new StringBuilder();

            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            JSONObject json = new JSONObject(response.toString());
            return json.getJSONObject("rates").getDouble(targetCurrency);

        } catch (Exception e) {
           System.out.println("Please Enter a valid Country Code");
            return 0; // Handle error, return default value or show an error message
        }
    }
}

