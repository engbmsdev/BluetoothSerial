module.exports = {

    isEnabled: function (success, failure) {
        cordova.exec(success, failure, "BluetoothState", "isEnabled", []);
    },

    showBluetoothSettings: function (success, failure) {
        cordova.exec(success, failure, "BluetoothState", "showBluetoothSettings", []);
    },

    enable: function (success, failure) {
        cordova.exec(success, failure, "BluetoothState", "enable", []);
    }

};
