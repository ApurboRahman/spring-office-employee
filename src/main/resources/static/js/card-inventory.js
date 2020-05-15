
$(function() {
    $('#periodMonth, #department').change(function() {

        var periodMonth = $('#periodMonth').val();
        var department = $('#department').val();
        console.log(periodMonth)
        console.log(department)
        $('#periodMonth').val(periodMonth);
        $('#department').val(department);
       // location.href = "/card-inventory/search/" + periodMonth + "/" + department
    });

    $('.searchbtn').click(function() {

        var periodMonth = $('#periodMonth').val();
        var department = $('#department').val();
        console.log(periodMonth)
        console.log(department)
        $('#periodMonth').val(periodMonth);
        $('#department').val(department);
         location.href = "/card-inventory/search/" + periodMonth + "/" + department
    });

    $('#approveButton').on('click', function () {
        console.log('approve clicked');
        $('#approveForm').trigger('submit');
    });
/*
    $('#approve').click(function(){
        var periodMonth = $('#periodMonth').val();
        var department = $('#department').val();
        $.post("/card-inventory/approve",
            {
                cardInventoryForm: {
                "periodMonth": periodMonth,
                "department": department,

            }
            },
            function(data, status){
                alert("Data: " + data + "\nStatus: " + status);
            });
    });

    $('#approve').click(function(){
        console.log('approve clicked');

        $(".message_normal").each(function() {
            $(this).remove();
        });

        $(".fieldError").each(function() {
            $(this).removeClass("fieldError");
        });

        var periodMonth = $('#periodMonth').val();
        var department = $('#department').val();

        var data = {
            "cardInventoryForm": {
                "periodMonth": periodMonth,
                "department": department,

            }
        };
        console.log(data)
        $.ajax({
            method: 'post',
            contentType: 'application/json;charset=utf-8',
            data: data,
            url: '/card-inventory/approve',
            dataType: 'text'
        }).done(function(data) {
            console.log(data.status)
            if (data.status==1) {
                //成功したら表示位置保持して、画面遷移
                location.href = "/card-inventory";
            } else {
                console.log('error')
                //alert("検証エラーならエラーメッセージを表示");
                for (var key in data.fldErrors) {
                    $('#'+key).addClass("fieldError");
                    $('#'+key).after('<span class="message_normal">'+data.fldErrors[key]+'</span>')
                }
            }
        });
        console.log('click end')
    });
*/
});