package xyz.alfonso.paypalcalc.utils;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by alfonsomora on 05/06/17.
 */

public class CustomRequestArray extends Request<JSONArray> {

    private Response.Listener<JSONArray> listener;
    private Map<String, String> params;
    private Priority mPriority;

    public CustomRequestArray(String url, Map<String, String> params,
                              Response.Listener<JSONArray> reponseListener, Response.ErrorListener errorListener) {
        super(Method.POST, url, errorListener);
        this.listener = reponseListener;
        this.params = params;
    }

    public CustomRequestArray(int method, String url, Map<String, String> params,
                              Response.Listener<JSONArray> reponseListener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.listener = reponseListener;
        this.params = params;
    }


    protected Map<String, String> getParams()
            throws com.android.volley.AuthFailureError {
        return params;
    };

    @Override
    protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(new JSONArray(jsonString),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException je) {
            return Response.error(new ParseError(je));
        }
    }

    @Override
    protected void deliverResponse(JSONArray response) {

        listener.onResponse(response);
    }


    public void setPriority(Priority priority) {
        mPriority = priority;
    }

    @Override
    public Priority getPriority() {
        // Priority is set to NORMAL by default
        return mPriority != null ? mPriority : Priority.NORMAL;
    }

}
