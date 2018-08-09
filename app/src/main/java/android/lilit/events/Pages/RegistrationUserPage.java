package android.lilit.events.Pages;

import android.lilit.events.MD5;
import android.lilit.events.R;
import android.lilit.events.SendEmailInBackground;
import android.lilit.events.apiservices.ApiServiceUserRegistration;
import android.lilit.events.clients.ApiClient;
import android.lilit.events.models.RegistrationLoginUpdateUserResponseModel;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationUserPage extends AppCompatActivity{

    private EditText username_registration_et, password_registration_et, repeat_password_registration_et, nickname_registration_et;
    /*private String username_registration;
    private String password_registration;
    private String repeat_password_registration;
    private String nickname_registration;*/
    private TextView username_registration_tv, password_registration_tv, repeat_password_registration_tv,nickname_registration_tv, hintUser_tv;

    //private String emailText_registrationUser;
    //private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_user_layout);

        username_registration_et = (EditText)findViewById(R.id.username_etPD);
        password_registration_et = (EditText)findViewById(R.id.password_etPD);
        repeat_password_registration_et = (EditText)findViewById(R.id.repeat_password_etPD);
        nickname_registration_et = (EditText)findViewById(R.id.nickname_etPD);
        username_registration_tv = (TextView)findViewById(R.id.username_registration_tv);
        password_registration_tv =(TextView)findViewById(R.id.password_registration_tv);
        repeat_password_registration_tv = (TextView)findViewById(R.id.repeat_password_registration_tv);
        nickname_registration_tv = (TextView)findViewById(R.id.nickname_registration_tv);
        hintUser_tv = (TextView)findViewById(R.id.hintUser_tv);

        }

    //onclick
    public void addProfilePicture(View view) {

    }

    //onclick
    public void registrationNewUser(View view) {

        String username_registration = username_registration_et.getText().toString();
        String password_registration = password_registration_et.getText().toString();
        String repeat_password_registration = repeat_password_registration_et.getText().toString();
        String nickname_registration = nickname_registration_et.getText().toString();

        if (!testEmail(username_registration)){
            changeViewTrueOrFalseUsernameOrPassword(username_registration_et, username_registration_tv, getResources().getColor(R.color.colorRose), View.VISIBLE);
        } else {
            changeViewTrueOrFalseUsernameOrPassword(username_registration_et, username_registration_tv, getResources().getColor(R.color.colorBlue), View.INVISIBLE);
        }
        if (!testPassword(password_registration)){
            changeViewTrueOrFalseUsernameOrPassword(password_registration_et, password_registration_tv, getResources().getColor(R.color.colorRose), View.VISIBLE);
            changeViewTrueOrFalseUsernameOrPassword(repeat_password_registration_et, repeat_password_registration_tv, getResources().getColor(R.color.colorRose), View.VISIBLE);
        } else {
            changeViewTrueOrFalseUsernameOrPassword(password_registration_et, password_registration_tv, getResources().getColor(R.color.colorBlue), View.INVISIBLE);
            if (!repeat_password_registration.equals(password_registration)) {
                changeViewTrueOrFalseUsernameOrPassword(repeat_password_registration_et, repeat_password_registration_tv, getResources().getColor(R.color.colorRose), View.VISIBLE);
            } else {
                changeViewTrueOrFalseUsernameOrPassword(repeat_password_registration_et, repeat_password_registration_tv, getResources().getColor(R.color.colorBlue), View.INVISIBLE);
            }
        }
           if (!testNickname(nickname_registration)){
            changeViewTrueOrFalseUsernameOrPassword(nickname_registration_et, nickname_registration_tv, getResources().getColor(R.color.colorRose), View.VISIBLE);
        } else {
            changeViewTrueOrFalseUsernameOrPassword(nickname_registration_et, nickname_registration_tv, getResources().getColor(R.color.colorBlue), View.INVISIBLE);
        }

        if (testEmail(username_registration) && testPassword(password_registration) && repeat_password_registration.equals(password_registration) && testNickname(nickname_registration)){
            insertUserData( username_registration, MD5.md5Custom(password_registration), nickname_registration);
            hintUser_tv.setText("Ձեր էջի ակտիվացման համար անհրաժեշտ է սույն էլ․ հասցեից այն հաստատել");

            //noric petq e login lini, mail-y hastateluc heto
            /*Intent loginPageIntent = new Intent(this, LoginPage.class);
            startActivity(firstPageIntent);*/
        }
        else {
            hintUser_tv.setText("Ճշգրտել մուտքագրված տվյալները");
        }
    }

    //onclick
    public void cancelPage(View view) {
        this.finish();
    }

    /*  this method used to send user registration data to server or our local server
     * @param username
     * @param password */
    public void insertUserData(final String username, final String password, String nickname){

        ApiServiceUserRegistration apiService = ApiClient.getClient().create(ApiServiceUserRegistration.class);
        Call<RegistrationLoginUpdateUserResponseModel> call = apiService.registrationUserData(username, password, nickname);
        call.enqueue(new Callback<RegistrationLoginUpdateUserResponseModel>() {
            @Override
            public void onResponse(Call<RegistrationLoginUpdateUserResponseModel> call, Response<RegistrationLoginUpdateUserResponseModel> response) {

                RegistrationLoginUpdateUserResponseModel insertUserResponseModel = response.body();

                //ProgressDialog progressDialog = new ProgressDialog(Registration_User.this);

                //check the status code
                if(insertUserResponseModel.getStatus()==1){
                    String emailText_registrationUser = "Շնորհավորում ենք, Դուք հաջողությամբ գրանցվել եք 'Իրադարձությունների վերահսկում' Բջջային հավելվածում։" + "\n\n";//R.string.emailText_registrationUser + "\n\n";
                    SendEmailInBackground sendEmailInBackground = new SendEmailInBackground(RegistrationUserPage.this, username, password, emailText_registrationUser);
                    sendEmailInBackground.sendMail();

                    Toast.makeText(RegistrationUserPage.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    //progressDialog.dismiss();
                }else{
                    Toast.makeText(RegistrationUserPage.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    //progressDialog.dismiss();
                }
            }
            @Override
            public void onFailure(Call<RegistrationLoginUpdateUserResponseModel> call, Throwable t) {
                Toast.makeText(RegistrationUserPage.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                //progressDialog.dismiss();
            }
        });

    }

    /*change views with inserting true or false username's or password's*/
    public void changeViewTrueOrFalseUsernameOrPassword(EditText et, TextView tv, int color, int visibility){
        et.setBackgroundColor(color);
        tv.setVisibility(visibility);
    }

    //Regular Expressions for username/email, password,

    public boolean testEmail(String email){
        Pattern patt = Pattern.compile("[^,\\s]+@[^,\\s]+[.][^,\\s]+\\s*"); 		//cankacac simvolner baci storaketic, probelic u mechy petq e anpayman lini '@' u heto '.' nshannery hertakanutyamb u email-i verchum karox e linel kam chlinel probel/ner....."^[^,]\\S[^,]{0,}\\@(gmail.com|yahoo.com|mail.ru|yandex.ru|rambler.ru)"	//mail-i anuni simvolnery chen karox linel probel ev ',' ev qanaky chi karox poqr linel 2-ic u verchanum e hmpt verdjavorutyunnerov
        Matcher match = patt.matcher(email);
        boolean b = match.matches();
        return b;

        //return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        //    return !(email == null || TextUtils.isEmpty(email)) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();

       /* public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
                "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                        "\\@" +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                        "(" +
                        "\\." +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                        ")+"
        );
        private boolean checkEmail(String email) {
            return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
        }*/


        /*Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();*/
    }


    public boolean testPassword(String password){
        Pattern patt = Pattern.compile("([\\S\\s]){6,15}");	  //    \\S*[A-Z]\\S*[A-Z]\\S*[0-9]\\S*[0-9]\\S*[0-9]\\S*  //gitem sxal a ashkhatum:) grac artahaytutyan mech erkrord mecataric heto petq e gone ereq hat tiv lini grac
        Matcher match = patt.matcher(password);
        boolean b = match.matches();
        return b;
    }

    public boolean testNickname(String nickname){
        Pattern patt = Pattern.compile("([a-zA-Z0-9\\s-]){2,25}"); //([a-zA-Z0-9\s-]){2,15}")	//([/w]+){3,}      ([^,\s]+){3,} cankacac simvol(length>2) baci ','-ic probelic
        Matcher match = patt.matcher(nickname);
        boolean b = match.matches();
        return b;
    }
}
