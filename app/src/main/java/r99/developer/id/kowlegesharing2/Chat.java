package r99.developer.id.kowlegesharing2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.HashMap;
import java.util.Map;


public class Chat extends AppCompatActivity {
    TextView nama,isi,isi2;
    LinearLayout layout;
    RelativeLayout layout_2;
    ImageView sendButton;
    EditText messageArea;
    ScrollView scrollView;
    Firebase reference1, reference2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        layout = (LinearLayout) findViewById(R.id.layout1);
        layout_2 = (RelativeLayout)findViewById(R.id.layout2);
        sendButton = (ImageView)findViewById(R.id.sendButton);
        messageArea = (EditText)findViewById(R.id.messageArea);
        scrollView = (ScrollView)findViewById(R.id.scrollView);

        Firebase.setAndroidContext(this);
        reference1 = new Firebase("https://knowlegesharing-1819d.firebaseio.com/message/" + UserDetails.username + "_" + UserDetails.chatWith);
        reference2 = new Firebase("https://knowlegesharing-1819d.firebaseio.com/message/" + UserDetails.chatWith + "_" + UserDetails.username);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                String messageText = messageArea.getText().toString();

                if(!messageText.equals("")){
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("message", messageText);
                    map.put("user", UserDetails.username);
                    reference1.push().setValue(map);
                    reference2.push().setValue(map);
                    messageArea.setText("");
                }
            }
        });

        reference1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Map map = dataSnapshot.getValue(Map.class);
                String message = map.get("message").toString();
                String userName = map.get("user").toString();

                if(userName.equals(UserDetails.username)){
                    addMessageBox(  message, 1,"You :");
                }
                else{
                    addMessageBox(  message, 2,UserDetails.chatWith + " :");
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    public void addMessageBox(String message, int type, String namas){
        View chat = getLayoutInflater().inflate(R.layout.chat, null);

        nama = chat.findViewById(R.id.name);
        isi  = chat.findViewById(R.id.isi);
        isi2  = chat.findViewById(R.id.isi2);

        TextView textView = new TextView(Chat.this);
        nama.setText(namas);
        isi.setText(message);
        isi2.setText(message);

        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp2.weight = 1.0f;

        if(type == 1) {
            lp2.gravity = Gravity.RIGHT;
               isi.setVisibility(View.GONE);

        }
        else{
            lp2.gravity = Gravity.LEFT;
            isi2.setVisibility(View.GONE);
        }
        chat.setLayoutParams(lp2);
        layout.addView(chat);
        scrollView.fullScroll(View.FOCUS_DOWN);
    }
}