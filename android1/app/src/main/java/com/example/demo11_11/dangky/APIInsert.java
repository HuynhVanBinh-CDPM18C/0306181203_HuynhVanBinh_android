package com.example.demo11_11.dangky;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class APIInsert extends AsyncTask<TuVung, String, String> {
    private Context m_con;
    public APIInsert(Context con)
    {
        m_con = con;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(m_con, "Start", Toast.LENGTH_SHORT).show();
    }
    // nao a???
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(m_con, "Finish"+s, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected String doInBackground(TuVung... tuVungs) {
        return APIDict.insertWord(tuVungs[0]);

    }
}
