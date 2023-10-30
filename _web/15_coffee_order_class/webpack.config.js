const path = require('path');

module.exports = {
    entry: './src/main.js',
    output: {
        filename: "bundle.js",
        // path: __dirname + '/dist'
        path: path.resolve(__dirname, 'dist'),
    },
    mode: "development"
}