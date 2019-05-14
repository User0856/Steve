window.onload = function(){

    var httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function(ev){

        if(this.readyState === XMLHttpRequest.DONE && this.status === 200){

          console.log(httpRequest.responseText);
        }

    }

    httpRequest.open("POST", 'localhost:67002/api/testpost', true);


    httpRequest.send();
}



