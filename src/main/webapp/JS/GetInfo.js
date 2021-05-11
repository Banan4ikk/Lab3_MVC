let OutputArray = [];
$(function (){
    $("#GetInfoButton").on('click',function (){
        $.post("read", function (data) {
            OutputArray = JSON.parse(data);
            showOutputArray(OutputArray);
        });
    });
});
