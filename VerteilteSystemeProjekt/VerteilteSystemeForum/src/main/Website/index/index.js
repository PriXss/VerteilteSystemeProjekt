async function fetchAPIData1() {

    fetch('http://localhost:8080/api/v1/student')
        .then(response => response.json())
        .then(data => {
            console.log (data)
            for(var i=0; i<data.length; i++) {
                el = document.createElement('div')
                el.append(`${data[i].username}, ${data[i].age} schreibt: ${data[i].message}`)
                document.getElementById("description1").append(el)
            }
        });
}



async function fetchAPIData2() {

    fetch('http://localhost:8080/api/v2/student')
        .then(response => response.json())
        .then(data => {
            console.log (data)
            for(var i=0; i<data.length; i++) {
                el = document.createElement('div')
                el.append(`${data[i].username}, ${data[i].age} schreibt: ${data[i].message}`)
                document.getElementById("description2").append(el)
            }
        });
}


fetchAPIData1();
fetchAPIData2();


function redirectForum1(){
    window.location.assign("http://localhost:63342/VerteilteSystemeForum/src/main/Website/forum1/forum1.html?_ijt=f578ahmuljg3dmr12qphm0u0h6")
}

function redirectForum2(){
    window.location.assign("http://localhost:63342/VerteilteSystemeForum/src/main/Website/forum2/forum2.html?_ijt=f578ahmuljg3dmr12qphm0u0h6")
}

