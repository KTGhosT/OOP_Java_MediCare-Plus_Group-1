package notifications;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class TwilioSMS {
    // Twilio Credentials (Replace with your actual Twilio credentials)
    public static final String ACCOUNT_SID = "ACbfeddafaaf39e170b6b0a3ef28978dea"; 
    public static final String AUTH_TOKEN = "25a578699d4459b5fcc13b336648da44";  
    public static final String TWILIO_NUMBER = "+17755499359"; 

    public static void sendSMS(String patientPhone, String message) {
        try {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN); // Initialize Twilio

            Message sms = Message.creator(
                    new com.twilio.type.PhoneNumber(patientPhone), // Patient's phone number
                    new com.twilio.type.PhoneNumber(TWILIO_NUMBER), // Twilio number
                    message
            ).create();

            System.out.println("SMS Sent Successfully! Message SID: " + sms.getSid());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error Sending SMS: " + e.getMessage());
        }
    }
}
