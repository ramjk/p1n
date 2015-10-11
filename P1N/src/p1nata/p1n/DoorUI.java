package p1nata.p1n;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DoorUI extends Fragment {
	private final DoorInfo info;

	public DoorUI(DoorInfo info) {
		this.info = info;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.doorui, container, false);
		((TextView) v.findViewById(R.layout.textView1)).setText(info.name);
		((Button) v.findViewById(R.layout.button1)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.e("P1N", "Unlocking " + info.write());

				// TODO unlock
			}
		});
		((Button) v.findViewById(R.layout.button2)).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.e("P1N", "SMSING " + info.write());

				// TODO sms

			}

		});
		return v;
	}
}