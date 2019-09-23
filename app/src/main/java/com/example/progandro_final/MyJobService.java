package com.example.progandro_final;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MyJobService extends JobService {
    private static final String TAG = "MyJobService";
    private boolean jobCancelled = false;
    @Override
    public boolean onStartJob(JobParameters jobParameters){
        //write your code here
        Log.d(TAG,"Job Started");
        doBackgroundWork(jobParameters);
        return true;
    }

    private void doBackgroundWork(final JobParameters params){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    Handler handler = new Handler(getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),"Ini Toast",Toast.LENGTH_SHORT).show();
                        }
                    });
                    Log.d(TAG, "run: " +i);
                    if (jobCancelled){
                        return;
                    }
                    try {
                        Thread.sleep(3000);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                Log.d(TAG,"Job Finished");
                jobFinished(params,false);
            }
        }).start();
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters){
        Log.d(TAG,"Job cancelled before completion");
        jobCancelled = true;
        return true;
    }
}
