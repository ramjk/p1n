package p1nata.p1n;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

public class P1NErrors {

	public P1NErrors(P1Nmain main) {
		this.main = main;
	}

	private P1Nmain main;

	public void bluetoothNotFound(P1Nmain main) {
		new AlertDialog.Builder(main).setTitle("Bluetooth not found")
				.setMessage("Your phone does not appear to support bluetooth. This app requires bluetooth.")
				.setPositiveButton("Exit", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						System.exit(0);
					}
				}).create().show();

	}

	public void bluetoothNotEnabled(P1Nmain p1Nmain) {
		new AlertDialog.Builder(main).setTitle("Bluetooth not enabled").setMessage("Please turn on bluetooth.")
				.setPositiveButton("Settings", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Intent bluetooth = new Intent();
						bluetooth.setAction(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS);
						main.startActivity(bluetooth);
					}
				}).setNegativeButton("Exit", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						System.exit(0);
					}
				}).create().show();

	}

	public void validationError(String title, String message) {
		new AlertDialog.Builder(main).setTitle(title).setMessage(message)
				.setPositiveButton("OK", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				}).create().show();

	}

	public void needToSelectABluetoothDevice() {
		validationError("Bluetooth Device Missing", "Please select a bluetooth device");
	}

	public void needMasterKey() {
		validationError("Master Key Missing", "The Master Key must not be empty");

	}

	public void nameMustNotBeEmpty() {
		validationError("Door Name Missing", "The Door Name must not be empty");

	}

}
