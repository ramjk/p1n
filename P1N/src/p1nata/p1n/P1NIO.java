package p1nata.p1n;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;

public class P1NIO {
	private final P1Nmain main;

	public P1NIO(P1Nmain main) {
		this.main = main;
	}

	public List<DoorInfo> readDoors() {
		List<DoorInfo> di = new ArrayList<DoorInfo>();
		for (File f : main.getFilesDir().listFiles()) {
			try {
				di.add(readDoorInfo(f.getName()));
			} catch (IOException e) {
				// should not happen. Just ignore and continue
			}
		}
		return di;
	}

	private DoorInfo readDoorInfo(String id) throws IOException {
		return DoorInfo.read(readSingleLine(id));
	}

	private String readSingleLine(String file) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				main.openFileInput(file)));
		String ln = br.readLine();
		br.close();
		return ln;
	}

	private void writeSingleLine(String file, String toWrite)
			throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				main.openFileOutput(file, Activity.MODE_PRIVATE)));
		bw.write(toWrite + "\n");
		bw.close();

	}

	public void writeDoor(String doorName, int masterKey, BluetoothDevice device) {
		int usableID;
		for (int i = 0;; i++) {
			try {
				readDoorInfo(Integer.toString(i));
				continue;
			} catch (IOException e) {
				// the file is not found
				usableID = i;
				break;
			}
		}
		System.out.println("Writing to file " + usableID + "; " + doorName);
		try {
			writeSingleLine(Integer.toString(usableID), new DoorInfo(doorName,
					usableID, masterKey, device.getAddress()).write());
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}

	}

}
