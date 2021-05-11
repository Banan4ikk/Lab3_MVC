$(function (){
    let Params = {};
    $("#updateForm").submit(function (e){
        e.preventDefault();

        Params.Name = $("#name").val();
        Params.Surname = $("#surname").val();
        Params.Date = $("#date").val();
        Params.Socials = $("#socials").val();
        Params.Email = $("#email").val();

        let NewUserInfo = JSON.stringify(Params);

        $.post("Name",NewUserInfo)
    });
});