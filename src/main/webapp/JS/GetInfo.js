let OutputArray = [];
$(function (){
    $("#GetInfoButton").on('click',function (){
        $.post("list", function (data) {
            OutputArray = JSON.parse(data);
            showOutputArray(OutputArray);
        });
    });
});