package p1nata.p1n;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoorInfo {
	public final String name;
	public final int internalID;
	public final int masterkey;
	public final String mac_address;

	public DoorInfo(String name, int internalID, int masterkey, String mac_address) {
		super();
		this.name = name;
		this.internalID = internalID;
		this.masterkey = masterkey;
		this.mac_address = mac_address;
	}

	public String write() {
		return name + "\t" + internalID + "\t" + masterkey + "\t" + mac_address;
	}

	public static DoorInfo read(String asString) {
		Matcher mat = Pattern.compile("(.+)\t([^\t]+)\t([^\t]+)\t([^\t]+)").matcher(asString);
		return new DoorInfo(mat.group(1), Integer.parseInt(mat.group(2)), Integer.parseInt(mat.group(3)), mat.group(4));
	}
}
