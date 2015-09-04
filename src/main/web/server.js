var connect = require('gulp-connect'),
	morgan = require('morgan');

// todo: add api to stop, restart, validate etc

module.exports = function () {
	connect.server({
		host: 'localhost',
		root: './',
		livereload: true,
		directoryListing: true,
		port: 9090,
		middleware: function () {
			return [
				morgan('dev'),
				function (req, res, next) {
					// set cors headers
					res.setHeader('Access-Control-Allow-Origin', '*');
					res.setHeader('Access-Control-Allow-Headers', '*');
					next();
				}
			];
		}
	});
};