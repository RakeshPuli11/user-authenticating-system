function validatePassword() {
    let username = document.getElementById("signupForm").elements["uname"].value;
	let password1 = document.getElementById("signupForm").elements["pass1"].value;
	let password2 = document.getElementById("signupForm").elements["pass2"].value;

    if (password1 === "" || password2 === "" || username === "") {
        alert("Please enter all fields!");
        return false; // Prevent form submission
    } else if (password1 !== password2) {
        alert("Passwords do not match! Please re-enter.");
        return false; // Prevent form submission
    } 
        return true; // Allow form submission
}
