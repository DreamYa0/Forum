var gulp = require('gulp'),
    boilerplate = require('boilerplate-gulp');
    
boilerplate(gulp, {
    pkg: require('./package.json'),
    jsMain: './src/angular-fooRepeatDone.js',
    karmaConfig: require('./test/karma.conf.js'),
    connectConfig: require('./example/connect.conf.js')
});