package android.lilit.events.apiservices;

import android.lilit.events.models.RegistrationLoginUpdateUserResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServiceCheckUsernameAvailability {

    @FormUrlEncoded
    @POST("users/forgotPassword")
    Call<RegistrationLoginUpdateUserResponseModel> checkUserData(@Field("username") String Username);
}
