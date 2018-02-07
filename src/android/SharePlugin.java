package com.chltec.cordova;

import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * This class echoes a string called from JavaScript.
 */
public class SharePlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("share")) {
            String message = args.getString(0);
            this.share(message, callbackContext);
            return true;
        }
        return false;
    }

    private void share(String message, CallbackContext callbackContext) {
         try {
             String title = "title";
             String mimetype = "text/plain";
             Intent sendIntent = new Intent();
             sendIntent.setAction(Intent.ACTION_SEND);
             sendIntent.putExtra(Intent.EXTRA_TEXT, message);
             sendIntent.setType(mimetype);
             cordova.getActivity().startActivity(Intent.createChooser(sendIntent, title));
             callbackContext.success("success");
         }catch (Exception e){
             callbackContext.error(e.getMessage());
         }
    }
}
