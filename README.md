# Bluetooth State Plugin

This plugin enable to check if bluetooth is enabled or disabled.

## Supported Platforms

* Android

# Installing

Install with Cordova cli

    $ cordova plugin add https://github.com/engbmsdev/BluetoothSerial

# API

## Methods

- [bluetoothState.isEnabled](#isenabled)


## isEnabled

Reports if bluetooth is enabled.

    bluetoothState.isEnabled(success, failure);

### Description

Function `isEnabled` calls the success callback when bluetooth is enabled and the failure callback when bluetooth is *not* enabled.

### Parameters

- __success__: Success callback function, invoked when Bluetooth is enabled.
- __failure__: Error callback function, invoked when Bluetooth is NOT enabled.

### Quick Example

    bluetoothState.isEnabled(
        function() {
            console.log("Bluetooth is enabled");
        },
        function() {
            console.log("Bluetooth is *not* enabled");
        }
    );

## showBluetoothSettings

Show the Bluetooth settings on the device.

    bluetoothState.showBluetoothSettings(success, failure);

### Description

Function `showBluetoothSettings` opens the Bluetooth settings on the operating systems.

### Parameters

- __success__: Success callback function [optional]
- __failure__: Error callback function, invoked when error occurs. [optional]

### Quick Example

    bluetoothState.showBluetoothSettings();

## enable

Enable Bluetooth on the device.

    bluetoothState.enable(success, failure);

### Description

Function `enable` prompts the user to enable Bluetooth.
If `enable` is called when Bluetooth is already enabled, the user will not prompted and the success callback will be invoked.

### Parameters

- __success__: Success callback function, invoked if the user enabled Bluetooth.
- __failure__: Error callback function, invoked if the user does not enabled Bluetooth.

### Quick Example

    bluetoothState.enable(
        function() {
            console.log("Bluetooth is enabled");
        },
        function() {
            console.log("The user did *not* enable Bluetooth");
        }
    );

## License and credits

The plugin is a semplified version of [Don Coleman's BluetoothSerial Plugin](https://github.com/don/BluetoothSerial)
The original [BluetoothSerial Plugin](https://github.com/don/BluetoothSerial) is licensed under the [Apache License, Version 2.0.](https://github.com/don/BluetoothSerial/blob/master/LICENSE.txt)
