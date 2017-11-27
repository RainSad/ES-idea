$(function () {
    getData();
});

var vm1 = new Vue({
    el: "#messageDetail",
    data: {
        info: {
            message: ""
        }
    },
    computed: {
        setHTML: function () {
            $("#messageDetail").append(this.info.message)
        }
    }

});

function getData() {
    $.ajax({
        url: "index/viewShare/detail/351289fe8de64f42888d251c0a4f5085",
        dataType: "json",
        type: "post",
        success: function (data) {

            vm1.info.message = data.data.message;
        }
    })
}
