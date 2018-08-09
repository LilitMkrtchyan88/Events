package android.lilit.events.Pages;

import android.app.ActionBar;
import android.content.Intent;
import android.lilit.events.MD5;
import android.lilit.events.MainActivity;
import android.lilit.events.R;
import android.lilit.events.apiservices.ApiServiceUserLogin;
import android.lilit.events.clients.ApiClient;
import android.lilit.events.models.RegistrationLoginUpdateUserResponseModel;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPage extends AppCompatActivity {

    private EditText login_username_et, login_password_et;
    private ImageView login_password_iv;
    private String login_username, login_password;
    private LinearLayout username_ll, password_ll;
    private TextView falseUsername_tv, falsePassword_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        login_username_et = (EditText) findViewById(R.id.login_username_et);
        login_password_et = (EditText) findViewById(R.id.login_password_et);
        login_password_iv = (ImageView) findViewById(R.id.login_password_iv);
        username_ll = (LinearLayout)findViewById(R.id.username_ll);
        password_ll = (LinearLayout)findViewById(R.id.password_ll);
        falseUsername_tv = (TextView)findViewById(R.id.falseUsername_tv);
        falsePassword_tv = (TextView)findViewById(R.id.falsePassword_tv);

        /*      touch in 'eye' button and hold a finger - the password show as text('eye_password_open' mipmap resource) and
         after releasing the finger- again, change it as textPassword ('eye_password_close' mipmap resource) */
        login_password_iv.setOnTouchListener(new View.OnTouchListener(){
        @Override
            public boolean onTouch (View view, MotionEvent motionEvent){
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    login_password_et.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    login_password_iv.setImageResource(R.mipmap.eye_password_open);
                    return true;
                case MotionEvent.ACTION_UP:
                    login_password_et.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    login_password_iv.setImageResource(R.mipmap.eye_password_close);
                    return true;
              }
            return false;
             }
        });
    }

    /*  onClick clear texts of username/email and password fields ('delete_email' mipmap resource) */
    public void clearUsernamePasswordFilds(View view) {
        clearEmailAndPasswordFilds();
    }

    /*onClick*/
    public void signInAccount(View view) {

        login_username = login_username_et.getText().toString();
        login_password = login_password_et.getText().toString();

        if (!testEmail(login_username)){
            changeViewTrueOrFalseUsernameOrPassword(username_ll, falseUsername_tv, getResources().getColor(R.color.colorRose), View.VISIBLE);
            changeViewTrueOrFalseUsernameOrPassword(password_ll, falsePassword_tv, getResources().getColor(R.color.colorRose), View.VISIBLE);
        } else {
            changeViewTrueOrFalseUsernameOrPassword(username_ll, falseUsername_tv, getResources().getColor(R.color.colorBlue), View.INVISIBLE);
            if(!testPassword(login_password)){
                changeViewTrueOrFalseUsernameOrPassword(password_ll, falsePassword_tv, getResources().getColor(R.color.colorRose), View.VISIBLE);
            }else {
                changeViewTrueOrFalseUsernameOrPassword(password_ll, falsePassword_tv, getResources().getColor(R.color.colorBlue), View.INVISIBLE);
            }
        }
        if (testEmail(login_username) && testPassword(login_password)){
            ApiServiceUserLogin apiServiceLogin = ApiClient.getClient().create(ApiServiceUserLogin.class);
            Call<RegistrationLoginUpdateUserResponseModel> call =  apiServiceLogin.loginUserData(login_username, MD5.md5Custom(login_password));
            call.enqueue(new Callback<RegistrationLoginUpdateUserResponseModel>() {
                @Override
                public void onResponse(Call<RegistrationLoginUpdateUserResponseModel> call, Response<RegistrationLoginUpdateUserResponseModel> response) {
                    RegistrationLoginUpdateUserResponseModel r = response.body();

                    if (r.getStatus()== 1){
                        // clearEmailAndPasswordFilds();
                        //Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(LoginPage.this, "uraaaaaaaaaaaaaaa", Toast.LENGTH_SHORT).show();

                        Intent firstPageIntent = new Intent(LoginPage.this, MainActivity.class);
                        startActivity(firstPageIntent);
                    } else {
                        Toast.makeText(LoginPage.this, "lav eli", Toast.LENGTH_SHORT).show();
                    }
                    /*if(response.body().status == 1){
                        status.setText("NIKOL" *//**//**//**//*+ r.content.token*//**//**//**//*);
                    }else{
                        status.setText(r.message+"nhghvhvkbhbm");
                    }*/
                }

                @Override
                public void onFailure(Call<RegistrationLoginUpdateUserResponseModel> call, Throwable t) {
                    Log.e("Nikol" , "Nikol");
                    //status.setText("something went wrong");
                }
             });
            /*Intent firstPageIntent = new Intent(this, MainActivity.class);
            startActivity(firstPageIntent);*/
        }

    }
//jcvb,xjcv,xc0000
    //onClick
    public void closeLoginPage(View view) {
        this.finish();
    }

     /*  onClick generation new random password and it automaticaly sended to email of user */
    public void forgotAndGiveNewPassword(View view) {
        Intent i = new Intent(this, UpdateForgotPasswordPage.class);
        i.putExtra("forgotPasswordUsername", login_username_et.getText().toString());
        startActivity(i);
        //clearEmailAndPasswordFilds();
    }

    /*  onClick generation new random password and it automaticaly sended to email of user */
    public void registrationNewUser(View view) {
        clearEmailAndPasswordFilds();
        Intent i = new Intent(getApplicationContext(), RegistrationUserPage.class);
        startActivity(i);
    }

    /*  this method used to clear texts of username/email and password fields ('delete_email' mipmap resource) */
    public void clearEmailAndPasswordFilds() {
        login_username_et.setText("");
        login_password_et.setText("");
        changeViewTrueOrFalseUsernameOrPassword(username_ll, falseUsername_tv, getResources().getColor(R.color.colorBlue), View.INVISIBLE);
        changeViewTrueOrFalseUsernameOrPassword(password_ll, falsePassword_tv, getResources().getColor(R.color.colorBlue), View.INVISIBLE);
    }

    /*change views with inserting true or false username's or password's*/
    public void changeViewTrueOrFalseUsernameOrPassword(LinearLayout ll, TextView tv, int color, int visibility){
        ll.setBackgroundColor(color);
        tv.setVisibility(visibility);
    }

    /*design pattern username's'*/
    public boolean testEmail(String email){
        Pattern patt = Pattern.compile("[^,\\s]+@[^,\\s]+[.][^,\\s]+\\s*"); 		//cankacac simvolner baci storaketic, probelic u mechy petq e anpayman lini '@' u heto '.' nshannery hertakanutyamb u email-i verchum karox e linel kam chlinel probel/ner....."^[^,]\\S[^,]{0,}\\@(gmail.com|yahoo.com|mail.ru|yandex.ru|rambler.ru)"	//mail-i anuni simvolnery chen karox linel probel ev ',' ev qanaky chi karox poqr linel 2-ic u verchanum e hmpt verdjavorutyunnerov
        Matcher match = patt.matcher(email);
        boolean b = match.matches();
        return b;
    }

    /*design pattern password's'*/
    public boolean testPassword(String password){
        Pattern patt = Pattern.compile("([\\S\\s]){6,15}");	  //    \\S*[A-Z]\\S*[A-Z]\\S*[0-9]\\S*[0-9]\\S*[0-9]\\S*  //gitem sxal a ashkhatum:) grac artahaytutyan mech erkrord mecataric heto petq e gone ereq hat tiv lini grac
        Matcher match = patt.matcher(password);
        boolean b = match.matches();
        return b;
    }


}
