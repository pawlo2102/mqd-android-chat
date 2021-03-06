package com.moqod.android.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 08/06/16
 * Time: 13:51
 */
public class LifecycleFragment extends Fragment {

    private HashSet<Lifecycle> mLifecycleComponentList = new HashSet<>();

    protected void addLifecycle(Lifecycle lifecycle) {
        mLifecycleComponentList.add(lifecycle);
    }

    protected void addLifecycle(Lifecycle... lifecycles) {
        for (Lifecycle lifecycle : lifecycles) {
            mLifecycleComponentList.add(lifecycle);
        }
    }

    protected void removeLifecycle(Lifecycle lifecycle) {
        mLifecycleComponentList.remove(lifecycle);
    }

    protected void removeLifecycle(Lifecycle... lifecycles) {
        for (Lifecycle lifecycle : lifecycles) {
            mLifecycleComponentList.remove(lifecycle);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        for (Lifecycle lifecycle : mLifecycleComponentList) {
            lifecycle.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (Lifecycle lifecycle : mLifecycleComponentList) {
            lifecycle.restoreState(savedInstanceState);
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        for (Lifecycle lifecycle : mLifecycleComponentList) {
            lifecycle.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        for (Lifecycle lifecycle : mLifecycleComponentList) {
            lifecycle.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        for (Lifecycle lifecycle : mLifecycleComponentList) {
            lifecycle.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();

        for (Lifecycle lifecycle : mLifecycleComponentList) {
            lifecycle.onStop();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        for (Lifecycle lifecycle : mLifecycleComponentList) {
            lifecycle.onDestroy();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        for (Lifecycle lifecycle : mLifecycleComponentList) {
            lifecycle.saveState(outState);
        }
    }

}
