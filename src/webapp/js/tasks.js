/**
 * Created by Katherine on 11.12.2015.
 */
html = {
    task:
        '<div class="task">'+
        '   <i class="icon fa fa-square-o"></i>'+
        '   <div contenteditable="true" class="task-descr"></div>' +
        '   <i class="delete-icon fa fa-times-circle"></i>'+
        '</div>',

    new_task:
        '<div class="task-item">'+
            '<div class="task-title"></div>'+
            '<div class="task-date"></div>'+

            '<div class="tasks"></div>'+

            '<div class="tasks-hidden">' +
                '<div class="tasks"></div>' +
                '<div class="tasks-done"></div>'+
            '</div>'+

            '<div class="author-and-icons">'+
                '<div class="task-author"></div>'+
                '<div class="task-block">'+
                    '<a class="icon task-done" href="#"></a>'+
                    '<a class="icon task-remove" href="#"></a>'+
                    '<div class="icon task-important"></div>'+
                '</div>'+
            '</div>'+
        '</div>'
};

max_tasks = 3;

$(document).ready(function(){
    //Переключение пунктов меню
    $('.menu-list a').click(function(){
        var number = $(this).index();
        $(this).toggleClass('active');
        $('.menu-list a').not(this).removeClass('active');
    });

    //Переключение активных тасков
    $(".task-container").on("click", ".task-item", function(){
        if(!$(this).hasClass("active")){
            //$(this).addClass("active");
            if($(".task-item.active .tasks").html() == ""){
                $(".task-item.active").remove();
            } else{
                $(".task-item").not($(this)).removeClass("active");
            }
            $(this).addClass("active");

            taskDescr = $(".task-container .task-item.active .tasks-hidden .tasks").html();
            $(".edit-window .tasks").html(taskDescr);
            taskDone = $(".task-container .task-item.active .tasks-hidden .tasks-done").html();
            $(".edit-window .tasks-done").html(taskDone);
            taskTitle = $(this).find(".task-title").text();
            $("#list-title").val(taskTitle);
        }
    });

    //Заголовок задания
    $("#list-title").on("input", function(){
        var taskItemTitle = $(".task-item.active .task-title");
        taskItemTitle.text($(this).val());
    });

    //Текст задания
    $(".edit-container .tasks").on("input", function(){
        var taskDescr = $(".task-item.active .tasks-hidden .tasks");
        taskDescr.html($(this).html());

        //Первые три таска из task-hidden
        all_tasks = $('.task-container .task-item.active .tasks-hidden .task:nth-child(-n+' + max_tasks + ')').clone();
        all_tasks.find('div').attr('contenteditable', 'false');

        tasks = $('.task-container .task-item.active > .tasks');
        tasks.html(all_tasks);

        //Если тасков больше, чем 3, то добавляются точечки после них
        if($('.task-container .task-item.active .tasks-hidden .task:nth-child(4)').length != 0){
            tasks.append('<i class="big-task fa fa-ellipsis-h"></i>');
        }
    });

    //Очистка полей ввода при нажатии на кнопку Create
    $(".create").on("click", function(){
        $("#task-title").val("");
        $(".edit-container .tasks-done").html("");
        $(".edit-container .tasks").html("");

        $(".task-container").prepend(html.new_task);
        $(".task-item.active").removeClass("active");
        $(".task-container .task-item:first-child").addClass("active");

        $(".task-item:first-child .task-title").text("Название списка");
    });

    //Добавление новых пунктов в таски
    $(".edit-container .add-task").on("click", function() {
        last_task = $(".edit-container .tasks .task:last-of-type div");
        if((last_task.length == 0) || (last_task.text() != "")){
            $(".edit-container .tasks").append(html.task);
            $(".edit-container .tasks .task:last-of-type div").focus();
        }
    });

    //Удаление активного таска
    $(".task-container").on("click", ".task-item.active .icon.task-remove", function(){
        $(".task-item.active").remove();
    });

    //Удаление задания из списка
    $(".edit-container").on("click", ".delete-icon", function(){
        $(this).parent().remove();

        var taskDescr = $(".task-item.active .tasks-hidden .tasks");
        taskDescr.html($(".edit-container .tasks").html());

        //Первые три таска из task-hidden
        all_tasks = $('.task-container .task-item.active .tasks-hidden .task:nth-child(-n+' + max_tasks + ')').clone();
        all_tasks.find('div').attr('contenteditable', 'false');

        tasks = $('.task-container .task-item.active > .tasks');
        tasks.html(all_tasks);

        //Если тасков больше, чем 3, то добавляются точечки после них
        if($('.task-container .task-item.active .tasks-hidden .task:nth-child(4)').length != 0){
            tasks.append('<i class="big-task fa fa-ellipsis-h"></i>');
        }
    });
});