//html = {
//    task:
//    '<div class="task">'+
//    '   <i class="icon fa fa-square-o"></i>'+
//    '   <div contenteditable="true" class="task-descr" ></div>'+
//    '</div>'
//};
//
//
//$(document).ready(function(){
//    function edit_tasks($tasks_hidden){
//        var $tasks_current = $tasks_hidden.find('.tasks');
//        var $tasks_done = $tasks_hidden.find('.tasks-done');
//        $('.edit-window .tasks').html($tasks_current.html());
//        $('.edit-window .tasks-done').html($tasks_done.html());
//    }
//
//    function add_task(event) {
//        event.stopPropagation();
//        var $task_descr = $('.edit-window .tasks .task:last-of-type .task-descr');
//        if ($task_descr.text() != "") {
//            $('.edit-window .tasks').append(html.task);
//        }
//        $task_descr = $($task_descr.selector);
//        $task_descr.focus();
//    }
//
//    $('.task-container').on('click', '.task-item', function(){
//        if(!$(this).hasClass('active')){
//            edit_tasks($(this).find('.tasks-hidden'));
//            $(this).addClass('active');
//            $('.task-item').not(this).removeClass('active');
//        }
//    });
//
//    $('.edit-container').on('click', '.add-task', add_task);
//
//    $('.edit-window .tasks').on('keypress', '.task-descr', function(event){
//        var $last_task_descr = $('.edit-window .tasks .task:last-of-type .task-descr');
//        if (event.which == 13) {
//            if ($last_task_descr[0] == $(this)[0]) {
//                event.preventDefault();
//                add_task(event);
//            } else {
//                event.preventDefault();
//                $(this).parent().next().find('.task-descr').focus();
//            }
//        }
//    });
//
//    $('body').click(function () {
//        var $task_descr = $('.edit-window .tasks .task:last-of-type .task-descr');
//        if ($task_descr.text() == ""){
//            $task_descr.parent().remove();
//        }
//    });
//
//
//
//
//});