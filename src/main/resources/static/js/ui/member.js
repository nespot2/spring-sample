!function (global, $, _) {


    global.addEventListener('DOMContentLoaded', init);

    function init() {
        const initObjArr = [
            {
                eventName: "click",
                el: $.qs("#member_btn"),
                f: _.debounce(createMember, 200)
            },
            {
                eventName: "keydown",
                el: $.qs("#member_password"),
                f: _.debounce(createMemberWithEnter, 200)
            }
        ];

        _.go(
            initObjArr,
            _.each(addEvent)
        );
    }

    function addEvent({eventName, el, f}) {
        return _.go(
            el,
            $.on(eventName, f)
        )
    }

    function createMemberWithEnter(e) {
        if (e.keyCode === 13) {
            createMember(e);
        }
    }

    function createMember(e) {
        _.go(
            createMemberWithPromise(),
            ({code}) => {
                if (code == 0) {
                    alert("회원 등록!");
                }
            }
        ).catch(({response}) => {
            loadingRemove($.qs(".signal"));
            let data = response.data;
            console.log(data);
        });
    }

    function loading(parent) {
        _.go(
            $.el(`<div class="signal"></div>`),
            $.append(parent)
        )
    }

    function loadingRemove(el) {
        _.go(
            el,
            $.remove
        )
    }

    function createMemberWithPromise() {
        loading($.qs(".member"));
        const name = $.qs("#member_name");
        const password = $.qs("#member_password");
        const email = $.qs("#member_email");

        const data = {
            name, password, email
        };

        return axios({
            method: "post",
            data: data,
            url: "/member-api"
        });
    }

}(this, $, _);

