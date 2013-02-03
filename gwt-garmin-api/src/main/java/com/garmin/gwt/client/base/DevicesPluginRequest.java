package com.garmin.gwt.client.base;


import com.garmin.gwt.client.DevicePlugin;


/**
 * General handler for callbacks to the device
 * 
 * @author Joseph Lust
 * 
 */
public final class DevicesPluginRequest extends AbstractPluginRequest<Device[]> {


	public DevicesPluginRequest(DevicePlugin plugin, RequestCallback<Device[]> callback) {
		setPlugin(plugin);
		setCallback(callback);
	}

	@Override
	public void startRequest() {
		plugin.startFindDevices();
		getTimer().schedule(POLLING_INTERVAL_MS);
	}

	@Override
	public boolean finishRequest() {
		return plugin.finishFindDevices();
	}

	@Override
	public void cancelRequest() {
		plugin.cancelFindDevices();
		getTimer().cancel();
	}

	@Override
	public Device[] getRequestResult() {
		return getPlugin().getDevices();
	}

}
