async function fetchAPIData() {

    fetch('http://localhost:8080/api/v2/student')
        .then(response => response.json())
        .then(data => {
            console.log (data)
            for(var i=0; i<data.length; i++) {
                el = document.createElement('div')
                el.append(`${data[i].username}, ${data[i].age} schreibt: ${data[i].message}`)
                document.getElementById("description").append(el)
            }
        });
}

fetchAPIData();

async function postDataToAPI() {
    if (document.getElementById('MessageInput').value == "" || document.getElementById('NameInput').value == "" || document.getElementById('EmailInput').value == "" || document.getElementById('AgeInput').value == "") {
        alert("You have to type your message in the answer box pls.")
        return false
    }
    if(document.getElementById('AgeInput').value < 18){
        alert("You have to be at least 19 years old to commit to this Forum")
        return false
    }

    fetch('http://localhost:8080/api/v2/student', {
        method: 'POST',
        headers: {
            'Content-Type': 'text/plain'
        },
        body: JSON.stringify({
            message: document.getElementById('MessageInput').value,
            age: document.getElementById('AgeInput').value,
            username : document.getElementById('NameInput').value,
            email: document.getElementById('EmailInput').value

        })
    })
        .then(response => {
            return response.json()
        })
        .then(data => console.log(data),
            alert("Your Post was successfully sent to the API"),
            window.location.reload())
        .catch(error => console.log('Something went wrong'))
}

function redirectToIndex(){
    window.location.assign("http://localhost:63342/VerteilteSystemeForum/src/main/Website/index/index.html?_ijt=8mla3gnajsb2gdtc9ge2b80oat")
}