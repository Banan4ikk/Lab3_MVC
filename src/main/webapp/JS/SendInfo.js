$(function (){
    let Params = {};
    $("#photoForm").submit(function (e){
        e.preventDefault();

        Params.Name= $("#name").val();
        Params.Surname= $("#surname").val();
        Params.Date= $("#date").val();
        Params.Socials= $("#socials").val();
        Params.Email= $("#email").val();

        let jsonString = JSON.stringify(Params);

        $.post("add",jsonString);
        alert("Send to server successfully.");
        console.log(jsonString);
    });
});
