if (process.env.NODE_ENV === "production") {
    const opt = require("./trash-talk-bot-frontend-opt.js");
    opt.main();
    module.exports = opt;
} else {
    var exports = window;
    exports.require = require("./trash-talk-bot-frontend-fastopt-entrypoint.js").require;
    window.global = window;

    const fastOpt = require("./trash-talk-bot-frontend-fastopt.js");
    fastOpt.main()
    module.exports = fastOpt;

    if (module.hot) {
        module.hot.accept();
    }
}
