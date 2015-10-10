package request;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by juanortizjr on 10/10/15.
 */
public class Request{
        public void Return() throws IOException {
            //http://192.168.11.190:8000/pacientes/1/{
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost("http://192.168.11.190:8000/pacientes/1/");

            List<NameValuePair> pairList = new ArrayList<>();
            pairList.add(new BasicNameValuePair("key", "test"));
            post.setEntity(new UrlEncodedFormEntity(pairList));

            HttpResponse response= client.execute(post);
        }
}
