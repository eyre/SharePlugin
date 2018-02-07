var exec = require('cordova/exec');

exports.share = function(text, success, error) {
    exec(success, error, "SharePlugin", "share", [text]);
};
