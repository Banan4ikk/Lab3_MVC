$(function (){
    let Params = {};
    $("#updateForm").submit(function (e){
        e.preventDefault();

        Params.NameToUpdate = $("#nameUpdate").val();
        Params.SurnameToUpdate = $("#surnameUpdate").val();
        Params.Name = $("#name").val();
        Params.Surname = $("#surname").val();
        Params.Date = $("#date").val();
        Params.Socials = $("#socials").val();
        Params.Email = $("#email").val();

        let NewUserInfo = JSON.stringify(Params);

        $.post("update",NewUserInfo)
    });
});