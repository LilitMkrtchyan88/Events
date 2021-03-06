package android.lilit.events;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Lilit Mkrtchyan on 5/28/2018.
 */

public class SendEmailInBackground {

    private final String username = "events_tracker@mail.ru";
    private final String password = "ArsSystems8";
    private String email_username;
    private String newPassword_user;
    private String textEmail;
    Context context;
    //context = getClass();

    public SendEmailInBackground(Context context, String email_username, String newPassword_user, String textEmail){
        this.email_username = email_username;
        this.newPassword_user = newPassword_user;
        this.textEmail = textEmail;
        this.context = context;

    }

    public void sendMail() {

        //autogeneratedNewPassword = getToken(length_forgotPassword);

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.mail.ru");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email_username + ",events_tracker@mail.ru"));
            message.setSubject("Իրադարձությունների վերահսկում - ուղարկված է MobileApp-ից");
            message.setText(textEmail);

            new SendMailTask().execute(message);
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    /*   */
    private class SendMailTask extends AsyncTask<Message, String, String> {
        private ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(context, null, "Sending mail", true, false);
        }
        @Override
        protected String doInBackground(Message... messages) {
            try {
                Transport.send(messages[0]);
                return "Success";
            } catch (SendFailedException ee) {
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                return "error1";
            } catch (MessagingException e) {
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                return "error2";
            }
        }
        @Override
        protected void onPostExecute(String result) {
            if(result.equals("Success")) {
                super.onPostExecute(result);
                progressDialog.dismiss();
                Toast.makeText(context, "Mail Sent Successfully", Toast.LENGTH_LONG).show();

            }
            else if(result.equals("error1")) {
                Toast.makeText(context, "Email Failure", Toast.LENGTH_LONG).show();
            }
            else if(result.equals("error2")) {
                Toast.makeText(context, "Email Sent problem2", Toast.LENGTH_LONG).show();
            }
        }


    }

}
