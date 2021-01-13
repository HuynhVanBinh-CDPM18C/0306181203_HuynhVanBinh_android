package com.example.demo11_11.thongtincaNhan;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class apishow extends AsyncTask<String, String, String> {
    private Context m_con;
    public apishow(Context con)
    {
        m_con = con;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(m_con, "Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(m_con, "Finish"+s, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected String doInBackground(String... level) {
        return apithongtin.getWord();

    }
}