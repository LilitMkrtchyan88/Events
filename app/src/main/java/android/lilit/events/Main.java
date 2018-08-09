/*
package android.lilit.events;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.Service;
import android.content.Intent;
import android.lilit.events.apiservices.ApiServiceUserLogin;
import android.lilit.events.clients.ApiClient;
import android.lilit.events.models.RegistrationLoginUpdateUserResponseModel;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.AdapterView.*;

public class    MainActivity extends AppCompatActivity {


    private EditText login_email_et, login_password_et;
    private ImageView login_password_iv;
    private ProgressDialog progressDialog;

    public void oc(){

    //@Override
   // protected void onCreate(Bundle savedInstanceState) {
    //    super.onCreate(savedInstanceState);
        //setContentView(R.layout.first_page_layout);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);  //for soft keyboard - not changeed window view/size

        */
/*      initialize *//*

        //login_email_et = (EditText) findViewById(R.id.login_email_et);
        //login_password_et = (EditText) findViewById(R.id.login_password_et);
        //login_password_iv = (ImageView) findViewById(R.id.login_password_iv);


       */
/**
         * Sets ListView height dynamically based on the height of the items.
         *
         * @param listView to be resized
         *
         *//*


        */
/*public static void setListViewHeightBasedOnChildren(ListView listView) {
            ListAdapter listAdapter = listView.getAdapter();
            if (listAdapter == null) {
                // pre-condition
                return;
            }

            int totalHeight = 0;
            float singleViewHeight = 0;
            for (int i = 0; i < listAdapter.getCount(); i++) {
                View listItem = listAdapter.getView(i, null, listView);
                listItem.measure(0, 0);
                totalHeight += listItem.getMeasuredHeight();
                singleViewHeight = listItem.getMeasuredHeight();
            }

            // Get total height of all item dividers.
            int totalDividersHeight = listView.getDividerHeight() *
                    (listAdapter.getCount() - 1);

            // Set list height
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = totalHeight + totalDividersHeight + (Math.round(singleViewHeight / 2));
            listView.setLayoutParams(params);
            listView.requestLayout();

        }*//*


*/
/*      touch in 'eye' button and hold a finger - the password show as text('eye_password_open' mipmap resource) and
        * after releasing the finger- again, change it as textPassword ('eye_password_close' mipmap resource) *//*

       */
/* login_password_iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
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
*//*


    }

    */
/*  onClick clear texts of username/email and password fields ('delete_email' mipmap resource) *//*

    public void clearEmailPasswordFilds_EditText(View view) {
        clearEmailAndPasswordFilds();
    }

    */
/*  this method used to clear texts of username/email and password fields ('delete_email' mipmap resource) *//*

    public void clearEmailAndPasswordFilds() {
        login_email_et.setText("");
        login_password_et.setText("");
    }

    //Registration_User-um e

*/
/*  this method used to send user registration data to server or our local server
    * @param username
    * @param password *//*


    */
/*public void insertUserData(String username, String password){
        ApiServiceUserRegistration apiService = ApiClient.getClient().create(ApiServiceUserRegistration.class);
        Call<RegistrationLoginUpdateUserResponseModel> call = apiService.registrationUserData(username, password);
        call.enqueue(new Callback<RegistrationLoginUpdateUserResponseModel>() {
            @Override
            public void onResponse(Call<RegistrationLoginUpdateUserResponseModel> call, Response<RegistrationLoginUpdateUserResponseModel> response) {

                RegistrationLoginUpdateUserResponseModel insertUserResponseModel = response.body();

                //check the status code
                if(insertUserResponseModel.getStatus()==1){
                    Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }else{
                    Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
            @Override
            public void onFailure(Call<RegistrationLoginUpdateUserResponseModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }*//*



   */
/* UpdateForgotPassword-um e
   * *//*
*/
/*  this method used to send user updatable data to server or our local server
        * @param username
        * @param password *//*
*/
/*
    public void changUserData(String username, String password){
        ApiServiceUserUpdateNewAutogeneratedPassword_ForgotPassword apiService = ApiClient.getClient().create(ApiServiceUserUpdateNewAutogeneratedPassword_ForgotPassword.class);
        Call<RegistrationLoginUpdateUserResponseModel> call = apiService.updateUserData(username, password);
        call.enqueue(new Callback<RegistrationLoginUpdateUserResponseModel>() {
            @Override
            public void onResponse(Call<RegistrationLoginUpdateUserResponseModel> call, Response<RegistrationLoginUpdateUserResponseModel> response) {

                RegistrationLoginUpdateUserResponseModel insertUserResponseModel = response.body();

                *//*
*/
/* check the status code *//*
*/
/*
                if(insertUserResponseModel.getStatus()==1){
                    Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }else{
                    Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
            @Override
            public void onFailure(Call<RegistrationLoginUpdateUserResponseModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }*//*


    */
/*  onClick generation new random password and it automaticaly sended to email of user *//*

    public void forgotAndGiveNewPassword(View view) {

        Intent i = new Intent(this, UpdateForgotPasswordPage.class);
        i.putExtra("forgotPasswordUsername", login_email_et.getText().toString());
        startActivity(i);
    }

    */
/*  onClick registration new user in DB and automaticaly sended message  to email of user *//*

    public void registrationNewUser(View view) {

        clearEmailAndPasswordFilds();
        Intent i = new Intent(getApplicationContext(), RegistrationUserPage.class);
        startActivity(i);
    }

*/
/*  onClick generation new random password and it automaticaly sended to email of user *//*

    */
/*public void registrationNewUser(View view) {
        clearEmailAndPasswordFilds();
        final boolean[] addUser = new boolean[1];

        //Intent i = new Intent(this, Registration_User.class);
        //startActivity(i);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        view = inflater.inflate(R.layout.layout_registration_user, null);
        builder.setView(view);

        final EditText username_etPD = (EditText)findViewById(R.id.username_etPD);
        final EditText password_etPD = (EditText)findViewById(R.id.password_etPD);

        final String username = username_etPD.getText().toString();
        final String password = password_etPD.getText().toString();

        builder.setPositiveButton(R.string.userRegistrationPD_positiveButton, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (TextUtils.isEmpty(username)) {
                    username_etPD.setBackgroundColor(getResources().getColor(R.color.colorRose));
                    Toast.makeText(MainActivity.this, R.string.login_hintEditTextAndToast, Toast.LENGTH_SHORT).show();
                    addUser[0] = true;
                } else if (TextUtils.isEmpty(password)) {
                    password_etPD.setBackgroundColor(getResources().getColor(R.color.colorRose));
                    Toast.makeText(MainActivity.this, R.string.password_hintEditTextAndToast, Toast.LENGTH_SHORT).show();
                    addUser[0] = true;

                } else {
                    username_etPD.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                    password_etPD.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                    insertUserData(username, MD5.md5Custom(password));
                    addUser[0] = false;
                    //dialogInterface.dismiss();

                    progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setTitle(R.string.userRegistrationPD_message);
                    progressDialog.setMessage("Խնդրում ենք սպասել․․․");  //?????????????string-eric chi ashkhatum vor kanchum enq
                    progressDialog.show();
                }
                //dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int id) {
                        addUser[0] = false;
                        dialog.cancel();
                    }
                });
        final AlertDialog alertClient = builder.create();
        alertClient.show();

        alertClient
                .setOnDismissListener(new DialogInterface.OnDismissListener() {

                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        //If the error flag was set to true then show the dialog again
                        if (addUser[0] == true) {
                            alertClient.show();
                        } else {
                            return;
                        }

                    }
                });

      *//*
*/
/*  builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialog) {
                if (isEmptyEditText == true) {
                    insertUserData(username, MD5.md5Custom(password));//.show();
                } else {
                    return;
                }

            }
        });*//*
*/
/*

       // builder.show();


    }*//*


        //mutq andznakan edj
*/
/*    public void signInAccount(View view) {

        String login = login_email_et.getText().toString();
        String pass = login_password_et.getText().toString();

        ApiServiceUserLogin apiServiceLogin = ApiClient.getClient().create(ApiServiceUserLogin.class);
        Call<RegistrationLoginUpdateUserResponseModel> call =  apiServiceLogin.loginUserData(login,MD5.md5Custom(pass));
        call.enqueue(new Callback<RegistrationLoginUpdateUserResponseModel>() {
            @Override
            public void onResponse(Call<RegistrationLoginUpdateUserResponseModel> call, Response<RegistrationLoginUpdateUserResponseModel> response) {
                RegistrationLoginUpdateUserResponseModel r = response.body();

                if(r.getStatus()== 1){
                    // clearEmailAndPasswordFilds();
                    //Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "uraaaaaaaaaaaaaaa", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(MainActivity.this, "lav eli", Toast.LENGTH_SHORT).show();

                }
                    *//*
*/
/*if(response.body().status == 1){
                        status.setText("NIKOL" *//*
*/
/**//*
*/
/**//*
*/
/**//*
*/
/**//*
*/
/**//*
*/
/**//*
*/
/**//*
*/
/*+ r.content.token*//*
*/
/**//*
*/
/**//*
*/
/**//*
*/
/**//*
*/
/**//*
*/
/**//*
*/
/**//*
*/
/*);
                    }else{
                        status.setText(r.message+"nhghvhvkbhbm");
                    }*//*
*/
/*
            }

            @Override
            public void onFailure(Call<RegistrationLoginUpdateUserResponseModel> call, Throwable t) {
                Log.e("Nikol" , "Nikol");
                //status.setText("something went wrong");
            }
        });
    }*//*


       */
/*  public void lookAtAndClosePasswordFild_EditText(View view) {   //chi ashxatum es dzevov

        //if(password_iv.getResources().equals(R.mipmap.eye_password_open)){
        if (password_et.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
            password_iv.setImageResource(R.mipmap.eye_password_close);
            password_et.setTransformationMethod(PasswordTransformationMethod.getInstance());
            //password_et.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        } else {
            password_iv.setImageResource(R.mipmap.eye_password_open);
            //password_et.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            password_et.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);

            //password_et.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            //password_et.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }
    *//*


}
*/

