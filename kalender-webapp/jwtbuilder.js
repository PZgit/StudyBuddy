function base64url(source) {
        // Encode in classical base64
        var encodedSource = CryptoJS.enc.Base64.stringify(source);

        // Remove padding equal characters
        encodedSource = encodedSource.replace(/=+$/, '');

        // Replace characters according to base64url specifications
        encodedSource = encodedSource.replace(/\+/g, '-');
        encodedSource = encodedSource.replace(/\//g, '_');

        return encodedSource;
}

function buildUserToken(data) {
	var header = {
        "alg": "HS256",
        "typ": "JWT"
    };
	
    var stringifiedHeader = CryptoJS.enc.Utf8.parse(JSON.stringify(header));
    var encodedHeader = base64url(stringifiedHeader);
	
    var stringifiedData = CryptoJS.enc.Utf8.parse(JSON.stringify(data));
	var encodedData = base64url(stringifiedData);
	
    var token = encodedHeader + "." + encodedData;

    // var secret = "this is super secret";
    var secret = "gPcADw395jbmV5JrNrW280z0AqopVtfU";

    var signature = CryptoJS.HmacSHA256(token, secret);
    signature = base64url(signature);

    var signedToken = token + "." + signature;
    console.log("signed token: " + signedToken);
	return signedToken;
}