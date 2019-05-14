function onTestGetButtonClick(){

    var httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function(ev){

        if(this.readyState === XMLHttpRequest.DONE && this.status === 200){

            //new
            var responseJson = JSON.parse(httpRequest.responseText);
            document.getElementById("server_response_section").innerHTML = responseJson.location;


      //      console.log(httpRequest.responseText);
      //      document.getElementById("server_response_section").innerHTML = httpRequest.responseText;
        }

    }

    httpRequest.open("POST", '/api/testpost', true);

    var requestJson = {

        text : document.getElementById("test_input").value
        location : location.host,
        protocol : location.protocol


    };


    httpRequest.send(JSON.stringify(requestJson));




}