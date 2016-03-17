package lateralview.co.testapp;


/**
 * Created by Joaquin on 3/7/15.
 */
import android.content.Context;

import com.android.volley.Request;

import net.lateralview.simplerestclienthandler.RestClientManager;
import net.lateralview.simplerestclienthandler.base.RequestCallbacks;
import net.lateralview.simplerestclienthandler.base.RequestHandler;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;
import java.util.concurrent.CountDownLatch;
import lateralview.co.testapp.application.TestApplication;
import lateralview.co.testapp.model.Entry;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static org.junit.Assert.assertEquals;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 *
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(application = TestApplication.class,constants = BuildConfig.class,sdk = 21)
public class OptionAActivityTest {
    @Mock
    Context mMockContext;

    final CountDownLatch signal = new CountDownLatch(1);

    MockWebServer mockWebServer;
    HttpUrl mockBaseUrl;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        //Enable logging
        ShadowLog.stream = System.out;
        // Create a MockWebServer. These are lean enough that you can create a new instance for every unit test.
        mockWebServer= new MockWebServer();
        // Start the server.
        mockWebServer.start();
        // Ask the server for its URL.
        mockBaseUrl = mockWebServer.url("/v1/entry/");
    }

    @After
    public void shutDownServer() throws Exception{
        // Shut down the server. Instances cannot be reused.
        mockWebServer.shutdown();
    }

    @Test
    public void validApiDataForEntry() throws Exception{

        JSONObject o = new JSONObject("{\n" +
                "        \"userId\": 1,\n" +
                "            \"id\": 1,\n" +
                "            \"title\": \"Test\",\n" +
                "            \"body\": \"Body Test\"\n" +
                "    }");

        // Schedule some responses.
        mockWebServer.enqueue(new MockResponse()
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .setBody(o.toString()));

        final Entry[] entries = new Entry[1];

        RestClientManager.getInstance().makeJsonRequest(
                Request.Method.GET,
                mockBaseUrl.toString(),//"http://jsonplaceholder.typicode.com/posts/1",
                new RequestHandler<>(new RequestCallbacks<Entry, Object>() {
                    @Override
                    public void onRequestSuccess(Entry response) {
                        //Save the response in an object we can evaluate later
                        entries[0] = response;
                        //Allow the thread to continue
                        signal.countDown();
                    }

                    @Override
                    public void onRequestError(Object error) {
                        Object e = error;
                        signal.countDown();
                    }

                }), null, null);

        // wait for callback
        signal.await();
        //Compare results.
        assertEquals("Test", entries[0].getmTitle());
    }

}