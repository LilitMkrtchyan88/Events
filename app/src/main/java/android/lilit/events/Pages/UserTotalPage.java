package android.lilit.events.Pages;

import android.content.Intent;
import android.lilit.events.R;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class UserTotalPage extends AppCompatActivity{

    private float clickTextSize = 25f;
    private float nonClickTextSize = 18f;
    private TextView exitTotalPage_tv, mainTotalPage_tv, aboutUsTotalPage_tv, help_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_total_layout);

        exitTotalPage_tv = (TextView)findViewById(R.id.exitTotalPage_tv);
        mainTotalPage_tv = (TextView)findViewById(R.id.mainTotalPage_tv);
        aboutUsTotalPage_tv = (TextView)findViewById(R.id.aboutUsTotalPage_tv);
        help_tv = (TextView)findViewById(R.id.help_tv);

    }


    public void openFirstPage(View view) {
        mainTotalPage_tv.setTextColor(getResources().getColor(R.color.colorAccent));
        click();
    }

    public void openMyPage(View view) {
    }

    public void createNewEvent(View view) {
    }

    public void openCalendar(View view) {
    }

    public void openNotifications(View view) {
    }

    public void openMessages(View view) {
    }

    public void openContacts(View view) {
    }

    public void openEvents(View view) {
    }

    public void openSettings(View view) {
    }

    public void openSuggestsApp(View view) {


    }

    public void openAboutUs(View view) {
        aboutUsTotalPage_tv.setTextColor(getResources().getColor(R.color.colorAccent));
        aboutUsTotalPage_tv.setTextSize(clickTextSize);
        Intent ourSite = new Intent(Intent.ACTION_VIEW, Uri.parse("http://arssystems.am/"));
        startActivity(ourSite);
    }

    public void openHelp(View view) {
        help_tv.setTextColor(getResources().getColor(R.color.colorAccent));
        help_tv.setTextSize(clickTextSize);
        Intent help = new Intent(this, HelpPage.class);
        startActivity(help);

    }

    public void exitTotalPage(View view) {
        exitTotalPage_tv.setTextColor(getResources().getColor(R.color.colorAccent));
        click();
    }

    @Override
    protected void onStop() {
        super.onStop();
        aboutUsTotalPage_tv.setTextSize(nonClickTextSize);
        aboutUsTotalPage_tv.setTextColor(getResources().getColor(R.color.colorBlack));

    }

    private void click(){
        exitTotalPage_tv.setTextSize(clickTextSize);
        this.finish();
    }
}
