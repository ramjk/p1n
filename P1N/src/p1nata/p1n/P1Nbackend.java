package p1nata.p1n;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

public class P1Nbackend {

	public static BluetoothDevice getDeviceByAddress(DoorInfo info) {
		BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
		if (pairedDevices.size() > 0) {
			for (BluetoothDevice device : pairedDevices) {
				if (device.getAddress().equals(info.mac_address)) {
					return device;
				}
			}
		}
		throw new IllegalStateException();
	}

	public static void unlock(Activity activity, DoorInfo info) throws IOException {
		BluetoothDevice dev = getDeviceByAddress(info);
		BluetoothSocket socket = dev
				.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805f9b34fb"));
		socket.connect();
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		writeIntLE(dos, encrypt(info.masterkey));
	}

	public static void writeIntLE(DataOutputStream out, int value) throws IOException {
		out.writeByte(value & 0xFF);
		out.writeByte((value >> 8) & 0xFF);
		out.writeByte((value >> 16) & 0xFF);
		out.writeByte((value >> 24) & 0xFF);
	}

	private static int encrypt(int masterkey) {
		// TODO Auto-generated method stub
		return 0;
	}

}
