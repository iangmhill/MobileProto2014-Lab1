package iangmhill.lab1;

/**
 * Created by ihill on 9/16/2014.
 */
public class MessageItem implements Comparable{
    public String sender, message, userId;
    public long time;

    public MessageItem(String sender, String message, String userId){
        this.sender = sender;
        this.message = message;
        this.userId = userId;
        this.time = System.currentTimeMillis();
    }

    public int compareTo(Object object) {
        return (time < ((MessageItem) object).time)?1:0;
    }
}
