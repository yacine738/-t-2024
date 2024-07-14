function genQR() {
    var gapi = "https://quickchart.io/qr?text=";
    var myimg = document.getElementById("img");
    var mytext = document.getElementById("qrtext").value;
    var mysize = document.getElementById("size").value;

    if (mytext === "") {
        alert("Please Enter Text");
    } else {
        myimg.src = gapi + encodeURIComponent(mytext) + "&size=" + mysize;
    }
}