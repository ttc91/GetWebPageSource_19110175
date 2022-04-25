package com.android.s19110175;

import android.content.Context;
import android.net.Uri;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {

    private static final String HTTP = "http";
    private static final String HTTPS = "https";

    public static String getSourceCode(Context context, String queryString, String transferProtocol){

        HttpURLConnection httpURLConnection = null;
        BufferedReader bufferedReader = null;
        String htmlSourceCode = null;
        String[] protocol = context.getResources().getStringArray(R.array.http_array);

        try{

            Uri uri;
            if (transferProtocol.equals(protocol[0])){
                uri = Uri.parse(queryString).buildUpon().scheme(HTTP).build();
            }
            else{
                uri = Uri.parse(queryString).buildUpon().scheme(HTTPS).build();
            }

            URL request = new URL(uri.toString());

            httpURLConnection = (HttpURLConnection) request.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            InputStream inputStream = httpURLConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while((line = bufferedReader.readLine())!= null){
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }

            if (stringBuilder.length() == 0){
                return null;
            }

            htmlSourceCode = stringBuilder.toString();

            return htmlSourceCode;

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
