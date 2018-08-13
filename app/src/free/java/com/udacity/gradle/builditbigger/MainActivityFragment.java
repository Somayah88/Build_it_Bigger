package com.udacity.gradle.builditbigger;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivityFragment extends Fragment {
    @BindView(R.id.progress_indicator)
    ProgressBar progressIndicator;
    @BindView(R.id.get_joke_btn)
    Button getJokeButton;
    @BindView(R.id.adView)
    AdView mAdView;
    private PublisherInterstitialAd mPublisherInterstitialAd=null;


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_activity, container, false);
        ButterKnife.bind(this,root);
         getJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPublisherInterstitialAd.isLoaded() && mPublisherInterstitialAd!=null) {
                    mPublisherInterstitialAd.show();
                }
                else {
                  tellJoke();
                }

            }
        });
        mPublisherInterstitialAd = new PublisherInterstitialAd(getActivity());
        mPublisherInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mPublisherInterstitialAd.setAdListener(new AdListener() {

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                createNewAd();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                progressIndicator.setVisibility(View.VISIBLE);
                tellJoke();
                createNewAd();
            }
        });

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        progressIndicator.setVisibility(View.GONE);
        createNewAd();
        return root;
    }

    private void tellJoke() {
        new EndpointsAsyncTask().execute(this);
    }

    private void createNewAd(){
        PublisherAdRequest publisherAdRequest=new PublisherAdRequest.Builder().addTestDevice(PublisherAdRequest.DEVICE_ID_EMULATOR).build();
        mPublisherInterstitialAd.loadAd(publisherAdRequest);
    }
}
