$(function() {
    $(".btn-destroy").click(function(e) {
        if(!confirm("Bạn thực sự muốn xóa?")) {
            e.preventDefault();
        }
    })
})