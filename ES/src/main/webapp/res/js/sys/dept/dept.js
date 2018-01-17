$(function () {
    initDeptDeptList(null);
});

//渲染左边部门树
var deptVm = new Vue({
    data: {
        deptData: [],
        deptParm: {}
    }
});

deptVm.$watch('deptData', function () {
    $('#treeDeptList').treeview({
        data: deptVm.deptData,
        onNodeSelected: function (event, data) {
            deptVm.deptParm.id = data.id;
        }
    });
});
deptVm.$watch('deptParm', function () {

})


//得到左侧部门树数据
function initDeptDeptList() {
    var url = "sys/dept/tree.json";
    $.getJSON(url, parm, function (result) {
        deptVm.deptData = result.data;
    });

}
