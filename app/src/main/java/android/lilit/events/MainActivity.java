package android.lilit.events;

import android.app.ProgressDialog;
import android.content.Intent;
import android.lilit.events.Pages.CalendarPage;
import android.lilit.events.Pages.ContactsPage;
import android.lilit.events.Pages.EventsPages.EventPage;
import android.lilit.events.Pages.EventsPages.EventsListPage;
import android.lilit.events.Pages.LoginPage;
import android.lilit.events.Pages.MessagesPage;
import android.lilit.events.Pages.EventsPages.MyEventsPage;
import android.lilit.events.Pages.MyPage;
import android.lilit.events.Pages.EventsPages.NewEventPage;
import android.lilit.events.Pages.NotificationsPage;
import android.lilit.events.Pages.UserTotalPage;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean login_status = false;
    private EditText login_email_et, login_password_et;
    private ImageView login_password_iv;
    private ProgressDialog progressDialog;

    private EditText searchEvent_et;
    private LinearLayout notification_ll, message_ll, event_image_ll;
    private TextView notification_count_tv, message_count_tv;
    private ImageView onePoint_iv, twoPoint_iv, threePoint_iv, fourPoint_iv, fivePoint_iv, sixPoint_iv, sevenPoint_iv, eightPoint_iv;
    private ListView myThemeEvents_lv;
    private String searchEvent, notification_count, message_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);

        /*     for not changed window/view size - The problem is related to the soft keyboard     */
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

        /*     initialize     */
        searchEvent_et = (EditText) findViewById(R.id.searchEvent_et);
        notification_ll = (LinearLayout) findViewById(R.id.notification_ll);
        message_ll = (LinearLayout) findViewById(R.id.message_ll);
        event_image_ll = (LinearLayout) findViewById(R.id.event_image_ll);
        notification_count_tv = (TextView) findViewById(R.id.notification_count_tv);
        message_count_tv = (TextView) findViewById(R.id.message_count_tv);

        onePoint_iv = (ImageView) findViewById(R.id.onePoint_iv);
        twoPoint_iv = (ImageView) findViewById(R.id.twoPoint_iv);
        threePoint_iv = (ImageView) findViewById(R.id.threePoint_iv);
        fourPoint_iv = (ImageView) findViewById(R.id.fourPoint_iv);
        fivePoint_iv = (ImageView) findViewById(R.id.fivePoint_iv);
        sixPoint_iv = (ImageView) findViewById(R.id.sixPoint_iv);
        sevenPoint_iv = (ImageView) findViewById(R.id.sevenPoint_iv);
        eightPoint_iv = (ImageView) findViewById(R.id.eightPoint_iv);
        myThemeEvents_lv = (ListView) findViewById(R.id.myThemeEvents_lv);


        /*if (isInternetAvailable()){}
        else{
            Toast.makeText(this, "Internet կապի բացակայություն", Toast.LENGTH_SHORT).show();
        }*/

        if (login_status){

            //username-n ukharkel server
            final String[] myEvents_data = {"event 1", "event 2", "event 3", "event 4", "event 5", "event 6", "event 7", "event 8"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myEvents_data);
            myThemeEvents_lv.setAdapter(adapter);

            //if ete chkardacac notification unem
            notification_ll.setBackground(getResources().getDrawable(R.drawable.bell_circle));
            notification_count_tv.setText(notification_count);
            //if ete chkardacac message unem
            message_ll.setBackground(getResources().getDrawable(R.drawable.message_circle));
            message_count_tv.setText(message_count);

        } else {
            //null username-n ukharkel server
            final String[] myEvents_data = {"event 1", "event 2", "event 3", "event 4", "event 5", "event 6", "event 7", "event 8"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myEvents_data);
            myThemeEvents_lv.setAdapter(adapter);
        }

    }

        public void openUserTotalPage(View view) {
            if (login_status){
                Intent totalPage = new Intent(this, UserTotalPage.class);
                startActivity(totalPage);
            } else {
                Intent loginPage = new Intent(this, LoginPage.class);
                startActivity(loginPage);
            }
        }

        public void searchInAllEvents(View view) {
            searchEvent = searchEvent_et.getText().toString();
            Intent searchEventIntent = new Intent(this, EventsListPage.class);
            startActivity(searchEventIntent);
        }

        public void seeNotifications(View view) {
            if (login_status){
                Intent notificationsPage = new Intent(this, NotificationsPage.class);
                startActivity(notificationsPage);
            } else {
                Toast.makeText(this, "Դուք մուտք չեք գործել Ձեր անձնական էջ", Toast.LENGTH_SHORT).show();
            }
        }

        public void seeMessages(View view) {
            if (login_status){
                Intent messagesPage = new Intent(this, MessagesPage.class);
                startActivity(messagesPage);
            } else {
                Toast.makeText(this, "Դուք Ձեր անձնական էջում չեք", Toast.LENGTH_SHORT).show();
            }
        }

        public void seeEventInAll(View view) {
            Intent seeEventIntent = new Intent(this, EventPage.class);
            startActivity(seeEventIntent);
        }

        public void seeMyPage(View view) {
            if (login_status){
                Intent myPageIntent = new Intent(this, MyPage.class);
                startActivity(myPageIntent);
            } else {
                openLoginPage();
            }
        }

        public void createNewEvent(View view) {
            if (login_status){
                Intent newEventIntent = new Intent(this, NewEventPage.class);
                startActivity(newEventIntent);
            } else {
                openLoginPage();
            }
        }

        public void seeCalendar(View view) {
            if (login_status){
                Intent calendarIntent = new Intent(this, CalendarPage.class);
                startActivity(calendarIntent);
            } else {
                openLoginPage();
            }
        }

        public void seeContacts(View view) {
            if (login_status){
                Intent contactsIntent = new Intent(this, ContactsPage.class);
                startActivity(contactsIntent);
            } else {
                openLoginPage();
            }
        }

        public void seeMyEvents(View view) {
            if (login_status){
                Intent myEventsIntent = new Intent(this, MyEventsPage.class);
                startActivity(myEventsIntent);
            } else {
                openLoginPage();
            }
        }

        public void openLoginPage(){
            Intent loginPage = new Intent(this, LoginPage.class);
            startActivity(loginPage);
        }

   /* public boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            //ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            //You can replace it with your name
            return !ipAddr.equals("");

        } catch (Exception e) {
            return false;
        }
    }*/

}
