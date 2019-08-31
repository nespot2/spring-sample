!function (global, $, _) {


    global.addEventListener('DOMContentLoaded', init);

    /*_.go(
        $.el(`<div class="signal"></div>`),
        $.append($.qs(".member"))
    )*/

    function init() {
        const initObjArr = [
            {
                eventName: "click",
                el: $.qs("#member_btn"),
                f: _.debounce((e) => console.log(e), 200)
            },

            {
                eventName: "keydown",
                el: $.qs("#member_password"),
                f: _.debounce((e) => console.log(e), 200)
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


}(this, $, _);

