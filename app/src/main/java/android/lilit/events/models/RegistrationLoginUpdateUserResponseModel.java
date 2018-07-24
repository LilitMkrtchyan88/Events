package android.lilit.events.models;

/**
 * Created by Lilit Mkrtchyan on 5/23/2018.
 */


import com.google.gson.annotations.SerializedName;

public class RegistrationLoginUpdateUserResponseModel {

    @SerializedName("success")
    public int status;
    @SerializedName("message")
    private String message;

    public RegistrationLoginUpdateUserResponseModel(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public RegistrationLoginUpdateUserResponseModel() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
