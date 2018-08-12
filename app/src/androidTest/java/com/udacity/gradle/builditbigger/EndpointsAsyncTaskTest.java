package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/* Test Reference: https://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework/3802487#3802487 */
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    Context context;
    private MainActivityFragment mainActivityFragment;

    @Test
    public void testEndpointAsyncTask() throws InterruptedException {
        assertTrue(true);
        final CountDownLatch latch = new CountDownLatch(1);
        mainActivityFragment = new MainActivityFragment();
        EndpointsAsyncTask testTask = new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                if (!result.equals("")) {
                    assertTrue(result.length() > 0);
                    latch.countDown();


                }
            }
        };
        testTask.execute(mainActivityFragment);
        latch.await();

    }
}
