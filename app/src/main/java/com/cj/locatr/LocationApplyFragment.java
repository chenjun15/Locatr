package com.cj.locatr;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class LocationApplyFragment extends DialogFragment {

    public static final String ARG_MSG = "msg_content";
    private Fragment mParentFragment;

    public static LocationApplyFragment newInstance(Fragment parentFragment) {
        return new LocationApplyFragment(parentFragment);
    }

    public LocationApplyFragment(Fragment parentFragment) {
        mParentFragment = parentFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setMessage(R.string.permission_query_msg)
                .setPositiveButton(R.string.grant, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mParentFragment.requestPermissions(LocatrFragment.LOCATION_PERMISSIONS, LocatrFragment.REQUEST_LOCATION_PERMISSIONS);
                    }
                })
                .setNegativeButton(R.string.reject, null)
                .create();
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
    }
}
