package com.example.shriji.gitsquare;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.shriji.gitsquare.adapters.SquareContribsAdapter;
import com.example.shriji.gitsquare.models.SquareContribsModel;
import com.example.shriji.gitsquare.webservices.SquareContibsWebService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.DialogInterface.BUTTON_NEGATIVE;
import static android.content.DialogInterface.BUTTON_POSITIVE;

public class SquareContribs extends AppCompatActivity {

    private static final int ASC = 0;
    private static final int DESC = 1;
    int mSortOrder = ASC;

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    @BindView(R.id.rvSquareContribsList)
    RecyclerView mRvSquareContribsList;
    @BindView(R.id.rvRefresh)
    SwipeRefreshLayout mRvRefresh;


    private String TAG = "SquareContribs";
    private List<SquareContribsModel> mList;
    private SquareContibsWebService mSquareContibsWebService;
    private SquareContribsAdapter mSquareContribsAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_squarecontribs);
        ButterKnife.bind(this);

        //on swipe we call api and prepare list and set in adapter
        mRvRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getAllUserInList();
            }
        });

        //initialize webService
        mSquareContibsWebService = SquareContibsWebService.retrofit.create(SquareContibsWebService.class);

        //prepare list
        mList = new ArrayList<>();
        getAllUserInList();

        //initialize recycler view to show data in list with custom adapter
        mRvSquareContribsList.setLayoutManager(new LinearLayoutManager(this));
        mSquareContribsAdapter = new SquareContribsAdapter(this, mList);
        mRvSquareContribsList.setAdapter(mSquareContribsAdapter);

    }


    private void getAllUserInList() {
        //check internet connection available or not
        if (!isOnline()) {
            //if internet not on no need to refresh data
            mRvRefresh.setRefreshing(false);
            //if not available show alert dialog
            showNoInternet();
            return;
        }

        //show progressbar if online
        mProgressBar.setVisibility(View.VISIBLE);
        //network request call
        Call<List<SquareContribsModel>> call = mSquareContibsWebService.getUsers();
        call.enqueue(new Callback<List<SquareContribsModel>>() {
            @Override
            public void onResponse(Call<List<SquareContribsModel>> call, Response<List<SquareContribsModel>> response) {
                //before add clear list
                mList.clear();
                //add all data in list
                mList.addAll(response.body());
                //before set in adapter we sort data then after we notify adapter
                sortingData();
                //if data will update adapter also update
                mSquareContribsAdapter.notifyDataSetChanged();
                //hide progressbar after our list prepared
                mProgressBar.setVisibility(View.GONE);

                if (mRvRefresh.isRefreshing()) {
                    mRvRefresh.setRefreshing(false);
                }
                //check retrieved data
                for(int i = 0 ;i < mList.size(); i++) {
                    Log.d(TAG, "onResponse: " + mList.get(i).getLogin());
                }
            }

            @Override
            public void onFailure(Call<List<SquareContribsModel>> call, Throwable t) {
                Log.d(TAG, "=== onFail: " + t.getMessage());
                t.printStackTrace();
                showOnFailure();
            }
        });
    }

    //if some problem on retrieving data than this dialog show
    private void showOnFailure() {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("ERROR");
        alertDialog.setMessage("Enable To Connect");
        alertDialog.show();
    }

    //if user not online than show this alert dialog
    private void showNoInternet() {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("ERROR");
        alertDialog.setMessage("Internet not available...");
        alertDialog.setButton(BUTTON_POSITIVE, "ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.setButton(BUTTON_NEGATIVE, "Try Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                getAllUserInList();
            }
        });
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    //check device online or not
    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    //on button click we set data in ascending or descending order
    @OnClick(R.id.btnFilter)
    public void onViewClicked() {
        if (mSortOrder == ASC) {
            mSortOrder = DESC;
        } else {
            mSortOrder = ASC;
        }
        sortingData();
        mSquareContribsAdapter.notifyDataSetChanged();
    }

    //sorting data in ascending and descending order on same button click
    private void sortingData() {
        Collections.sort(mList, new Comparator<SquareContribsModel>() {
            @Override
            public int compare(SquareContribsModel o1, SquareContribsModel o2) {
                if (mSortOrder == ASC) {
                    return o1.getContributions().compareTo(o2.getContributions());
                } else {
                    return o2.getContributions().compareTo(o1.getContributions());
                }
            }
        });
    }
}
