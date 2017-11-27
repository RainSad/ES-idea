/**
 * bootstrap弹出式模态框
 */
var confirmModel = 
    '<div class="modal fade" id="delcfmModel">\n' +
    '    <div class="modal-dialog">\n' +
    '        <div class="modal-content message_align">\n' +
    '            <div class="modal-header">\n' +
    '                <button type="button" class="close" data-dismiss="modal"\n' +
    '                        aria-label="Close">\n' +
    '                    <span aria-hidden="true">×</span>\n' +
    '                </button>\n' +
    '                <h4 class="modal-title">{{info.header}}</h4>\n' +
    '            </div>\n' +
    '            <div class="modal-body">\n' +
    '                <p>{{info.message}}</p>\n' +
    '            </div>\n' +
    '            <div class="modal-footer">\n' +
    '                <button v-on:click="cancel" type="button" class="btn btn-default" data-dismiss="modal">{{info.cancel}}\n' +
    '                </button>\n' +
    '                <button v-on:click="submit" type="button" class="btn btn-primary">{{info.confirm}}</button>\n' +
    '            </div>\n' +
    '        </div>\n' +
    '    </div>\n' +
    '</div>';

var confirmModel = Vue.extend({
	props: ['info'],
    template: confirmModel,
    methods:{
    	cancel:function(){
    		this.$emit('cancel');
    	},
    	submit:function(){
    		this.$emit('submit');
    	}
    }
});
