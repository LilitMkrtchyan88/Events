package android.lilit.events.apiservices;

/**
 * Created by Lilit Mkrtchyan on 5/23/2018.
 */

import android.lilit.events.models.RegistrationLoginUpdateUserResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServiceUserLogin {

    @FormUrlEncoded
    @POST("users/login") //@POST("user/LoginUser.php")
    Call<RegistrationLoginUpdateUserResponseModel> loginUserData(@Field("username") String Username, @Field("password") String Password);
    //Call<RegistrationLoginUpdateUserResponseModel> loginUserData(@Field("Username") String Username, @Field("Password") String Password);

}
