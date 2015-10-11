package p1nata.p1n;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
		BufferedReader br = new BufferedReader(new InputStreamReader(main.openFileInput(id)));
		String ln = br.readLine();
		br.close();
		return DoorInfo.read(ln);
	}
}
