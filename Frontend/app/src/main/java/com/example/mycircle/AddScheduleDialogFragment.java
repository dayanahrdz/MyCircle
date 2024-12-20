package com.example.mycircle;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class AddScheduleDialogFragment extends DialogFragment {

    public interface OnScheduleItemAddedListener {
        void onScheduleItemAdded(String name, String time);
    }

    private OnScheduleItemAddedListener listener;

    public void setOnScheduleItemAddedListener(OnScheduleItemAddedListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_add_schedule_item, null);

        EditText itemNameEditText = view.findViewById(R.id.schedule_item_name);
        EditText itemTimeEditText = view.findViewById(R.id.schedule_item_time);
        Button addButton = view.findViewById(R.id.add_schedule_button);
        Button cancelButton = view.findViewById(R.id.cancel_schedule_button);

        builder.setView(view);

        addButton.setOnClickListener(v -> {
            String itemName = itemNameEditText.getText().toString().trim();
            String itemTime = itemTimeEditText.getText().toString().trim();

            if (!TextUtils.isEmpty(itemName) && !TextUtils.isEmpty(itemTime)) {
                if (listener != null) {
                    listener.onScheduleItemAdded(itemName, itemTime);
                }
                dismiss();
            } else {
                if (TextUtils.isEmpty(itemName)) {
                    itemNameEditText.setError("Name is required");
                }
                if (TextUtils.isEmpty(itemTime)) {
                    itemTimeEditText.setError("Time is required");
                }
            }
        });

        cancelButton.setOnClickListener(v -> dismiss());

        return builder.create();
    }
}
