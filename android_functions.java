

public static int REQUEST_ENABLE_BT = 123456;

public boolean setupBluetooth(){
    BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (mBluetoothAdapter == null) {
        return false;
    }
    if (!mBluetoothAdapter.isEnabled()) {
        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        int result = startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        if (result != Activity.RESULT_OK){
            return false;
        }
    }
}
