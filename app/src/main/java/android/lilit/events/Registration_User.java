package android.lilit.events;

/**
 * Created by Lilit Mkrtchyan on 5/23/2018.
 */

import android.app.Activity;
import android.lilit.events.apiservices.ApiServiceUserRegistration;
import android.lilit.events.clients.ApiClient;
import android.lilit.events.models.RegistrationLoginUpdateUserResponseModel;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration_User extends Activity{

    private EditText username_registration_et;
    private EditText password_registration_et;
    private EditText repeat_password_registration_et;
    private EditText nickname_registration_et;
    /*private String username_registration;
    private String password_registration;
    private String repeat_password_registration;
    private String nickname_registration;*/
    private TextView username_registration_tv;
    private TextView password_registration_tv;
    private TextView repeat_password_registration_tv;
    private TextView nickname_registration_tv;
    private Button registrationUser_btn;



    //private String emailText_registrationUser;

    //private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_registration_user);

        username_registration_et = (EditText)findViewById(R.id.username_etPD);
        password_registration_et = (EditText)findViewById(R.id.password_etPD);
        repeat_password_registration_et = (EditText)findViewById(R.id.repeat_password_etPD);
        nickname_registration_et = (EditText)findViewById(R.id.nickname_etPD);
        username_registration_tv = (TextView)findViewById(R.id.username_registration_tv);
        password_registration_tv =(TextView)findViewById(R.id.password_registration_tv);
        repeat_password_registration_tv = (TextView)findViewById(R.id.repeat_password_registration_tv);
        nickname_registration_tv = (TextView)findViewById(R.id.nickname_registration_tv);
        registrationUser_btn = (Button)findViewById(R.id.registrationUser_btn);

        registrationUser_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username_registration = username_registration_et.getText().toString();
                String password_registration = password_registration_et.getText().toString();
                String repeat_password_registration = repeat_password_registration_et.getText().toString();
                String nickname_registration = nickname_registration_et.getText().toString();

                /*if (username_registration.equals("")){
                    //Log.e("Lilit", "1");
                    username_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
                }
                else */
                if (!testEmail(username_registration)){
                    username_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
                    username_registration_tv.setVisibility(View.VISIBLE);
                }
                else {
                    username_registration_et.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                    username_registration_tv.setVisibility(View.INVISIBLE);
                }

                if (!testPassword(password_registration)){
                    password_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
                    password_registration_tv.setVisibility(View.VISIBLE);
                }
                else {
                    password_registration_et.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                    password_registration_tv.setVisibility(View.INVISIBLE);
                }

                if (password_registration.equals("")|| !repeat_password_registration.equals(password_registration)) {
                    repeat_password_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
                    repeat_password_registration_tv.setText(R.string.falseRepeatPassword);
                    repeat_password_registration_tv.setVisibility(View.VISIBLE);}
                else {
                    repeat_password_registration_et.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                    repeat_password_registration_tv.setVisibility(View.INVISIBLE);
                }

                if (!testNickname(nickname_registration)){
                    nickname_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
                    nickname_registration_tv.setVisibility(View.VISIBLE);}
                else {
                    nickname_registration_et.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                    nickname_registration_tv.setVisibility(View.INVISIBLE);
                    insertUserData( username_registration, MD5.md5Custom(password_registration), nickname_registration);
                }
            }
/*
                *//*if (password_registration.equals("")){
                    //Log.e("Lilit", "1");
                    password_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
                }
                else*//* if (!testPassword(password_registration)){
                    password_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
                    password_registration_tv.setVisibility(View.VISIBLE);
                }
                else {
                    password_registration_et.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                    password_registration_tv.setVisibility(View.INVISIBLE);
                }



               *//* if (repeat_password_registration.equals("")){
                    //Log.e("Lilit", "1");
                    repeat_password_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
                }
                else *//*if (!repeat_password_registration.equals(password_registration)) {
                    repeat_password_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
                    repeat_password_registration_et.setText(R.string.falseRepeatPassword);

                }else{
                    repeat_password_registration_et.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                    repeat_password_registration_et.setVisibility(View.INVISIBLE);
                }


                *//*if (nickname_registration.equals("")){
                    //Log.e("Lilit", "1");
                    nickname_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
                }
                else*//* if (!testPassword(nickname_registration)){
                    nickname_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
                    nickname_registration_tv.setVisibility(View.VISIBLE);
                }
                else {
                    nickname_registration_et.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                    nickname_registration_tv.setVisibility(View.INVISIBLE);
                }

                *//*if ( username_registration_et.getBackground().equals(getResources().getColor(R.color.colorBlue)) &&
                        password_registration_et.getBackground().equals(getResources().getColor(R.color.colorBlue)) &&
                        repeat_password_registration_et.getBackground().equals(getResources().getColor(R.color.colorBlue)) &&
                        nickname_registration_et.getBackground().equals(getResources().getColor(R.color.colorBlue))) {
                    //Log.e("Lilit", "1");
                    insertUserData( username_registration, MD5.md5Custom(password_registration), nickname_registration);
                }*/



        });

    }

 /*   public void ok(View view) {


        username_registration = username_registration_et.getText().toString();
        password_registration = password_registration_et.getText().toString();
        repeat_password_registration = repeat_password_registration_et.getText().toString();
        nickname_registration = nickname_registration_et.getText().toString();

        //insertUserData( username_registration, MD5.md5Custom(password_registration), nickname_registration);

        //ProgressDialog progressDialog = ProgressDialog.show(this, null, "Sending mail", true, false);;

        //insertUsername();
        //insertPassword();
        //insertNickname();
        if (username_registration.equals("")){
            Log.e("Lilit", "1");
            username_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
        }
        else if (!testEmail(username_registration)){
            username_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
            username_registration_tv.setVisibility(View.VISIBLE);
        }
        else {
            username_registration_et.setBackgroundColor(getResources().getColor(R.color.colorBlue));
            username_registration_tv.setVisibility(View.INVISIBLE);
        }


        if (password_registration.equals("")){
            Log.e("Lilit", "1");
            password_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
        }
        else if (!testPassword(password_registration)){
            password_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
            password_registration_tv.setVisibility(View.VISIBLE);
        }
        else {
            password_registration_et.setBackgroundColor(getResources().getColor(R.color.colorBlue));
            password_registration_tv.setVisibility(View.INVISIBLE);
        }



        if (repeat_password_registration.equals("")){
            Log.e("Lilit", "1");
            repeat_password_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
        }
        else if (!repeat_password_registration.equals(password_registration)) {
            repeat_password_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
            repeat_password_registration_et.setText(R.string.falseRepeatPassword);

        }else{
            repeat_password_registration_et.setBackgroundColor(getResources().getColor(R.color.colorBlue));
            repeat_password_registration_et.setVisibility(View.INVISIBLE);
        }


        if (nickname_registration.equals("")){
            Log.e("Lilit", "1");
            nickname_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
        }
        else if (!testPassword(nickname_registration)){
            nickname_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
            nickname_registration_tv.setVisibility(View.VISIBLE);
        }
        else {
            nickname_registration_et.setBackgroundColor(getResources().getColor(R.color.colorBlue));
            nickname_registration_tv.setVisibility(View.INVISIBLE);
        }

        if ( !(username_registration_et.getBackground().equals(getResources().getColor(R.color.colorAccent))) ||
                !(password_registration_et.getBackground().equals(getResources().getColor(R.color.colorAccent))) ||
                !(repeat_password_registration_et.getBackground().equals(getResources().getColor(R.color.colorAccent))) ||
                !(nickname_registration_et.getBackground().equals(getResources().getColor(R.color.colorAccent)))) {
            Log.e("Lilit", "1");
            //insertUserData( username_registration, MD5.md5Custom(password_registration), nickname_registration);
        }
    }*/

    public void cancel(View view) {
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
                    SendEmailInBackground sendEmailInBackground = new SendEmailInBackground(Registration_User.this, username, password, emailText_registrationUser);
                    sendEmailInBackground.sendMail();

                    Toast.makeText(Registration_User.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    //progressDialog.dismiss();
                }else{
                    Toast.makeText(Registration_User.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    //progressDialog.dismiss();
                }
            }
            @Override
            public void onFailure(Call<RegistrationLoginUpdateUserResponseModel> call, Throwable t) {
                Toast.makeText(Registration_User.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                //progressDialog.dismiss();
            }
        });
    }

   /* private void insertUsername(){
        if (username_registration == ""){
            username_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
            Toast.makeText(Registration_User.this,R.string.login_hintEditTextAndToast , Toast.LENGTH_SHORT).show();
        }
    }
    private void insertPassword(){
        if (password_registration == ""){
            password_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
            Toast.makeText(Registration_User.this,R.string.password_hintEditTextAndToast , Toast.LENGTH_SHORT).show();
        }
    }
    private void insertRepeatPassword(){
        if (repeat_password_registration == ""){
            repeat_password_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
            Toast.makeText(Registration_User.this,R.string.password_hintEditTextAndToast , Toast.LENGTH_SHORT).show();
        }
    }
    private void insertNickname(){
        if (nickname_registration == ""){
            nickname_registration_et.setBackgroundColor(getResources().getColor(R.color.colorRose));
            Toast.makeText(Registration_User.this,R.string.registrationUser_nikname_hint , Toast.LENGTH_SHORT).show();
        }
    }*/

    //onclick
    public void addProfilePicture(View view) {
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
        Pattern patt = Pattern.compile("([a-zA-Z0-9\\s-]){2,15}"); //([a-zA-Z0-9\s-]){2,15}")	//([/w]+){3,}      ([^,\s]+){3,} cankacac simvol(length>2) baci ','-ic probelic
        Matcher match = patt.matcher(nickname);
        boolean b = match.matches();
        return b;
    }



}
