package p1nata.p1n;

public class DoorInfo {
	public final String name;
	public final int internalID;
	public final int masterkey;
	public final String mac_address;

	public DoorInfo(String name, int internalID, int masterkey,
			String mac_address) {
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
		int lt = asString.lastIndexOf('\t');
		int lt2 = asString.lastIndexOf('\t', lt - 1);
		int lt3 = asString.lastIndexOf('\t', lt2 - 1);
		return new DoorInfo(asString.substring(0, lt3),
				Integer.parseInt(asString.substring(lt3 + 1, lt2)),
				Integer.parseInt(asString.substring(lt2 + 1, lt)),
				asString.substring(lt + 1));
	}
}
