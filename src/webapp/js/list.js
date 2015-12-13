/**
 * Created by Katherine on 05.12.2015.
 */
$(document).ready(function(){

    var topConteinerTitle = "All tasks";
    $(".list-window .top-container-title").html(topConteinerTitle);

    var topConteinerTitle = "Edit task";
    $(".edit-window .top-container-title").html(topConteinerTitle);

    var userName = "UserName";
    $(".username").html(userName);

    //Переключение пунктов меню
    $('.menu-list a').click(function(){
        var number = $(this).index();
        $(this).toggleClass('active');
        $('.menu-list a').not(this).removeClass('active');
    });

    //Переключение активных тасков
    $(".task-container").on("click", ".task-item", function(){
        $(this).addClass("active");
        $(".task-item").not($(this)).removeClass("active");

        $(".task-item.active .icon.task-remove").css("display", "block");
        //Скрытие кнопки удаления у неактивных тасков
        $(".task-item .icon.task-remove").not($(".task-item.active .icon.task-remove")).css("display", "none");

        taskDescr = $(this).find(".task-descr").text()
        taskTitle = $(this).find(".task-title").text()
        $(".edit-window .task-descr").val(taskDescr);
        $("#task-title").val(taskTitle);
    });

    //Отправка изменённых данных на сервер
    var lastTaskTitle, newTaskTitle;
    lastTaskTitle = $("#task-title").val();
    setInterval(function() {
        newTaskTitle = $("#task-title").val();
        if (lastTaskTitle != newTaskTitle){
            $.ajax({
                type: "POST",
                url: "/task",
                data:  {
                    "title" : $("#task-title").val(),
                    "text": $(".edit-container .task-descr").val()
                },
                success: function(msg){
                    alert( "Data Saved: " + msg );
                }
            });
        }
        lastTaskTitle = newTaskTitle;
    }, 2000);

    //Заголовок задания
    $("#task-title").on("input", function(){
        var taskItemTitle = $(".task-item.active .task-title");
        taskItemTitle.text($(this).val());
    });

    //Текст задания
    $(".edit-container .task-descr").on("input", function(){
        var taskDescr = $(".task-item.active .task-descr");
        taskDescr.text($(this).val().substr(0,100) + "...");
    });

    //Очистка полей ввода при нажатии на кнопку Create
    $(".create").on("click", function(){
        $("#task-title").val("");
        $(".edit-container .task-descr").val("");

        $(".task-container").prepend("<div class='task-item'> <div class='task-title'> </div> <div class='task-date'> </div> <div class='task-descr'> </div> <div class='task-author'> </div> <div class='task-block'> <a class='icon task-done' href='#'></a> <a class='icon task-remove' href='#'></a> <div class='icon task-important'> </div> </div> </div>");
        $(".task-item.active").removeClass("active");
        $(".task-container .task-item:first-child").addClass("active");
        $(".task-container .task-item:first-child .task-title").text("New task title");
        $(".task-container .task-item:first-child .task-descr").text("New task text");

        $(".task-item.active .icon.task-remove").css("display", "block");
        //Скрытие кнопки удаления у неактивных тасков
        $(".task-item .icon.task-remove").not($(".task-item.active .icon.task-remove")).css("display", "none");

        taskDescr = $(".task-container .task-item.active").find(".task-descr").text()
        taskTitle = $(".task-container .task-item.active").find(".task-title").text()
        $(".edit-window .task-descr").val(taskDescr);
        $("#task-title").val(taskTitle);
    });

    //Удаление активного таска
    $(".task-container").on("click", ".task-item.active .icon.task-remove", function(){
        $(".task-item.active").remove();
    });



});