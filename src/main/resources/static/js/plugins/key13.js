function p13() {
var input = document.getElementById("myInput");
input.addEventListener("keyup", function(event) {
    event.preventDefault();
    if (event.keyCode === 13) {
        document.getElementById("myBtn").click();
    }
	else if (event.keyCode === 108) {
        document.getElementById("myBtn").click();
    }
});
}
