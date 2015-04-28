package it.engbmsdev.cordova.bluetoothstate;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.json.JSONException;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;


public class BluetoothState extends CordovaPlugin {

	private static final String IS_ENABLED = "isEnabled";
	private static final String SETTINGS = "showBluetoothSettings";
	private static final String ENABLE = "enable";

	private CallbackContext enableBluetoothCallback;
	private static final int REQUEST_ENABLE_BLUETOOTH = 1;

	private BluetoothAdapter bluetoothAdapter;

	private static final String TAG = "BluetoothState";

	@Override
	public boolean execute(String action, CordovaArgs args,
			CallbackContext callbackContext) throws JSONException {

		LOG.d(TAG, "action = " + action);

		if (bluetoothAdapter == null) {
			bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		}

		if (action.equals(IS_ENABLED)) {

			if (bluetoothAdapter.isEnabled()) {
				callbackContext.success();
			} else {
				callbackContext.error("Bluetooth is disabled.");
			}

		} else if (action.equals(SETTINGS)) {

			Intent intent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
			cordova.getActivity().startActivity(intent);
			callbackContext.success();

		} else if (action.equals(ENABLE)) {

			enableBluetoothCallback = callbackContext;
			Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			cordova.startActivityForResult(this, intent,
					REQUEST_ENABLE_BLUETOOTH);

		} else {
			return false;
		}

		return true;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == REQUEST_ENABLE_BLUETOOTH) {

			if (resultCode == Activity.RESULT_OK) {
				Log.d(TAG, "User enabled Bluetooth");
				if (enableBluetoothCallback != null) {
					enableBluetoothCallback.success();
				}
			} else {
				Log.d(TAG, "User did *NOT* enable Bluetooth");
				if (enableBluetoothCallback != null) {
					enableBluetoothCallback
							.error("User did not enable Bluetooth");
				}
			}

			enableBluetoothCallback = null;
		}
	}
}
