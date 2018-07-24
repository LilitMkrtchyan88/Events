package android.lilit.events.apiservices;

/**
 * Created by Lilit Mkrtchyan on 5/23/2018.
 */

import android.lilit.events.models.RegistrationLoginUpdateUserResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServiceUserRegistration {

    @FormUrlEncoded
    @POST("user/RegisterUser.php")      //@POST("users/register")
    Call<RegistrationLoginUpdateUserResponseModel> registrationUserData(@Field("username") String Username, @Field("password") String Password, @Field("nickname") String Nickname);

}