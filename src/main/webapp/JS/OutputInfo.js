function showOutputArray(OutputArray) {
    let ParamsToOut = {};
    $("#header").append("<th>Email</th> <th>Socials</th> <th>Name</th> <th>Dates</th> <th>Surname</th>");
    for (let i = 0; i < OutputArray.length; i++) {
        ParamsToOut = OutputArray[i];

        $("#tbody").append("<tr>");
        for(var item in ParamsToOut){
            $("#tbody").append("<td>" + ParamsToOut[item]+"</td>");
        }
        $("#tbody").append("</tr>");
    }
}

