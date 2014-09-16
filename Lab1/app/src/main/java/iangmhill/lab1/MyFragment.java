package iangmhill.lab1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyFragment extends android.app.Fragment {
    ChatAdapter chatAdapter;
    public MyFragment() {
    }

    private MessageItem testMI1 = new MessageItem("Ian Hill","This is a new text message","2");
    private MessageItem testMI2 = new MessageItem("Ian Hill","This is a new text message","2");
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getChats();
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.my_list_view);

        listView.setAdapter(chatAdapter);

        final EditText input = (EditText) rootView.findViewById(R.id.main_chat_input);
        input.clearFocus();

        Button sendButton = (Button) rootView.findViewById(R.id.main_chat_button);
        sendButton.setOnClickListener(OnClickListeners.sendButtonListener(getActivity(),chatAdapter));
        return rootView;
    }
    private void getChats(){
        //Use content provider in the future
        List<MessageItem> newChats = new ArrayList<MessageItem>();
        newChats.add(testMI1);
        newChats.add(testMI2);
        if (chatAdapter == null)
            chatAdapter = new ChatAdapter(getActivity(), new ArrayList<MessageItem>(), R.layout.chat_item);
        chatAdapter.addChats(newChats);
    }
}