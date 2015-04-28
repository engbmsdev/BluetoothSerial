module.exports = {

    isEnabled: function (success, failure) {
        cordova.exec(success, failure, "BluetoothSerial", "isEnabled", []);
    },

    showBluetoothSettings: function (success, failure) {
        cordova.exec(success, failure, "BluetoothSerial", "showBluetoothSettings", []);
    },

    enable: function (success, failure) {
        cordova.exec(success, failure, "BluetoothSerial", "enable", []);
    }

};
