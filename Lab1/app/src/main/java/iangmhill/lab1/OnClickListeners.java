package iangmhill.lab1;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ihill on 9/16/2014.
 */
public class OnClickListeners {
    public static View.OnClickListener sendButtonListener(final Activity activity, final ChatAdapter adapter){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = ((EditText) activity.findViewById(R.id.main_chat_input));
                if (input.getText().toString().equals("")){
                    Toast.makeText(activity, "You didn't type anything in!", Toast.LENGTH_SHORT).show();
                    return;
                }
                adapter.addChat(new MessageItem("Ian Hill", input.getText().toString(), "2"));
                input.setText("");
            };
        };
    }
}
