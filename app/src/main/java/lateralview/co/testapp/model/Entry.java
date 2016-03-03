package lateralview.co.testapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Joaquin on 1/3/16.
 */
public class Entry {
    /*{
        "userId": 1,
            "id": 1,
            "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
            "body": "quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas totam nostrum rerum est autem sunt rem eveniet architecto"
    }*/

    @SerializedName("userId")
    private Integer mId;
    @SerializedName("id")
    private Integer mUserId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("body")
    private String mBody;

    public int getmId() {
        return mId;
    }

    public int getmUserId() {
        return mUserId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmBody() {
        return mBody;
    }

}
